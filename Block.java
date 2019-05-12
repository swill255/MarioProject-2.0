import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Block extends PhysicalObject {
    public Block(Point p, double length, Image img) {
        super(p, length, length, img);
    }

    public boolean hitFromBottom(PhysicalObject other) {
        if(other.getTop().overlaps(this.getBottom()) || other.getTop().crosses(this.getBottom())) {
            return true;
        }
        return false;
    }
}
