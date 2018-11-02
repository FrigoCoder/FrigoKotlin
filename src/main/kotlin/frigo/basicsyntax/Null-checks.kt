package frigo.basicsyntax

fun parseInt(str: String): Int? {
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        println("$str is not Int")
        null
    }
}

fun main(args: Array<String>) {
    if (args.size < 2) {
        println("No number supplied")
        return
    }
    val x: Int? = parseInt(args[0])
    val y: Int? = parseInt(args[1])

    if (x == null || y == null) {
        print("One of the arguments is null")
    } else {
        print(x * y)
    }
}