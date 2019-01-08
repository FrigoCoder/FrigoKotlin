package trace

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.nullValue
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Test

class RayTest {

    private val origin = Vector(1.0, 2.0, 3.0)
    private val directionOriginal = Vector(2.0, 3.0, 4.0)
    private val direction = directionOriginal.normalize()
    private val ray = Ray(origin, directionOriginal)

    @Test
    fun `ray is initialized properly`() {
        assertThat(ray.origin, equalTo(origin))
        assertThat(ray.direction, equalTo(direction))
    }

    @Test
    fun `ray equals works properly`() {
        assertThat(ray, equalTo(Ray(origin, direction)))
        assertThat(ray, not(equalTo(Ray(direction, origin))))
        assertThat(ray, not(nullValue()))
    }

    @Test
    fun `ray hashcode works properly`() {
        assertThat(ray.hashCode(), equalTo(31 * origin.hashCode() + direction.hashCode()))
    }

    @Test
    fun `ray toString works properly`() {
        assertThat(ray.toString(), equalTo("Ray(origin=$origin, direction=$direction)"))

    }

}
