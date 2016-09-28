package core

import javafx.scene.canvas.GraphicsContext
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent

class Sketch(f: Sketch.() -> Unit) {
    var now: Long = 0
        get() = now
        internal set(value) {
            field = value
        }
    var mouseX: Double = 0.0
        get() = mouseX
        internal set(value) {
            field = value
        }
    var mouseY: Double = 0.0
        get() = mouseY
        internal set(value) {
            field = value
        }
    var isMousePressed: Boolean = false
        get() = isMousePressed
        internal set(value) {
            field = value
        }
    var width: Double = 0.0
        get() = width
        internal set(value) {
            field = value
        }
    var height: Double = 0.0
        get() = height
        internal set(value) {
            field = value
        }


    private var fDraw: (GraphicsContext.() -> Unit) = {}
    private var fSetup: (GraphicsContext.() -> Unit) = {}
    private var fMousePressed: (GraphicsContext.(MouseEvent) -> Unit) = {}
    private var fMouseReleased: (GraphicsContext.(MouseEvent) -> Unit) = {}
    private var fMouseMoved: (GraphicsContext.(MouseEvent) -> Unit) = {}
    private var fMouseClicked: (GraphicsContext.(MouseEvent) -> Unit) = {}
    private var fMouseEntered: (GraphicsContext.(MouseEvent) -> Unit) = {}
    private var fMouseExited: (GraphicsContext.(MouseEvent) -> Unit) = {}
    private var fMouseDragged: (GraphicsContext.(MouseEvent) -> Unit) = {}

    private var fKeyPressed: (GraphicsContext.(KeyEvent) -> Unit) = {}
    private var fKeyReleased: (GraphicsContext.(KeyEvent) -> Unit) = {}
    private var fKeyTyped: (GraphicsContext.(KeyEvent) -> Unit) = {}

    init {
        f()
    }

    fun draw(g: GraphicsContext.() -> Unit) {
        fDraw = g
    }

    fun setup(g: GraphicsContext.() -> Unit) {
        fSetup = g
    }

    fun mousePressed(g: GraphicsContext.(MouseEvent) -> Unit) {
        fMousePressed = g
    }

    fun mouseReleased(g: GraphicsContext.(MouseEvent) -> Unit) {
        fMouseReleased = g
    }

    fun mouseMoved(g: GraphicsContext.(MouseEvent) -> Unit) {
        fMouseMoved = g
    }

    fun mouseClicked(g: GraphicsContext.(MouseEvent) -> Unit) {
        fMouseClicked = g
    }

    fun mouseEntered(g: GraphicsContext.(MouseEvent) -> Unit) {
        fMouseEntered = g
    }

    fun mouseExited(g: GraphicsContext.(MouseEvent) -> Unit) {
        fMouseExited = g
    }

    fun mouseDragged(g: GraphicsContext.(MouseEvent) -> Unit) {
        fMouseDragged = g
    }

    fun keyPressed(g: GraphicsContext.(KeyEvent) -> Unit) {
        fKeyPressed = g
    }

    fun keyReleased(g: GraphicsContext.(KeyEvent) -> Unit) {
        fKeyReleased = g
    }
    fun keyTyped(g: GraphicsContext.(KeyEvent) -> Unit) {
        fKeyTyped = g
    }

    internal fun setup(g: GraphicsContext) = g.fSetup()
    internal fun draw(g: GraphicsContext) = g.fDraw()
    internal fun mousePressed(g: GraphicsContext, e: MouseEvent) = g.fMousePressed(e)
    internal fun mouseReleased(g: GraphicsContext, e: MouseEvent) = g.fMouseReleased(e)
    internal fun mouseClicked(g: GraphicsContext, e: MouseEvent) = g.fMouseClicked(e)
    internal fun mouseMoved(g: GraphicsContext, e: MouseEvent) = g.fMouseMoved(e)
    internal fun mouseEntered(g: GraphicsContext, e: MouseEvent) = g.fMouseEntered(e)
    internal fun mouseExited(g: GraphicsContext, e: MouseEvent) = g.fMouseExited(e)
    internal fun mouseDragged(g: GraphicsContext, e: MouseEvent) = g.fMouseDragged(e)
    internal fun keyPressed(g: GraphicsContext, e: KeyEvent) = g.fKeyPressed(e)
    internal fun keyReleased(g: GraphicsContext, e: KeyEvent) = g.fKeyReleased(e)
    internal fun keyTyped(g: GraphicsContext, e: KeyEvent) = g.fKeyTyped(e)
}