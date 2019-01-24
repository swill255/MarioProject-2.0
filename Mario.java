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


    public Mario(Point location, double length, double height, Image image, double velocityX, double velocityY) {
        super(location, length, height);
        this.image = image;
    }



    public void setImage(Image img) {
        this.image = img;
    }
}