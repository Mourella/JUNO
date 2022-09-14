package Controller.Controllers;

import Controller.ActionListener.ActionListenerLabelCenter;
import Controller.ActionListener.ActionListenerPlayerHand;
import Controller.Observers.ObserverGameStage;
import Model.GameStage.GameStageClassic;
import Model.GameStage.PlayersException;
import Model.GestioneDeck.DeckClassic;
import Model.GestioneUtente.RealPlayer;
import View.GameStage.FrameViewGS;


/**
 * This class represents the controller of game stage.
 * @author Davide Morelli
 *
 */
public class ControllerGameStageClassic {
	@SuppressWarnings("deprecation")
	
	
	/**
	 * The constructor creates a game stage instance, game stage listeners and observers.
	 * I add observers to the list of the observable.I create the game stage frame for the view
	 * @param utenteScelto
	 * @throws PlayersException
	 */
	public ControllerGameStageClassic(RealPlayer utenteScelto) throws PlayersException {
		GameStageClassic game =new GameStageClassic(new DeckClassic(),utenteScelto,4);
		ActionListenerPlayerHand.getInstance().setGameStage(game);
		ActionListenerLabelCenter.getInstance().setGameStage(game);
		ObserverGameStage observerCards=new ObserverGameStage();
		
		game.addObserver(observerCards);
		game.prepareGame(); 
		
		FrameViewGS frame=new FrameViewGS(observerCards.getMappa(),observerCards.getDealer(), observerCards.getPlayers()); 
		observerCards.setFrame(frame); //add the frame to the observer
		game.updateOb(); //update view
		if (game.getCurrentPlayer()!=0) game.playGame();	//if current player is bot, play
	}
	

}
