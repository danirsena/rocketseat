package classes

import classes.classesObjs.Animal

import classes.classesObjs.Animatronic
import classes.classesObjs.Dog


fun main() {

    //1. Animatronics

    val key = Animatronic.KEY

    //Observe that Funtime Freddy doesn't have an attribute key. It belongs to Animatronic
    val funtimeFreddy: Animatronic = Animatronic(model = "Freddy", lineOfProduction = "Funtime")

    println(funtimeFreddy.dadesCreation())

    funtimeFreddy.password = 113423.toString()

    println(funtimeFreddy.password)

    //2. Animals

    val animal: Animal = Animal("Giraffe")
    animal.sound()

    val doguinho: Dog = Dog("caramel")
    doguinho.sound()
    println("The ${doguinho.name}'s raça is ${doguinho.family}")
}