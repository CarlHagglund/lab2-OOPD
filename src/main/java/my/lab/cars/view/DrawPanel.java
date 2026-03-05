package my.lab.cars.view;

import my.lab.cars.model.Car;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    Map<Car,BufferedImage> images;
    Map<Car,Point> points;

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    public void moveit(int x, int y, Car car){
        points.get(car).x=x;
        points.get(car).y=y;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.blue);
        // Print an error message in case file is not found with a try/catch block
        try { volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")); }
        catch (IOException ex) { ex.printStackTrace(); }

        images = new HashMap<>();
        points = new HashMap<>();
    }

    public void addCar(Car car, String imagePath) {
        try {
            images.put(car, ImageIO.read(DrawPanel.class.getResourceAsStream(imagePath)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        points.put(car, new Point());
    }
    public void removeCar(Car car) {
        images.remove(car);
        points.remove(car);
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);

        for (Map.Entry<Car, BufferedImage> entry : images.entrySet()) {
            Point p = points.get(entry.getKey());
            if (p != null) {
                g.drawImage(entry.getValue(), p.x, p.y, null);}
        }
    }
}
