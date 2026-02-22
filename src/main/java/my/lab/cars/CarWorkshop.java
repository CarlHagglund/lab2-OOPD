package my.lab.cars;

import java.util.ArrayList;
import java.util.List;


public class CarWorkshop<T extends Car> implements ICarWorkshop<T> {
    private final int maxCapacity;
    private List<T> cars;
    private double CurrX;
    private double CurrY;

    public CarWorkshop(int maxCapacity, double currX, double currY) {
        this.maxCapacity = maxCapacity;
        this.cars = new ArrayList<>();
        this.CurrX = currX;
        this.CurrY = currY;

    }



    /*
    public CarWorkshop(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.cars = new ArrayList<>();
    }

    public void cartoWorkshop(T car) {
        if (cars.size() < maxCapacity) {
            cars.add(car);
        }else {
            throw new IllegalStateException("Too many cars");
        }

    }

    public T carOutOfWorkshop(int index) {
        if (index >= 0 && index < cars.size()) {
            return cars.remove(index);
        } else {
            return null;

        }
    }

     */

    @Override
    public void accept(T car) {
        if (cars.size() < maxCapacity) {
            cars.add(car);
        } else {
            IO.println("Workshop is full!");
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
        return CurrX;
    }

    @Override
    public double getCurrY() {
        return CurrY;
    }

    @Override
    public boolean checkProximity(Car car,boolean check){

        double proximityX = this.getCurrX() - car.getCurrX();
        double proximityY = this.getCurrY() - car.getCurrY();

        return (Math.abs(proximityX) <= 7 && Math.abs(proximityY) <= 7);

    }

}

