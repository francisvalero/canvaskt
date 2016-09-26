package core

import javafx.animation.AnimationTimer
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext


class AnimationCanvas( val draw: (g: GraphicsContext, e: Environment) -> Unit,
                       w: Double = 640.0,
                       h: Double = 360.0) : Canvas(), Renderable{
    init {
        width = w
        height = h
    }
    val timer = object : AnimationTimer() {
        override fun handle(now: Long){
            draw(graphicsContext2D, Environment(now))
        }
    }
    override fun render() = timer.start()
}



interface Renderable{
    fun render()
}

class Environment(val now:Long)

fun graphics(f: GraphicsContext.(e: Environment) -> Unit) : (g: GraphicsContext, e: Environment) -> Unit{
    return { g:GraphicsContext, e: Environment -> g.f(e) }
}

fun defaultEnvironment() = Environment(0.toLong())