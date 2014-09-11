
/**
 * Write a description of class PalindromeDoneRight here.
 * 
 * @author Matthew Cheng
 * @version 1337
 */
import java.util.Scanner;
public class PalindromeDoneRight
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner (System.in);

        String another = "y";
        while (another.equalsIgnoreCase("y")) {

            System.out.print("Please enter a potential palindrome: ");
            String s = scan.nextLine();
            
            String sNew = "";

            s = s.toLowerCase();
            
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c>='a' && c<='z'){
                    sNew += c;
                }
            }
            int left = 0, right = sNew.length() - 1;
            while (sNew.charAt(left) == sNew.charAt(right) && left < right)
            {
                left++;
                right--;
            }
            if (left < right) {
                System.out.println ("That string is NOT a palindrome.");
            }
            else {
                System.out.println ("That string IS a palindrome.");
            }

            System.out.println();
            System.out.print("Test another palindrome (y/n)? ");
            another = scan.nextLine();
        }
    }
}
