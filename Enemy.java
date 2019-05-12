import java.awt.*;

public class Enemy extends PhysicalObject {
    private Point start;
    private Point end;
    private Point current;
    private double velocity = 10;

    public Enemy(Point start, Point end, double length, double height, Image img){
        super(start, length, height, img);
        this.start = start;
        this.end = end;
        this.current = start;
    }

    public void checkPosition() {
        if(current.equals(end)) {
            velocity *= -1;
            Point temp = start;
            this.start = end;
            this.end = temp;
        }
    }


}

