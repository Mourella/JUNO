package View.Game;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import javax.swing.JFrame;

import Model.GestioneDeck.Card;

public class Reader extends JFrame implements Observer{

	private String stringa;

	
	@Override
	public void update(Observable o, Object arg) {
		
		if (arg instanceof String) {
			this.stringa=(String)arg;
		}
		else {
			new FrameViewGS((TreeMap<String, List<Card>>) arg,stringa);//questo forse lo puoi spostare
		}
		
		
	}

}
