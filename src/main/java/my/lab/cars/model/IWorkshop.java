package my.lab.cars.model;

public interface IWorkshop<T> {
    void accept(T car);
    T release(int index);
    int count();
    double getCurrX();
    double getCurrY();
    boolean checkProximity(Car car, boolean check);


}

