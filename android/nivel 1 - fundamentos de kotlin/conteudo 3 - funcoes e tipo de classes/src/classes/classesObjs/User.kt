package classes.classesObjs

//its minimum to have one attribute
data class UserDataClass (val name: String, val password: String){}

class User(val id: Int, var name: String, var password: String) {
}

fun main() {

    //users
    val yuriAlpha = User(1, "Yuri Alpha", "ainz_sama")
    val lupusBeta = User(2, "Lupusregina Beta", "ainzSama")
    val lupusBetaCopia = User(2, "Lupusregina Beta", "ainzSama")

    //usersDataClass
    val userDataClass: UserDataClass = UserDataClass("yuriAlpha", "ainzsama")
    val userDataClass2: UserDataClass = UserDataClass("lupusBeta", "ainzsama")
    val userDataClass21: UserDataClass = UserDataClass("lupusBeta", "ainzsama")

    //1. toString()
    // On this method its println() it's like we doing user.toString(), userDataClass.toString()
    println(yuriAlpha)
    println(userDataClass)

    //2. equals
    println("\nEquals\n")

    println("\nUsers")
    println(yuriAlpha.name + " is equals to " + lupusBeta.name + "?: " + (yuriAlpha == lupusBeta))
    println(lupusBeta.name + " is equals to " + lupusBetaCopia.name + "?: " + (yuriAlpha == lupusBeta) + ", because Classes compares your memory addresses")
    //To have equals classes, you need to do something like val user: Class = class3

    println("\nDataClasses")
    println(userDataClass.name + " is equals to " + userDataClass2.name + "?: " + (userDataClass == userDataClass2))
    println(userDataClass2.name + " is equals to " + userDataClass21.name + "?: " + (userDataClass2 == userDataClass21) + ", because dataClasses compares your values")

    //3. Coisas legais das dataClasses
    println("\nDataClasses")

    //copy
    val copyUserDataClass: UserDataClass = userDataClass.copy(password = "iloveainzsamatoomuch")
    // classes don't have a .copy() val copyUserYuriAlpha = yuriAlpha.copy()
    println(copyUserDataClass)

    //desestruturação
    val(x, y) = userDataClass
    println("$x é o nome e o $y é a senha")

    //dataClasses are closed, so "open" doesn't work with
}