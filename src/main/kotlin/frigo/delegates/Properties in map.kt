package frigo.delegates

class MapUser(private val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun main(args: Array<String>) {
    val user = MapUser(mapOf(
            "name" to "John Doe",
            "age" to 25
    ))
    println("name = ${user.name}, age = ${user.age}")
}
