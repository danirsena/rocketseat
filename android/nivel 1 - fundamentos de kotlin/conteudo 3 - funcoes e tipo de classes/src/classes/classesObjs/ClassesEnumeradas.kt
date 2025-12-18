package classes.classesObjs

import jdk.jfr.Description
import javax.lang.model.util.Elements

enum class Element(val description: String) {
    FIRE("the most destructive element") {
        override fun symbol(): String = "🔥"
        override val users: List<String> = listOf("Carla", "Fajro", "Adam, Rick")
    },

    WATER("the most life-sustaining element") {
        override fun symbol(): String = "💧"
        override val users: List<String> = listOf("Rebeca", "Regelos", "Adam, Rick")
    },

    EARTH("good element for construction") {
        override fun symbol(): String = "🌍"
        override val users: List<String> = listOf("Carla", "Fajro", "Adam, Rick")
    },

    AIR("this element provides movement velocity") {
        override fun symbol(): String = ""
        override val users: List<String> = listOf("Mertir", "Larry", "Adam, Rick")
    },

    DARK("witches and magicians love this one") {
        override fun symbol(): String = ""
        override val users: List<String> = listOf("Morgana", "Adam, Rick")
    },

    LIGHT("loved by all papas and children") {
        override fun symbol(): String = "☀️"
        override val users: List<String> = listOf("Agatha", "Adam, Rick")
    },

    NATURE("the center of life") {
        override fun symbol(): String = ""
        override val users: List<String> = listOf("Hera", "Adam, Rick")
    },

    ELECTRICITY("the most important element of all") {
        override fun symbol(): String = ""
        override val users: List<String> = listOf("HR", "Adam")
    },

    METAL("the most durable element") {
        override fun symbol(): String = ""
        override val users: List<String> = listOf("Will", "Henrickson")
    };

    companion object {

        fun sumElements(firstElement: Element, secondElement: Element) {
            println("The sum of ${firstElement.name} and ${secondElement.name} is ${firstElement.ordinal + secondElement.ordinal}")
        }
    }

    fun addElement(element: Element) {
        println(this.description)
        println(element.description)
    }

    abstract fun symbol(): String

    abstract val users: List<String>
}

fun main() {
    var element = Element.WATER
    println(element)
    println(element.symbol())
    println(element.ordinal)

    element = Element.FIRE
    println(element)
    println(element.name)
    println("The ${element.name} description is '" + element.description + "'")

    element.addElement(Element.EARTH)

    Element.sumElements(Element.FIRE, Element.WATER)

    // entries
    Element.entries.forEach {
        println("${it.name} is ${it.description}")
    }

    //valueOf
    println(Element.valueOf("FIRE").ordinal)

    //users of water
    println("${element.symbol()} | ${element.name} - users: ${element.users}")
}