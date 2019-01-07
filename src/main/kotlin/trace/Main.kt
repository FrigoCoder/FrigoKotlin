package trace

fun main(args: Array<String>) {
    val image = Image(1024, 768)
    for (x in 0 until image.xs) {
        for (y in 0 until image.ys) {
            image[x, y] = Color(x / 1023.0, y / 767.0, Math.random())
        }
    }
    image.save("test.png")
}
