package trace

fun main(args: Array<String>) {
    val image = Image(1024, 768)
    for (x in 0 until image.xs) {
        for (y in 0 until image.ys) {
            image[x, y] = Color(Math.random(), Math.random(), Math.random())
        }
    }
    image.save("test.png")
}
