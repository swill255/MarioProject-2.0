import java.awt.*;

/**
 * PhysicalObject which is a rectangular object in 2D space
 * created from 4 lines a top, left, right, and bottom
 *
 * Created 1/17/19 - shanew
 * Author(s): shanew
 */
public class PhysicalObject {
    /** Line that composes the top of the rectangular object*/
    protected Line top;

    /** Line that composes the left side of the rectangular object*/
    protected Line left;

    /** Line that composes the bottom of the rectangular object*/
    protected Line bottom;

    /** Line that composes the right side of the rectangular object*/
    protected Line right;

    /** Length of the top and bottom lines*/
    protected double length;

    /** Length of the right and left lines*/
    protected double height;

    /** Image in the rectangle of the PhysicalObject*/
    protected Image image;

    /**
     * Constructor that with two lines that are the top and left compose an entire PhysicalOBject
     * @param length top Line of the object that then is used to create the bottom line
     * @param height left Line of the object that this is used to create the right line
     */
    public PhysicalObject(Line length, Line height, Image img) {
        this.top = length;
        this.left = height;
        Point bottomRight = new Point(top.getP1().getX(), left.getP1().getY());
        this.bottom = new Line(left.getP1(), bottomRight);
        this.right = new Line(bottomRight, top.getP2());
        this.length = length.getDistance();
        this.height = height.getDistance();
        this.image = img;
    }

    /**
     * Constructor that with a Point object and double length and height of the object
     * creates the 4 lines that make up a PhysicalObject.
     * @param p Point that is the top left corner of the rectangle
     * @param length the length of the bottom and top of the rectangle
     * @param height the length of the right and left sides of the rectangle
     */
    public PhysicalObject(Point p, double length, double height, Image img) {
        Point p1 = p;
        Point p2 = new Point(p.getX() + length, p.getY());
        Point p3 = new Point(p.getX(), p.getY() - height);
        Point p4 = new Point(p.getX() + length, p.getY() - height);
        this.top = new Line(p1, p2);
        this.bottom = new Line(p3, p4);
        this.left = new Line(p1, p3);
        this.right = new Line(p2, p4);
        this.length = length;
        this.height = height;
        this.image = img;
    }

    /**
     * Getter method that returns the top side
     * @return top instance variable
     */
    public Line getTop() {
        return top;
    }

    /**
     * Getter method that returns the bottom side
     * @return bottom instance variable
     */
    public Line getBottom() {
        return bottom;
    }

    /**
     * Getter method that returns the left side
     * @return left instance variable
     */
    public Line getLeft() {
        return left;
    }

    /**
     * Getter method that returns the right side
     * @return right instance variable
     */
    public Line getRight() {
        return right;
    }

    /**
     * Gives the top left Point of the PhysicalObject
     * @return p1 of top line
     */
    public Point getPosition() {
        return top.getP1();
    }

    /**
     * Sets the position of the top left corner of the PhysicalObject.
     * This transposes the four lines to fit this new point
     * @param p the new point where the PhysicalObject will be
     */
    public void setPosition(Point p) {
        Point p1 = p;
        Point p2 = new Point(p.getX() + length, p.getY());
        Point p3 = new Point(p.getX(), p.getY() - height);
        Point p4 = new Point(p.getX() + length, p.getY() - height);
        this.top = new Line(p1, p2);
        this.bottom = new Line(p3, p4);
        this.left = new Line(p1, p3);
        this.right = new Line(p2, p4);
        this.length = length;
        this.height = height;
    }

    /**
     * Given two PhysicalObjects determines whether they overlap at all aka share a point in common
     * @param other PhysicalObject being compared
     * @return true if overlaps and false if otherwise
     */
    public boolean overlaps(PhysicalObject other){
        Line[] ourSides = {this.top, this.bottom, this.right, this.left};
        Line[] theirSides = {other.top, other.bottom, other.right, other.left};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Line our = ourSides[i];
                Line their = theirSides[j];
                if(our.crosses(their) || our.overlaps(their)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Prints the Image over the space taken up by the
     * PhysicalObject as a GUI (will be MARIO, BLOCK, etc.)
     * @param g Graphics parameter that is for the JPanel
     */
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, (int) this.getPosition().getX(), (int) this.getPosition().getY(), null);
    }

    /**
     * Overriden method from the Object class that determines whether another object is equal
     * It is equal if all four lines are equal.
     * @param o Object that is being compared
     * @return true if equal and false if otherwise
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof PhysicalObject) {
            PhysicalObject other = (PhysicalObject) o;
            if(other.getBottom().equals(bottom) && other.getLeft().equals(left) &&
                other.getRight().equals(right) && other.getTop().equals(top)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a String of the relavent information; the four Lines
     * @return String printing the four lines
     */
    @Override
    public String toString() {
        return top.toString() + bottom.toString() + right.toString() + left.toString();
    }

}
