/**
 * 1.4 PalindromeTester2
 *
 * @author Matthew Cheng
 * @version  9/6
 */

import java.util.Scanner;

public class PalindromeTester2 {

    public static void main (String [] args) {

        String input, reverse = "", another = "y";
        Scanner sc = new Scanner (System.in);

        while (another.equalsIgnoreCase("y")) {
            
            System.out.print("Please enter a potential palindrome: ");
            input = sc.nextLine();

            reverse = reverseString(input);
            reverse = letterOnly(reverse);
            input = letterOnly(input);

            boolean equals = input.equalsIgnoreCase(reverse);

            if (equals) {
                System.out.println();
                System.out.println("That string IS a palindrome.");
            } else {
                System.out.println();
                System.out.println("That string IS NOT a palindrome.");
            }

            System.out.println();
            System.out.print("Test another palindrome (y/n)? ");
            another = sc.nextLine();
        }
    }

    public static String reverseString(String Line) {

        int length = Line.length() - 1;

        String s = "";

        for (int i = length; i >= 0; i--) {
            if (Line.charAt(i) != ' ') {
                s += Line.charAt(i);
            }
        }
        return s;
    }

    public static String letterOnly(String Line) {

        int length = Line.length();

        String s = "";

        for (int i = 0; i < length; i++) {
            if (Character.isLetter(Line.charAt(i))) {
                s += Line.charAt(i);
            }
        }
        return s;
    }
}
