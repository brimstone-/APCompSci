// ******************************************************************
//   Fib.java
//
//   A utility class that provide methods to compute elements of the
//   Fibonacci sequence.
// ******************************************************************
import java.util.*;
public class Fib
{
    //--------------------------------------------------------------
    // Recursively computes fib(n)
    //--------------------------------------------------------------
    public static int fib1(int n)
    {
        if (n <= 0) 
            return 0;
        else if (n == 1)
            return 1;
        else 
            return fib1(n - 1) + fib1(n - 2);
    }
    public static int fib2(int n)
    {
        ArrayList<Integer> fib = new ArrayList<Integer>();
        fib.add(0);
        fib.add(1);
        for (int ind = 2; ind <= n; ind++)
        {
            int num = fib.get(ind-1) + fib.get(ind-2);
            fib.add(num);
        }
        return fib.get(n);
    }
}
