package job4j;

import org.junit.Assert;
import org.junit.Test;

public class FitTest {

    @Test
    public void manWeight() {
        double expected = 92.0;
        double out = Fit.manWeight(180);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void womanWeight() {
        double expected = 69.0;
        double out = Fit.womanWeight(170);
        Assert.assertEquals(expected, out, 0.01);
    }
}
