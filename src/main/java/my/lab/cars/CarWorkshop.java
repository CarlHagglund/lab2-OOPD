package my.lab.cars;

import java.util.ArrayList;
import java.util.List;


public class CarWorkshop<T extends Car> implements ICarWorkshop<T> {
    private final int maxCapacity;
    private List<T> cars;
    private double currX;
    private double currY;

    public CarWorkshop(int maxCapacity, double currX, double currY) {
        this.maxCapacity = maxCapacity;
        this.cars = new ArrayList<>();
        this.currX = currX;
        this.currY = currY;
    }

    @Override
    public void accept(T car) {
        if (cars.size() < maxCapacity) {
            cars.add(car);
        } else {
            throw new IllegalStateException("Too many cars");
        }
    }

    @Override
    public T release(int index) {
        return cars.remove(index);
    }

    @Override
    public int count() {
        return cars.size();
    }

    @Override
    public double getCurrX() {
        return currX;
    }

    @Override
    public double getCurrY() {
        return currY;
    }

    @Override
    public boolean checkProximity(Car car,boolean check){

        double proximityX = this.getCurrX() - car.getCurrX();
        double proximityY = this.getCurrY() - car.getCurrY();

        return (Math.abs(proximityX) <= 7 && Math.abs(proximityY) <= 7);

    }

}

