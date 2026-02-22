package my.lab.cars;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CarTransport extends Car implements IMovable {

    protected boolean Ramp;
    private static int MAX_LOAD = 10;
    List<Car> LoadedCars = new ArrayList<>();


    public CarTransport() {
        super(2, Color.red, 1000, "Car Transport", 30000);
        this.Ramp = false;

    }

    @Override
    public void move() {
        if (this.Ramp) {
            IO.println("Ramp is down, can't move");
        }
        else {
            super.move();
            for (Car car : LoadedCars) {
                car.setCurrX(this.getCurrX());
                car.setCurrY(this.getCurrY());
            }
        }
    }

    @Override
    public void turnLeft() {
        if (this.Ramp)
            IO.println("Ramp is down, can't move");
        super.turnLeft();
    }

    @Override
    public void turnRight() {
        if (this.Ramp)
            IO.println("Ramp is down, can't move");
        super.turnRight();
    }

    public void getLoadedCars() {
        IO.println(LoadedCars);
    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0)
            this.Ramp = true;
        else IO.println("Can't lower ramp while moving");
    }

    public void raiseRamp() {
        this.Ramp = false;
    }

    public void loadCar(Car car) {
        if ((car.getWeight() > 3000)) {
            IO.println("Car is to big");
        } else if (Ramp && getCurrentSpeed() == 0 && LoadedCars.size() < MAX_LOAD &&
                checkProximity(this, car)) {
            LoadedCars.add(car);
        }
        else {
            IO.println("Ramp is not down, can't load vehicles");
        }
    }

    public void unloadCar(Car car) {
        if (Ramp && LoadedCars.getLast().equals(car)) {
            LoadedCars.remove(car);
            car.setCurrX(this.getCurrX() + 3 );
            car.setCurrY(this.getCurrY() + 3 );
        }

    }

    public boolean checkProximity(CarTransport carTransport, Car car) {

        double proximityX = carTransport.getCurrX() - car.getCurrX();
        double proximityY = carTransport.getCurrY() - car.getCurrY();

        return Math.abs(proximityX) <= 7 && Math.abs(proximityY) <= 7;
    }

}