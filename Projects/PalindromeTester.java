/**
 * 1.2 Charge Account Statement
 *
 * @author Matthew Cheng
 * @version  9/6
 */

import java.util.Scanner;

public class PalindromeTester {
    public static void main (String [] args) {
        String input, reverse, another = "y";
        Scanner sc = new Scanner (System.in);
        while (another.equalsIgnoreCase("y")) { // allows y or Y
            System.out.print("Please enter a potential palindrome: ");
            input = sc.nextLine();
            reverse = new StringBuilder(input).reverse().toString();
            boolean equals = input.equalsIgnoreCase(reverse);
            System.out.println();
            if (equals) {
                System.out.println("That string IS a palindrome.");
            } else {
                System.out.println("That string IS a palindrome.");
            }
            System.out.println();
            System.out.print("Test another palindrome (y/n)? ");
            another = sc.nextLine();
        }
    }
}