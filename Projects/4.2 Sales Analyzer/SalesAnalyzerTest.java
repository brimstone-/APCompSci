
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesAnalyzerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SalesAnalyzerTest
{
    private SalesAnalyzer salesAna1;

    /**
     * Default constructor for test class SalesAnalyzerTest
     */
    public SalesAnalyzerTest()
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
        String[] names = {"Devin","Sree","Hannah"};
        int[] sales = {200,140, 230};
        salesAna1 = new SalesAnalyzer(names, sales);
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
    public void maxSaleAmount()
    {
        assertEquals(230, salesAna1.maxSale());
    }

    @Test
    public void minSaleAmount()
    {
        assertEquals(140, salesAna1.minSale());
    }

    @Test
    public void averageSaleAmount()
    {
        assertEquals(190.0, salesAna1.averageSale(), 0.01);
    }

    @Test
    public void totalSales()
    {
        assertEquals(570, salesAna1.totalSales());
    }

    @Test
    public void numAtOrAbove200()
    {
        assertEquals(2, salesAna1.numSalesAtOrAbove(200));
    }

    @Test
    public void report()
    {
        System.out.println("This method should return a string that matches the table below:");
        System.out.println("Salesperson   Sales\n"+
            "--------------------\n"+
            "Devin" + "\t\t" + 200+"\n"+
            "Sree" + "\t\t" + 140+"\n"+
            "Hannah" + "\t\t" + 230+"\n");

        System.out.println(salesAna1.report());
    }

    @Test
    public void maxPeople()
    {
        String[] names = {"Hannah"};
        assertArrayEquals(names, salesAna1.maxSalesPeople());
    }

    @Test
    public void peopleAbove200()
    {
        String[] names = {"Devin", "Hannah"};
        assertArrayEquals(names, salesAna1.peopleWithSalesAtOrAbove(200));
    }

    
    
}




