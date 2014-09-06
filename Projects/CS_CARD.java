/**
 * 1.2 Charge Account Statement
 * 
 * @author Matthew Cheng
 * @version  9/3
 */

import java.util.Scanner;
import java.text.NumberFormat;

public class CS_CARD
{
    public static void main (String [] args)
    {
        double prevBal, newBal, charges, interest, minPay;
        
        Scanner sc = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        
        System.out.print("Please enter your previous balance: ");
        prevBal = sc.nextDouble();
        
        System.out.println();
        
        System.out.print("Please enter any additional charges you have incurred: ");
        charges = sc.nextDouble();
        
        if (prevBal > 0) {
            interest = 0.02 * (prevBal + charges);
        }
        else {
            interest = 0;
        }
        
        newBal = prevBal + charges + interest;
        
        if (newBal < 50) {
            minPay = newBal;
        }
        else if (newBal < 300) {
            minPay = 50;
        }
        else {
            minPay = newBal * 0.20;
        }
        
        System.out.println();
        System.out.println("CS CARD International Statement");
        System.out.println("===============================");
        System.out.println("Previous Balance:  	" + money.format(prevBal));
        System.out.println("Additional Charges:     " + money.format(charges));
        System.out.println("Interest:          	" + money.format(interest));
        System.out.println("New Balance:       	" + money.format(newBal));
        System.out.println("Minimum Payment:   	" + money.format(minPay));
    }
}
