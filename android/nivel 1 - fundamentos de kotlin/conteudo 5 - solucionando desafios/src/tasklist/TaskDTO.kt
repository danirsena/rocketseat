package tasklist

data class TaskDTO(
    val title: String,
    val isCompleted: Boolean
) {
    override fun toString(): String {
        return "(${title}, ${isCompleted})"
    }
}