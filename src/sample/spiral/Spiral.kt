package sample.spiral

import core.App
import core.Canvas2D

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class Spiral() : Application(){
    override fun start(stage: Stage){
        val root = StackPane()
        val canvas = Canvas2D(sketch, 720.0, 400.0)
        root.children.add(canvas)
        val scene = Scene(root)
        stage.title = "JavaFX Canvas + Kotlin"
        stage.scene = scene
        stage.show()
        canvas.start()
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Spiral::class.java)
        }
    }
}






