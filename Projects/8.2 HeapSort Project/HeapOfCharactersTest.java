import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HeapOfCharactersTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HeapOfCharactersTest
{
    /**
     * Default constructor for test class HeapOfCharactersTest
     */
    public HeapOfCharactersTest()
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
    public void testEvenRemoveOneBubbleDown()
    {
        HeapOfCharacters heapOfCh1 = new HeapOfCharacters();
		heapOfCh1.add('c');
		heapOfCh1.add('b');
		heapOfCh1.add('a');
		heapOfCh1.add('d');
		heapOfCh1.removeRoot();
		assertEquals("[null, b, c, d]", heapOfCh1.toString());
    }

    @Test
    public void testOddRemoveOneBubbleDown()
    {
        HeapOfCharacters heapOfCh1 = new HeapOfCharacters();
		heapOfCh1.add('a');
		heapOfCh1.add('b');
		heapOfCh1.add('c');
		heapOfCh1.add('f');
		heapOfCh1.add('d');
		heapOfCh1.removeRoot();
		assertEquals("[null, b, d, c, f]", heapOfCh1.toString());
    }
    
    @Test
    public void testOddRemoveOneBubbleDownTwice()
    {
        HeapOfCharacters heapOfCh1 = new HeapOfCharacters();
		heapOfCh1.add('a');
		heapOfCh1.add('b');
		heapOfCh1.add('c');
		heapOfCh1.add('d');
		heapOfCh1.add('e');
		heapOfCh1.add('f');
		heapOfCh1.add('g');
		heapOfCh1.removeRoot();
		assertEquals("[null, b, d, c, g, e, f]", heapOfCh1.toString());
    }
}


