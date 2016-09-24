package core

import javafx.animation.AnimationTimer
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext


class AnimationCanvas( val draw: (g: GraphicsContext) -> Unit ) : Canvas(){
    val timer = object : AnimationTimer() {
        override fun handle(now: Long){
            draw(graphicsContext2D)
        }
    }

    fun start(){
        timer.start()
    }

    fun stop(){
        timer.stop()
    }
}


fun graphics(f: GraphicsContext.() -> Unit ) : (g: GraphicsContext) -> Unit{
    return { g:GraphicsContext-> g.f() }
}
