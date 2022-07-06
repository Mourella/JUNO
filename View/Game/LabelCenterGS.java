package View.Game;



import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Model.GestioneDeck.Card;
/**
 * 
 * @author Davide Morelli
 *This class in a container for the centre of Frame.
 *It contains discards, deck anche button Juno
 */
public class LabelCenterGS extends JLabel implements ScaledIcon {
	
	//setto layout null
	public LabelCenterGS(Card card) {
		setLayout(null);
		//creo la label del ddeck e scelgo dove metterla
		JLabel deck = new JLabel(new ImageIcon(ScaledIcon.setIconLabel("C:\\Users\\Davide Morelli\\Desktop\\Sapienza\\Java2k22\\JUNO\\Image\\Deck.png",70,90)));
		deck.setBounds(400, 150, 100, 100);
		System.out.println(card);
		JLabel discards=new JLabel(new ImageIcon(ScaledIcon.setIconLabel("C:\\Users\\Davide Morelli\\Desktop\\Sapienza\\Java2k22\\JUNO\\Image\\Cards\\"+card+".png",70,90))); //TODO: puoi fare il costruttore che prende il path in input
		discards.setBounds(550, 150, 100, 100);
		
		JButton buttonJUNO=new JButton("JUNO!");
		
		
		buttonJUNO.setBounds(700,150,100,100);
		
		add(buttonJUNO);
		add(discards);
		add(deck);
		
		
		
	}

}
