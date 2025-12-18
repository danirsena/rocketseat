package classes.classesObjs

// does not depend on the type
// can impor uma restriction de tipo generic.

//Fun generic
// Item é um placeholder para o tipo, so need to stay entre <>. Seu nome can be anything.
fun <Item> printItem(item: Item) {
    println(item)
}

// The
//printItem
// function on line 12 is a generic utility that prints any value passed to it, regardless of type, using Kotlin's generics to maintain type safety while working with any data type.
fun <T : Comparable<T>> maiorDe(a: T, b: T): T {
    return if (a > b) a else b
}

//Class generic
// Item é um placeholder para o tipo, so need to stay between <>. Seu nome can be anything.
class Box<T>(val items: List<T>) : ItemsPrinter<T> {
    fun printItems() {
        println(
            """
            The box contains: 
            ${items.joinToString(", ")}
            """.trimIndent()
        )
    }

    override fun showItem(items: T) {
        println(items)
    }
}

interface ItemsPrinter<T> {
    fun showItem(items: T)
}

fun <T> List<T>.secondOrNull(): T? = if (size <= 2) null else this[1]

fun main() {

    val list = listOf(1, 2, 3, 4, 5)

    printItem(object {
        val name = "Yuri Alpha"
        val age = 21
    })

    val boxOfNumbers = Box(
        listOf(
            1, 2, 3, 4, 5
        )
    )
    boxOfNumbers.printItems()

    val boxOfStrings = Box(listOf("Hello", "World"))
    boxOfStrings.printItems()
    boxOfStrings.showItem(boxOfStrings.items.first())

    println(list.secondOrNull())
    println(listOf("NI").secondOrNull())

    println(maiorDe(a = "Hello", b = "Kotlin"))
    println(maiorDe(87, 13))
    //dá error, because tem que ser do same tipo println(maiorDe("Hello", 12))
}