/**
 * The class creates a binary tree that represents an arithmetic expression
 * of ints with operators +,-,*,/ and %.
 */
public class ExpressionTree
{
    public ExpressionNode head;
    public ExpressionTree(String s)
    {
        build(s);
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
        String val = "";
        if (s.lastIndexOf("+") != -1 || s.lastIndexOf("-") != -1) {
            
        }
        else if (s.lastIndexOf("*") != -1 || s.lastIndexOf("/") != -1 || s.lastIndexOf("%") != -1) {
            
        }
        else
            return new ExpressionNode(val, null, null);
    }

}
