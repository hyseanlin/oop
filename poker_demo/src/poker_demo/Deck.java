package poker_demo;

import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Deck implements DisplayCards {
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

	// Implement the displayJCards function of the DisplayCard interface
	public void displayJCards()
	{
		// Create a JFrame window
		String windowTitle = "The deck of cards";
		JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setTitle(windowTitle);
        // Size of the JFrame
        int frameWidth=0, frameHeight=0;
        String deckFilename = "img/card_deck.jpg";	
        try {
	    	/* Step 2: Load the image from the file
			 * according to the cardFilename */
	     	// create a File object
	    	File deckFile = new File(deckFilename);	
	    	// read image data from the file object
	    	BufferedImage deckImage = ImageIO.read(deckFile);
	        frameWidth = deckImage.getWidth();
	        frameHeight = deckImage.getHeight(); 
	        // Create an ImageIcon from the buffer image
	        ImageIcon icon=new ImageIcon(deckImage);
	        // Create a JLabel
	        JLabel deckLabel=new JLabel();
	        deckLabel.setIcon(icon);
	        // Add the JLabel into JFrame
	        frame.add(deckLabel);
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
		for (int i=0; i<cardList.size(); i++)
		{
			Card card = cardList.get(i);
			System.out.println(card.getSuit() + card.getRankStr());
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
		
		myDeck.displayJCards();
	}

}
