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

            hits = 0;
            outs = 0;
            walks = 0;
            sacrifices = 0;

            fileScan.useDelimiter(" ");
            firstName = fileScan.next();
            fileScan.useDelimiter(",");
            lastName = fileScan.next();

            System.out.print(firstName + " " + lastName);

            String stat, s = "";
            fileScan.useDelimiter(" ");

            stat = fileScan.nextLine();

            //System.out.println();
            //System.out.print("   raw:" + stat);

            int length = stat.length();

            for (int i = length - 1; i >= 0; i--) {
                if (stat.charAt(i) != ',') {
                    s += stat.charAt(i);
                }

                int m = stat.charAt(i);

                if (m == 104) {
                    hits++;
                } else if (m == 111) {
                    outs++;
                } else if (m == 119) {
                    walks++;
                } else if (m == 115) {
                    sacrifices++;
                }
            }

            System.out.println();
            //System.out.println("   processed: " + s);
            System.out.println("\thits: " + hits + " outs: " + outs + " walks: " + walks + " sacrifices: " + sacrifices);
            fileScan.useDelimiter(",");
        }

    }
}
