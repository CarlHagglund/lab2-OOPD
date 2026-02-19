package my.lab.cars;

public interface ICarWorkshop<T extends Car> {
    void accept(T car);
    T release(int index);
    int count();
    double getCurrX();
    double getCurrY();
    boolean checkProximity(Car car,boolean check);


}

