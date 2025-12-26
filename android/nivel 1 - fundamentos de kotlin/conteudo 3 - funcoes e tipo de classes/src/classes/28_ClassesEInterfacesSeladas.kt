package classes

//sealed classes can be constructed/parameterized, but sealed interfaces can't
// additionally, sealed can be grouped and maintain the same name

//serve para restringir numeros de subclasses permitidas
sealed interface Animal {

    data class Dog(val breed: String) : Animal {
        override fun sound() {
            println("Au au")
        }

        override val name: String
            get() = "Dog"
    }

    data class Cat(val color: String) : Animal {
        override fun sound() = println("Miau miau")

        override val name: String
            get() = super.name + " - Cat"
    }

    val name: String
        get() = "Animal" //essa linha serve para não obrigar a instanciar nas classes que implementam

    fun sound()

}

//Representa estados baseados em uma operação. possibilidade de cobrir resultados de operações genéricas

sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val exception: Exception) : Result()
    data object Loading : Result()

    //pode ser funs ou vals que implementam
    //abstract fun handleResult(result: Result)

    // ou já setar um valor
    val x: String = "Calculando... "
}

fun handleResult(result: Result) {
    when(result) {
        is Result.Success -> println("${result.x} \n    Success: ${result.data}")
        is Result.Error -> println("An error occurred: ${result.exception.message}")
        is Result.Loading -> println("Loading...")
    }
}

object Database {

    fun getGames(): Result {
        return Result.Success(listOf("Minecraft", "Among Us", "Fortnite").joinToString())
    }

    fun insertGame(game: String): Result {
        return Result.Error(Exception(IllegalArgumentException("Game $game can't be inserted")))
    }

    fun updateGame(id: Int, game: String): Result {
        return Result.Loading
    }

}

fun handleAnimal(animal: Animal) {
    when(animal) {
        is Animal.Dog -> println("${animal.name} is a ${animal.breed}")
        is Animal.Cat -> println("${animal.name} is a ${animal.color}")
    }
}

fun main() {

    val games: Result = Database.getGames()
    handleResult(games)

    val insertGame: Result = Database.insertGame("Minecraft")
    handleResult(insertGame)

    val updateGame: Result = Database.updateGame(1, "Among Us")
    handleResult(updateGame)

    // interfaces
    val dog: Animal = Animal.Dog("Golden Retriever")
    dog.sound()
    handleAnimal(dog)
}