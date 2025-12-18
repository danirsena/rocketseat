package classes.classesObjs

import kotlin.random.Random

//final class, closed class. It can't be herdada
class Animatronic(
    val id: Short = Random.nextInt(100).toShort(),
    var model: String,
    var lineOfProduction: String,
    var isPossessed: Boolean = true
) {

    val name: String = "$lineOfProduction $model"

    var password = Random.nextInt(87).toString()
        set(value) {
            if (value.length in (5..9)) field = value
            else println("Essa senha não é permitida. Deve ter entre 5 e 9 caracteres...")
        }
        get() = "A senha é ********"

    private fun intensions(givenPassword: Int): String {
        return if (givenPassword.toString() == password.toString()) "Yes! you know the password." else "No, u are wrong, man."
    }

    fun dadesCreation() = "The animatronic with ID $id and psw ${this.password}"

    fun activate() {
        println("${this.name} is activating now...")
        for (i in 0..4) println("...")
        println("Animatronic activated!")
    }

    //companion objects are things that belongs classes, not your instances

    companion object {
        const val KEY = "1987"
    }
}