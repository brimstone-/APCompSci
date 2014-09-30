/**
 * Phone
 *
 * @author Matthew Cheng
 * @version
 */
public class Phone {
    private String brandName = "UNKNOWN", modelType = "UNKNOWN", ownerName = "UNKNOWN";
    private int batteryLife = 0;
    private double spaceLeft = 0;

    public Phone() {

    }

    public Phone(String owner, String brand, String model, int battery, double space) {
        brandName = brand;
        modelType = model;
        ownerName = owner;
        batteryLife = battery;
        spaceLeft = space;
    }

    public String makeCall(String number) {
        return "You dial " + number + " but it seems that you have no provider, so you can't make calls.";
    }

    public void setPhone(String owner, String brand, String model, int battery, double space) {
        brandName = brand;
        modelType = model;
        ownerName = owner;
        batteryLife = battery;
        spaceLeft = space;
    }

    public String getBrand() {
        return brandName;
    }

    public void setBrand(String brand) {
        brandName = brand;
    }

    public String getModel() {
        return modelType;
    }

    public void setModel(String model) {
        modelType = model;
    }

    public String getOwner() {
        return ownerName;
    }

    public void setOwner(String owner) {
        ownerName = owner;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int battery) {
        batteryLife = battery;
    }

    public double getSpace() {
        return spaceLeft;
    }

    public void setSpace(double space) {
        spaceLeft = space;
    }

    public String toString() {
        return "This phone belongs to " + ownerName + " and is a " + modelType + " manufactured by " + brandName 
        + " it has\n" + batteryLife + "% battery left and " + spaceLeft + " Gb of storage space available.";
    }

}
