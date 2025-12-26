package tasklist

object Menu {
    fun getMenu() {
        println("\n0 - Sair")
        println("1 - Adicionar tarefa")
        println("2 - Listar tarefas")
        println("3 - Buscar tarefa")
        println("4 - Excluir tarefa")
        println("5 - Completar tarefa")
        println("6 - Filtrar tarefas concluídas")
        println("7 - Filtrar tarefas pendentes")
        println("8 - Contagem de tarefas")
        println("9 - Converter tarefa formatada")
        println("10 - Atualizar tarefa\n")
    }

    fun getOption(): Int {

        var option: Int

        do {
            print("opcao: ")
            option = readln().toInt()
        } while (option !in 0..10)

        return option
    }
}