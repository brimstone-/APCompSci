/**
 * 1.1 ConvertToSeconds
 *
 * @author Matthew Cheng
 * @version  8/28
 */

import java.util.Scanner;

public class ConvertToSeconds {
    public static void main (String [] args) {
        int hours, minutes, seconds, totalMinutes, totalSeconds;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the number of hours:");
        hours = sc.nextInt();
        System.out.print("Please enter the number of minutes:");
        minutes = sc.nextInt();
        System.out.print("Please enter the number of seconds:");
        seconds = sc.nextInt();

        totalMinutes = hours * 60 + minutes;
        totalSeconds = totalMinutes * 60 + seconds;

        System.out.print("The total number of seconds = " + totalSeconds);
    }
}
