package job4j;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

    @Test
    public void square() {
        double expected1 = 1.0;
        double out1 = SqArea.square(4, 1);
        double expected2 = 2.0;
        double out2 = SqArea.square(6, 2);
        Assert.assertEquals(expected1, out1, 0.01);
        Assert.assertEquals(expected2, out2, 0.01);
    }

}