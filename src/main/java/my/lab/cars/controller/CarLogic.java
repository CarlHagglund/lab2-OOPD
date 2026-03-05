package my.lab.cars.controller;
import my.lab.cars.model.IWorkshop;
import my.lab.cars.model.Volvo240;
import my.lab.cars.model.Workshop;
import my.lab.cars.model.Car;
import my.lab.cars.view.CarView;

import java.util.ArrayList;


public class CarLogic {

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    IWorkshop<Volvo240> volvoStation = new Workshop<>(5, 300, 300);

    public CarLogic(ArrayList<Car> cars, IWorkshop<Volvo240> volvoStation, CarView frame) {
        this.frame = frame;
        this.cars = cars;
        this.volvoStation = volvoStation;
    }


    public void tick() {
        //for (Car car : cars) {
        for (int i = cars.size() - 1; i >= 0; i--) {
            Car car = cars.get(i);
            car.move();

            int x = (int) Math.round(car.getCurrX());
            int y = (int) Math.round(car.getCurrY());

            if (x >= 700) {
                car.setCurrX(699);
                car.turnLeft();
                car.turnLeft();
            } else if (x <= 0) {
                car.setCurrX(1);
                car.turnLeft();
                car.turnLeft();
            } else if (y >= 560) {
                car.setCurrY(559);
                car.turnRight();
                car.turnRight();
            } else if (y <= 0) {
                car.setCurrY(1);
                car.turnRight();
                car.turnRight();
            } else if (volvoStation.checkProximity(car, car instanceof Volvo240)) {
                assert car instanceof Volvo240;
                volvoStation.accept((Volvo240) car);
                car.stopEngine();
                cars.remove(car);
            }
            frame.drawPanel.moveit(x, y, car);
        }
        frame.drawPanel.repaint();}


}

