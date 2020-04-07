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
		System.out.println("Dealer's cards:");
		dealer.displayCards();
		for (int i=0; i<NUM_OF_PLAYERS; i++)
		{
			System.out.println("Player " + players[i].name + "'s cards:");
			players[i].displayCards();
		}
	}
	
	public static void main(String[] args) {
		FiveCardStudGame myGame = new FiveCardStudGame();
		myGame.start();
		myGame.displayCards();
	}

}
