package funcoes

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun subtract(a: Int, b: Int) = a - b

fun multiply(a: Int, b: Int) = a * b

fun operate(a: Int, b: Int, operation: (Int, Int) -> Int): Int = operation(a, b)
//basicamente, a funcao recebe uma funcao como argumento

fun main() {
    val divide = { a: Int, b: Int -> a / b }

    println(operate(2, 3, ::sum))
    println(operate(2, 3, ::subtract))
    println(operate(2, 3, divide))
    println(operate(2, 3, ::multiply))
}