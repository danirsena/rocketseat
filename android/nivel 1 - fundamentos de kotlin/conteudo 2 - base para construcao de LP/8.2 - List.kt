fun main() {
    //List
    //Diferente do Array, pode adicionar e remover elementos,desde que ele seja mutável
    val list = listOf(1, 2, "3", 4, "5", 6, 7, 8, 9, 10)
    val listInt: List<Int> = list.filterIsInstance<Int>()
    val mutableList = mutableListOf(11, 12, 13.87, false, 15, 16, 17, "+18", 19, 20)
    val listOrganizada = listOf("BETA - Lupusregina", "ALFA - Yuri", "DELTA - CZ")

    println("\nLists\n")

    mutableList.add(21)

    println("mutableList add: $mutableList")
    println("filterIsInstance(): $listInt")
    println("filter(): " + list.filter { it is Int && it > 7 })
    println("sorted(): " + listOrganizada.sorted() + "\nreversed(): " + listOrganizada.reversed()) //sorted() organiza a lista em ordem crescente e reversed() organiza em ordem decrescente
    println("maxOf(): " + listInt.max())
    println("minOf(): " + listInt.min())
    println("sumOf(): " + listInt.sum())
    println("averageOf(): " + listInt.average())
    println("countOf(): " + listInt.count())
    println("find(): " + listInt.find { it % 2 == 0 }) //encontra o primeiro elemento da lista que seja divisível por 2
    println("findAll(): " + listInt.findLast { it % 2 == 0 }) //encontra todos os elementos da lista que seja divisível por 2
    print("map: " + listInt.map { it * 2 }) //Multiplica todos os elementos da lista por 2. O map transforma os elementos da lista em outro tipo

    //funções extras
    println("first(): " + listInt.first())
    println("last(): " + listInt.last())
    println("subList(): " + listInt.subList(2, 5))
    println("list[0]: " + list[0])
    println("indexOf(): " + listInt.indexOf(6))
    println("indices: " + listInt.indices)
    println("size: " + listInt.size)
    println("isEmpty(): " + listInt.isEmpty())
    println("isNotEmpty(): " + listInt.isNotEmpty())
    println("drop(): " + listInt.drop(3))
    println("dropLast(): " + listInt.dropLast(2))
    listInt.dropWhile { it % 2 != 0 }
    listInt.any { it < 0}
    listOrganizada.any { it.startsWith("A") }
    println(mutableList.all { it is Double })
    println(mutableList.zip(list))
    list.elementAt(1)
    list.getOrNull(10)
    println(listInt.mapIndexed { index, item -> index + item}) //soma 'item' e i número da sua posição
}