/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card oneOfHearts = new Card("one", "Hearts", 1);
		Card aceOfSpades = new Card("ace", "Spades", 0);
		Card kingOfClubs = new Card("king", "Clubs", 13);

		System.out.println("Is the the King of Clubs equal to the Ace of Spades?");
		System.out.println(kingOfClubs.matches(aceOfSpades));

		System.out.println("Suit of One of Hearts: " + oneOfHearts.suit());
		System.out.println("Rank of Ace of Spades: " + aceOfSpades.rank());
		System.out.println("Value of kingOfClubs: " + kingOfClubs.pointValue());
	}
}
