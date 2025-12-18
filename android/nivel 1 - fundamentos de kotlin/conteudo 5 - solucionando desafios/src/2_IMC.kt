fun validarDado(dado: String, maximo: Double): Double {

    var dadoValidado: Double? = 0.0

    do {
        print("Insira o $dado: ")
        dadoValidado = readln().toDoubleOrNull()
    } while (dadoValidado == null || dadoValidado <= 0 || dadoValidado > maximo)
    return dadoValidado
}

enum class IMC {
    ABAIXO_DO_PESO,
    NORMAL,
    SOBREPESO,
    OBESIDADE_DE_GRAU_1,
    OBESIDADE_DE_GRAU_2,
    OBESIDADE_DE_GRAU_3;

    companion object {
        fun gerarClassificacaoIMC(massa: Double, altura: Double): IMC {
            val imc = massa / (altura * altura)
            return when {
                imc < 18.5 -> ABAIXO_DO_PESO
                imc < 25 -> NORMAL
                imc < 30 -> SOBREPESO
                imc < 35 -> OBESIDADE_DE_GRAU_1
                imc < 40 -> OBESIDADE_DE_GRAU_2
                else -> OBESIDADE_DE_GRAU_3
            }
        }
    }
}

fun main() {

    println("\n-- IMC Calculator --\n")

    val massa = validarDado("massa", 300.00)
    val altura = validarDado("altura", 3.00)
    val imc = (massa / (altura * altura))
    var resposta = "Com imc de %.2f".format(imc) + " você está "

    resposta += IMC.gerarClassificacaoIMC(massa, altura)

    println(resposta)
}