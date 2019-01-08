package trace

class Ray(val origin: Vector, direction: Vector) {

    val direction: Vector = direction.normalize()

    override fun equals(other: Any?) = other is Ray && origin == other.origin && direction == other.direction
    override fun hashCode() = 31 * origin.hashCode() + direction.hashCode()
    override fun toString() = "Ray(origin=$origin, direction=$direction)"

}
