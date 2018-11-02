package frigo.basicsyntax

fun main(args: Array<String>) {
    val x = args[0].toInt()
    val y = 10
    if (x in 1 until y) {
        println("OK")
    }
    for (a in 1..5) {
        println("$a ")
    }

    println()
    val array = ArrayList<String>()
    array.add("aaa")
    array.add("bbb")
    array.add("ccc")

    if (x !in 0 until array.size) {
        println("Out: array has only ${array.size} elements. x = $x")
    }

    if ("aaa" in array) {
        println("Yes: array contains aaa")
    }
    if ("ddd" in array) {
        println("Yes: array contains ddd")
    } else {
        println("No: array doesn't contain ddd")
    }
}
