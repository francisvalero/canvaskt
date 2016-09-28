package sample.simple

import core.App
import core.Sketch
import javafx.scene.paint.Color
import java.util.*


class Simple{
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App.run(sketch)
        }
    }
}

val sketch = Sketch{
    setup{
        fill = Color.ORANGE
    }
    draw {
        val r = Random()
        fillRect(r.nextInt(640).toDouble(), r.nextInt(360).toDouble(), 10.0, 10.0)
    }
}
