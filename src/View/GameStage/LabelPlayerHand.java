package View.GameStage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;


import Controller.ActionListener.ActionListenerPlayerHand;

import Model.GestioneDeck.Card;



/**
 * 
 * @author Davide Morelli
 *This class is label for  real player cards
 *It contains cards.
 */
class LabelPlayerHand extends JLabel implements ScaledIcon{

	/**
	 * This field contains seriaVersionUID
	 */
	private static final long serialVersionUID = 2221274187386291563L; 
	/**
	 * This field contains list of cards
	 */
	private  List<Card> cards=new ArrayList<>();
	
	/**
	 * Constructor of this class. Set size and adds the buttons
	 * @param carta
	 */
	LabelPlayerHand(List<Card> carta) {
	
		this.cards=carta;
		setLayout(new FlowLayout(FlowLayout.CENTER));
	    setPreferredSize(new Dimension(200,100)); //size JLabel
	    addButton();

		
	}

	/**
	 * This method adds the buttons that represent the cards 
	 */
	void addButton() {
		for (int k=0;k<cards.size();k++) {
			JButton bottone=new JButton();
			bottone.setContentAreaFilled(false);
			bottone.setBorder(null);
			ScaledIcon.setIconButton("Image\\Cards\\"+cards.get(k).toString()+".png",bottone,70,90);
			add(bottone);
			bottone.setActionCommand(cards.get(k).getTypeCard()+" "+cards.get(k)+" "+k); 
			bottone.addActionListener(ActionListenerPlayerHand.getInstance());
		
		}
	}
	


	
	
	
}
