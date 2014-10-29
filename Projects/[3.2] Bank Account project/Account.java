//*******************************************************
// Account.java
//
// A bank account class with methods to deposit to, withdraw from,
// change the name on, charge a fee to, and print a summary of the account.
//*******************************************************

public class Account
{
    private double balance;
    private String name;
    private long acctNum;

    private static int numAccounts;

    private static int depositCount;
    private static int withdrawalCount;
    private static double depositTotal;
    private static double withdrawalTotal;

    public Account(double initBal, String owner)
    {
        balance = initBal;
        name = owner;
        acctNum = (int) (Math.random() * Integer.MAX_VALUE);
        numAccounts++;
    }

    //----------------------------------------------
    //Constructor -- initializes balance, owner, and account number
    //----------------------------------------------
    public Account(double initBal, String owner, long number)
    {
        balance = initBal;
        name = owner;
        acctNum = number;
        numAccounts++;
    }

    //----------------------------------------------
    // Checks to see if balance is sufficient for withdrawal.
    // If so, decrements balance by amount; if not, prints message.
    //----------------------------------------------
    public void withdraw(double amount)
    {
        if (balance >= amount){
            balance -= amount;
            withdrawalCount++;
            withdrawalTotal += amount;
        }
        else
            System.out.println("Insufficient funds");
    }

    //----------------------------------------------
    // Adds deposit amount to balance.
    //----------------------------------------------
    public void deposit(double amount)
    {
        balance += amount;
        depositCount++;
        depositTotal += amount;
    }

    //----------------------------------------------
    // Returns balance.
    //----------------------------------------------
    public double getBalance()
    {
        return balance;
    }

    //----------------------------------------------
    // Returns a string containing the name, account number, and balance.
    //----------------------------------------------
    public String toString()
    {
        return "Name: " + name + "\nAcct #: " + acctNum + "\nBalance: " + balance;
    }

    public long getAcctNumber()
    {
        return acctNum;
    }
    
    //----------------------------------------------
    // Deducts $10 service fee
    //----------------------------------------------
    public double chargeFee()
    {
        return balance -= 10;
    }
    //----------------------------------------------
    // Changes the name on the account 
    //----------------------------------------------
    public void changeName(String newName)
    {
        name = newName;
    }

    public static int getNumAccounts()
    {
        return numAccounts;
    }

    public static int getNumDeposits()
    {
        return depositCount;
    }

    public static int getNumWithdrawals()
    {
        return withdrawalCount;
    }

    public static double getAmtDeposits()
    {
        return depositTotal;
    }

    public static double getAmtWithdrawals()
    {
        return withdrawalTotal;
    }

    public void close()
    {
        name += " [CLOSED]";
        balance = 0;
        numAccounts--;
    }

    public static Account consolidate(Account acct1, Account acct2)
    {
        if (acct1.name.equals(acct2.name) && acct1.acctNum != acct2.acctNum){
            Account newAcc = new Account(acct1.balance + acct2.balance, acct1.name);
            acct1.close();
            acct2.close();
            return newAcc;
        }
        else {
            System.out.println("You can't consolidate " + acct1.name + " and " + acct2.name +", either they have different names, or have the same account number, or both!");
            return null;
        }
    }
    
    public static void reset()
    {
        depositCount = 0;
        withdrawalCount = 0;
        depositTotal = 0;
        withdrawalTotal = 0;
    }
    
    public void transfer(Account acct, double amount) //transfer frunds from acct1 --> acct2
    {
        if (this.balance >= amount)
        {
            this.withdraw(amount);
            acct.deposit(amount);
        }
    }
    
    public static void transfer(Account acct1, Account acct2, double amount)
    {
        if (acct1.balance >= amount)
        {
            acct1.withdraw(amount);
            acct2.deposit(amount);
        }
    }
}