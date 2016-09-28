package core

import java.lang.Math.*;

data class Vector2D(val x: Double, val y: Double) {
    operator fun plus(v: Vector2D) = Vector2D(x + v.x, y + v.y)
    operator fun minus(v: Vector2D) = Vector2D(x + v.x, y - v.y)
    operator fun times(n: Double) = Vector2D(x * n, y * n)
    operator fun div(n: Double) = Vector2D(x / n, y / n)
}
