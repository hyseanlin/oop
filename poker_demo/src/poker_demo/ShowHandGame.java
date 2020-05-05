package poker_demo;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.Comparator;

public class ShowHandGame implements DisplayCards {
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
				dealer.deal(players[i], 1);
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
		int[] suitHist = new int[4];
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
		} else if (hasRank(cards, 13) &&
				hasRank(cards, 12) &&
				hasRank(cards, 11) &&
				hasRank(cards, 10) &&
				hasRank(cards, 1)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isStraightFlush(LinkedList<Card> cards)
	{		
		return this.isStraight(cards) && this.isFlush(cards);
	}

	public boolean hasRank(LinkedList<Card> cards, int rank)
	{
		for (int i=0; i<cards.size(); i++)
		{
			if (cards.get(i).getRank() == rank)
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isRoyalFlush(LinkedList<Card> cards)
	{			
		return this.isStraightFlush(cards) &&
				this.hasRank(cards, 13) &&
				this.hasRank(cards, 1);
	}
	// Implement the function of the DisplayCard interface
	public void displayCards() {
		dealer.displayCards();
		System.out.println();

		for (int i=0; i<NUM_OF_PLAYERS; i++)
		{
			players[i].displayCards();
			System.out.println();
		}
	}
	
	public void displayResult(LinkedList<Card> cards)
	{
		if (this.isFullHouse(cards)) {
			System.out.println("There is a full house");
		} else if (this.isSinglePair(cards))
		{
			System.out.println("There is a pair");
		} else if (this.isTwoPair(cards))
		{
			System.out.println("There is a two pair");
		} else if (this.isThreeOfAKind(cards))
		{
			System.out.println("There is a three of a kind");
		} else if (this.isFourOfAKind(cards))
		{
			System.out.println("There is a four of a kind");
		} else if (this.isRoyalFlush(cards))
		{
			System.out.println("There is a royal flush");
		} else if (this.isStraightFlush(cards))
		{
			System.out.println("There is a straight flush");
		} else if (this.isStraight(cards)) 
		{
			System.out.println("There is a straight");
		} else if (this.isFlush(cards))
		{
			System.out.println("There is a flush");

		} else
		{
			System.out.println("There is no hands");
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
			this.displayResult(players[i].showHand());
		}
	}
	
	public static void main(String[] args) {
		ShowHandGame myGame = new ShowHandGame();
		//myGame.start();
		//myGame.displayCards();
		//myGame.showdown();
		
		
		Dealer d = new Dealer();
		Player p = new Player("Tester", 'M', 42);
		d.shuffle();			
		d.deal(p, 5);
		
		while (!myGame.isStraight(p.showHand())) {
			d.recycleAll(p);
			d.shuffle();
			d.deal(p, 5);
		}
		p.displayCards();
		myGame.displayResult(p.showHand());

		while (!myGame.isRoyalFlush(p.showHand())) {
			d.recycleAll(p);
			d.shuffle();
			d.deal(p, 5);
		}
		p.displayCards();
		myGame.displayResult(p.showHand());

	}

}
