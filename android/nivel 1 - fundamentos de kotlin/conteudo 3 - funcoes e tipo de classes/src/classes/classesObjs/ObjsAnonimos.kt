package classes.classesObjs

interface ClickCallback {
    fun onClick()
}

//anonimos são bons para coisas simples que não justidica criar uma classe. Agora, se a função for muito complexa,
//é melhor criar uma classe.

fun main() {

    val name: String = "Yuri Alpha"

    // é singletone e se autoimplemena interface, bom sevai usar uma vez só. tem acaesso a variaveis for ado escopo
    val obj = object {
        fun sayHello() = println("Hello, I'm $name")
    }

    obj.sayHello()

    val button = object : ClickCallback {
        override fun onClick() {
            println("Button clicked!")
        }
    }

    button.onClick()
}