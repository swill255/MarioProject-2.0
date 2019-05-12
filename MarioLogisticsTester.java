//These tests are just for non graphics based tests

public class MarioLogisticsTester {

    public static void main(String[] args) {
        Point p1 = new Point(-3,1);
        Point p2 = new Point(5,1);
        Point p3 = new Point(-12,1);
        Point p4 = new Point(-4,1);

        if(p1.isBelow(p2)){
            System.out.println("p1 is below p2 and the distance between them is " + p1.getDistance(p2));
        }
        if(p1.isLeft(p2)){
            System.out.println("p1 is to the left of p2 and the distance between them is " + p2.getDistance(p1));
        }
        if(p1.equals(p2)) {
            System.out.println("p1 is equal to p2 with a distance of " + p1.getDistance(p2));
        }

        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p3, p4);

        if(l1.isOnLine(p3)){
            System.out.println("p3 is on the line between p1 and p2");
        }
        System.out.println(l1);

        if(l1.isPerpendicular(l2)) {
            System.out.println("These be perpendicular");
        }
        System.out.println(l1.getP1().getX());
        System.out.println(l1.getP2().getX());

        if(l1.getP1().getX() < l1.getP2().getX()) {
            System.out.println("The points oriented correctly");
        }

        if(l1.crosses(l2)) {
            System.out.println("These bitches cross");
        }

        if(l1.overlaps(l2)) {
            System.out.println("They be overlapping ");
        }
    }
}
