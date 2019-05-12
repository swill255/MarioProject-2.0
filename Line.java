/**
 * Special Line class for the purpose of a Mario game where all the characters will be created using rectangular objects.
 * It is comprised of 2 points in 2D space
 *
 * Created 1/12/19 - shanew
 * Author(s): shanew
 */
public class Line {
    /** Point object, is either the left or bottom point of the line */
    private Point p1;

    /** Point object, is either the right or top point on the line */
    private Point p2;

    /** double distance between p1 and p2 */
    private double distance;

    /**
     * Constructor to form a line from two Points p1 and p2.
     * p1 will always be the point on the left unless it is a line with no change in X
     * in which case it will be the lower point. Thus p2 is always the right point or top if
     * there is no change in X.
     * @param p1 Point that is left or bottom
     * @param p2 Point that is right or top
     */
    public Line(Point p1, Point p2) {
        setPs(p1, p2);
    }
    /**
     * Getter method that returns to the user p1
     * @return Point p1 that is left or bottom
     */
    public Point getP1() {
        return p1;
    }

    /**
     * Getter method that returns to the user p2
     * @return Point p2 that is right or top
     */
    public Point getP2() {
        return p2;
    }

    /**
     * Setter that with a input will change the first point
     * will orientate so as to still have everything in correct order
     * @param p1 the new Point for the line to orientate from p2
     TODO: Fix param
     */
    public void setPs(Point p1, Point p2) {
        double x1 = p1.getX();
        double x2 = p2.getX();
        double y1 = p1.getY();
        double y2 = p2.getY();
        if(x1 < x2) {
            this.p1 = p1;
            this.p2 = p2;
        } else if (x1 > x2) {
            this.p1 = p2;
            this.p2 = p1;
        } else {
            if(y1 < y2) {
                this.p1 = p1;
                this.p2 = p2;
            } else {
                this.p1 = p2;
                this.p2 = p1;
            }
        }
        this.distance = this.p1.getDistance(this.p2);
    }

    public void setP1(Point p) {
        setPs(p, this.p2);
    }

    /**
     * Setter that with an input will change the first point
     * will orientate so as to still have everything in correct order
     * @param p the new Point for the Line to orient from p2
     */
    public void setP2(Point p) {
        setPs(this.p1, p);
    }
    /**
     * Returns to the user the distance between p1 and p2
     * @return double instance variable distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Calculates the difference of the x components between the left and right points
     * @return double, the difference between the two
     */
    public double getDeltaX() {
        if(p1.isLeft(p2)) {
            return p2.getX() - p1.getX();
        }
        return p1.getX() - p2.getX();
    }

    /**
     * Calculates the difference of the y components between the left and right points
     * @return double, the difference between the two
     */
    public double getDeltaY() {
        if(p1.isBelow(p2)) {
            return p2.getY() - p1.getY();
        }
        return p1.getY() - p2.getY();
    }

    /**
     * Calculates the slope of the line
     * @return double slope
     */
    public double getSlope() {
        if(getDeltaX() != 0) {
            return this.getDeltaY() / this.getDeltaX();
        }
        return 0.0;
    }

    /**
     * Returns whether another Line object is parallel (has the same slope)
     * as another Line object.
     * @param other the Line object being compared.
     * @return boolean, true if parallel and false if otherwise
     */
    public boolean isParallel(Line other) {
        double slope1 = this.getDeltaY()/this.getDeltaX();
        double slope2 = other.getDeltaY()/other.getDeltaX();

        if(slope1 == slope2) {
            return true;
        }
        return false;
    }

    /**
     * Determines whether two Line objects are perpendicular and returns true or false
     * @param other Line object being compared
     * @return boolean, true if perpendicular and false if otherwise
     */
    public boolean isPerpendicular(Line other) {
        if(this.getSlope() == (1/other.getSlope()) * -1) {
            return true;
        } else if((this.getDeltaY() == 0 && this.getDeltaX() != 0) &&
                    (other.getDeltaY() != 0 && other.getDeltaX() == 0)) {
            return true;
        } else if((other.getDeltaY() == 0 && other.getDeltaX() != 0) &&
                (this.getDeltaY() != 0 && this.getDeltaX() == 0)) {
            return true;
        }
        return false;
    }

    /**
     * Given a point object returns a boolean whether the point is on the Line object
     * @param p Point object
     * @return true if on line and false otherwise
     */
    public boolean isOnLine(Point p) {
        Point a = p1;
        Point b = p2;
        return a.getDistance(p) + p.getDistance(b) == a.getDistance(b);
    }

    /**
     * This tells whether two lines that are either parallel or perpendicular to the x-axis cross.
     * They must be perpendicular and share a point in common.
     * @param other Line object being compared to the given Line
     * @return true if cross and false otherwise
     */
    public boolean crosses(Line other) {
        if (this.isPerpendicular(other)) {
            if (this.getDeltaX() == 0) {
                double x = this.getP1().getX();
                double a = other.getP1().getX();
                double b = other.getP2().getX();
                if (a <= x && b >= x) {
                    double y = other.getP1().getY();
                    double c = this.getP1().getY();
                    double d = this.getP2().getY();
                    if(c <= y && d >= y) {
                        return true;
                    }
                    return true;
                }
                return false;
            }
            if (other.getDeltaX() == 0) {
                double x = other.getP1().getX();
                double a = this.getP1().getX();
                double b = this.getP2().getX();
                if(a <= x && b >= x) {
                    double y = this.getP1().getY();
                    double c = other.getP1().getY();
                    double d = other.getP2().getY();
                    if(c <= y && d >= y) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /**
     * Determines whether two lines that are either parallel or perpendicular to the x axis overlap eachother.
     * The criteria is that they must be parallel and have at least one point in common.
     * @param other
     * @return
     */
    public boolean overlaps(Line other) {
        if(this.isParallel(other)) {
            if(this.getDeltaX() == 0) {
                if (other.getP1().getX() == this.getP1().getX()) {
                    if(other.getP1().getY() < this.getP1().getY()) {
                        if(other.getP2().getY() >= this.getP1().getY() && other.getP2().getY() <= this.getP2().getY()) {
                            return true;
                        }
                        return false;
                    } else {
                        if (this.getP2().getY() >= this.getP1().getX() && this.getP2().getY() <= other.getP2().getY()) {
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            } else if (this.getDeltaY() == 0){
                if(this.getP1().getY() == other.getP1().getY()) {
                    if (other.getP1().getX() < this.getP1().getX()) {
                        if (other.getP2().getX() >= this.getP1().getX() && other.getP2().getX() <= this.getP2().getX()) {
                            return true;
                        }
                        return false;
                    } else {
                        if (this.getP2().getX() >= other.getP1().getX() && this.getP2().getX() <= other.getP2().getX()) {
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /**
     * Overriden from the Object class and is true if both points are the same
     * @param other Line object being compared
     * @return true if points are the same and false if otherwise
     */
    @Override
    public boolean equals(Object other) {
        if(other instanceof Line) {
            Line o = (Line) other;
            if (this.p1.equals(o.getP1())) {
                if(this.p2.equals(o.getP2())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Overriden from the Object class and returns relevant information,
     * the points and distance between them, in String form
     * @return String of points and distance between them
     */
    @Override
    public String toString() {
        return "P1: " + p1 + " P2: " + p2 + " Distance: " + distance;
    }
}
