import java.util.*;

public class ExpressionTreeRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String keepRunning = "y";
        while (keepRunning.trim().toLowerCase().equals("y")) {
            System.out.println("Please enter an expression.");
            String expressionInput = scan.next();

            ExpressionTree expression = new ExpressionTree(expressionInput);
            int solution = expression.EvaluateTree();

            System.out.println("The value of this expression is: " + solution);
            System.out.println();
            System.out.println("Evaluate another expression? (y/n)");
            keepRunning = scan.next();
        }
    }
}