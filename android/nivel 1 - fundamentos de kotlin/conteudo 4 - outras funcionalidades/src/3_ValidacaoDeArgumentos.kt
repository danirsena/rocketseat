fun divide(x: Int, y: Int): Int {
    require(y != 0) { "Divisor nao pode ser zero" } //default é IllegalArgumentException
    return x / y
}

//requireNotNull
fun imprimirNome(name: String?) {
    val nomeNaoNulo = requireNotNull(name) { "Nome nao foi definido" }

    println("O nome e: $nomeNaoNulo")
}

//check
//serve para ver condições internas ao invés das predefinidas. Lança o IllegalStateexception
fun imprimirlista(list: List<Int>) {
    check(list.isNotEmpty()) { "A lista não pode estar vazia"}
    println("Processando lista de tamanho ${list.size}")

    check(list.all() {it != 0}) { "Números 0 são proibidos aqui" }
    println("A media dos nums é ${list.sum() / list.size}")
}

// requireNotNull é validação de entrada, e o check é validação de estado interno

fun main() {

    /*divide(10, 0)
    divide(10, 10)

    imprimirNome(null)
    imprimirNome("John")*/

    imprimirlista(listOf(1, 2, 45, 76, 87))
    imprimirlista(listOf(0, 2))
}