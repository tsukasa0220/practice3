fun main() {
    val points = arrayOf(Point(1.1, 2.5), 
                         ColorPoint(2.1, 3.9, "red"), 
                         DeepPoint(1.9, 0.25, 5))
    for (p in points) {
        p.moveAndShow(1.5, -0.5)
        println()
    }
}