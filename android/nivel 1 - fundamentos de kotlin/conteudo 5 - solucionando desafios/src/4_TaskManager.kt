import tasklist.Menu
import tasklist.TaskManager

object Get {
    fun getInt(msg: String): Int {
        print(msg)
        val num = readln().toInt()
        return num
    }

    fun getString(msg: String): String {
        print(msg)
        val string = readln()
        return string
    }
}

fun main() {

    val lista = TaskManager()
    var option: Int

    while (true) {

        Menu.getMenu()
        option = Menu.getOption()
        if (option == 0) break

        when (option) {

            // 1. Cria a tarefa
            1 -> {
                lista.createTask(
                    Get.getString("Coloque o nome: "),
                    Get.getString("Coloque a descricao: ")
                )
            }

            // 2. Pega as tarefas
            2 -> {
                println("\nTarefas: ")
                lista.getTasks()
            }

            // 3. Busca uma tarefa
            3 -> {
                val id = Get.getInt("Digite o id da tarefa a ser buscada: ")
                println(lista.getTask(id))
            }

            // 4. Exclui uma tarefa
            4 -> {
                val id = Get.getInt("Digite o id da tarefa a ser excluida: ")
                println(lista.deleteTask(id))
            }

            // 5. Conclui uma tarefa
            5 -> {
                val id = Get.getInt("Digite o id da tarefa a ser completada: ")
                println(lista.completeTask(id))
            }

            // 6. Lista as tarefas concluidas
            6 -> {
                println("Tarefas Concluídas")
                lista.filterTask(true).forEach { item ->
                    println(item.toString())
                }
            }

            // 7. Lista as tarefas ativas
            7 -> {
                println("Tarefas em Curso")
                lista.filterTask(false).forEach { item ->
                    println(item.toString())
                }
            }

            // 8. Retorna a quantidade de tarefas
            8 -> println("Quantidade de tarefas: " + lista.getCounter())

            // 9. Retorna uma tarefa formatada
            9 -> {
                print("Digite o id da tarefa a ser formatada: ")
                val id = readln().toInt()
                println(lista.getTask(id).toString())
            }

            // 10. Altera uma task
            10 -> {
                val id = Get.getInt("Digite o id da task que será alterada: ")
                val newNome = Get.getString("Digite o novo nome: ")
                val newDscr = Get.getString("Digite o novo nome: ")
                lista.alterarTask(id, newNome, newDscr)
            }
        }
    }
}