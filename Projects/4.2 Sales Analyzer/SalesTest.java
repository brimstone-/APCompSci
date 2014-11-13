
/**
 * Write a description of class SalesTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SalesTest
{
    public static void main(String []Args)
    {
        String[] names = {"Devin","Sree","Hannah"};
        int[] sales = {200,140, 230};
        SalesAnalyzer salesAna1 = new SalesAnalyzer(names, sales);
        System.out.println("This method should return a string that matches the table below:");
        System.out.println("Salesperson   Sales\n"+
            "--------------------\n"+
            "Devin" + "\t\t" + 200+"\n"+
            "Sree" + "\t\t" + 140+"\n"+
            "Hannah" + "\t\t" + 230+"\n");

        System.out.println(salesAna1.report());
    }
}
