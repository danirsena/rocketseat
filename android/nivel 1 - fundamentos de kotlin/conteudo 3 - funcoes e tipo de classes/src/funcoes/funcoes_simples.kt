package funcoes

fun isEven(number: Int) = number % 2 == 0


fun isEve(num: Int): Boolean {

    if (num % 2 == 0) println("O $num é par")
    else println("O $num é ímpar")

    return true
}