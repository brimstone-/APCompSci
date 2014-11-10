import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TaskUnitTest.
 *
 * @author  Spearman & Gammelgaard
 * @version 0.0.2
 */
public class TaskUnitTest
{
    
    /**
     * Default constructor for test class TaskUnitTest
     */
    public TaskUnitTest()
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
    
    
    
  //---------------------------------------------------------------------------------------------------------------------------------//
  // checks to see if constants were named and set correctly in the Priority interface
    @Test
    public void testPriorityMin() 
    {
        assertEquals(1, Priority.MIN_PRIORITY);
    }
    @Test
    public void testPriorityMed() 
    {
        assertEquals(5, Priority.MED_PRIORITY);
    }
    @Test
    public void testPriorityMax() 
    {
        assertEquals(10, Priority.MAX_PRIORITY);
    }
  //--------------------------------------------------------------------------------------------------------------------------------//
    
    @Test
    public void testTaskPrioritySetAndGet() 
    // checks priority setter/getter methods in task
    {
        Task task1 = new Task("Get Donuts");
        task1.setPriority(2);
        assertEquals(2, task1.getPriority());
    }
    
    @Test
    public void testTaskComplexitySetAndGet() 
    // checks complexity setter/getter methods in task
    {
        Task task1 = new Task("Do Homework");
        task1.setComplexity(4);
        assertEquals(4, task1.getComplexity());
    }
    
    @Test
    public void testTaskCompareTo()
    // checks the compareTo() method of
    {
        Task task1 = new Task("Mow lawn");
        Task task2 = new Task("Clean room");
        
        task1.setPriority(5); // note, this is the MED_PRIORITY
        task2.setPriority(10); // note, this is the MAX_PRIORITY
        assertTrue(task1.compareTo(task2)<0);
       
    }
    
    @Test
    public void testTaskCompareTo2()
    // checks the compareTo() method of
    {
        Task task1 = new Task("Mow lawn");
        Task task2 = new Task("Clean room");
        
        task1.setPriority(5); // note, this is the MED_PRIORITY
        task2.setPriority(10); // note, this is the MAX_PRIORITY
        assertTrue(task2.compareTo(task1)>0);
        
    }
    
    @Test
    public void implementsPriorityInterface() 
    // checks priority setter/getter methods in task
    {
        Task task1 = new Task("Get Donuts");
        assertTrue(task1 instanceof Priority);
    
    }
    
    @Test
    public void implementsComplexityInterface() 
    // checks priority setter/getter methods in task
    {
        Task task1 = new Task("Get Donuts");
        assertTrue(task1 instanceof Complexity);
    
    }
    
    @Test
    public void implementsComparableInterface() 
    // checks priority setter/getter methods in task
    {
        Task task1 = new Task("Get Donuts");
        assertTrue(task1 instanceof Comparable);
    
    }
}
