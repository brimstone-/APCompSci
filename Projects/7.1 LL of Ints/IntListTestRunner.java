// *************************************************************
//   IntListTest.java
//
//   Driver to test IntList methods.
// *************************************************************

import java.util.Scanner;

public class IntListTestRunner
{
    private static Scanner scan;
    private static IntList list = new IntList();

    //----------------------------------------------------------------
    // Creates a list, then repeatedly prints the menu and does what 
    // the user asks until they quit.
    //----------------------------------------------------------------
    public static void main(String[] args)
    {
        scan = new Scanner(System.in);
        printMenu();
        int choice = scan.nextInt();
        while (choice != 0)
        {
            list.clear();
            dispatch(choice);
            printMenu();
            choice = scan.nextInt();
        }
    }

    //----------------------------------------
    //  Does what the menu item calls for.
    //----------------------------------------
    public static void dispatch(int choice)
    {
        int newVal, oldVal;
        switch(choice)
        {
            case 0: 
            System.out.println("Bye!");
            break;

            case 1:    //add to front
            System.out.println("Enter integer to add to front");
            newVal = scan.nextInt();
            list.addToFront(newVal);
            break;

            case 2:   //add to end
            System.out.println("Enter integer to add to end");
            newVal = scan.nextInt();
            list.addToEnd(newVal);
            break;

            case 3:  //remove first element
            list.removeFirst();
            break;

            case 4:  //print
            //list.print();
            System.out.println(list.toString());
            break;
            
            case 5:
            System.out.println("---------------------");
            System.out.println("This list is " + list.length() + " entries long.");
            System.out.println("---------------------\n");
            break;
            
            case 6:
            list.removeLast();
            break;
            
            case 7:
            System.out.println("Enter the integer to be replaced");
            newVal = scan.nextInt();
            System.out.println("Enter a new integer to replace with");
            oldVal = scan.nextInt();
            list.replace(newVal, oldVal);
            break;
            
            default:
            System.out.println("Sorry, invalid choice");
        }
    }

    //----------------------------------------
    //  Prints the user's choices
    //----------------------------------------
    public static void printMenu()
    {
        System.out.println("\n   Menu   ");
        System.out.println("   ====");
        System.out.println("0: Quit");
        System.out.println("1: Add an integer to the front of the list");
        System.out.println("2: Add an integer to the end of the list");
        System.out.println("3: Remove an integer from the front of the list");
        System.out.println("4: Print the list");
        System.out.println("5: Get the length of the list");
        System.out.println("6: Remove an integer from the end of the list");
        System.out.println("7: Replace an integer with another");

        System.out.print("\nEnter your choice: ");
    }
}