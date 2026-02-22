package my.lab.cars;

import java.awt.*;


public class Scania extends Car implements IMovable {

    private boolean flatbedLifted;

    public Scania() {
        super(2, Color.red, 770, "Scania", 30000);
        this.flatbedLifted = false;
        this.setCurrY(200);
    }

    @Override
    public void move() {
        if (!flatbedLifted) {
            super.move();
        }
        else this.stopEngine();
    }
    @Override
    public void turnLeft() {
        super.turnLeft();
    }
    @Override
    public void turnRight() {
        super.turnRight();
    }

    public void liftFlatbed() {
        if (super.getCurrentSpeed() != 0) {
            IO.println("Truck is moving, can't change flatbed angle");
            }
        else flatbedLifted = true;

    }
    public void lowerFlatbed() {
        if (super.getCurrentSpeed() != 0) {
            IO.println("Truck is moving, can't change flatbed angle");
        }
        else flatbedLifted = false;
    }
}
