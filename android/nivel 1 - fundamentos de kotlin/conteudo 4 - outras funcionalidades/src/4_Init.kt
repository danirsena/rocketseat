//serve para inicializar lógicas que precisa ser feita com oparte do processo de contrução da classe

class Computer (val cpu: String, val ram: String) {
    init {
        println("Ligando pc com CPU $cpu e $ram de RAM")
        require(cpu.isNotEmpty()) { "CPU nao pode ser vazia" }
        require(ram.isNotEmpty()) { "RAM nao pode ser vazia" }
    }

    init {
        println("PC ligado")
    }
}

class Notebook(val montadora: String, val cost: Double) {

    var ano: Int = 0

    init {
        println("Notebook $montadora criado. Welcome year $ano")
    }

    constructor(montadora: String, ano: Int) : this(montadora, 0.0) {
        this.ano = ano
        println("Notebook $montadora ligando...")
    }
}

fun main() {
    val pc = Computer("AMD 5500", "16GB")

    val notebook = Notebook("Apple", 2025)
}