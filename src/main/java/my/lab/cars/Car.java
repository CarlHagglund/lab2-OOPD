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

    private boolean IsTurningLeft;
    private boolean IsTurningRight;
    private double CurrX;
    private double CurrY;

    public Car(int nrDoors, Color color, double enginePower, String modelName, int weight) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.weight = weight;
        stopEngine(); // set the moving speed to 0

    }

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
        // Samma som increment cred till Calle
    }

    public void gas(double amount) {
        if (amount < 0.0 || amount > 1.0)
            throw new IllegalArgumentException(
                    "amount must be between 0.0 and 1.0. " + amount
            );
        else incrementSpeed(amount);
    } // lite samma visa här men om den inte raise:ar exception så kallas incrementSpeed()

    public void brake(double amount) {
        if (amount < 0.0 || amount > 1.0)
            throw new IllegalArgumentException(
                    "amount must be between 0.0 and 1.0. and can't be greater than current speed "
            );
        else if (amount > currentSpeed)
            currentSpeed=0;
        else decrementSpeed(amount);
        // Samma som innan men nu kallas decrementSpeed(), cred till mig, cool, Øhl osv <3
    }

    @Override
    public void move() {
        if (IsTurningLeft) {
            CurrX += getCurrentSpeed();
        } else if (IsTurningRight) {
            CurrY += getCurrentSpeed();
        }
        IO.println(CurrX + CurrY);

    }

    @Override
    public void turnLeft() {
        IsTurningLeft = true;
        IsTurningRight = false;
    }

    @Override
    public void turnRight() {
        IsTurningRight = true;
        IsTurningLeft = false;

    }


}
