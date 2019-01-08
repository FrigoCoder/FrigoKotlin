package trace

import kotlin.random.Random

fun main(args: Array<String>) {
    val scene = Scene(listOf(
        Sphere(1e5, Vector(1e5 + 1, 40.8, 81.6), Color.Black, Color(.75, .25, .25), Reflection.Diffuse),
        Sphere(1e5, Vector(-1e5 + 99, 40.8, 81.6), Color.Black, Color(.25, .25, .75), Reflection.Diffuse),
        Sphere(1e5, Vector(50.0, 40.8, 1e5), Color.Black, Color(.75, .75, .75), Reflection.Diffuse),
        Sphere(1e5, Vector(50.0, 40.8, -1e5 + 170), Color.Black, Color.Black, Reflection.Diffuse),
        Sphere(1e5, Vector(50.0, 1e5, 81.6), Color.Black, Color(.75, .75, .75), Reflection.Diffuse),
        Sphere(1e5, Vector(50.0, -1e5 + 81.6, 81.6), Color.Black, Color(.75, .75, .75), Reflection.Diffuse),
        Sphere(16.5, Vector(27.0, 16.5, 47.0), Color.Black, Color.White * .999, Reflection.Specular),
        Sphere(16.5, Vector(73.0, 16.5, 78.0), Color.Black, Color.White * .999, Reflection.Refractive),
        Sphere(600.0, Vector(50.0, 681.6 - .27, 81.6), Color(12.0, 12.0, 12.0), Color.Black, Reflection.Diffuse)
    ))

    val image = Image(1024, 768)

    val camera = Camera(Vector(50.0, 52.2, 295.6), Vector(0.0, -0.042612, -1.0), 0.5135, image.xs, image.ys)

    val filter = Dirichlet(2.0)
    val random = Random(0x12345678)

    for (x in 0 until image.xs) {
        for (y in 0 until image.ys) {
            var result = Color.Black
            var sum = 0.0
            for (s in 0 until 100) {
                val dx = random.nextDouble(filter.left, filter.right)
                val dy = random.nextDouble(filter.left, filter.right)

                val direction = camera.direction(x + 0.5 + dx, y + 0.5 + dy)
                val ray = Ray(camera.origin + direction * 140.0, direction)
                val hit = scene.shoot(ray)
                var color = hit?.sphere?.color ?: Color.Black
                val weight = filter(dx) * filter(dy)

                result += color * weight
                sum += weight
            }
            image[x, y] = result / sum
        }
    }

    image.save("result.png")
}
