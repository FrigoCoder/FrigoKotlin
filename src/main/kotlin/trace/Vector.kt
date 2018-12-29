package trace

public data class Vector(val x: Double, val y: Double, val z: Double) {

    companion object {
        public val Zero = Vector(0.0,0.0,0.0);
    }

    operator fun unaryPlus () = this;
    operator fun unaryMinus () = Vector(-x, -y, -z);

    operator fun times (s: Double) = Vector(x * s, y * s, z * s);
    operator fun div (s: Double) = Vector(x / s, y / s, z / s);

    operator fun plus (that: Vector) = Vector(x + that.x, y + that.y, z + that.z);
    operator fun minus (that: Vector) = Vector(x - that.x, y - that.y, z - that.z);
    operator fun times (that: Vector) = x * that.x + y * that.y + z * that.z;
    infix fun x (v: Vector) = Vector(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x); 

    fun norm () = if (this == Zero) Zero else this / Math.sqrt(x* x + y * y + z * z);
           
}
