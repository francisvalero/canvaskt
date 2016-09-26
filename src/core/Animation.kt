package core

import javafx.animation.AnimationTimer
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.input.MouseEvent.*


class AnimationCanvas( val draw: (g: GraphicsContext, e: Environment) -> Unit,
                       w: Double = 640.0,
                       h: Double = 360.0) : Canvas(), Renderable{
    init {
        width = w
        height = h
        addEventFilter(ANY){
            when(it.eventType){
                MOUSE_MOVED, MOUSE_DRAGGED -> {
                    mouseX = it.x
                    mouseY = it.y
                }
                MOUSE_PRESSED -> isMousePressed = true
                MOUSE_RELEASED -> isMousePressed = false
            }
        }
    }
    var mouseX: Double = 0.0
    var mouseY: Double = 0.0
    var isMousePressed: Boolean = false

    val timer = object : AnimationTimer() {
        override fun handle(now: Long){
            draw(graphicsContext2D, Environment(now, mouseX, mouseY, isMousePressed))
        }
    }
    override fun render() = timer.start()
}



interface Renderable{
    fun render()
}

class Environment(val now:Long, val mouseX: Double, val mouseY: Double, val isMousePressed: Boolean)

fun graphics(f: GraphicsContext.(e: Environment) -> Unit) : (g: GraphicsContext, e: Environment) -> Unit{
    return { g:GraphicsContext, e: Environment -> g.f(e) }
}

fun defaultEnvironment() = Environment(0.toLong(), 0.0, 0.0, false)