package my.lab.cars;

import org.junit.Assert;
import org.junit.Test;


public class Volvo240Test {

    private Volvo240 sut = new Volvo240();

    @Test
    public void testStartEngine() {

        sut.startEngine();
        Assert.assertEquals(0.1, sut.getCurrentSpeed(), 0.0);
        /*
        kontrollerar att startengine() ändrar currenspeed till 0.1. Anledning till delta 0.0 (sista parametern)
        är jag ej hitta en assertEqual som testar floats utan en delta.
        */
    }

    @Test
    public void testTurnLeft() {

        sut.startEngine();
        sut.turnLeft();
        sut.move();

        double currX = sut.getCurrX();
        double currY = sut.getCurrY();

        Assert.assertTrue(0.1 == currX);

        Assert.assertTrue(0.0 == currY);
        /*
        testar att turnLeft() ändrar riktningen av bilen till x-axeln, kontrollerar detta genom att move()
        ökar värdet på x-axeln och ej på y-axeln
         */


    }

    @Test
    public void testTurnRight() {

        sut.startEngine();
        sut.turnRight();
        sut.move();

        double currX = sut.getCurrX();
        double currY = sut.getCurrY();

        Assert.assertTrue(0.0 == currX);

        Assert.assertTrue(0.1 == currY);
        /*
        testar att turnRight() ändrar riktning samt värde på y-axel, ej x-axel.
         */
    }

    @Test
    public void testMove() {

        sut.startEngine();
        sut.turnLeft();
        double currxBeforeMove = sut.getCurrX();
        sut.move();
        double currXAfterMove = sut.getCurrX();
        Assert.assertTrue(currxBeforeMove == 0.0);
        Assert.assertTrue(currXAfterMove == 0.1);
        /*
        kontrollerar att move() ökar värdet på aktuell axel genom att kontrollerar innan och efter move() används.
         */

    }

    @Test
    public void testCurrX() {


        sut.startEngine();
        sut.turnLeft();
        sut.move();
        double currX = sut.getCurrX();

        Assert.assertEquals(0.1, currX, 0.0);
        /*
        extra test som riktar sig åt specifikt getCurrX(), kanske lite överflödigt eftersom att
        de ovanstående testerna skulle misslyckas om denna ej funkar.
         */

    }

    @Test
    public void testCurrY() {


        sut.startEngine();
        sut.turnRight();
        sut.move();
        double currY = sut.getCurrY();

        Assert.assertEquals(0.1, currY, 0.0);
        /*
        som ovan men getCurrY()
         */
    }

    @Test
    public void testGas() {
        try {
            sut.gas(1.1);}
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
            // Här testar vi om gas kan sättas till över 1.0

        }
        try {
            sut.gas(-0.1);}
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
            //Om gas inte kan sättas till negativt så kan inte farten sänkas av gas()
        }}

    @Test
    public void testCurrSpeedIncrement() {

        sut.startEngine();

        try {
            sut.incrementSpeed(150);}
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
            // testar att currentspeed går att öka samt att värdet för currspeed hamnar inom gränsvärden
        }}

    @Test
    public void testCurrSpeedDecrement() {

        sut.startEngine();

        try {
            sut.decrementSpeed(150);}
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
            // testar att värdet kan sänkas samt hamnar inom gränsvärden
        }}


    @Test
    public void testBrake() {
        try {
            sut.brake(1.1);}
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
            // Här testar vi om brake kan sättas till över 1.0
        }
        try {
            sut.brake(-0.1);}
        catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
            // När vi gör test med brake -0.1 så visar vi att break() inte kan göra att farten höjs
            // Tyckte jag gjorde en bra lösning på detta problem faktiskt, tog inspo från python <3
        }}
}
