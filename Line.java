public class Line {
    private Point p1;
    private Point p2;
    private double distance;

    public Line(Point p1, Point p2) {
        if(p1.getX() < p2.getX()) {
            this.p1 = p1;
            this.p2 = p2;
        } else if (p1.getX() > p2.getX()) {
            this.p1 = p2;
            this.p2 = p1;
        } else {
            if(p1.getY() < p2.getY()) {
                this.p1 = p1;
                this.p2 = p2;
            } else {
                this.p1 = p2;
                this.p2 = p1;
            }
        }
        this.distance = p1.getDistance(p2);
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
        this.distance = p1.getDistance(p2);
    }

    public void setP2(Point p2) {
        this.p2 = p2;
        this.distance = p1.getDistance(p2);
    }

    public double getDistance() {
        return distance;
    }

    public double getDeltaX() {
        if(p1.isLeft(p2)) {
            return p2.getX() - p1.getX();
        }
        return p1.getX() - p2.getX();
    }

    public double getDeltaY() {
        if(p1.isBelow(p2)) {
            return p2.getY() - p1.getY();
        }
        return p1.getY() - p2.getY();
    }

    public double getSlope() {
        if(getDeltaX() != 0) {
            return this.getDeltaY() / this.getDeltaX();
        }
        return 0.0;
    }

    public boolean isParallel(Line other) {
        double slope1 = this.getDeltaY()/this.getDeltaX();
        double slope2 = other.getDeltaY()/other.getDeltaX();

        if(slope1 == slope2) {
            return true;
        }
        return false;
    }

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

    public boolean isOnLine(Point p) {
        Point a = p1;
        Point b = p2;
        return a.getDistance(p) + p.getDistance(b) == a.getDistance(b);
    }

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

    public boolean overlaps(Line other) {
        if(this.isParallel(other)) {
            if(this.getDeltaX() == 0) {
                if
                if(other.getP1().getY() < this.getP1().getY()) {
                    if(other.getP1)
                }
            } else if (this.getDeltaY() == 0){
                if(this.getP1().getY() == other.getP1().getY()) {
                    if (other.getP1().getX() < this.getP1().getX()) {
                        if (other.getP2().getX() > this.getP1().getX()) {
                            return true;
                        }
                        return false;
                    } else {
                        if (this.getP2().getX() >= other.getP1().getX()) {
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

    @Override
    public String toString() {
        return "P1: " + p1 + " P2: " + p2 + " Distance: " + distance;
    }
}
