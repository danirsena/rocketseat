package classes.classesObjs

class Car(val chassi: Int, val model: String, val year: Int) {

    class Engine {

        // as classes não tem acesso aos dados da superior
        class FuelType(val typeName: String) {
            fun fuelCar() = println("Abastecendo o carro com $typeName")
        }

        fun start() = println("Ligando carro...")

    }
}

fun main() {

    val carrinho: Car = Car(12314, "Chevrolet Onyx", 2025)

    var carrinhoEngine = Car.Engine()

    val fuelType = Car.Engine.FuelType("Gasolina")

    fuelType.fuelCar()

}