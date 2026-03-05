package my.lab.cars.model;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import my.lab.cars.controller.CarController;




public class CarCreation {

    public static Car create() {

        int randomNum = ThreadLocalRandom.current().nextInt(1, 4);
        return switch (randomNum) {
            case 1 -> new Saab95();
            case 2 -> new Scania();
            case 3 -> new Volvo240();
            default -> throw new IllegalArgumentException("Invalid random number");
        };
    }

    }

