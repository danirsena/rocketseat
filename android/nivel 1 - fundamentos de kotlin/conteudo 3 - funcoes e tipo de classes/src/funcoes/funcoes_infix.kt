package funcoes

infix fun Int.sum(num: Int): Int = this + num

class XY(val x: Int, val y: Int) {
    infix fun sum(xy: XY): XY {
        return XY(x = this.x + xy.x, y = this.y + xy.y)
    }
}

// note that =, - and / are infix functions! Oh, cool
fun main () {

    //functions infix have a parameter, which aren't var args. To be able, it needs to be a class function or be an extensional function

    println(1 sum 2)

    val sumXY = XY(x = 1, y = 2) sum XY(12, 53)

    println("\n\tThe funcoes.sum of numbers is ${sumXY.x} for X and ${sumXY.y} for Y")
}