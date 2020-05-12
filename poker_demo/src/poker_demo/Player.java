package poker_demo;

import java.awt.FlowLayout;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;

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
		// Create a JFrame window
		String windowTitle = "The player " + this.name + 
				"'s cards (" + this.cardCount() + " in total):";
		JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setTitle(windowTitle);
        // Size of the JFrame
        int frameWidth=0;
        int frameHeight=0;
		// Create the JCard cards from the linked list of the Card objects
		try {
			for (int i=0; i<this.cardList.size(); i++)
			{
				Card card = cardList.get(i);
				JCard jcard = new JCard(card);
				frameWidth += jcard.getCardImageWidth();
				frameHeight = jcard.getCardImageHeight();
				frame.add(jcard.getJLabel());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

        frame.setSize(frameWidth + 50, frameHeight + 50);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    	
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
		player.put(new Card(1, 12)); // Diamond Queen
		player.put(new Card(1, 11)); // Diamond Jazz
		player.put(new Card(1, 10)); // Diamond 10
		
		player.displayCards();
		player.displayJCards();
	}

}
