import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Block extends PhysicalObject {
    Image image;

    public Block(Point p, double length, Image img) {
        super(p, length, length);
        this.image = img;
    }

    public boolean hitFromBottom(PhysicalObject other) {
        if(other.getTop().overlaps(this.getBottom())) {
            return true;
        }
        return false;
    }
}
