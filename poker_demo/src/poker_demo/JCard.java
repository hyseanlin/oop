package poker_demo;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
// swing-related packages
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JCard extends Card {
	String cardFilename=""; 		// filename of a card
	BufferedImage cardImage=null; 	// image information of a card
	int cardImageHeight=0;			// Height of a card image
	int cardImageWidth=0;			// Width of a card image
	JLabel cardLabel=new JLabel();;			// JLabel representation of a card

	private void createCardImage(int suit_id, int rank_number) throws IOException
	{
		// Step 1: Generate a random filename, which follows
		// the format of a poker card's filename
		int id = Card.getFileID(suit_id, number);
    	this.cardFilename = "img/" + id + ".png";	
    	/* Step 2: Load the image from the file
		 * according to the cardFilename */
     	// create a File object
    	File pokerFile = new File(this.cardFilename);	
    	// read image data from the file object
        this.cardImage = ImageIO.read(pokerFile);
        this.cardImageWidth = this.cardImage.getWidth();
        this.cardImageHeight = this.cardImage.getHeight(); 
        // Create an ImageIcon from the buffer image
        ImageIcon icon=new ImageIcon(this.cardImage);
        // Create a JLabel from the image icon
        this.cardLabel.setIcon(icon);

	}
	
	public JCard()
	{
		super();
		
		this.cardFilename="";
		this.cardImage=null;
		this.cardImageHeight=0;
		this.cardImageWidth=0;
		this.cardLabel=new JLabel();;
	}
	
	public JCard(int suit_id, int rank_number) throws IOException
	{
		super(suit_id, rank_number);
		this.createCardImage(this.suit_id, this.number);
	}
	
	public JCard(int fid) throws IOException
	{
		super(Card.getSuitID(fid), Card.getRank(fid));
		this.createCardImage(this.suit_id, this.number);
	}
	
	public JLabel getJLabel() {
		return this.cardLabel;
	}
	
	public int getCardImageHeight()
	{
		return this.cardImageHeight;
	}

	public int getCardImageWidth()
	{
		return this.cardImageWidth;
	}
	
	public static void main(String[] args) {
		JCard myCard = null;
		try {
			int i = (int)(Math.random() * 51) + 1;
			myCard = new JCard(i);

			JFrame frame=new JFrame();
	        frame.setLayout(new FlowLayout());
	        frame.setSize(myCard.getCardImageWidth() + 20, myCard.getCardImageHeight() + 50);
	        frame.setTitle("Test program based on JCard for displaying single card");
	        
	        frame.add(myCard.getJLabel());
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    	
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
