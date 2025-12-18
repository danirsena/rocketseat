package funcoes//add new functions on existing functions from kotlin, without altering th e original ones

//Basically, u put the class that you want to add a new functionality and add a dot with the name of the functionality. To access the value of the class, u add 'this'
fun String.isPalindrome(): Boolean {
    return this == this.reversed()
}

fun Double.format(decimalDigits: Int) = "%.${decimalDigits}f".format(this)

fun main () {

    val isPalindrome = "radar"
    val isPalindrome2 = "Radar"

    println("$isPalindrome is a palindrome? " + isPalindrome.isPalindrome())
    println("And $isPalindrome2, is a palindrome? " + isPalindrome2.isPalindrome())
    println("Oh, is it a case sensitive? Yes, it is")

    val pi = Math.PI

    println("O PI principal é $pi e o PI formato é o ${pi.format(2)}")
}