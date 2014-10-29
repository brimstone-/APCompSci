
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TaskTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TaskTest
{
    /**
     * Default constructor for test class TaskTest
     */
    public TaskTest()
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
    public void testSetPriority()
    {
        Task t1 = new Task(10,5);
        t1.setPriority(5);
        assertEquals(5,t1.getPriority());
    }
    
    @Test
    public void testGetPriority()
    {
        Task t2 = new Task(1,2);
        assertEquals(1,t2.getPriority());
    }
}