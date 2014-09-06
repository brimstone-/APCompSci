/**
 * 1.3 Factorials
 *
 * @author Matthew Cheng
 * @version 9/3
 */

import java.util.Scanner;

public class Factorials {
    public static void main (String [] args) {
        int nbr, ctr = 1, answer = 1;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Please enter a non-negative integer: ");
            nbr = sc.nextInt();
            if (nbr < 0) {
                System.out.print("Bad input, please enter a non-negative integer: ");
            }
        } while (nbr < 0);
        while (nbr > 1) {
            answer *= nbr;
            nbr--;
            ctr++;
        }
        System.out.print(ctr + " factorial is " + answer);
    }
}