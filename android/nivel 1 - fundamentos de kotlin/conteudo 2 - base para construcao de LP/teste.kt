fun main() {
    val map: Map<String, String> = mapOf("nome" to "Yuri", "sobrenome" to "Alfa")

    println(map["nome"])

    for ((key, value) in map) {
        println("$key: $value")
    }

    map.forEach() { (key, value) -> println("$key: $value") }

    println(soma(4))
}

fun soma(n: Int): Int = if (n == 1) 1 else n + soma(n - 1)
