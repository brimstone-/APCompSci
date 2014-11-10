

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AccountTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AccountTest
{
    /**
     * Default constructor for test class AccountTest
     */
    public AccountTest()
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

    @Test
    public void testChargeFee()
    {
        Account account1 = new Account(102.30, "Katherine");
        assertEquals(92.30, account1.chargeFee(), 0.001);
    }

    @Test
    public void testGetNumAccounts()
    {
        int num = Account.getNumAccounts();
        Account account1 = new Account(110.33, "Casey");
        assertEquals(num+1, Account.getNumAccounts());
    }

    @Test
    public void testClose()
    {
        int num = Account.getNumAccounts();
        Account account1 = new Account(23.45, "Matt");
        account1.close();
        assertEquals(0.0, account1.getBalance(), 0.001);
        assertEquals(num, Account.getNumAccounts());
    }

    @Test
    public void testConsolidate()
    {
        Account account1 = new Account(112.34, "Justin");
        Account account2 = new Account(20001.12, "Justin");
        Account account3 = new Account(20113.46, "Justin");
        assertEquals(account3.getBalance(), (Account.consolidate(account1, account2)).getBalance(),0.001);
    }

    @Test
    public void testConsolidate2()
    {
        Account account1 = new Account(35.00, "Carter");
        Account account2 = new Account(123.00, "Ryan");
        assertEquals(null, Account.consolidate(account1, account2));
    }

    @Test
    public void testConsolidate3()
    {
        Account account1 = new Account(11.90, "Alvin");
        assertEquals(null, Account.consolidate(account1, account1));
    }


    @Test
    public void testGetNumDeposits()
    {
        int d = Account.getNumDeposits();
        Account account1 = new Account(12.01, "Caleb");
        account1.deposit(0.01);
        account1.deposit(12.02);
        assertEquals(d+2, Account.getNumDeposits());
    }
    
    @Test
    public void testGetAmtDeposits()
    {
        double a = Account.getAmtDeposits();
        Account account1 = new Account(12.01, "Caleb");
        account1.deposit(0.01);
        account1.deposit(12.02);
        assertEquals(a+12.03, Account.getAmtDeposits(), 0.001);
    }

    @Test
    public void testGetNumWithdrawals()
    {
        int w =Account.getNumWithdrawals();
        Account account1 = new Account(12.01, "Riley");
        account1.withdraw(0.01);
        account1.withdraw(10.00);
        assertEquals(w+2, Account.getNumWithdrawals());
    }
    
    @Test
    public void testGetAmtWithdrawals()
    {
        double w = Account.getAmtWithdrawals();
        Account account1 = new Account(12.01, "Riley");
        account1.withdraw(0.01);
        account1.withdraw(10.00);
        assertEquals(w+10.01, Account.getAmtWithdrawals(), 0.001);
    }

    @Test
    public void testTransfer()
    {
        Account account1 = new Account(123.45, "Lena");
        Account account2 = new Account(200.00, "Michael");
        account1.transfer(account2, 10.00);
        assertEquals(210., account2.getBalance(), 0.001);
        assertEquals(113.45, account1.getBalance(), 0.001);
    }
    
    @Test
    public void testStaticTransfer()
    {
        Account account1 = new Account(123.45, "Lena");
        Account account2 = new Account(200.00, "Michael");
        Account.transfer(account1,account2, 10.00);
        assertEquals(210., account2.getBalance(), 0.001);
        assertEquals(113.45, account1.getBalance(), 0.001);
    }
}










