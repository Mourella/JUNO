package Controller.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.GameStage.GameStageClassic;
import Model.GestioneDeck.Card;
import View.GameStage.OptionPaneWild;

/**
 * This class represents the listener for game stage, thanks to this we can choose the card to play
 * Implements ActionListener
 * This is a singleton class. 
 * @author Davide Morelli
 *
 */
public class ActionListenerPlayerHand implements ActionListener  {

	/**
	 * Instance of GameStage
	 */
	private GameStageClassic gameStage;
	private OptionPaneWild paneWild= new OptionPaneWild();

	/*
	 * This field contains an instance of this class
	 */
	private static ActionListenerPlayerHand instance;

	 /**
	  * This method @return a single instance of this class
	  */
	public static ActionListenerPlayerHand getInstance() {
		if (instance==null) instance=new ActionListenerPlayerHand();
		return instance;
	}

	/**
	 * This method check If the chosen card can be played without breaking the rules
	 * @param carta
	 * @return boolean
	 */
	private boolean moveController(Card carta) {
		if (!(gameStage.checkHand().contains(carta))) return false;
		return true;
	}
	
	/**
	 * This method  @return an instance of GameStage
	 */
	private GameStageClassic getGameStage() {return gameStage;}

	/**
	 * This method set an instance of GameStage
	 * @param gs
	 */
	public void setGameStage(GameStageClassic gs) {this.gameStage = gs;} 
	
	/**
	 *  Override of actionPerformed
	 *  Thanks to this we play a card and if the chosen card is wild we can choose the color
	 */
	@Override
	public void actionPerformed(ActionEvent e) {	
		String type= e.getActionCommand().split(" ")[0];
		int indexCard=Integer.parseInt(e.getActionCommand().split(" ")[2]);
		Card carta= gameStage.getHands().get(gameStage.getPlayers().get(0).getNickname()).get(indexCard);
		if (moveController(carta)) {
			switch(type) {
					
				case "Value" -> getGameStage().playUser(carta); 
				case "Action" -> getGameStage().playUser(carta);				
				case "Wild" -> {
					paneWild.createOptionPane();
				
					carta.setColor(paneWild.getColorCard());
			
					getGameStage().playUser(carta);	}
						}
			gameStage.playGame();
				}
		else JOptionPane.showMessageDialog(null, "Non puoi giocare questa carta!");
		}
	}

	