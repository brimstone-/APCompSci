public class Rectangle extends Shape
{
    private double width, height;

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle(double w, double h)
    {
        super("Rectangle");
        width = w;
        height = h;
    }

    public double area()
    {
        return width * height;
    }
    
    public String toString()
    {
        return super.toString() + " of width " + width + " and height " + height;
    }
}
