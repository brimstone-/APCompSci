import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ExpressionTreeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExpressionTreeTest
{
    /**
     * Default constructor for test class ExpressionTreeTest
     */
    public ExpressionTreeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testOneInt()
    {
        ExpressionTree expressi2 = new ExpressionTree("123");
        assertEquals(123, expressi2.EvaluateTree());
    }
    
    @Test
    public void testAdd()
    {
        ExpressionTree expressi1 = new ExpressionTree("1+3");
        assertEquals(4, expressi1.EvaluateTree());
    }

    @Test
    public void testAddMultSubt()
    {
        ExpressionTree expressi1 = new ExpressionTree("1+2*5-4");
        assertEquals(7, expressi1.EvaluateTree());
    }

    @Test
    public void testAll()
    {
       ExpressionTree expressi1 = new ExpressionTree("1*5-6+7/2-32%3");
       assertEquals(0, expressi1.EvaluateTree()); 
    }
}



