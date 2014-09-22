public class RunsExpected
{
    public static void main (String[] args)
    {
        final int FLIPS = 100; // number of coin flips

        int currentRun = 0; // length of the current run of HEADS
        int maxRun = 0;     // length of the maximum run so far
        int totalMax = 0;
        Coin c = new Coin();
        for (int ind = 0; ind < 100000; ind++){
            // Flip the coin FLIPS times
            maxRun = 0;
            for (int i = 0; i < FLIPS; i++)
            {
                // Flip the coin & print the result
                c.flip();
                //System.out.println(c.toString());
                if (c.isHeads()) {
                    currentRun++;
                }
                else {
                    currentRun = 0;
                }
                // Update the run information
                if (maxRun < currentRun) {
                    maxRun = currentRun;
                }
            }
            // Print the results
            //System.out.println("The longest consecutive run of heads in 100 flips was: " + maxRun);
            totalMax += maxRun;
        }
        System.out.println("Expected length of longest run: " + totalMax / 100000.0);
    }
}
