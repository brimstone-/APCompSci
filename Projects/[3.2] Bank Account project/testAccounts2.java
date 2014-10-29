import java.util.Scanner;
public class testAccounts2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter three names for account creation.\n");
        System.out.print("First Name: ");
        String name1 = sc.next();
        System.out.print("Second Name: ");
        String name2 = sc.next();
        System.out.print("Third Name: ");
        String name3 = sc.next();
        
        Account acct1 = new Account(100, name1);
        Account acct2 = new Account(100, name2);
        Account acct3 = new Account(100, name3);
        
        System.out.println("\n" + acct1.toString());
        System.out.println("\n" + acct2.toString());
        System.out.println("\n" + acct3.toString());
        
        acct1.close();
        
        System.out.println("\n" + name1 + "'s account has been closed.\n");
        
        Account acct4 = Account.consolidate(acct2, acct3);
        
        System.out.println("\n" + acct1.toString());
        System.out.println("\n" + acct2.toString());
        System.out.println("\n" + acct3.toString());
        
        if (acct4 != null)
            System.out.println("\n" + acct4.toString());
    }
}
