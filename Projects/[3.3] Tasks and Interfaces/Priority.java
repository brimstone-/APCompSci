
/**
 * Write a description of interface Priority here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Priority
{
    /**
     * An example of a method header - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the result produced by sampleMethod 
     */
    
    public static final int MIN_PRIORITY = 1;
    public static final int MED_PRIORITY = 5;
    public static final int MAX_PRIORITY = 10;
    
    public void setPriority(int n);
    public int getPriority();
}
