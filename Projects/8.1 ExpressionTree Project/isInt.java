import java.util.*;

public class isInt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter something to test:  ");
        String tryThis = scan.next();
        boolean truefalse = isInteger(tryThis);
        System.out.println(truefalse);
    }
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch ( Exception e) {
            return false;
        }
    }
}