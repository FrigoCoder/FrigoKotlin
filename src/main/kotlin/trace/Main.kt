package trace

import kotlin.random.Random

fun main(args: Array<String>) {
    val scene = Scene(listOf(
        Sphere(Vector(1e5 + 1, 40.8, 81.6), 1e5, Color(.75, .25, .25), Reflection.Diffuse, Color.Black),
        Sphere(Vector(-1e5 + 99, 40.8, 81.6), 1e5, Color(.25, .25, .75), Reflection.Diffuse, Color.Black),
        Sphere(Vector(50.0, 40.8, 1e5), 1e5, Color(.75, .75, .75), Reflection.Diffuse, Color.Black),
        Sphere(Vector(50.0, 40.8, -1e5 + 170), 1e5, Color.Black, Reflection.Diffuse, Color.Black),
        Sphere(Vector(50.0, 1e5, 81.6), 1e5, Color(.75, .75, .75), Reflection.Diffuse, Color.Black),
        Sphere(Vector(50.0, -1e5 + 81.6, 81.6), 1e5, Color(.75, .75, .75), Reflection.Diffuse, Color.Black),
        Sphere(Vector(27.0, 16.5, 47.0), 16.5, Color.White * .999, Reflection.Specular, Color.Black),
        Sphere(Vector(73.0, 16.5, 78.0), 16.5, Color.White * .999, Reflection.Refractive, Color.Black),
        Sphere(Vector(50.0, 681.6 - .27, 81.6), 600.0, Color.Black, Reflection.Diffuse, Color(12.0, 12.0, 12.0))
    ))

    val image = Image(1024, 768)
    val camera = Camera(Vector(50.0, 52.2, 295.6), Direction(0.0, -0.042612, -1.0), 54.3609968, 140.0, image.xs,
        image.ys)

    val random = Random(0x12345678)

    for (x in 0 until image.xs) {
        for (y in 0 until image.ys) {
            var result = Color.Black
            var sum = 0.0
            for (s in 1..100) {
                val dx = random.nextDouble()
                val dy = random.nextDouble()
                val ray = camera.ray(x + dx, y + dy)
                val hit = scene.shoot(ray)
                var color = hit?.sphere?.color ?: Color.Black
                val weight = 1.0
                result += color * weight
                sum += Math.abs(weight)
            }
            image[x, y] = result / sum
        }
    }

    image.save("result.png")
}
