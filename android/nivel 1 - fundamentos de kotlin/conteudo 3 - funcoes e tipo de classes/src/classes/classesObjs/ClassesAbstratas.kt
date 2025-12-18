package classes.classesObjs

abstract class Veiculo {

    abstract val maxSpeed: Int
    abstract val wheelsAmount: Int

    abstract fun startMoving()
}

class Carro(montadora: String): Veiculo() {

    override var maxSpeed: Int = 200
    override val wheelsAmount: Int = 4

    override fun startMoving() {
        println("The car is moving at $maxSpeed km/h")
    }
}

class Bicycle: Veiculo() {

    override var maxSpeed: Int = 120
    override var wheelsAmount: Int = 2

    override fun startMoving() {
        println("The bicycle is moving at $maxSpeed km/h! WOW, are you kidding me?")
    }

    override fun toString(): String {
        return "$maxSpeed, $wheelsAmount"
    }
}

fun main() {

    val celta = Carro("Chevrolet")
    celta.maxSpeed = 200
    celta.startMoving()

    val bike: Bicycle = Bicycle()
    bike.maxSpeed = 120
    bike.wheelsAmount = 2
    bike.startMoving()

    println(bike)

}