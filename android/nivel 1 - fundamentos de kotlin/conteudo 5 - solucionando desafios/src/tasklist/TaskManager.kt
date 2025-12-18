package tasklist

import java.time.LocalDateTime

class TaskManager() {

    var tasks: MutableList<Task> = mutableListOf()

    object ObjCreateID {
        fun createID() = Math.random().toInt()
    }

    fun createTask(title: String, description: String) {

        val newTask = Task(
            id = ObjCreateID.createID(),
            title = title,
            description = description,
            isCompleted = false,
            createadAt = LocalDateTime.now()
        )
        tasks.add(newTask)
    }

    fun getTasks() {

        println("Tarefas: ")
        tasks.forEach { task ->
            val (title, isCompleted) = task
            println("($title, $isCompleted)")
        }
    }

    fun getTask(id: Int): Task? {
        return tasks.find { it.id == id }
    }
}

fun main() {
    val lista: TaskManager = TaskManager()

    lista.createTask(
        "Cavar um poço",
        "Enterrar o sus que moggou o chat"
    )

    println(lista.getTasks())
}