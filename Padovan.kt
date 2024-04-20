val padovan = sequence {
    var a = 1; var b = 1; var c = 1; var tmp: Int
    yield(a); yield(b); yield(c)
    while (true) {
        tmp = b + a
        yield(tmp)
        a = b
        b = c
        c = tmp
    }
}

fun main() {
    println(padovan.take(30).toList())
}