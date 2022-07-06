package View.Game;


import java.awt.BorderLayout;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Model.GameStage.GameStage;
import Model.GestioneDeck.Card;
import Model.GestioneDeck.DeckClassic;
import Model.GestioneUtente.Giocatore;

public class MainLabelGS extends JLabel {

	private static final long serialVersionUID = -1859874002422896962L;
	private TreeMap<String,List<Card>> mapHands;
	private Object[] players;
	
	public MainLabelGS( TreeMap<String,List<Card>> mapHands) {
		super(new ImageIcon("C:\\Users\\Davide Morelli\\Desktop\\Sapienza\\Java2k22\\JUNO\\Image\\Table_4.png"));
		setLayout(new BorderLayout(0,20));	
		this.mapHands=mapHands;
		this.players= mapHands.keySet().toArray(); //prendo la lista di giocatori
		
		System.out.println(mapHands.get("Discards")+" "+mapHands);
		
		add(new LabelCenterGS(mapHands.get("Discards").get(mapHands.get("Discards").size()-1)),BorderLayout.CENTER);
		
		//me
		add(new LabelPlayerHand(mapHands.get("Franc")),BorderLayout.PAGE_END);	
		//sx
		add(new LabelPlayerHandBot(60,40,"DeckHoDx.png",mapHands.get(players[1]).size()),BorderLayout.LINE_START);
		//up
		add(new LabelPlayerHandBot(40,60,"DeckDown.png",mapHands.get(players[2]).size()),BorderLayout.PAGE_START);
		//dx
		add(new LabelPlayerHandBot(60,40,"DeckHoSx.png",mapHands.get(players[3]).size()),BorderLayout.LINE_END);
		
			
		
	}
	
	

	
	
	
}
