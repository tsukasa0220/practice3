open class Point(var x: Double, var y: Double) {
    open fun show() {
        print("($x, $y)")
    }
    fun move(dx: Double, dy: Double) {
        x += dx; y += dy
    }
    fun moveAndShow(dx: Double, dy: Double) {
        move(dx, dy)
        show()
    }
}

class ColorPoint(x: Double, y: Double,
                 var color: String): 
          Point(x, y) {
    override fun show() {
        print("<font color='$color'>($x, $y)</font>")
    }
}

class DeepPoint(x: Double, y: Double, var depth: Int): 
          Point(x, y) {
    override fun show() {
        if (depth <= 0) {
            print("$x, $y")
        } else {
            print("(".repeat(depth) + "$x, $y" 
                   + ")".repeat(depth))
        }
    }
}