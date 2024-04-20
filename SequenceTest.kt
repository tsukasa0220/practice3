fun main() {
    val nums = generateSequence(1) { x -> x + 3 }
    println(nums.take(10).toList())
    val fibs = sequence {
        var a = 1; var b = 1
        while (true) {
            yield(a)
            val c = a
            a = b; b += c
        }
    }
    println(fibs.take(10).toList())
}