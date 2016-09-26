package sample.simple

import core.App
import core.graphics
import javafx.scene.paint.Color


class Simple(){
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App.run(draw)
        }
    }
}

val draw = graphics {
    fill = Color.ORANGE
    fillRect(150.0, 150.0, 150.0, 150.0)
}