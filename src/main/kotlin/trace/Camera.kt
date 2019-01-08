package trace

data class Camera(val origin: Vector, val direction: Vector, val angle: Double, val xs: Int, val ys: Int) {

    private val cx = Vector(angle * xs / ys, 0.0, 0.0)
    private val cy = (cx x direction).normalize() * angle

    fun direction(x: Double, y: Double) = direction + cx * (2 * x / xs - 1) + cy * (2 * y / ys - 1)

}
