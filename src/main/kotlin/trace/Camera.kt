package trace

data class Camera(val origin: Vector, val direction: Vector, val angle: Double, val xs: Int, val ys: Int) {

    private val aspectRatio = xs.toDouble() / ys.toDouble()
    private val cx = Vector(aspectRatio, 0.0, 0.0) * angle
    private val cy = (cx x direction).normalize() * angle

    fun direction(x: Double, y: Double) = direction + cx * (x / xs - 0.5) + cy * (y / ys - 0.5)

}
