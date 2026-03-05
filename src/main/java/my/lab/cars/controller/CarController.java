package my.lab.cars.controller;

import my.lab.cars.model.*;
import my.lab.cars.view.CarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    CarLogic carLogic;
    CarView frame;
    CarCreation carCreation;


    //methods:
    public void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        ArrayList<Car> cars = new ArrayList<>();


        IWorkshop<Volvo240> volvoStation = new Workshop<>(5,300,300);

        cc.frame = new CarView("CarSim 1.0", cc);
        cc.carLogic = new CarLogic(cars,volvoStation,cc.frame);




        cc.timer.start();

    }
    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            carLogic.tick();
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        for (Car car : carLogic.cars) {
            double gas = ((double) amount) / 100;
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : carLogic.cars) {
            car.brake(brake);
        }
    }

    public void start() {
        for (Car car : carLogic.cars) {
            car.startEngine();
        }
    }

    public void stop() {
        for (Car car : carLogic.cars) {
            car.stopEngine();
        }
    }

    public void turboOn() {
        for (Car car : carLogic.cars)
            if (car instanceof Saab95 saab) {
                saab.setTurboOn();
            }
    }

    public void turboOff() {
        for (Car car : carLogic.cars)
            if (car instanceof Saab95 saab) {
                saab.setTurboOff();
            }
    }

    public void liftBed() {
        for (Car car : carLogic.cars) {
            if (car instanceof Scania scania) {
                scania.liftFlatbed();
            }
        }
    }
    public void lowerBed() {
        for (Car car : carLogic.cars) {
            if (car instanceof Scania scania) {
                scania.lowerFlatbed();
            }
        }
    }
    public void createCar() {
        if (carLogic.cars.size() <= 9) {
            Car car = carCreation.create();
            String imagePath = switch (car) {
                case Volvo240 v -> "pics/Volvo240.jpg";
                case Saab95 v -> "pics/Saab95.jpg";
                case Scania v -> "pics/Scania.jpg";
                default -> null;
            };
            carLogic.cars.add(car);
            frame.drawPanel.addCar(car, imagePath);
        }
    }

    public void destroyCar() {
        if (!carLogic.cars.isEmpty()) {       // ← guard against empty list
            Car car = carLogic.cars.removeLast();
            frame.drawPanel.removeCar(car);
        }
    }
}



