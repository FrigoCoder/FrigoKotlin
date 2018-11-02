package frigo.delegates

import kotlin.properties.Delegates

class User {
    var name: String by Delegates.notNull()

    fun init(name: String) {
        this.name = name
    }
}

fun main(args: Array<String>) {
    val user = User()
    try {
        println(user.name)
    } catch (e: IllegalStateException) {
        println("Threw IllegalStateException as it should have")
    }
    user.init("Carl")
    println(user.name)
}
