data class Produto(
    val id: Int,
    val nome: String,
    val preco: Double,
    var quantidade: Int
)

fun adicionarProduto(): Produto {

    var id: Int = 0
    var nome: String = ""
    var preco: Double = 0.0
    var quantidade: Int = 0

    do {
        print("Digite o ID do produto: ")
        id = readln().toInt()
    } while (id < 0)

    do {
        print("Digite o nome do produto: ")
        nome = readln()
    } while (nome.isEmpty())

    do {
        print("Digite o preço do produto: ")
        preco = readln().toDouble()
    } while (preco < 0)

    do {
        print("Digite a quantidade do produto: ")
        quantidade = readln().toInt()
    } while (quantidade < 0)

    val produto = Produto(id, nome, preco, quantidade)

    return produto
}

class ControleDeEstoque {

    var estoque = listOf<Produto>()

    fun inserirProduto(produto: Produto) {
        estoque += produto
    }

    fun atualizarProduto(produto: Produto) {
        estoque = estoque.map {
            if (it.id == produto.id) produto else it
        }
    }

    fun deletarProduto(id: Int) {
        val produto = estoque.find { it.id == id }
        if (produto != null) {
            estoque = estoque.drop(1)
            println("Produto removido com sucesso!")
        } else println("Produto nao encontrado!\n\n")
    }

    fun listarProdutos() {
        if (estoque.isEmpty()) {
            println("Estoque vazio!")
        } else {
            for (produto in estoque) {
                println("ID: ${produto.id}, Nome: ${produto.nome}, Preço: ${produto.preco}, Quantidade: ${produto.quantidade}")
            }
        }
    }

    fun encontrarProduto(id: Int) {
        val produto = estoque.find { it.id == id }
        if (produto != null) {
            println("Produto encontrado: ${produto.nome}")
        } else println("Produto nao encontrado!")
    }
}

fun main() {

    println("\n-- Controle de Estoque --\n")

    val controleDeEstoque = ControleDeEstoque()
    var opcao = 0

    while (true) {

        println("\n Produtos no estoque: ${controleDeEstoque.listarProdutos()}\n")

        println("\n-- Menu --\n")

        println("1 - Adicionar produto")
        println("2 - Remover produto")
        println("3 - Listar produtos")
        println("0 - Sair\n")

        do {
            print("Escolha uma opção: ")
            opcao = readln().toInt()
        } while (opcao !in 0..3)

        when (opcao) {
            1 -> {
                println("\n-- Adicionar produto --\n")
                controleDeEstoque.inserirProduto(adicionarProduto())
            }

            2 -> {
                println("\n-- Remover produto --\n")
                controleDeEstoque.deletarProduto(1)
            }

            3 -> {
                println("\n-- Listar produtos --\n")
                controleDeEstoque.listarProdutos()
            }

            else -> break
        }
    }
    println("\n-- Fim do programa --\n")
}