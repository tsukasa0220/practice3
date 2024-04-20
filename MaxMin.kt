fun maxMin(arr: Array<Double>):Pair<Double, Double> {
    var max: Double = arr[0]
    var min: Double = arr[0]
    for (i in 1 until arr.size) {
        if (arr[i] > max) {
            max = arr[i]
        } else if (arr[i] < min) {
            min = arr[i]
        }
    }
    return Pair(max, min)
}

fun main() {
    val a1 = arrayOf(9.0, 8.1, 7.2, 6.3)
    val a2 = arrayOf(1.2, 3.4, 5.6, 2.1, 2.0)
    val a3 = arrayOf(-3.3, -4.4, -2.1, -3.7, -4.2, -1.0)

    val (x1, n1) = maxMin(a1)
    println("a1 の最大値は $x1、最小値は $n1")
    val (x2, n2) = maxMin(a2)
    println("a2 の最大値は $x2、最小値は $n2")
    val (x3, n3) = maxMin(a3)
    println("a3 の最大値は $x3、最小値は $n3")
}