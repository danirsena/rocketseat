package classes.classesObjs

open class Animal (val name: String) {

    open val family: String = "Alive"

    open fun sound() = println("The $name som")
}

class Dog(override val family: String): Animal(name = "Dog") {

    override fun sound() {
        // this funtion execute super.sound()
        println("The $name say AUAU")
    }
}