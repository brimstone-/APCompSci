public abstract class Shape
{
    String shapeName;
    
    public Shape(String a)
    {
        shapeName = a;
    }
    
    public abstract double area();
    
    public String toString()
    {
        return shapeName;
    }
}
