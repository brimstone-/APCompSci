

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BaseConversionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BaseConversionTest
{
    /**
     * Default constructor for test class BaseConversionTest
     */
    public BaseConversionTest()
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
    public void testBase2()
    {
        assertEquals("1011001", BaseConversion.convert(89, 2));
    }

    @Test
    public void testBase5()
    {
        assertEquals("2342", BaseConversion.convert(347, 5));
    }

    @Test
    public void testBase8()
    {
        assertEquals("6331", BaseConversion.convert(3289, 8));
    }
    
    @Test
    public void testBase16()
    {
        assertEquals("3D4AB", BaseConversion.convert(251051, 16));
    }
}



