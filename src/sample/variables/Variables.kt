package sample.variables

import core.App
import core.Canvas2D
import core.Sketch
import javafx.scene.canvas.Canvas

class Variables {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App.run(sketch)
        }
    }
}

val sketch = Sketch {
    draw {
        val x = mouseX
        val y = mouseY
        val clicked = isMousePressed
        val time = nano
        clearRect(0.0, 0.0, canvas.width, canvas.height)
        fillText("Mouse X: $x", 50.0, 50.0)
        fillText("Mouse Y: $y", 50.0, 80.0)
        fillText("Mouse Clicked: $clicked", 50.0, 120.0)
        fillText("timestamp in nanosec: $time", 50.0, 150.0)
    }
}