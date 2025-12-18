package classes.classesObjs

// diz respeito ao comportamento dos genericos em relaçaõ a herança dos tipos recebdiso. Especificar varianca que será implementado em generics.

// OUT - co variancia
// IN - contra variancia

open class Place(val name: String)

class Room : Place("living room")
class Kitchen : Place("kitchen")
class RestRoom : Place("rest room")

// 1. contra varianca ou consumidores. Se tem vinculo com generics e tem in no escopo
class Cleaner<in T : Place> { // esse in serve para restringir saídas (ou seja, só aceita inputs. )

    fun clean(place: T) { //Se tentar dar um return com o param d T dentro do scope, da erro
        println("Cleaning ${place.name}")
        return
    }
}

// 2. OUT ou produtores - covarianca, só produz valores do tipo generics

open class Drink(val nameOfDrink: String)

class Juice : Drink("juice")
class Water : Drink("water")
class Soda : Drink("soda")

class Cup<out T : Drink>(val drink: T, val amount: Int) // colocando ALT aqui, não vai deixar botar param

fun serveDrink(cup: Cup<Drink>) {
    println("Serving ${cup.drink.nameOfDrink} de quantidade ${cup.amount}l")
}


fun main() {

    Cleaner<Room>().clean(Room())

    serveDrink(Cup(Juice(), 1))
    serveDrink(Cup(Soda(), 87))

}
