package my.lab.cars;

import java.util.ArrayList;
import java.util.List;


public class CarWorkshop<T extends Car> {

    private int maxCapacity;
    private List<T> cars;

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
}

