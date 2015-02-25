/**
 * The class creates a binary tree that represents an arithmetic expression
 * of ints with operators +,-,*,/ and %.
 */
public class ExpressionTree
{
    public ExpressionNode head;
    public ExpressionTree(String s)
    {
        head = build(s);
    }

    //-----------------------------------------------------------------
    // Returns an int representing the value of the expression 
    // stored in this tree.
    //-----------------------------------------------------------------
    public int EvaluateTree()
    {
        return head.getExprValue();
    }

    //-----------------------------------------------------------------
    // Helper method for the constructor.
    //-----------------------------------------------------------------
    private ExpressionNode build(String s)
    {
        int plus = s.lastIndexOf("+");
        int minus = s.lastIndexOf("-");
        int multiply = s.lastIndexOf("*");
        int divide = s.lastIndexOf("/");
        int mod = s.lastIndexOf("%");
        ExpressionNode result;
        if (plus > -1 || minus > -1) {
            if (plus > minus) {
                result = new ExpressionNode("+", build(s.substring(0, plus)), build(s.substring(plus+1)));
            }
            else {
                result = new ExpressionNode("-", build(s.substring(0, minus)), build(s.substring(minus+1)));
            }
        }
        else if (multiply > -1 || divide > -1 || mod > -1) {
            if (multiply > divide && multiply > mod) {
                result = new ExpressionNode("*", build(s.substring(0, multiply)), build(s.substring(multiply+1)));
            }
            else if (divide > multiply && divide > mod) {
                result = new ExpressionNode("/", build(s.substring(0, divide)), build(s.substring(divide+1)));
            }
            else
                result = new ExpressionNode("%", build(s.substring(0, mod)), build(s.substring(mod+1)));
        }
        else {
            result = new ExpressionNode(s, null, null);
        }
        return result;
    }
}
