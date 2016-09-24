package sample

import core.AnimationCanvas
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.stage.Stage

class Main() : Application(){
    override fun start(stage: Stage){
        val root = StackPane()
        val canvas = AnimationCanvas( draw )
        canvas.width = 720.0
        canvas.height = 400.0
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
            launch(Main::class.java)
        }
    }
}




