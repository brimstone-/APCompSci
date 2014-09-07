/**
 * 1.4 PalindromeTester
 *
 * @author Matthew Cheng
 * @version  9/6
 */

import java.util.Scanner;

public class PalindromeTester2 {
    public static void main (String [] args) {
        String input, reverse, another = "y";
        Scanner sc = new Scanner (System.in);

        while (another.equalsIgnoreCase("y")) {
            System.out.print("Please enter a potential palindrome: ");
            input = sc.nextLine();

           	

            System.out.println();
            System.out.print("Test another palindrome (y/n)? ");
            another = sc.nextLine();
        }
    }
}