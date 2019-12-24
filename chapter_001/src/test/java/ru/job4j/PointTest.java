package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        double expected = 2.82;
        double out = Point.distance(1, 2, 3, 4);
        Assert.assertEquals(expected, out, 0.01);
    }
}
