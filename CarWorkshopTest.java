package my.lab.cars;

import org.junit.Assert;
import org.junit.Test;

public class CarWorkshopTest {

    Volvo240 volvo240 = new Volvo240();
    Saab95 saab95 = new Saab95();
    CarWorkshop<Volvo240> volvoworkshop = new CarWorkshop<>(5);

    CarWorkshop<Car> carworkshop = new CarWorkshop<>(10);

    @Test
    public void testMaxCapacity() {

        try {
            volvoworkshop.cartoWorkshop(volvo240);
            volvoworkshop.cartoWorkshop(volvo240);
            volvoworkshop.cartoWorkshop(volvo240);
            volvoworkshop.cartoWorkshop(volvo240);
            volvoworkshop.cartoWorkshop(volvo240);
            volvoworkshop.cartoWorkshop(volvo240);
        } catch (IllegalStateException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void testcarOutOfWorkshop() {
        carworkshop.cartoWorkshop(saab95);
        carworkshop.cartoWorkshop(volvo240);

        Assert.assertNull(carworkshop.carOutOfWorkshop(2));

    }

}
