package my.lab.cars;

import org.junit.Assert;
import org.junit.Test;


public class ScaniaTest {

    private final Scania testscania = new Scania();

    @Test
    public void liftFlatbedTest() {

        testscania.liftFlatbed();
        Assert.assertTrue(true);
    }

    @Test
    public void lowerFlatbedTest() {

        testscania.lowerFlatbed();
        Assert.assertTrue(false);


        /*

        testscania.ChangeFlatbedAngle(70);
        IO.println(testscania.getCurrFlatbedAngle());

        if (testscania.getCurrFlatbedAngle() == 70) {
            Assert.assertTrue(true);
        }

         */


    }
}
