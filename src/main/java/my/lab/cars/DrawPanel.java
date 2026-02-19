package my.lab.cars;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    //ArrayList<String> carImage = new ArrayList<>();
    //String [] carimages = {"pics/Volvo.jpg","pics/VolvoBrand.jpg", "pics/Saab95.jpg", "pics/Scania.jpg"};


    BufferedImage carImage;
    // To keep track of a single car's position
    //Point carPoint = new Point();
    Point saabPoint = new Point();
    BufferedImage saabImage;

    Point volvoPoint = new Point();
    BufferedImage volvoImage;

    Point scaniaPoint = new Point();
    BufferedImage scaniaImage;

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,0);

    // TODO: Make this general for all cars
    void moveit(int x, int y, Car car){

        if (car instanceof Volvo240) {
            volvoPoint.x = x;
            volvoPoint.y = y;
        }
        else if (car instanceof Saab95) {
           saabPoint.x = x;
            saabPoint.y = y;
        }
       else if (car instanceof Scania) {
           scaniaPoint.x = x;
           scaniaPoint.y = y;
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.blue);
        // Print an error message in case file is not found with a try/catch block

        try { volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")); }
        catch (IOException ex) { ex.printStackTrace(); }

        try { volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")); }
        catch (IOException ex) { ex.printStackTrace(); }

        try { saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")); }
        catch (IOException ex) { ex.printStackTrace(); }

        try { scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")); }
        catch (IOException ex) { ex.printStackTrace(); }



//        for (String carimage : carimages) {
//            try {
//                carImage = ImageIO.read(DrawPanel.class.getResourceAsStream(carimage));
//
//            } catch (IOException ex) {
//                ex.printStackTrace();
            }


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);

    }
}
