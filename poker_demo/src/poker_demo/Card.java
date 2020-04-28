package poker_demo;


public class Card {
	 public static String[] SUITS = {
			 "\u2660", // club 
			 "\u2665", // heart
			 "\u2666", // diamond
			 "\u2663"};// spades
	
	int suit_id;	// index of the pattern, ranging from 0-3
	int number;	// number of the card, ranging from 1-13

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
	 * convert it into the corresponding number
	 */
	public static int getRank(int fid)
	{
		//return (fid-1) % 13 + 1;
		return Math.floorMod(fid-1, 13)+1;
	}
	
	public Card()
	{
		this.suit_id = 0;
		this.number = 0;
	}
	
	public Card(int suit_id, int number)
	{
		this.suit_id = suit_id;
		this.number = number;
	}
	
	public Card(int fid)
	{
		this.suit_id = Card.getSuitID(fid);
		this.number = Card.getRank(fid);
	}
	
	public String getSuit()
	{
		return Card.SUITS[this.suit_id];
	}

	public int getRank()
	{
		return this.number;
	}
	public String getRankStr()
	{
		String s;
		switch (this.number)
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
			s = String.valueOf(this.number);
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
		int suit_id, number, fid;
		suit_id = 3;
		number = 13;
		fid = Card.getFileID(suit_id, number);
		suit = Card.SUITS[suit_id];
		System.out.println("Given pattern index: " + suit_id + suit + ", number: " + number + ", its file id: " + fid);
		
		suit_id = Card.getSuitID(fid);
		System.out.println("Given file id: " + fid + ", we have pid: " + suit_id);
		
		number = Card.getRank(fid);
		System.out.println("Given file id: " + fid + ", we have number: " + number);
		
	}
}
