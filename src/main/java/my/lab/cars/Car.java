package my.lab.cars;

import java.awt.*;

public abstract class Car implements Movable {


    // Privata för att de inte ska kunna förändras eller kallas på direkt. Säkerhet

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private int weight;

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
    //private boolean IsTurningLeft;
    //private boolean IsTurningRight;
    private double CurrX;
    private double CurrY;

    public Car(int nrDoors, Color color, double enginePower, String modelName, int weight) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.weight = weight;
        //Direction currDir = Direction.RIGHT;
    //this.IsTurningLeft = false;
        //this.IsTurningRight = false;
        stopEngine(); // set the moving speed to 0
        this.CurrX = 0;
        this.CurrY = 0;

    }
    Direction currDir = Direction.RIGHT;

    public void setCurrX(double amount) {CurrX = amount;}

    public void setCurrY(double amount) {CurrY = amount;}

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public int getWeight() {return weight;}

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public double getCurrX() {
        return CurrX;
    }
    // två getter funktioner bara :)
    public double getCurrY() {
        return CurrY;
    }

    public double speedFactor() {
        return enginePower * 0.01;
    }

    public void incrementSpeed(double amount) {
        double currentSpeedtest = getCurrentSpeed() + speedFactor() * amount;

        if (currentSpeedtest >= 0 && currentSpeedtest <= enginePower) {
            currentSpeed = currentSpeedtest;

        } else {

            throw new IllegalArgumentException("Speed " + currentSpeedtest + " is out of range!");
        }

        // Denna kallas för att öka farten på bilen. Den skall raise:a error om kriteriet ej uppfylls.

    }

    public void decrementSpeed(double amount) {

        double currentSpeedtest = getCurrentSpeed() - speedFactor() * amount;

        if (currentSpeedtest >= 0 && currentSpeedtest <= enginePower) {
            currentSpeed = currentSpeedtest;

        } else {
            throw new IllegalArgumentException("Speed " + currentSpeedtest + " is out of range!");
        }
    }

    public void gas(double amount) {
        if (amount < 0.0 || amount > 1.0)
            throw new IllegalArgumentException(
                    "amount must be between 0.0 and 1.0. " + amount
            );
        else incrementSpeed(amount);
    }

    public void brake(double amount) {
        if (amount < 0.0 || amount > 1.0)
            throw new IllegalArgumentException(
                    "amount must be between 0.0 and 1.0. and can't be greater than current speed "
            );
        else if (amount > currentSpeed)
            currentSpeed=0;
        else decrementSpeed(amount);
    }

    @Override
    public void move() {

        switch(currDir) {
            case RIGHT:
                CurrX += currentSpeed;
                //IO.println("nu åker vi höger");
                break;
            case LEFT:
                CurrX -= getCurrentSpeed();
                //IO.println("Nu åker vi vänster");
                break;
            case UP:
                CurrY -= getCurrentSpeed();
                //IO.println("nu åker vi upp");
                break;
            case DOWN:
                CurrY += getCurrentSpeed();
                //IO.println("nu åker vi ner");
                break;
        }
    }

    @Override
    public void turnLeft() {

        switch(currDir) {
            case RIGHT: currDir = currDir.UP; break;
            case UP: currDir = currDir.LEFT; break;
            case LEFT: currDir = currDir.DOWN; break;
            case DOWN: currDir = currDir.RIGHT; break;
        }

    }
    @Override
    public void turnRight() {

        switch(currDir) {
            case RIGHT: currDir = currDir.DOWN; break;
            case DOWN: currDir = currDir.LEFT; break;
            case LEFT: currDir = currDir.UP; break;
            case UP: currDir = currDir.RIGHT; break;
        }

    }



}
