package my.lab.cars;

import org.junit.Assert;
import org.junit.Test;

public class CarTransportTest {

    private CarTransport ctTest = new CarTransport();

    private Car c1 = new Saab95();
    private Car c2 = new Volvo240();

    @Test
    public void testRamp(){
        ctTest.lowerRamp();
        Assert.assertTrue(ctTest.Ramp);

        ctTest.raiseRamp();
        Assert.assertFalse((ctTest.Ramp));

    }


    }
