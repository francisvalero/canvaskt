package sample.spiral

import core.Sketch
import javafx.scene.paint.Color.*
import java.lang.Math.*


val sketch = Sketch {

    var startingTheta = 0.0

    draw {
        val width = canvas.width
        val height = canvas.height
        save()
        fill = WHITE
        fillRect(0.0, 0.0, width, height)
        fill = ORANGE
        translate(width / 2.0, height / 2.0)
        val maxRadius = max(width, height) / 2.0 + 50.0
        var theta = startingTheta
        var r = 0.0
        while (r < maxRadius) {
            val y = r * sin(toRadians(theta))
            val x = r * cos(toRadians(theta))
            fillOval(x, y, 15.0, 15.0)
            theta += 0.6
            r += 0.05
        }
        restore()
        startingTheta += 0.5
    }
}