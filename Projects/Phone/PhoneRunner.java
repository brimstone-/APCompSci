/**
 * PhoneRunner
 *
 * @author Matthew Cheng
 * @version
 */
public class PhoneRunner {
    public static void main(String[] args) {
    	Phone p1 = new Phone("Matthew","Apple","iPhone 5",99,1.3);
    	System.out.println(p1+"\n");
    	p1.setModel("iPhone 6");
    	p1.setSpace(30.2);
    	System.out.println("Matthew has upgraded his phone.\n\n" + p1);
    	p1.setBrand("Google");
    	p1.setModel("Nexus 5");
    	p1.setSpace(60);
    	System.out.println("\nMatthew comes to his senses and actually upgrades to a real phone this time.\n\n" + p1);
    }
}