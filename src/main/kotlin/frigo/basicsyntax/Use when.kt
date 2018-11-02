package frigo.basicsyntax

fun main(args: Array<String>) {
    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")
}

fun cases(obj: Any) {
    when (obj) {
        1 -> {
            var str = "One"
            println(str)
        }
        "Hello" -> {
            var str = "Greeting"
            println(str)
        }
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}

class MyClass
