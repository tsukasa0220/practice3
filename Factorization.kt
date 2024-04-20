fun factorization(num: Int): Sequence<Int> {
    var fact = 2
    var n: Int = num
    return sequence {
        while (fact * fact <= n) {
            if (n % fact == 0) {
                yield(fact)
                n /= fact
            } else {
                fact++
            }
        }
        if (n > 1) {
            yield(n)
        }
    }
}

fun main() {
    while (true) {
        print("正の整数を入力してください: ")
        val n = try {
            readLine()?.toInt()?:0
        } catch (ex: Exception) { 0 }
        if (n <= 0) {
            println("終了します")
            break
        }
        val result = factorization(n).toList()
        println("$n の素因数分解の結果は $result です。")
    }
}