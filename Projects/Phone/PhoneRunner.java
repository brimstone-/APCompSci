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
    	System.out.println(p1);
    }
}