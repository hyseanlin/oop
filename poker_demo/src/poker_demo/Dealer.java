package poker_demo;

public class Dealer {
	private DeckOfCards deck = new DeckOfCards(true);
	
	public void deal(Player p)
	{
		Card card = deck.get();	// Remove one card from the deck(cardList)
		p.put(card); // Deal the card to the specified player
	}
	
	public void recycle(Player p)
	{
		Card card = p.get();	// Remove one card from the player
		deck.put(card);	// Put it back to the deck
	}
	
	public void recycleAll(Player p)
	{
		while (!p.isEmpty())
		{
			Card card = p.get(); // Remove all the cards from the player
			deck.put(card);		// Put them back to the deck
		}
	}
	
	public void shuffle() {
		deck.shuffle();
	}
	
	public void displayCards() {
		deck.displayCards();
	}

	public static void main(String[] args) {
		Player p1 = new Player();
		Player p2 = new Player();
		Dealer d = new Dealer();
		System.out.println("Player 1's cards:");
		p1.displayCards();
		System.out.println("Player 2's cards:");
		p2.displayCards();
		System.out.println("Dealer's cards:");
		d.displayCards();
		
		d.deal(p1);
		d.deal(p1);
		d.deal(p2);
		System.out.println("Player 1's cards:");
		p1.displayCards();
		System.out.println("Player 2's cards:");
		p2.displayCards();
		System.out.println("Dealer's cards:");
		d.displayCards();

	}

}
