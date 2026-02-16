package my.lab.cars;

import org.junit.Assert;
import org.junit.Test;


public class Saab95Test {

    private Saab95 saab95Test = new Saab95();

    @Test
    public void testSpeedFactor() {
        saab95Test.setTurboOn();

        saab95Test.speedFactor();

        Assert.assertEquals(1.625, saab95Test.speedFactor(), 0.01);
    }
}
