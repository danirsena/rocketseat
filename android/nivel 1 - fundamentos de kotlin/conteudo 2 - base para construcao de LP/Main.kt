fun main() {

    //if, else e else if tem funcionamento igual todas as outras linguagens

    var x: Int? = null //Null safety. Digo que x pode ser nulo (e por enquanto, ele é mesmo)

    val aa: Int = x!!.toInt()
    //Força que x não seja nulo. Muito perigoso, pois se x for nulo, o programa vai quebrar.
    //Logo, tenha certeza de que não tem como o x ser nulo quando for usar.
    // Aqui, nem tem como ele ter valor, então se usar a 'aa' aqui, o programa quebra.

    val ab = aa as? Int //Conversão de tipos. Se x for nulo, ab recebe null. Se não, ab recebe x convertido para int.
    //conhecido como Safe cast

    ab?.let {
        print(it)
    }

    try {
        println("Try, onde o x é $x")
        print("Coloque o novo x: ")
        x = readln().toInt()
        if (x == 14) throw IllegalNumberException()
    } catch (e: IllegalNumberException) {
        print("Número proibido!\nDigite outro: ")
        x = readln().toInt()
    } catch (e: Exception) {
        println("Ocorreu uma exceção: $e") //e.printStackTrace()
    } finally { println("\nresultados...") } //independente do try ou catch

    //Operadores ternários nos null safety
    val y: Int = x ?: 0 //se x for nulo, y recebe 0, se não, y recebe x.
    var z: Int = 12
    z = x?.toInt() ?: 0 //se x for nulo, z recebe 0, se não, z recebe o valor de x convertido para int.

    print("\nO novo x é $x e ")

    val ifElseMelhorado = when (x) {
        in 1..100 -> "Menor que 100"
        136 -> "Valor igual a 100"
        in -200..-100 -> "Entre -200 e -100"
        else -> "Não passei em ninguém"
    }

    println(ifElseMelhorado)
}

class IllegalNumberException : Throwable()