package core

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.layout.StackPane
import javafx.stage.Stage



private var canvas: Renderable? = null

class App() : Application(){

    override fun start(stage: Stage){
        val root = StackPane()
        canvas?.let { root.children.add(canvas as Canvas) }
        val scene = Scene(root)
        stage.title = "JavaFX Canvas + Kotlin"
        stage.scene = scene
        stage.show()
        canvas?.render()

    }

    /***
     *  Pre-defined stage for canvas animations
     *  Usage:  App.run(draw, [width],[height])
     */
    companion object Runner{
        fun run(draw: (g: GraphicsContext, e: Environment) -> Unit,
                width: Double = 640.0,
                height: Double = 360.0){
            canvas = AnimationCanvas(draw, width, height)
            launch(App::class.java)
        }
    }
}




