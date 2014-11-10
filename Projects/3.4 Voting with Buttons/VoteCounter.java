//*********************************************************
// VoteCounter.java
//
// Demonstrates a graphical user interface and event listeners to
// tally votes for two candidates, Joe and Sue.
// Modified by Robert Gammelgaard 10/25/2012
//*********************************************************

public class VoteCounter
{
    //----------------------------------------------
    // Creates the displays the vote counter GUI.
    //----------------------------------------------
    public static void main(String[] args)
    {
        VoteCounterGUI counter = new VoteCounterGUI();
        counter.display();
    }
}