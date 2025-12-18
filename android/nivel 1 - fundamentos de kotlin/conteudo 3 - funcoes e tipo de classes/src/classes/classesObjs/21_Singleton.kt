package classes.classesObjs

//a unique stance for all application

//doest have (), it already borned instanciado. Remember, this is a class. Share things belong all project
object Databaseutil {

    val url = "jdbc:mysql://localhost:8081/mydb"
    val user = "admin"
    private val pwd = "admin"

    fun connect() {
        println("Conecting to $url with user $user...")
    }

}

fun main() {

    Databaseutil.connect()
}