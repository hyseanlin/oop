package poker_demo;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DisplayPoker {

	public static void main(String[] args) throws IOException {
		// Step 1: Generate a random filename, which follows
		// the format of a poker card's filename
    	int i = (int)(Math.random() * 51) + 1;
    	String cardFilename = "img/" + i + ".png";
    	
    	/* Step 2: Load the image from the file
		 * according to the cardFilename */
    	// create a File object
    	File pokerFile = new File(cardFilename);	
    	// read image data from the file object
        BufferedImage img = ImageIO.read(pokerFile);
        int imgWidth = img.getWidth();
        int imgHeight = img.getHeight();
        
        /* Step 3: Create a GUI interface 
         * for displaying the image */
        ImageIcon icon=new ImageIcon(img);

        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(imgWidth + 20, (imgHeight)*2 + 50);
        frame.setTitle(cardFilename);
        
        JLabel lbl1=new JLabel();
        lbl1.setIcon(icon);
        JLabel lbl2=new JLabel();
        lbl2.setIcon(icon);
        
        frame.add(lbl1);
        frame.add(lbl2);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    	
	}

}
