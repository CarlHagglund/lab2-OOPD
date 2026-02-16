import my.lab.cars.CarWorkshop;
import my.lab.cars.Volvo240;

void main() {
    /*
    IO.println(String.format("Hello and welcome!"));

    Saab95 saab95 = new Saab95();
    Volvo240 volvo240 = new Volvo240();
    IO.println(String.format("saabfärg = %s", saab95.getColor()));
    IO.println(String.format("volvodörrar = %d", volvo240.getNrDoors()));

    saab95.startEngine();

    IO.println(String.format("x = %f", saab95.getCurrX()));

    IO.println(String.format("currspeed = %f", saab95.getCurrentSpeed()));

    saab95.incrementSpeed(4);

    IO.println(String.format("currspeed = %f", saab95.getCurrentSpeed()));
    */

    Volvo240 volvo240 = new Volvo240();

    CarWorkshop<Volvo240> volvoworkshop = new CarWorkshop<>(10);
    //CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<>(5);
    volvoworkshop.cartoWorkshop(volvo240);


// Vi vet statiskt att detta är en Volvo240
    //Volvo240 myCar = volvoWorkshop.unloadCar(0);
}

