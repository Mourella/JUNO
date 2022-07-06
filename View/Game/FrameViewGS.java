package View.Game;



import java.awt.BorderLayout;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import javax.swing.JFrame;

import javax.swing.WindowConstants;

import Model.GameStage.GameStage;
import Model.GestioneDeck.Card;


public class FrameViewGS extends JFrame {
	
	
	
	public FrameViewGS(TreeMap<String,List<Card>> mappa,String stringa) {
		super("JUNO");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		add(new LabelTopGS(stringa),BorderLayout.PAGE_START);
		add(new MainLabelGS(mappa),BorderLayout.CENTER);
		
		//misure apparizione centrale
		setSize(1295,753);
		setLocationRelativeTo(null);
		setResizable(false);
		pack(); 
		setVisible(true);
		
	}
	
	
		
}
