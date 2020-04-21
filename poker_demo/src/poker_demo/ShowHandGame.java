package poker_demo;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Comparator;

public class ShowHandGame {
	final static int NUM_OF_PLAYERS = 5;
	Dealer dealer = new Dealer();
	Player[] players = new Player[NUM_OF_PLAYERS]; 
	
	public ShowHandGame() {
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
	
	private int rankRepetitionCount(LinkedList<Card> cards, int count)
	{
		// Construct a rank histogram
		int[] rankHist = new int[13];
		Arrays.fill(rankHist, 0);
		/* Iterate through the linked-list cards and
		 * accumulate the rank histogram rankHist 
		 */
		for (int i=0; i<cards.size(); i++)
			rankHist[cards.get(i).getRank()-1]++;
		/* Iterate through randHist and check if there 
		 * is a pair or not
		 */
		int repetition_count=0;
		for (int i=0; i<rankHist.length; i++)
			if (rankHist[i]==count)
				repetition_count++;
		return repetition_count;
	}
	// Sort the card list in descending order of rank
	private void sortCardList(LinkedList<Card> cards)
	{
		cards.sort(new Comparator<Card>()
		{
		     @Override
		     public int compare(Card o1, Card o2)
		     {
		    	 if (o1.getRank() < o2.getRank())
		    		 return 1;
		    	 else 
		    		 return -1;
		     }
		 });
	}
	
	public boolean isSinglePair(LinkedList<Card> cards)
	{
		return (rankRepetitionCount(cards, 2)==1);
	}
	
	public boolean isTwoPair(LinkedList<Card> cards)
	{
		return (rankRepetitionCount(cards, 2)==2);
	}

	public boolean isThreeOfAKind(LinkedList<Card> cards)
	{
		return (rankRepetitionCount(cards, 3)==1);
	}

	public boolean isFullHouse(LinkedList<Card> cards)
	{
		return (isThreeOfAKind(cards) && isSinglePair(cards));
	}

	public boolean isFourOfAKind(LinkedList<Card> cards)
	{
		return (rankRepetitionCount(cards, 4)==1);

	}

	public boolean isFlush(LinkedList<Card> cards)
	{
		// Construct a suit histogram
		int[] suitHist = new int[13];
		Arrays.fill(suitHist, 0);
		/* Iterate through the linked-list cards and
		 * accumulate the rank histogram suitHist 
		 */
		for (int i=0; i<cards.size(); i++)
			suitHist[cards.get(i).getSuitID()]++;
		/* Iterate through suitHist and check if there 
		 * is a flush or not
		 */			
		for (int i=0; i<suitHist.length; i++)
			if (suitHist[i]==cards.size())
				return true;
		return false;
	}

	public boolean isStraight(LinkedList<Card> cards)
	{
		// Construct a difference histogram
		int[] diffHist = new int[13];
		Arrays.fill(diffHist, 0);
		// Sort the card list in descending order of rank
		this.sortCardList(cards);
		// Calculate the difference between neighboring cards in the list
		for (int i=0; i<cards.size()-1; i++)
		{
			int diff = Math.abs(cards.get(i).getRank() - cards.get(i+1).getRank());
			diffHist[diff]++;
		}
		// if diffHist[1] is equal to 4, these must be a straight
		if (diffHist[1]==4)
		{
			return true;
		} else if (diffHist[1]==3 && 
				cards.getFirst().getRank()==13 && 
				cards.getLast().getRank()==1) {
			return true;
		} else {
			return false;
		}
	}
	

	public boolean isStraightFlush(LinkedList<Card> cards)
	{		
		return isStraight(cards) && this.isFlush(cards);
	}

	public boolean isRoyalFlush(LinkedList<Card> cards)
	{			
		boolean hasK = false;
		for (int i=0; i<cards.size(); i++)
		{
			if (cards.get(i).getRank() == 13)
			{
				hasK = true;
				break;
			}
		}
		return this.isStraightFlush(cards) && hasK;
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
			if (this.isFullHouse(players[i].showHand())) {
				System.out.println("There is a full house");
			} else if (this.isSinglePair(players[i].showHand()))
			{
				System.out.println("There is a pair");
			} else if (this.isTwoPair(players[i].showHand()))
			{
				System.out.println("There is a two pair");
			} else if (this.isThreeOfAKind(players[i].showHand()))
			{
				System.out.println("There is a three of a kind");
			} else if (this.isFourOfAKind(players[i].showHand()))
			{
				System.out.println("There is a four of a kind");
			} else if (this.isRoyalFlush(players[i].showHand()))
			{
				System.out.println("There is a royal flush");
			} else if (this.isStraightFlush(players[i].showHand()))
			{
				System.out.println("There is a straight flush");
			} else if (this.isStraight(players[i].showHand())) 
			{
				System.out.println("There is a straight");
			} else if (this.isFlush(players[i].showHand()))
			{
				System.out.println("There is a flush");

			} else
			{
				System.out.println("There is no hands");
			}
		}
	}
	
	public static void main(String[] args) {
		ShowHandGame myGame = new ShowHandGame();
		myGame.start();
		myGame.displayCards();
		myGame.showdown();
		
		LinkedList<Card> cards;
		cards = new LinkedList<Card>();
		// The following code is designed for check if isFlush() works or not
		cards.addFirst(new Card(0, 2));
		cards.addFirst(new Card(2, 2));
		cards.addFirst(new Card(1, 2));
		cards.addFirst(new Card(3, 2));
		cards.addFirst(new Card(0, 9));

		if (myGame.isTwoPair(cards))
			System.out.println("Yes, it's a two pair.");
		if (myGame.isSinglePair(cards))
			System.out.println("Yes, it's a single pair.");
		if (myGame.isThreeOfAKind(cards))
			System.out.println("Yes, it's a three of a kind.");
		if (myGame.isFourOfAKind(cards))
			System.out.println("Yes, it's a four of a kind.");		
		if (myGame.isFullHouse(cards))
			System.out.println("Yes, it's a full house.");
		if (myGame.isStraight(cards))
			System.out.println("Yes, it's a straight.");
		if (myGame.isRoyalFlush(cards))
			System.out.println("Yes, it's a royal flush.");
		if (myGame.isFlush(cards))
			System.out.println("Yes, it's a flush.");
		
	}

}
