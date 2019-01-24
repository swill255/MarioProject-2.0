public class PhysicalObject {
    private Line top;
    private Line left;
    private Line bottom;
    private Line right;
    private double length;
    private double height;

    public PhysicalObject(Line length, Line height) {
        this.top = length;
        this.left = height;
        Point bottomLeft = new Point(top.getP2().getX(), left.getP1().getY());
        this.bottom = new Line(height.getP1(), bottomLeft);
        this.right = new Line(length.getP2(), bottomLeft);
        this.length = length.getDistance();
        this.height = height.getDistance();
    }

    public PhysicalObject(Point p, double length, double height) {
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

    public Line getTop() {
        return top;
    }

    public Line getBottom() {
        return bottom;
    }

    public Line getLeft() {
        return left;
    }

    public Line getRight() {
        return right;
    }

    public Point getPosition() {
        return top.getP1();
    }

    public void setTop(Line top) {
        this.top = top;
    }

    public void setBottom(Line bottom) {
        this.bottom = bottom;
    }

    public void setLeft(Line left) {
        this.left = left;
    }

    public void setRight(Line right) {
        this.right = right;
    }

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
}
