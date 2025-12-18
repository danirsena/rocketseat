package funcoes

fun main() {

    val num = 3
    var sum = 13 + 64

    //Val that receives an unnamed function ou lambda function
    val funSum = { x: Int, y: Int -> {
        sum = 87 //a ordem dos tratores afeta o viaduto
        x + y
    } }// the alterations that we do here don't go to foreign ones

    //returns a function, without altering the value of variable
    println("Sem o invoke(): ${funSum(13, 87)}")

    println("Valor da funcoes.sum: $sum")

    //invocar a funcao, o que alterou o valor da variável, mas também retorna uma funcao
    println("Com o invoke(): " + funSum(13, 87).invoke())

    println("Valor da funcoes.sum: $sum")

    println("O num $num é par? ${isEven(num)}")
}