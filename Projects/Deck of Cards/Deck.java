import java.util.*;

public class Deck {
	private int cardCount;
	private ArrayList<Card> deck;
	private Iterator<Card> iter;

	/**
	 * Constructor for objects of class Deck
	 */
	public Deck(String[] ranks, String[] suits, int[] values) {
		deck = new ArrayList<Card>();
		cardCount = 0;
		for (String s : suits) {
			int i = 0;
			for (String r : ranks) {
				deck.add(new Card(r, s, values[i]));
				cardCount++;
				i++;
			}
		}
		shuffle();
	}

	public void shuffle() {

	}

	public int size() {
		return cardCount;
	}

	public Card deal() {
		cardCount--;
		return deck.get(cardCount);
	}

	public boolean isEmpty() {
		return (deck.size() == 0);
	}

	public void printDeck() {
		iter = deck.iterator();
		int ctr = 0;
		while (iter.hasNext()) {
			System.out.println(iter.next());
			ctr++;
		}
		System.out.println("Number of cards: " + ctr);
	}
}
