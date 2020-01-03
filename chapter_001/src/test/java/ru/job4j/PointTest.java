package ru.job4j;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        double expected = 2.82;
        Point a = new Point(1, 2);
        Point b = new Point(3, 4);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}
