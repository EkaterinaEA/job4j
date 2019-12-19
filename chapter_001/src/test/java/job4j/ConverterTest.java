package job4j;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConverterTest {

    @Test
    public void testRubleToEuro() {
        int in = 140;
        int expected = 2;
        double out = Converter.rubleToEuro(in);
        assertEquals(expected, out, 0);
    }

    @Test
    public void testRubleToDollar() {
        int in = 120;
        int expected = 2;
        double out = Converter.rubleToDollar(in);
        assertEquals(expected, out, 0);
    }

    @Test
    public void testDollarToRuble() {
        int in = 140;
        int expected = 8400;
        double out = Converter.dollarToRuble(in);
        assertEquals(expected, out, 0);
    }

    @Test
    public void testEuroToRuble() {
        int in = 140;
        int expected = 9800;
        double out = Converter.euroToRuble(in);
        assertEquals(expected, out, 0);
    }
}