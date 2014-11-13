import java.util.Scanner;

public class gradeQuiz
{
    public static void main()
    {
        int right = 0, numQuestions, ans;
        int key[];
        String keepGoing = "y";
        Scanner sc = new Scanner(System.in);
        Scanner asdf = new Scanner(System.in);
        while (keepGoing.equals("y"))
        {
            System.out.print("Number of questions on quiz: ");
            numQuestions = sc.nextInt();
            key = new int[numQuestions];
            System.out.println("Please enter the key:");
            for (int i = 0; i < key.length; i++)
            {
                key[i] = sc.nextInt();
            }
            System.out.println("Please enter the answers to be graded:");
            for (int i = 0; i < key.length; i++)
            {
                ans = sc.nextInt();
                if (ans == key[i]){
                    right++;
                }
            }
            System.out.println(right + " correct.");
            System.out.println(100 * ((double)right/(numQuestions)) + "%");
            
            System.out.println("Grade another quiz? (y/n)");
            keepGoing = asdf.nextLine();
        }
    }
}
