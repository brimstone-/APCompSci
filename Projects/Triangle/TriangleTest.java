public class TriangleTest {
    public static void main (String [] args) {
        Triangle t = new Triangle(3,4,5);
        System.out.println(t.toString());
        System.out.println("Triangle validity = " + t.isValid());
    }
}