package poker_demo;

import java.util.LinkedList;

public class Player {
	final static int MAX_CARD_COUNT=5;
	private LinkedList<Card> cardList;

	public Player()
	{
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
	
	public void displayCards()
	{
		for (int i=0; i<cardList.size(); i++)
		{
			Card card = cardList.get(i);
			System.out.println(card.getPattern() + card.getNumber());
		}
	}	

	public static void main(String[] args) {
		Player player = new Player();
		player.put(new Card(0, 1)); // Club Ace
		player.put(new Card(1, 13)); // Diamond King
		
		System.out.println("The player's cards are listed as follows:");
		player.displayCards();
	}

}
