package sample.spiral

import core.AnimationCanvas
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.stage.Stage

class Inline() : Application(){
    override fun start(stage: Stage){
        val root = StackPane()
        val canvas = AnimationCanvas{
            it.fill = Color.ORANGE
            it.fillRect(100.0, 100.0, 80.0, 80.0)
        }
        canvas.width = 400.0
        canvas.height = 320.0
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
            launch(Inline::class.java)
        }
    }
}




