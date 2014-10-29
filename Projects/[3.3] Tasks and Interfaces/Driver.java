
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main(String[] args)
    {
        Task t1 = new Task(1,3);
        Task t2 = new Task(2,5);

        System.out.println("The greater the value of priority or complexity, the more important or difficult the task.");
        
        System.out.println("Task one: " + t1.toString());
        System.out.println("Task two: " + t2.toString());

        t2.setPriority(3);
        System.out.println("The priority of task 2 is now " + t2.getPriority());

        t1.setComplexity(7);
        System.out.println("The complexity of task 1 is now " + t1.getComplexity());

        if (t1.compareTo(t2)>0) {
            System.out.println("Task 1 has greater priority");
        }

        else if (t1.compareTo(t2)<0) {
            System.out.print("Task 2 has greater priority");
        }

        else {
            System.out.println("The tasks have equal priority");
        }
    }
}
