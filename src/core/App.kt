package core

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.layout.StackPane
import javafx.stage.Stage



private var canvas: Canvas2D? = null

class App() : Application(){

    override fun start(stage: Stage){
        val root = StackPane()
        canvas?.let { root.children.add(canvas as Canvas) }
        val scene = Scene(root)
        stage.title = "CanvasKT"
        stage.scene = scene
        stage.isResizable = false
        canvas?.start()
        stage.show()
    }

    /***
     *  Pre-defined stage for canvas animations
     *  Usage:  App.run(draw, [width],[height])
     */
    companion object Runner{
        fun run(sketch: Sketch, w: Double = 640.0, h: Double = 320.0){
            canvas = Canvas2D(sketch, w, h)
            launch(App::class.java)
        }
    }
}




