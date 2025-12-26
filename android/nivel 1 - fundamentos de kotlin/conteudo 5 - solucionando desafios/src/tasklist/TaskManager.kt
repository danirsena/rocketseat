package tasklist

import java.time.LocalDateTime

object ObjCreateID {

    fun createID(tasks: List<Task>): Int {
        var id: Int = (Math.random() * 100).toInt()
        while (true) {
            if (tasks.find { it.id == id } == null) break
            id = (Math.random() * 100).toInt()
        }
        return id
    }
}

sealed class SealedReturn {
    data class Success(val message: String) : SealedReturn()
    data class Error(val message: String) : SealedReturn()
}

class TaskManager() {

    var tasks: MutableList<Task> = mutableListOf()

    fun createTask(title: String, description: String) {

        val newTask = Task(
            id = ObjCreateID.createID(tasks),
            title = title,
            description = description,
            isCompleted = false,
            createdAt = LocalDateTime.now()
        )
        tasks.add(newTask)

        println("\n" + SealedReturn.Success("Tarefa adicionada com sucesso! ID: ${newTask.id}"))
    }

    fun getTasks() {

        if (tasks.isEmpty()) {
            println("Não há tarefas...")
            return
        }

        tasks.forEach { task ->
            val (title, isCompleted) = TaskDTO(task.title, task.isCompleted)
            println("($title, $isCompleted)")
        }
    }

    fun getTask(id: Int): Task? {
        val task = tasks.find { it.id == id }
        if (task == null) println(SealedReturn.Error("Tarefa com ID $id nao encontrada!"))
        return task
    }

    fun deleteTask(id: Int) {
        val task = getTask(id)
        if (task != null) {
            require(task.title.isBlank())
            println(SealedReturn.Success("Tarefa com ID $id removida com sucesso"))
            tasks.remove(task)
        } else println(SealedReturn.Error("Tarefa com ID $id nao encontrada!\n"))
    }

    fun completeTask(id: Int) {

        val task = getTask(id)

        if (task != null) {
            task.isCompleted = true
            println(SealedReturn.Success("Status da tarefa ID ${task.id} atualizado para true"))
        } else return println(SealedReturn.Error("Tarefa com ID $id nao encontrada!"))
    }

    fun alterarTask(id: Int, newTitle: String, newDescr: String) {

        val task = getTask(id)
        if (task == null) SealedReturn.Error("Task com ID $id não encontrada")
        else {

            if ((task.title).isBlank()) {
                SealedReturn.Error("O título está em branco. Adicione um título antes de seguir com a alterção")
                return
            }
            task.title = newTitle
            task.description = newDescr.ifBlank { task.description }
        }
    }

    fun filterTask(seletor: Boolean): List<Task> = tasks.filter { it.isCompleted == seletor }

    fun getCounter(): Int = tasks.size
}