import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val name = "D4N1D4N" // val vem de value, uma variável imutável
    //name = "Aaaaaaaah"

    var idade = 21 //var de variable (obviamente do mesmo tipo)
    idade = 22

    //Tipos variáveis

    //Nums | Legal que nos nums, o K deixa um por _ para organization
    val bytes: Byte = 127 //de -128 até 127. Int com 8bits
    val shorts: Short = -32_768 // de -32768 até 32767. Tem 16 bits, é Int too
    val ints: Int = 12 // de 2^31 until 2^31 -1. Tem 32bits de resolution
    val longs: Long = 2684564523254576579 //com 64bits, vai de 2 63 até 2 63 -1
    val floats: Float = 13.87F // Don't forget 'F'. Tem 32bits
    val double: Double = 13.87 // Don't need 'D', mas o 3 must be 3.0, for exemple

    //letters
    val char: Char = '%'
    val string: String = "SUS"

    val textao: String =
        """
            Era uma vez um enchedor de linguiça, que lembrou de um cara que enchia uma linguiça tão boa quanto a dele. Começa assim: Ah, parece que agora você tem tempo de me escutar... Sempre tem algo a aprender com os outros, mesmo que o conteúdo do discurso possa parecer irrelevante. Veja, meu amigo Orville e eu estávamos sentados à beira de um lago, como costumávamos fazer... Ah, eu me lembro tão bem, era um dia tranquilo. Orville trouxe um sanduíche de presunto, eu acredito. Sim, era de presunto. Ou talvez tenha sido de peru? Enfim, não importa. Ele deixou cair o sanduíche na água, o que foi uma grande decepção para ele. Mas eu disse a ele: ‘Orville, a vida é cheia de desapontamentos. Às vezes você só precisa seguir em frente’. Então, ele pegou um pouco de pão que restou e comeu mesmo assim. Sabe, eu sempre achei interessante como as pessoas reagem a coisas triviais. Como o som das folhas caindo ou como as estrelas piscam à noite... Ah, onde eu estava mesmo? Ah, sim, o sanduíche. É engraçado como pequenas coisas podem estragar o dia de alguém, mas se você pensar bem, elas não têm tanta importância assim. Às vezes, só precisamos aprender a nos adaptar às mudanças inesperadas, como um sanduíche que cai no lago. Bem, acho que isso é tudo por enquanto. Espero que tenha sido útil para você de alguma forma...
        """.trimIndent() //trim tira espaços em branco

    val comedia: String = "$shorts"
    val comedia2: String = "$double e $ints são top.\n"

    val bool: Boolean = true

    println("$textao \n\n\n $comedia2")

    var age: Int = 21
    val meses: Double = 1.0 / 12.0
    var realAge: Double = age.toDouble()
    realAge += 12 * meses

    println("Minha ideade real é $realAge anos")

    val lindo = true
    val cabaço = false
    val D4N1L1ND0 = true

    val teste1 = lindo && cabaço
    val teste2 = lindo || cabaço
    val teste3 = !lindo

    println(teste1)
    println(teste2)
    println(teste3)

    val pow = age.toDouble().pow(3.0)
    val sqrt = sqrt(pow)
    val round = Math.round(sqrt)
    val newRound = Math.round(sqrt)
    val newSqrt = floor(sqrt).toInt()
    val newSqrt2 = ceil(sqrt).toInt()

    println(pow)
    println(sqrt)
    println(round)
    println(newRound)
    println(newSqrt)
    println(newSqrt2)

    println("Qual seu nome?: ")
    val nome = readln()

    println("Qual sua idade?: ")
    age = readln().toInt()

    println("\nSaluton, $nome\n")

    for (i in 1..age)
        if (i == age) println("Mas agora voce tem $age anos") else println("Voce tinha $i anos")

    var a = 20 / 3
    println(a)
    --a
    println(a)
}