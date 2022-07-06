package Controller;

import Controller.GameStage.*;
import Model.GameStage.GameStage;
import Model.GestioneDeck.DeckClassic;
import Model.GestioneUtente.Giocatore;
import View.Game.FrameViewGS;
import View.Game.Reader;
import View.Home.Home;

public class JUno {
	
		
	
	public static void main(String[] args) {
	
		//Home home=new Home();
		//home.setVisible(true);
		new ControllerGameStage(new GameStage(DeckClassic.getInstance(),new Giocatore("Franc"),4),new Reader());
		
		
	

	}

}