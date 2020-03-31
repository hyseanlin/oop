package poker_demo;

public class DeckOfCards {
	static int NUM_OF_CARDS = 52;
	Card[] cards = new Card[DeckOfCards.NUM_OF_CARDS];	// it stores 52 cards
	
	public DeckOfCards()
	{
		for (int i=1; i<=DeckOfCards.NUM_OF_CARDS; i++)
		{
			cards[i-1] = new Card(i);
		}
	}
	
	public void displayCards()
	{
		for (int i=0; i<DeckOfCards.NUM_OF_CARDS; i++)
		{
			Card card = cards[i];
			System.out.println(card.getPattern() + card.getNumber());
		}
	}

	public static void main(String[] args) {
		DeckOfCards myDeck = new DeckOfCards();
		myDeck.displayCards();
	}

}
