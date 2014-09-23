public class Triangle
{
    private double side1 = 0, side2 = 0, side3 = 0;
    private double angle1= 0, angle2 = 0, angle3 = 0;
    private double area = 0, perimeter = 0;
    
    public Triangle (double s1, double s2, double s3)
    {
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }
    public double area () //Hero's Formula.
    {
        double s = 0.5 * perimeter();
        return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
    }
    public boolean isValid ()
    {
        return ((side1 + side2) > side3 && (side2 + side3) > side1 && (side3 + side1) > side2);
    }
    public double perimeter ()
    {
        return side1 + side2 + side3;
    }
    public String toString ()
    {
        String list = "The length of the sides are " + side1 + ", " + side2 + " and " + side3 + " The perimeter is " + perimeter() + " and the area is " + area() + ".";
        return list;
    }
}
