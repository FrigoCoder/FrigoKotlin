package frigo.destructuring

fun getUser(): User {
    return User("Alex", 1)
}

fun main(args: Array<String>) {
    val user = getUser()
    println("name = ${user.name}, id = ${user.id}")

    val (name, id) = getUser()
    println("name = $name, id = $id")

    println("name = ${getUser().component1()}, id = ${getUser().component2()}")
}
