/**
 * @author Matthew Cheng
 * @date 8/28
 */
import java.util.Scanner;

public class ConvertFromSeconds {
    public static void main (String [] args) {
        int hours, minutes, seconds, totalMinutes, totalSeconds, remainder;

        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the number of seconds:");
        seconds = sc.nextInt();
        remainder = seconds % 60;
        minutes = (seconds - remainder) / 60;
        seconds = remainder;
        remainder = minutes % 60;
        hours = (minutes - remainder) / 60;
        minutes = minutes - hours * 60;

        System.out.println("The number of hours is:" + hours);
        System.out.println("The number of minutes is:" + minutes);
        System.out.println("The number of seconds is:" + seconds);
    }
}