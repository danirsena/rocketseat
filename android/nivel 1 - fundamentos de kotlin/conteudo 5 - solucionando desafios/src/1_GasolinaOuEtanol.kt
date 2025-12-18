fun main() {

    print("Insira o preco (R$) por litro da gasolina: ")
    val precoGasolina = readln().toDoubleOrNull()

    print("Insira o preco (R$) por litro do etanol: ")
    val precoEtanol = readln().toDoubleOrNull()

    if (precoGasolina == null || precoEtanol == null) {
        println("Preco invalido!")
        return
    }

    val razaoCombustivel = precoEtanol / precoGasolina

    when {
        razaoCombustivel < 0.7 -> println("Atualmente o etanol está mais barato que a gasolina")
        razaoCombustivel > 0.7 -> println("Atualmente a gasolina está mais barata que o etanol")
        else -> println("Os combustiveis estão com o mesmo custo benefício")
    }
}