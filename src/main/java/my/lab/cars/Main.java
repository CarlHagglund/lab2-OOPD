import my.lab.cars.CarController;
import my.lab.cars.CarView;
import my.lab.cars.CarWorkshop;
import my.lab.cars.Volvo240;

void main() {

    String[] args = {};
    CarController cc = new CarController();
    CarView carView = new CarView("mycar", cc);
    cc.main(args);



    //Volvo240 volvo240 = new Volvo240();

    //CarWorkshop<Volvo240> volvoworkshop = new CarWorkshop<>(10);
    //CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<>(5);
    //volvoworkshop.cartoWorkshop(volvo240);


// Vi vet statiskt att detta är en Volvo240
    //Volvo240 myCar = volvoWorkshop.unloadCar(0);
}

