/**
 * 1.5 BaseballStats
 *
 * @author Matthew Cheng
 * @version  9/6
 */

// ****************************************************************
//   BaseballStats.java
//
//   Reads baseball data in from a comma delimited file. Each line
//   of the file contains a name followed by a list of symbols
//   indicating the result of each at bat: h for hit, o for out,
//   w for walk, s for sacrifice.  Statistics are computed and
//   printed for each player.
// ****************************************************************

import java.util.Scanner;
import java.io.*;
public class BaseballStats {

    //-------------------------------------------------
    //  Reads baseball stats from a file and counts
    //  total hits, outs, walks, and sacrifice flies
    //  for each player.
    //-------------------------------------------------

    public static void main (String[] args) throws IOException {

        Scanner fileScan, lineScan, scan;
        String fileName, firstName, lastName;
        int hits = 0, outs = 0, walks = 0, sacrifices = 0;

        scan = new Scanner(System.in);
        System.out.print ("Enter the name of the input file: ");
        fileName = scan.nextLine();
        fileScan = new Scanner (new File(fileName));

        while (fileScan.hasNext()) {

            //firstName = fileScan.next();
            //fileScan.useDelimiter(",");
            //lastName = fileScan.next();
            //System.out.print(firstName + " " + lastName);

            hits = 0;
            outs = 0;
            walks = 0;
            sacrifices = 0;

            while (fileScan.hasNext()) {
                firstName = fileScan.next();
                fileScan.useDelimiter(",");
                lastName = fileScan.next();
                String stat;
                fileScan.useDelimiter(" ");
                stat = fileScan.nextLine();
                System.out.println(stat);
                int length = stat.length();
                String s = "";

                for (int i = 0; i < length; i++) {

                    Integer value = Integer.valueOf(stat.charAt(i));

                    if (i > 64 && i < 91 || i > 96 && i < 123) {
                        s += stat.charAt(i);
                    }
                }

                length = stat.length();
                for (int i = 0; i < length; i++) {
                    Integer value = Integer.valueOf(stat.charAt(i));
                    if (i == 104) {
                        hits++;
                    } else if (i == 111) {
                        outs++;
                    } else if (i == 119) {
                        walks++;
                    } else {
                        sacrifices++;
                    }
                }

                System.out.println();
                System.out.print("  " + " hits: " + hits + " outs: " + outs + " walks: " + walks + " sacrifices: " + sacrifices);
                fileScan.useDelimiter(",");
            }


        }
    }
}
