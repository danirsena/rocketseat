package tasklist

import java.time.LocalDateTime

data class Task(
    val id: Int,
    var title: String,
    var description: String?,
    var isCompleted: Boolean,
    val createdAt: LocalDateTime
) {
    override fun toString(): String {
        return "ID: $id | Título: $title | Concluído: $isCompleted | Criado em: $createdAt"
    }
}