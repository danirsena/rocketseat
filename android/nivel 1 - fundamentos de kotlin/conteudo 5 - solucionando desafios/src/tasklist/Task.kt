package tasklist

import java.time.LocalDateTime

class Task(
    val id: Int,
    var title: String,
    var description: String,
    var isCompleted: Boolean,
    val createadAt: LocalDateTime
) {
    operator fun component1() = title
    operator fun component2() = isCompleted
    operator fun component3() = description
    operator fun component4() = isCompleted
    operator fun component5() = createadAt
}