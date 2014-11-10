//*******************************************************
// ProcessTransactions.java
//
// A class to process deposits and withdrawals for two bank
// accounts for a single day.
//*******************************************************
import java.util.Scanner;

public class ProcessTransactions
{
    public static void main(String[] args)
    {
        Account acct1, acct2;           //two test accounts

        Scanner scan = new Scanner(System.in);
        //Create two accounts
        acct1 = new Account(1000, "Sue");
        acct2 = new Account(1000, "Joe");

        System.out.print("Number of days?");
        int ctr = 0;
        int days = scan.nextInt();

        while (ctr < days)
        {

            String keepGoing = "y";         //more transactions?
            String action;                  //deposit or withdraw
            double amount;                  //how much to deposit or withdraw
            long acctNumber;                //which account to access

            System.out.println("\n\nThe following accounts are available:\n");
            System.out.println(acct1);
            System.out.println();
            System.out.println(acct2);

            while (keepGoing.equals("y") || keepGoing.equals("Y"))
            {
                //get account number, what to do, and amount
                System.out.print("\nEnter the number of the account you would like to access: ");
                acctNumber = scan.nextLong();
                System.out.print("Would you like to make a deposit (D) or withdrawal (W)? ");
                action = scan.next();
                System.out.print("Enter the amount: ");
                amount = scan.nextDouble();

                if (amount > 0)
                    if (acctNumber == acct1.getAcctNumber())
                        if (action.equals("w") || action.equals("W"))
                            acct1.withdraw(amount);
                        else if (action.equals("d") || action.equals("D"))
                            acct1.deposit(amount);
                        else 
                            System.out.println("Sorry, invalid action.");
                        else if (acctNumber == acct2.getAcctNumber())
                            if (action.equals("w") || action.equals("W"))
                                acct2.withdraw(amount);
                            else if (action.equals("d") || action.equals("D"))
                                acct2.deposit(amount);
                            else 
                                System.out.println("Sorry, invalid action.");
                            else
                                System.out.println("Sorry, invalid account number.");
                            else
                                System.out.println("Sorry, amount must be > 0.");

                System.out.print("\nMore transactions? (y/n)");
                keepGoing = scan.next();
            }

            //Print number of deposits
            System.out.println("\nDeposit count: " + acct1.getNumDeposits());
            //Print number of withdrawals
            System.out.println("Withdrawals count: " + acct1.getNumWithdrawals());
            //Print total amount of deposits
            System.out.println("Deposit amount: " + acct1.getAmtDeposits());
            //Print total amount of withdrawals
            System.out.println("Withdrawals amount: " + acct1.getAmtWithdrawals());

            Account.reset();
            
            ctr++;
        }
    }
}