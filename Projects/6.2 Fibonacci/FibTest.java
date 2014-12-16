
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class FibTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FibTest
{
    /**
     * Default constructor for test class FibTest
     */
    public FibTest()
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
    public void testFib1Of0()
    {
        assertEquals(1, Fib.fib1(2));
    }

    @Test
    public void testFib2Of0()
    {
        assertEquals(1, Fib.fib2(2));
    }

    @Test
    public void testFib1Of1()
    {
        assertEquals(1, Fib.fib1(1));
    }

    @Test
    public void testFib2Of1()
    {
        assertEquals(1, Fib.fib2(1));
    }

    @Test
    public void testFib1Of10()
    {
        assertEquals(55, Fib.fib1(10));
    }

    @Test
    public void testFib2Of10()
    {
        assertEquals(55, Fib.fib2(10));
    }

    @Test
    public void testFib1Of25()
    {
        assertEquals(75025, Fib.fib1(25));
    }

    @Test
    public void testFib2Of25()
    {
        assertEquals(75025, Fib.fib2(25));
    }
    
    @Test
    public void testFib1Of40()
    {
        assertEquals(102334155, Fib.fib1(40));
    }

    @Test
    public void testFib2Of40()
    {
        assertEquals(102334155, Fib.fib2(40));
    }
}
