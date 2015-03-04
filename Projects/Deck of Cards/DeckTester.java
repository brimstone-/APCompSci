/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = new String[] {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
		String[] suits = new String[] {"Hearts", "Spades", "Diamonds", "Clubs"};
		int[] values = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

		Deck deck = new Deck(ranks, suits, values);

		deck.printDeck();
		System.out.println();
		System.out.println("Deal 5 cards.");

		for (int ind = 0; ind < 5; ind++) {
			System.out.println(deck.deal());
		}

		System.out.println("Cards left: " + deck.size());
	}
}
