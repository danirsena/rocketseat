data class Person(val name: String, val lastName: String, val age: Int)

class Animal(val name: String, val lastName: String, val age: Int) {
    operator fun component1() = name
    operator fun component2() = lastName
    operator fun component3() = age
}

fun main() {

    //desetrução de dados só servem para data classe os

    val (name, lastName, age) = Person("John", "Doe", 30)

    val (name2, lastName2) = Pair<String , String> ("John", "Doe")

    val (name3, lastName3, age3) = Triple<String , String , Int> ("John", "Doe", 30)

    println(name)
    println(lastName)
    println(age)

    println(name2)
    println(lastName2)

    println(name3)
    println(lastName3)
    println(age3)

    // para uma class convencional ter o desctructuring, dentro dela deeve ter os metodos component1, component2, component3, etc. Exemplo da classe Animal

    val (nameCao, lastNameCao, ageCao) = Animal("Rabito", "Da Silva", 1)

    println(nameCao)
    println(lastNameCao)
    println(ageCao)
}