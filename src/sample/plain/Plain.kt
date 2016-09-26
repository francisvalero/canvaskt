package sample.spiral

import core.PlainCanvas
import core.graphics
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.stage.Stage

class Plain() : Application(){
    override fun start(stage: Stage){
        val root = StackPane()
        val canvas = PlainCanvas(plainDrawing)
        canvas.width = 400.0
        canvas.height = 320.0
        root.children.add(canvas)
        val scene = Scene(root)
        stage.title = "JavaFX Canvas + Kotlin"
        stage.scene = scene
        stage.show()
    }
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Plain::class.java)
        }
    }
}

val plainDrawing = graphics {
    fill = Color.ORANGE
    fillRect(100.0, 100.0, 80.0, 80.0)
}


