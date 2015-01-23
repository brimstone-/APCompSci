
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class IntListTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class IntListTest
{
    private IntList intList1;

    /**
     * Default constructor for test class IntListTest
     */
    public IntListTest()
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
        intList1 = new IntList();
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
    public void addToFrontThenTestLength()
    {
        intList1.addToFront(7);
        assertEquals(1, intList1.length());
    }

    @Test
    public void addTwoToFrontTestLength()
    {
        intList1.addToFront(2);
        intList1.addToFront(5);
        assertEquals(2, intList1.length());
    }

    @Test
    public void addToFrontAndEndTestLength()
    {
        intList1.addToFront(1);
        intList1.addToFront(3);
        intList1.addToEnd(4);
        assertEquals(3, intList1.length());
    }

    @Test
    public void toStringSpaceAtEnd()
    {
        intList1.addToFront(3);
        intList1.addToFront(2);
        intList1.addToFront(6);
        assertEquals("This test should fail.....","6 2 3 ", intList1.toString());
    }

    @Test
    public void toStringNoSpaceAtEnd()
    {
        intList1.addToFront(3);
        intList1.addToFront(2);
        intList1.addToFront(6);
        String st = intList1.toString();
        assertEquals("6 2 3", intList1.toString());
    }

    @Test
    public void toStringEmptyList()
    {
        assertEquals("", intList1.toString());
    }

    @Test
    public void removeLastAfterAdd()
    {
        intList1.addToFront(3);
        intList1.addToFront(2);
        intList1.addToFront(6);
        intList1.removeLast();
        assertEquals("6 2", intList1.toString());
    }

    @Test
    public void removeLastWhenEmpty()
    {
        intList1.removeLast();
        assertEquals("", intList1.toString());
    }

    @Test
    public void replaceAllInMiddle()
    {
        intList1.addToEnd(3);
        intList1.addToEnd(2);
        intList1.addToEnd(2);
        intList1.addToEnd(2);
        intList1.addToEnd(2);
        intList1.addToEnd(6);
        intList1.replace(2,7);
        assertEquals("3 7 7 7 7 6", intList1.toString());
    }

    @Test
    public void replaceAllFrontToEnd()
    {
        intList1.addToEnd(2);
        intList1.addToEnd(2);
        intList1.addToEnd(2);
        intList1.addToEnd(2);
        intList1.addToEnd(2);
        intList1.replace(2,7);
        assertEquals("7 7 7 7 7", intList1.toString());
    }

    @Test
    public void replaceAllFirstAndLast()
    {
        intList1.addToEnd(1);
        intList1.addToEnd(2);
        intList1.addToEnd(2);
        intList1.addToEnd(2);
        intList1.addToEnd(2);
        intList1.addToEnd(2);
        intList1.addToEnd(2);
        intList1.addToEnd(1);
        intList1.replace(1,7);
        assertEquals("7 2 2 2 2 2 2 7", intList1.toString());
    }
}

