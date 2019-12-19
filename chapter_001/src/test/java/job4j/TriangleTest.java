package job4j;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    public void whenExist() {
        boolean result = Triangle.exist(2.0, 2.0, 2.0);
        assertThat(result, is(true));
    }

    @Test
    public void whenDoesNotExist() {
        boolean result = Triangle.exist(2.0, 2.0, 10.0);
        assertThat(result, is(false));
    }

}