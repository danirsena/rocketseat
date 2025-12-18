package classes.classesObjs

// (fun) INLINE - escopo feito/inserido dentro de onde vai ser usado, durante a compilação. Bom porque aumentar desempenhoe e reduz criação de objetos temporaneo

inline fun executeAction(action: () -> Unit) {
    println("Iniciando ação...")
    action()
    println("Ação concluida")
}

// os reified (materializar) são usados em generics para pegar indormações em tempo de execução

inline fun <reified T> printTypeName() {
    println(T::class.simpleName)
}

class Copo<out T: Drink>(val drink: T, val amount: Int)

//serve para usar tipo generics em tempo de execução
inline fun <reified T: Drink> serveDrink(cup: Copo<T>) {
    println("[${T::class.simpleName}] Serving ${cup.drink.nameOfDrink} de quantidade ${cup.amount}l")
}

fun main() {
    executeAction {
        println("Executando ação...")
    }

    // rodar o programa, o que acontece é que ele meio que cola isso aqui:

    //println("Iniciando ação...")
    //action()
    //println("Ação concluida")

    // ao invés de

    printTypeName<Int>()

    val juice = Copo(Juice(), 1)
    serveDrink(juice)
}