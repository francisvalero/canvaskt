package core

import javafx.animation.AnimationTimer
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.input.MouseEvent.*


class Sketch(f: Sketch.() -> Unit) {
    var now: Long = 0
    var mouseX: Double = 0.0
    var mouseY: Double = 0.0
    var isMousePressed: Boolean = false
    var width: Double = 0.0
        get() = width
        internal set(value) { field = value }
    var height: Double = 0.0
        get() = height
        internal set(value) { field = value }
    private var drawF: (GraphicsContext.() -> Unit) = {}
    private var setupF: (GraphicsContext.() -> Unit) = {}

    init{
        f()
    }

    fun draw(g: GraphicsContext.() -> Unit) {
        drawF = g
    }

    fun setup(g: GraphicsContext.() -> Unit) {
        setupF = g
    }

    internal fun setup(g: GraphicsContext){
        println("sketch setup")
        g.setupF()
    }
    internal fun draw(g: GraphicsContext){
        g.drawF()
    }
}


class Canvas2D(val sketch: Sketch) : Canvas() {
    constructor(sketch: Sketch, w: Double, h: Double):this(sketch){
        width = w
        height = h
    }
    init {
        addEventFilter(ANY) {
            when (it.eventType) {
                MOUSE_MOVED -> {
                    sketch.mouseX = it.x
                    sketch.mouseY = it.y
                }
                MOUSE_PRESSED -> sketch.isMousePressed = true
                MOUSE_RELEASED -> sketch.isMousePressed = false
            }
        }
        widthProperty().addListener { a, b, c -> sketch.width = width }
        heightProperty().addListener { a, b, c -> sketch.height = height }
    }

    val timer = object : AnimationTimer() {
        override fun handle(now: Long) {
            sketch.now = now
            sketch.draw(graphicsContext2D)
        }
    }

    fun start() {
        sketch.setup(graphicsContext2D)
        timer.start()
    }

    fun stop() = timer.stop()
}