fun main() {
    //Set - conjunto. Nao pode ter elementos repetidos, mas pode ser mutavel ou imutavel. Nao tem index.

    val set = setOf(13, 64, 87, 87, "The byte of 83", 0..100) //repare que ele nao aceita elementos repetidos, pois ele não printa o 87 duas vezes
    val setMutable = mutableSetOf(1, 2, 3, 4, 5, 87)

    println(set)

    setMutable.add(6)
    setMutable.remove(87)

    println(setMutable)


    //Map - mapa. Nao pode ter chaves repetidas, mas pode ser mutável ou imutável. Nao tem index. Chave e valor.

    val map = mapOf("Yuri Alfa" to 1, "Lupusregina Beta" to 2, "Narberal Gamma" to 3)
    val outroMap = mapOf<String, Int>("Yuri Alfa" to 1, "Lupusregina Beta" to 2, "Narberal Gamma" to 3)
    println("map: $map\n mapValues: ${map.values}\n mapKeys: ${map.keys}\n mapEntries: ${map.entries}")

    val mapMutable = mutableMapOf("Yuri Alfa" to 1, "Lupusregina Beta" to 2, "Narberal Gamma" to 3)
    mapMutable["CZ Delta"] = 4
    mapMutable["Solution Epsilon"] = 5

    mapMutable.remove("Solution Epsilon")

    println("mapMutable: $mapMutable\n mapMutableValues: ${mapMutable.values}\n mapMutableKeys: ${mapMutable.keys}\n mapMutableEntries: ${mapMutable.entries}")

    //funções extras
    val hashMap = hashMapOf("Yuri Alfa" to 1, "Lupusregina Beta" to 2, "Narberal Gamma" to 3)

    println("hashMap: $hashMap\n hashMapValues: ${hashMap.values}\n hashMapKeys: ${hashMap.keys}\n hashMapEntries: ${hashMap.entries}")

    //hashMap x map - o primero eh mutavel e o segundo eh imutavel. O primeiro eh mais performatico e o segundo eh mais seguro.

    val hashSet = hashSetOf(1, 2, 3, 4, 5)

    println("hashSet: $hashSet")

    //hashSet x set - o primero eh mutavel e o segundo eh imutavel. O primeiro eh mais performatico e o segundo eh mais seguro.
}