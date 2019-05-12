import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Mario extends PhysicalObject{
    Point location;
    double length;
    double height;
    Image image;

    public Mario(Point location, double length, double height, Image image) {
        super(location, length, height);
        this.image = image;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point p) {
        this.location = p;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double len) {
        this.length = len;
    }

    public double getHeight() {
        return height;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image img) {
        this.image = img;
    }
}