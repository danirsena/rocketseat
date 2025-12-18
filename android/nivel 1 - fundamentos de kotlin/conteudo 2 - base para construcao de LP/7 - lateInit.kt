import kotlin.properties.Delegates

fun main() {

    //late init - quando a variável precisa ser iniciada apenas quando for usada.

    lateinit var x: String //late init variável que precisa ser iniciada posteriormente
    var y: Int by Delegates.notNull() //como late init não funciona com primitivos, esse by Delegates.notNull() faz a mesma coisa

    println(x) //vai dar erro, pois x ainda nao foi iniciada

    x = "Late init"

    println(x)

   //lazy - quando a variável precisa ser iniciada quando o programa for iniciado ou quando for usada
   val z: String by lazy { "Lazy" }
   println(z)

}