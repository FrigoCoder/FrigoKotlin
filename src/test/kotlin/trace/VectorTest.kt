package trace.tests;

import trace.Vector;
import org.junit.Test
import org.junit.Assert
import org.hamcrest.Matchers.equalTo;
import org.hamcrest.MatcherAssert.assertThat;

public class VectorTest {
   
    @Test
    fun `zero vector is initialized to zero` () {
        assertThat(Vector.Zero.x, equalTo(0.0));
        assertThat(Vector.Zero.y, equalTo(0.0));
        assertThat(Vector.Zero.z, equalTo(0.0));
    }
    
    @Test
    fun `add works correctly` () {
        assertThat(Vector(1.0, 2.0, 3.0) + Vector(4.0, 5.0, 6.0), equalTo(Vector(5.0, 7.0, 8.0)));
    }

}
