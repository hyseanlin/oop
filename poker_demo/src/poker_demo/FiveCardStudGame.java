package poker_demo;

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
	
	public void displayCards() {
		dealer.displayCards();
		System.out.println();

		for (int i=0; i<NUM_OF_PLAYERS; i++)
		{
			players[i].displayCards();
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		FiveCardStudGame myGame = new FiveCardStudGame();
		myGame.start();
		myGame.displayCards();
	}

}
