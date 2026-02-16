package my.lab.cars;

import java.awt.*;

public class Saab95 extends Car {
    private boolean turboOn;
    private double turbo;

    public Saab95() {
        super(2, Color.red, 125, "Saab95", 1700);
        this.turbo = 1.0;
        this.turboOn = false;
    }

    public void move() {
        super.move();
    }

    public void turnLeft() {
        super.turnLeft();
    }

    public void turnRight() {
        super.turnRight();
    }
    public void setTurboOn() {
        turboOn = true;
    }
    public void setTurboOff() {
        turboOn = false;
    }
    @Override
    public double speedFactor() {
        if (turboOn) turbo = 1.3;
        return super.speedFactor()*turbo;
    }

}