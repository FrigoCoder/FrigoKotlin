package trace

import org.junit.Test

class DirichletTest {

    @Test
    fun `test trigonometric dirichlet against naive dirichlet`() {
        assertFilterEquals(Dirichlet(1.0), DirichletNaive(1), 0.25)
        assertFilterEquals(Dirichlet(2.0), DirichletNaive(2), 0.25)
        assertFilterEquals(Dirichlet(3.0), DirichletNaive(3), 0.25)
        assertFilterEquals(Dirichlet(4.0), DirichletNaive(4), 0.25)
    }

}

data class DirichletNaive(val radius: Int) : Filter {

    override val left get() = -radius.toDouble()
    override val right get() = radius.toDouble()

    override operator fun invoke(t: Double): Double {
        if (t !in (-radius.toDouble()).rangeTo(radius.toDouble())) {
            return 0.0
        }
        val x = t * Math.PI / radius
        var result = 0.5 + 0.5 * Math.cos(radius * x)
        for (i in 1 until radius) {
            result += Math.cos(i * x)
        }
        return result / radius
    }

}
