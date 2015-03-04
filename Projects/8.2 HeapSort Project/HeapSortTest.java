import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HeapSortTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HeapSortTest
{
    /**
     * Default constructor for test class HeapOfCharactersTest
     */
    public HeapSortTest()
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
    public void testOneChar()
	{
		char[] c = {'a'};
		HeapSort.heapsort(c);
		assertEquals('a', c[0]);
	}

    @Test
    public void testTwoChar()
	{
		char[] c = {'b','a'};
		HeapSort.heapsort(c);
		assertEquals(c[0],'a');
		assertEquals(c[1],'b');
	}
    
    @Test
    public void testOddNumberChar()
	{
		char[] c = {'b','a','d','e','c'};
		HeapSort.heapsort(c);
		char[] b = {'a','b','c','d','e'};
		for(int ind = 0; ind < c.length;ind++)
		assertEquals(b[ind], c[ind]);
	}
	
	@Test
	public void testEvenNumberChar()
	{
		char[] c = {'d','a','f','e','c','b'};
		char[] b = {'a','b','c','d','e','f'};
		HeapSort.heapsort(c);
		for(int ind = 0; ind < c.length;ind++)
		assertEquals(b[ind], c[ind]);
	}
}


