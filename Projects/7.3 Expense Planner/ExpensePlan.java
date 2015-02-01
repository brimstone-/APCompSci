import java.util.*;

public class ExpensePlan
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        LinkedList<Item> wishes = new LinkedList<Item>();

        System.out.print("Please enter the amount to be saved: ");
        int iterator = scan.nextInt();

        String input = "";
        String currentMonth = "";
        int month = 1;
        int cost = 0;
        int balance = 0;
        int keepGoing = 0;

        while (keepGoing == 0){
            printMenu();
            input = scan.next();

            if (input.equals("N") || input.equals("n")){
                balance += iterator;
                while (wishes.peek() != null && wishes.peek().getCost() < balance){
                    Item temp = wishes.getFirst();
                    while (temp != null && temp.getCost() < balance){
                        balance -= temp.getCost();
                        System.out.println();
                        System.out.println(temp.getDescription() + " has been purchased for $" + temp.getCost());
                        wishes.remove();
                        if (wishes.peek() != null) temp = wishes.getFirst();
                        else temp = null;
                    }
                }
                month++;
                if (month > 12) month = 1;
                currentMonth = returnMonth(month);
                System.out.println();
                System.out.println("The month is now: " + currentMonth);
                System.out.println("Current balance is: $" + balance);
            }
            else if (input.equals("Q") || input.equals("q")){
                System.out.println();
                System.out.print("Bye.");
                keepGoing++;
            }
            else {
                System.out.println();
                System.out.print("What is the cost of this item? (Round to nearest dollar) ");
                cost = scan.nextInt();
                wishes.add(new Item(input, cost));
            }
        }
    }

    public static void printMenu()
    {  
        System.out.println();
        System.out.println("Please specify an item for the wishlist, ");
        System.out.println("or enter N to proceed to the next month, or enter Q to quit.");
    }

    public static String returnMonth(int num)
    {
        if      (num == 1)  return "Janurary";
        else if (num == 2)  return "February";
        else if (num == 3)  return "March";
        else if (num == 4)  return "April";
        else if (num == 5)  return "May";
        else if (num == 6)  return "June";
        else if (num == 7)  return "July";
        else if (num == 8)  return "August";
        else if (num == 9)  return "September";
        else if (num == 10) return "October";
        else if (num == 11) return "November";
        else                return "December";
    }
}