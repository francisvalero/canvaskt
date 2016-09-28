package core

import javafx.animation.AnimationTimer
import javafx.scene.canvas.Canvas
import javafx.scene.input.KeyEvent
import javafx.scene.input.KeyEvent.*
import javafx.scene.input.MouseEvent
import javafx.scene.input.MouseEvent.*


class Canvas2D(val sketch: Sketch) : Canvas() {
    constructor(sketch: Sketch, w: Double, h: Double) : this(sketch) {
        width = w
        height = h
        isFocused = true
        isFocusTraversable = true
    }

    init {
        addEventFilter(MouseEvent.ANY) {
            sketch.mouseX = it.x
            sketch.mouseY = it.y
            when (it.eventType) {
                MOUSE_MOVED -> {
                    sketch.mouseMoved(graphicsContext2D, it)
                }
                MOUSE_PRESSED -> {
                    sketch.mousePressed(graphicsContext2D, it)
                    sketch.isMousePressed = true
                }
                MOUSE_RELEASED -> {
                    sketch.mouseReleased(graphicsContext2D, it)
                    sketch.isMousePressed = false
                }
                MOUSE_CLICKED -> {
                    sketch.mouseClicked(graphicsContext2D, it)
                }
                MOUSE_ENTERED -> {
                    sketch.mouseEntered(graphicsContext2D, it)
                }
                MOUSE_EXITED -> {
                    sketch.mouseExited(graphicsContext2D, it)
                }
                MOUSE_DRAGGED -> {
                    sketch.mouseDragged(graphicsContext2D, it)
                }
            }
        }
        addEventFilter(KeyEvent.ANY){
            when(it.eventType){
                KEY_PRESSED -> sketch.keyPressed(graphicsContext2D, it)
                KEY_RELEASED -> sketch.keyReleased(graphicsContext2D, it)
                KEY_TYPED -> sketch.keyTyped(graphicsContext2D, it)
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


