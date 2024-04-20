fun twice(x: Int): Int {
    return x + x
}

fun thrice(x: Int) = x + x + x

fun sayHello(): Unit {
    println("Hello!")
}

fun sayGoodbye() {
    println("Goodbye!")
}

fun main() {
    println(twice(2))
    println(thrice(2))
    sayHello()
    sayGoodbye()
}