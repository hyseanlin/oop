package poker_demo;


public class Card {
	 public static String[] SUITS = {
			 "\u2660", // club 
			 "\u2665", // heart
			 "\u2666", // diamond
			 "\u2663"};// spades
	
	int suit_id;		// index of the pattern, ranging from 0-3
	int rank_number;	// rank_number of the card, ranging from 1-13

	/**
	 * Given the suit index and the rank of a card,
	 * convert them into the id of the filename of the 
	 * card image 
	 */
	public static int getFileID(int suit_id, int rank) 
	{
		return suit_id * 13 + rank;
	}
	/**
	 * Given the file id of a card,
	 * convert it into the corresponding suit index
	 */
	public static int getSuitID(int fid)
	{
		return Math.floorDiv(fid-1, 13);
	}

	/**
	 * Given the file id of a card,
	 * convert it into the corresponding rank_number
	 */
	public static int getRank(int fid)
	{
		//return (fid-1) % 13 + 1;
		return Math.floorMod(fid-1, 13)+1;
	}
	
	public Card()
	{
		this.suit_id = 0;
		this.rank_number = 0;
	}
	
	public Card(int suit_id, int rank_number)
	{
		this.suit_id = suit_id;
		this.rank_number = rank_number;
	}
	
	public Card(int fid)
	{
		this.suit_id = Card.getSuitID(fid);
		this.rank_number = Card.getRank(fid);
	}
	
	public String getSuit()
	{
		return Card.SUITS[this.suit_id];
	}

	public int getRank()
	{
		return this.rank_number;
	}
	public String getRankStr()
	{
		String s;
		switch (this.rank_number)
		{
		case 11:
			s = "J";
			break;
		case 12:
			s = "Q";
			break;
		case 13:
			s = "K";
			break;
		case 1:
			s = "A";
			break;
		default:
			s = String.valueOf(this.rank_number);
		}
		return s;
	}
	public int getSuitID()
	{
		return this.suit_id;
	}
	
	public static void main(String[] args)
	{
		String suit;
		int suit_id, rank_number, fid;
		suit_id = 3;
		rank_number = 13;
		fid = Card.getFileID(suit_id, rank_number);
		suit = Card.SUITS[suit_id];
		System.out.println("Given pattern index: " + suit_id + suit + ", rank_number: " + rank_number + ", its file id: " + fid);
		
		suit_id = Card.getSuitID(fid);
		System.out.println("Given file id: " + fid + ", we have pid: " + suit_id);
		
		rank_number = Card.getRank(fid);
		System.out.println("Given file id: " + fid + ", we have rank_number: " + rank_number);
		
	}
}

interface DisplayCards {
	public void displayCards();
	public void displayJCards();
}