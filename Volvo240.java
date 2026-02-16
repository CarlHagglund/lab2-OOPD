package my.lab.cars;

import java.awt.*;

public class Volvo240 extends Car {

    /* Här använder vi inhertance när vi "extends Car"
    // Nu kan vi skapa instance objekt så att Car car1 = new Volvo240
    Car objekten är subtyper men kan fortfarande ses som "Car" objekt
    */

    // attributer för riktning och koordinater

    public Volvo240() {
        super(4, Color.black, 100, "Volvo240", 1300);
    }
    // Här visar vi vad som händer om vi kallar superklassen för att skapa en Volvo240 med dessa attributer.


    public void move() {
        super.move();
    }

    public void turnLeft() {
        super.turnLeft();
    }

    public void turnRight() {
        super.turnRight();
    }

}