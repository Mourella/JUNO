package View.Game;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JLabel;

import Model.GameStage.GameStage;
import Model.GestioneDeck.Card;




public class LabelPlayerHand extends JLabel implements ScaledIcon{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2221274187386291563L;
	
	private List<Card> mappa=new ArrayList<>();

	public LabelPlayerHand(List<Card> carta) {
		
		this.mappa=carta;
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setPreferredSize(new Dimension(200,100)); //size JLabel
		addButton();
		
		//setOpaque(true);
		
	}
	
	//Ci sarà una lista di bottoni in input ed un for che scorre le carte e aggiunge i bottoni tutti di stessa dimensione
	public void addButton() {
		//System.out.println("FFF "+mappa);
		for (int k=0;k<mappa.size();k++) {
			JButton bottone=new JButton();
			ScaledIcon.setIconButton("C:\\Users\\Davide Morelli\\Desktop\\Sapienza\\Java2k22\\JUNO\\Image\\Cards\\"+mappa.get(k).toString()+".png",bottone,70,90);
			add(bottone);
		}
	}

	



	
	
	
}
