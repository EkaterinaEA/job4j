package ru.job4j;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.describedAs;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

class TriangleTest {

    @Test
    public void whenExist() {

        Point point1 = new Point(0, 2);
        Point point2 = new Point(2, 2);
        Point point3 = new Point(0, 0);

        Triangle triangle = new Triangle(point1, point2, point3);

        double result = triangle.area();
        assertEquals(result, 2, 0.1);
    }

    @Test
    public void whenDoesNotExist() {
        Point point1 = new Point(0, 2);
        Point point2 = new Point(0, 3);
        Point point3 = new Point(0, 0);

        Triangle triangle = new Triangle(point1, point2, point3);

        double result = triangle.area();
        assertEquals(result, -1, 0.1);
    }

}