package poker_demo;

public class Dealer extends Person {
	private Deck deck = new Deck(true);
	
	public Dealer() {
		super();
	}

	public Dealer(String name, char gender, int age) {
		super(name, gender, age);
	}

	public void deal(Player p, int count)
	{
		for (int i=0; i<count && count <= deck.cardCount(); i++)
		{
			Card card = deck.get();	// Remove one card from the deck(cardList)
			p.put(card); // Deal the card to the specified player
		}
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
		System.out.println("Dealer " + this.name + "'s cards (" + 
							this.cardCount() + " in total):");		
		deck.displayCards();
	}

	public boolean isEmpty() {
		return deck.cardCount() == 0;
	}
	
	public int cardCount() {
		return deck.cardCount();
	}
	
	public static void main(String[] args) {
		Player p1 = new Player("Mary", 'F', 18);
		Player p2 = new Player("Sean", 'M', 45);
		Dealer d = new Dealer("Tom", 'M', 40);
		p1.displayCards();
		p2.displayCards();
		d.displayCards();
		
		d.deal(p1, 3);
		p1.displayCards();
		p2.displayCards();
		d.displayCards();

	}

}
