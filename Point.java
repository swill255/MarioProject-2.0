public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getDistance(Point other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }

    public boolean isBelow(Point other) {
        if(this.y < other.y) {
            return true;
        }
        return false;
    }

    public boolean isLeft(Point other) {
        if(this.x < other.x) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Point) {
            Point other = (Point) obj;
            if(other.x == this.x) {
                if(other.y == this.y) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
