fun main() {

    //Array

    val array: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val array2: Array<Int> = arrayOf(11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

    println("\nArrays")

    println("array: $array") //printa tipo e posição da memória onde o array2 está armazenado
    println("array2: " + array2.joinToString(prefix = "[", postfix = "]", separator = "-")) //função para printar array, muito powerful

    val array3 = array + array2

    //consigo add mais itens em um array?

    println("concatenado: " + array3.joinToString())
}