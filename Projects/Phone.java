
/**
 * Phone
 * 
 * @author Matthew Cheng
 * @version 
 */
public class Phone
{
    private String brandName = "UNKNOWN", modelType = "UNKNOWN", ownerName = "UNKNOWN";
    private int batteryLife = 0;
    private double spaceLeft = 0;
    
    public Phone()
    {

    }

    public int getBatteryLife()
    {
        return batteryLife;
    }

    public void setPhone(String owner, String brand, String model, int battery, int space)
    {
        brandName = brand;
        modelType = model;
        ownerName = owner;
        batteryLife = battery;
        spaceLeft = space;
    }

    public String toString()
    {
        return "This phone belongs to" + ownerName + " and is a " + modelType + " made by " + brandName + " it has " + batteryLife + "% battery left and has " + spaceLeft + " Gb of storage space left.";
    }

}
