package poker_demo;

import java.util.LinkedList;

public class Deck {
	static int NUM_OF_CARDS = 52;

	private LinkedList<Card> cardList;
	
	public Deck() {
		cardList = new LinkedList<Card>();
		for (int i=1; i<=NUM_OF_CARDS; i++)
		{
			this.put(new Card(i));
		}
	}

	public Deck(boolean is_shuffle)
	{
		cardList = new LinkedList<Card>();
		for (int i=0; i<NUM_OF_CARDS; i++)
		{
			this.put(new Card(i+1));
		}
		if (is_shuffle)
			this.shuffle();
	}
	
	public void put(Card card) {
		cardList.addFirst(card);
	}
	
	public Card get() {
		return cardList.removeLast();
	}
	
	public int cardCount() {
		return cardList.size();
	}

	public void displayCards()
	{
		for (int i=0; i<cardList.size(); i++)
		{
			Card card = cardList.get(i);
			System.out.println(card.getSuit() + card.getRank());
		}
	}
	
	public void shuffle() 
	{
		int N = Deck.NUM_OF_CARDS;	// shuffle times
		int i, j;	// correspond to two chosen cards to be exchanged
		for (int k=1; k<=N; k++)
		{
			i = (int)(Math.random() * 51);
			j = (int)(Math.random() * 51);
			if (i!=j)
			{
				// swap two cards in the card list
				Card temp = cardList.get(i);
				cardList.set(i, cardList.get(j));
				cardList.set(j, temp);
				
			} else	{
				// skipped the swapping to next run
				continue;
			}
		}

	}
	
	public static void main(String[] args) {
		Deck myDeck = new Deck();
		System.out.println("Befre shuffling, the deck of cards is as follows:");
		myDeck.displayCards();
		// Invoke/call the method shuffle()
		myDeck.shuffle();
		System.out.println("After shuffling, the deck of cards is as follows:");
		myDeck.displayCards();
	}

}
