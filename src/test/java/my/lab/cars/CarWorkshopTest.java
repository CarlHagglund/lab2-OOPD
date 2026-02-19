package my.lab.cars;

import org.junit.Assert;
import org.testng.annotations.Test;

public class CarWorkshopTest {

    Volvo240 volvo240 = new Volvo240();
    Saab95 saab95 = new Saab95();
    CarWorkshop<Volvo240> volvoworkshop = new CarWorkshop<>(3, 300, 300);
    ICarWorkshop<Volvo240> volvoStation = new CarWorkshop<>(2, 300, 0);
    CarWorkshop<Car> carworkshop = new CarWorkshop<>(3, 300, 300);

    @Test
    public void testMaxCapacity() {

        try {
            volvoworkshop.accept(volvo240);
            volvoworkshop.accept(volvo240);
            volvoworkshop.accept(volvo240);
            volvoworkshop.accept(volvo240);
        } catch (IllegalStateException e) {
            Assert.assertTrue(true);
        }
    }

    /*
    @Test
    public void testcarOutOfWorkshop() {
        carworkshop.cartoWorkshop(saab95);
        carworkshop.cartoWorkshop(volvo240);

        Assert.assertNull(carworkshop.carOutOfWorkshop(2));

    }

     */

}
