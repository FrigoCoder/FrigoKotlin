package frigo.basicsyntax

fun main(args: Array<String>) {
    println(getStringLength(obj = "aaa"))
    println(getStringLength(obj = 1))
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }
    return null
}
