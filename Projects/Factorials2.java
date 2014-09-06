/**
 *  1.3 Factorials
 * 
 * @author Matthew Cheng 
 * @version 9/3
 */
import java.util.Scanner;
public class Factorials2
{
    public static void main (String [] args)
    {
    	
    	Scanner sc = new Scanner(System.in);
    	int nbr;
    	do {
            System.out.print("Please enter a non-negative integer: ");
            nbr = sc.nextInt();
            if (nbr < 0){
                System.out.print("Bad input, please enter a non-negative integer: ");
            }
        }while (nbr < 0);
    	System.out.println(nbr + "! = " + factorial(nbr));
    }
    public static int factorial(int x)
    {
        if (x > 1)
            return (x * factorial (x-1));
        else
            return 1;
    }
}