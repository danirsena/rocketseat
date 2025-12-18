package classes.classesObjs

//também são aninhas, mas tem referencia a instancia da classe externa.
class Animatronics (val model: String, val type: String) {

    //class interna
    inner class Creator {
        val name: String = "Henry Emilly"
        val status: String = "Dead"

        fun getCreatorToString() {
            //notice that on classes aninhadas, isn't possible get superiors attributes
            println("The $type's creator is $name")
        }
    }
}

fun main() {

    val neddBear = Animatronics ("Freddy", "Mediocre Melodies")

    println(neddBear.Creator().getCreatorToString())

}

