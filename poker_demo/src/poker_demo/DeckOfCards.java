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
	
	public void shuffle() 
	{
		int N = DeckOfCards.NUM_OF_CARDS;	// shuffle times
		int i, j;	// correspond to two chosen cards to be exchanged
		for (int k=1; k<=N; k++)
		{
			i = (int)(Math.random() * 51);
			j = (int)(Math.random() * 51);
			if (i!=j)
			{
				// swap two cards
				Card temp = cards[i];
				cards[i] = cards[j];
				cards[j] = temp;
				
			} else	{
				// skipped the swapping to next run
				continue;
			}
		}

	}
	
	public static void main(String[] args) {
		DeckOfCards myDeck = new DeckOfCards();
		System.out.println("Befre shuffling, the deck of cards is as follows:");
		myDeck.displayCards();
		// Invoke/call the method shuffle()
		myDeck.shuffle();
		System.out.println("After shuffling, the deck of cards is as follows:");
		myDeck.displayCards();
	}

}
