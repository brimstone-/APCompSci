import java.util.Scanner;

public class TransferTest
{
    public static void main(String[] args)
    {
        Account acct1 = new Account(1000, "Sue");
        Account acct2 = new Account(1000, "Joe");

        boolean keepGoing = true;

        Scanner scan = new Scanner(System.in);

        while (keepGoing)
        {
            System.out.print("Which account are you transferring from? (accounts 1 or 2, enter 3 to quit)");
            int origin = scan.nextInt();
            
            double amount = 0;

            if (origin == 1)
            {
                System.out.print("How much?");
                amount = scan.nextDouble();
                acct1.transfer(acct2,amount);
                System.out.println(acct1.toString());
                System.out.println(acct2.toString());
            }
            else if (origin == 2)
            {
                System.out.print("How much?");
                amount = scan.nextDouble();
                acct2.transfer(acct1,amount);
                System.out.println(acct1.toString());
                System.out.println(acct2.toString());
            }
            else
            {
                keepGoing = false;
            }
        }
    }
}
