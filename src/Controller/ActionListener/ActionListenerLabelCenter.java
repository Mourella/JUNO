package Controller.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.GameStage.GameStageClassic;

/**
 * This class represents the listener for game stage, thanks to this we can
 * draw from the deck, skip turn and say JUNO!!
 * This is a singleton class.
 * Implements ActionListener
 * @author Davide Morelli
 *
 */
public class ActionListenerLabelCenter implements ActionListener{

	/*
	 * This field contains an instance of this class
	 */
	private static  ActionListenerLabelCenter  instance;
	/**
	 * Instance GameStageClassic
	 */
	private GameStageClassic gameStage;
	
	 /**
	  * This method @return a single instance of this class
	  */
	public static ActionListenerLabelCenter getInstance() {
		if (instance==null) instance=new ActionListenerLabelCenter();
		return instance;
	}

	/**
	 * This method @return an instance of GameStage
	 */
	private GameStageClassic getGameStage() {return gameStage;}
	/**
	 * This method set an instance of Game stage
	 * @param gameStage
	 */
	public void setGameStage(GameStageClassic gameStage) {this.gameStage = gameStage;}
	
	/**
	 * Override of actionPerformed
	 * If the button pressed is "DECK", i can draws a card
	 * If the button pressed is "JUNO!" we can say JUNO
	 * If the button pressed is "PASSA" we can skip turn
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (gameStage.getCurrentPlayer()==0) {
		switch (e.getActionCommand()) {
		case "Deck" ->{ getGameStage().drawCards(1, 0); getGameStage().setEvent("Hai pescato una carta\n"); getGameStage().updateOb();} 
				
		case "JUNO!" ->  {getGameStage().setEvent("Hai gridato JUNOOOO!\n");getGameStage().updateOb();}
		
		case "Passa" -> {getGameStage().setCurrentPlayer();getGameStage().setEvent("Hai passato il turno\n"); getGameStage().updateOb(); getGameStage().playGame();}
		
		}
		}
		else JOptionPane.showMessageDialog(null, "Non puoi eseguire nessuna azione nel turno degli altri!");
		
	}

}
