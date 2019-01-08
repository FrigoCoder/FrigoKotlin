package trace

data class Camera(
    val origin: Vector,
    val direction: Vector,
    val fov: Double,
    var near: Double,
    val xs: Int,
    val ys: Int) {

    private val angle = Math.tan(0.5 * fov * Math.PI / 180)
    private val aspectRatio = xs.toDouble() / ys.toDouble()
    private val cx = Vector(aspectRatio, 0.0, 0.0) * angle
    private val cy = (direction x cx).normalize() * angle

    fun ray(x: Double, y: Double): Ray {
        val direction = (direction + cx * (x / xs - 0.5) + cy * (y / ys - 0.5)).normalize()
        return Ray(origin + direction * near, direction)
    }

}
