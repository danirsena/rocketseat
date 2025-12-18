//serve para nomear tipos que já ecistem no Kotlin, um nome alternativo pra ele

typealias Operation = (Int, Int) -> Int

fun mathOperation(x: Int, y: Int, operation: Operation): Int {
    return operation(x, y)
}

typealias NotasDosAlunos = List<Int>
typealias NomeDoAluno = String

typealias MapaDeEstudantes = Map<NomeDoAluno, NotasDosAlunos>

fun processarNotas(mapaDeEstudantes: MapaDeEstudantes) {

    for((nome, notas) in mapaDeEstudantes) {
        println("Nome: $nome | Notas: $notas")
        println("Media: ${notas.average()}")
    }
}

fun main() {

    val estudantes: MapaDeEstudantes = mapOf(
        "Yuri Alpha" to listOf(10, 8, 7),
        "Lupus Berta" to listOf(9, 8, 7),
        "Milim Nava" to listOf(10, 8, 7),
    )

    processarNotas(estudantes)
}