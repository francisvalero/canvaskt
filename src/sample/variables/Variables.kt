package sample.variables

import core.App
import core.graphics
import javafx.scene.paint.Color

class Variables{
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App.run(draw)
        }
    }
}

val draw = graphics {
    val x = it.mouseX
    val y = it.mouseY
    val clicked = it.isMousePressed
    val time = it.now

    clearRect(0.0,0.0, canvas.width, canvas.height)
    fillText("Mouse X: $x", 50.0, 50.0)
    fillText("Mouse Y: $y", 50.0, 80.0)
    fillText("Mouse Clicked: $clicked", 50.0, 120.0)
    fillText("timestamp in nanosec: $time", 50.0, 150.0)
}