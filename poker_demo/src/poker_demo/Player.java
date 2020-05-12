package poker_demo;

import java.util.LinkedList;

public class Player extends Person implements DisplayCards {
	final static int MAX_CARD_COUNT=5;
	private LinkedList<Card> cardList;

	public Player()
	{
		super();
		cardList = new LinkedList<Card>();
	}
	
	public Player(String name, char gender, int age)
	{
		super(name, gender, age);
		cardList = new LinkedList<Card>();
	}

	public void put(Card card) {
		cardList.addFirst(card);
	}
	
	public Card get() {
		return cardList.removeLast();
	}
	
	public boolean isEmpty() {
		return cardList.size() == 0;
	}
	
	public int cardCount() {
		return cardList.size();
	}
	
	// Override the displayInformation of the Person class
	public void displayInformation()
	{
		System.out.println("The player's name is " + this.name + 
				", who is " + this.gender + " at age " + this.age);
	}
	// Implement the displayJCards function of the DisplayCard interface
	public void displayJCards()
	{
		
	}
	// Implement the displayCards function of the DisplayCard interface
	public void displayCards()
	{
		System.out.println("The player 's cards are listed as follows (" + this.cardCount() + " in total):");
		for (int i=0; i<cardList.size(); i++)
		{
			Card card = cardList.get(i);
			System.out.println(card.getSuit() + card.getRankStr());
		}
	}
	
	public LinkedList<Card> showHand()
	{
		return this.cardList;
	}

	public static void main(String[] args) {
		Player player = new Player("Sean", 'M', 45);
		player.put(new Card(0, 1)); // Club Ace
		player.put(new Card(1, 13)); // Diamond King
		
		player.displayCards();
	}

}
