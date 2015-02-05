public class Item
{
    private String description;
    private double cost;

    public Item(String description, double cost)
    {
        this.description = description;
        this.cost = cost;
    }

    public String getDescription()
    {
        return description;
    }

    public double getCost()
    {
        return cost;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public String toString()
    {
        return "Item:  " + description + ", Cost:  " + cost;
    }
}