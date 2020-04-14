package poker_demo;

import java.util.LinkedList;

public class FiveCardStudGame {
	final static int NUM_OF_PLAYERS = 5;
	Dealer dealer = new Dealer();
	Player[] players = new Player[NUM_OF_PLAYERS]; 
	
	public FiveCardStudGame() {
		for (int i=0; i<NUM_OF_PLAYERS; i++)
		{		
			players[i] = new Player();
		}
	}

	public void start() {
		dealer.shuffle();
		for (int j=0; j<Player.MAX_CARD_COUNT; j++)
		{
			for (int i=0; i<NUM_OF_PLAYERS; i++)
			{
				dealer.deal(players[i]);
			}
		}
	}
	
	public boolean isSinglePair(LinkedList<Card> cards)
	{
		boolean bResult = false;
		
		/* Write up your code */
		
		return bResult;
	}
	
	public boolean isTwoPair(LinkedList<Card> cards)
	{
		boolean bResult = false;
		
		/* Write up your code */
		
		return bResult;
	}

	public boolean isThreeOfAKind(LinkedList<Card> cards)
	{
		boolean bResult = false;
		
		/* Write up your code */
		
		return bResult;
	}

	public boolean isFullHouse(LinkedList<Card> cards)
	{
		boolean bResult = false;
		
		/* Write up your code */
		
		return bResult;
	}

	public boolean isFourOfAKind(LinkedList<Card> cards)
	{
		boolean bResult = false;
		
		/* Write up your code */
		
		return bResult;
	}

	public boolean isFlush(LinkedList<Card> cards)
	{
		boolean bResult = false;
		
		/* Write up your code */
		
		return bResult;
	}

	public boolean isStraight(LinkedList<Card> cards)
	{
		boolean bResult = false;
		
		/* Write up your code */
		
		return bResult;
	}

	public boolean isStraightFlush(LinkedList<Card> cards)
	{
		boolean bResult = false;
		
		/* Write up your code */
		
		return bResult;
	}

	public boolean isRoyalFlush(LinkedList<Card> cards)
	{
		boolean bResult = false;
		
		/* Write up your code */
		
		return bResult;
	}
	
	public void displayCards() {
		dealer.displayCards();
		System.out.println();

		for (int i=0; i<NUM_OF_PLAYERS; i++)
		{
			players[i].displayCards();
			System.out.println();
		}
	}
	
	public void showdown()
	{
		System.out.println("======================================");
		System.out.println("=== Five-card stud game shows down ===");
		System.out.println("======================================");
		for (int i=0; i<NUM_OF_PLAYERS; i++)
		{
			players[i].displayCards();
			if (this.isSinglePair(players[i].showHand()))
			{
				System.out.println("There is a single pair");
			} else if (this.isTwoPair(players[i].showHand())) {
				System.out.println("There is a two pair");
			} else if (this.isThreeOfAKind(players[i].showHand())) {
				System.out.println("There is a three of a kind");
			} else if (this.isStraight(players[i].showHand())) {
				System.out.println("There is a straight");
			} else if (this.isFlush(players[i].showHand())) {
				System.out.println("There is a flush");
			} else if (this.isFullHouse(players[i].showHand())) {
				System.out.println("There is a full house");
			} else if (this.isFourOfAKind(players[i].showHand())) {
				System.out.println("There is a four of a kind");
			} else if (this.isStraightFlush(players[i].showHand())) {
				System.out.println("There is a straight flush");
			} else if (this.isRoyalFlush(players[i].showHand())) {
				System.out.println("There is a royal flush");
			} else {
				System.out.println("There is no hands");
			}
		}
	}
	
	public static void main(String[] args) {
		FiveCardStudGame myGame = new FiveCardStudGame();
		myGame.start();
		myGame.displayCards();
		myGame.showdown();
		
	}

}
