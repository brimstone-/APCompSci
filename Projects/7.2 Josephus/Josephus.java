import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;

public class Josephus
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the number of men: ");
        int count = scan.nextInt();
        
        LinkedList<Integer> nerds = new LinkedList<Integer>();
        
        for (int ind = 1; ind <= count; ind++){
            nerds.add(ind);
        }
        while (nerds.size() > 1){
            System.out.println(nerds);
            nerds.remove(1);
            Collections.rotate(nerds, -1);
        }
        System.out.println(nerds);
    }
}