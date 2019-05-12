/**
 * Basic Point class that describes an object
 * that is a point in 2D space.
 *
 * Created 1/12/19 - shanew
 * Author(s): shanew
 */
public class Point {
    /** The x component of the point*/
    private double x;

    /** The y component of the point*/
    private double y;

    /**
     * Constructor for the Point class
     * @param x the x component of the Point object
     * @param y the y component of the Point object
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter method for the x component of the point.
     * @return double instance variable x
     */
    public double getX() {
        return x;
    }

    /**
     * Getter method for the y component of the point
     * @return double instance variable y
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the absolute value of the distance between two points.
     * This value will always be positive.
     * @param other another Point object that is being compared
     * @return double distance between the points
     */
    public double getDistance(Point other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }

    /**
     * Determines whether another point is below the other
     * @param other Point
     * @return boolean that determines whether it is
     */
    public boolean isBelow(Point other) {
        if(this.y < other.y) {
            return true;
        }
        return false;
    }

    /**
     * Determines whether another point is to the left of the current object
     * @param other Point object
     * @return boolean true if current object is left of other; false otherwise
     */
    public boolean isLeft(Point other) {
        if(this.x < other.x) {
            return true;
        }
        return false;
    }

    /**
     * Two Point objects are equal if they have the same x and y coordinates.
     * @param obj Object object to be compared to see if it is equal
     * @return boolean if the are equal and false otherwise
     */
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

    /**
     * Takes the most important information and converts it into a String format.
     * This only includes the x and y coordinates.
     * @return String representation of the information x and y
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
