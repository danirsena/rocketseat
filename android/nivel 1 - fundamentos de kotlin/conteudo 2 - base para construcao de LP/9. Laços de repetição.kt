fun main() {

    //for e forEach
    val lista = listOf(7, 13, 64, 87, 124)

    for (item in lista) print("$item ")

    println("\n")

    lista.forEach() { print("$it ") }

    println("\n")

    lista.forEachIndexed() { index, item -> println("index: $index, item: $item") }

    println("\nContinue e Break\n")

    for ((index, item) in lista.withIndex()) {
        if (index == 2) continue //continua o loop, sem executar o 2
        println("index: $index, item: $item")
    }

    println("\nWhile\n")

    //while
    var index = 1
    val maxIndex = 13

    while (index < maxIndex) {
        print(message = "index: $index...")
        index++
    }

    println("\n\nDo While\n")

    index = 1

    do {
        print(message = "index: $index...")
        if(index == 7) break
        index++
    } while(index < maxIndex)

    //laços aninhados

    loop@ for (i in 1..6) { //serve para identificar um loop aninhado
        println()
        for (j in 1..6) {
            print("${i * j} ")
            if(i == j) print("= ")
            if (i - j == 1) break@loop //quebra o loop inicial, diferente de simplemente break, que quebra o loop atual
        }
    }

    println("\n")

    //repeat
    repeat(5) {
        print("repeat: $it ")
    }

    println("\n")

    repeat (
        times = 2,
        action = { print("repeat: $it ") }
    )
}