
/**
 * This class can be used to analyze the sales of a group of sales people.
 * You will be completing the methods to find the total sales, average sale, 
 * min and max sale and a report that returns a table with each salesperson?s 
 * name and amount of sales.  The more challenging part of this project is 
 * to write the methods that return an array of names that meet certain criteria.
 * These methods include people with sales greater than or equal to a given 
 * amount as well as people that have the maximum sales amounts.
 * 
 * @author Robert Gammelgaard 
 * @version 20131104
 */
public class SalesAnalyzer
{

    private int[] sales;
    private String[] names;

    /**
     * Constructor for objects of class SalesForce.
     * @param names is the names of the salespeople.
     * @param sales is the amount of sales for each sales person.
     * Precondition: names and sales must have same length and not null.
     */
    public SalesAnalyzer(String[] names,int[]sales)
    {
        this.names = names;
        this.sales = sales;
    }

    /**
     * @return  the total sales of all sales people
     */
    public int totalSales()
    {
        int total = 0;
        for (int i = 0; i < sales.length; i++)
        {
            total += sales[i];
        }
        return total;
    }
    
    /**
     * @return  the average sales of all sales people
     */
    public double averageSale()
    {
        double total = 0;
        for (int i = 0; i < sales.length; i++)
        {
            total += sales[i];
        }
        return total / sales.length;
    }    

    /**
     * @return  the maximum sales amount of all sales people
     */
    public int maxSale()
    {        
        int max = 0;
        for (int i = 1; i < sales.length; i++)
        {
            if (sales[i]>sales[i-1])
            {
                max = i;
            }
        }
        return sales[max];
    }
    
    /**
     * @return  the minimum sales amount of all sales people
     */
    public int minSale()
    {           
        int min = 0;
        for (int i = 1; i < sales.length; i++)
        {
            if (sales[i]<sales[i-1])
            {
                min = i;
            }
        }
        return sales[min];
    }
    
    /**
     * @param n is the minimum sales amount to be counted   
     * @return  the number of sales amounts that are greater or equal to n.
     */
    public int numSalesAtOrAbove(int n)
    {
        int ctr=0;
        for (int i = 0; i < sales.length; i++)
        {
            if (sales[i]>=n)
            {
                ctr++;
            }
        }
        return ctr;
    }
    
    /** 
     * @return  an array of the names of the people with maximum sales.
     */
    public String[] maxSalesPeople()
    {   
        int a = this.numSalesAtOrAbove(this.maxSale());
        String returnNames[] = new String[a];
        int b = 0;
        for (int i = 0; i < sales.length; i++)
        {
            if (sales[i]>=this.maxSale())
            {
                returnNames[b] = names[i];
                b++;
            }
        }
        return returnNames;
    }
    
    /**
     * @param n is the minimum sales amount for sales person to be included   
     * @return an array of strings of the names of salespeople that have sales
     *  that are greater than or equal to n.
     */
    public String[] peopleWithSalesAtOrAbove(int n)
    {       
        int a = this.numSalesAtOrAbove(n);
        String returnNames[] = new String[a];
        int b = 0;
        for (int i = 0; i < sales.length; i++)
        {
            if (sales[i]>=n)
            {
                returnNames[b] = names[i];
                b++;
            }
        }
        return returnNames; 
    }

    /**
     * @return a string that, when printed, creates a table of salespeople and sales amounts.
     */
    public String report()
    {

        String s= "Salesperson   Sales\n"+
            "--------------------\n";
        /*add a loop here to add in the names and sales*/
        for (int i = 0; i < sales.length; i++)
        {
            s += names[i] + "           " + sales[i] + "\n";
        }
        return s;
    }
}
