package frigo.basicsyntax

fun main(args: Array<String>) {
    for (arg in args) {
        println(arg)
    }
    println()
    for (i in args.indices) {
        println(args[i])
    }
    for (i in 1..10) {
        println(i)
    }
}
