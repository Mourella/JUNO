package Controller.Observers;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import Model.GameStage.GameStageClassic;
import Model.GestioneDeck.Card;
import Model.GestioneUtente.User;
import View.GameStage.FrameViewGS;

/**
 * This class takes information about player cards and discards
 * and the update method does this
 * @author Davide Morelli
 *
 */

@SuppressWarnings("deprecation")
public class ObserverGameStage implements Observer{
	

	/**
	 * This field contains FrameViewGS
	 */
	private FrameViewGS frame;	

	/**
	 * This field contains TreeMap where to save the players' hands
	 */
	private TreeMap<String, List<Card>> mappa;
	/**
	 * This field contains players list
	 */
	private ArrayList<User> players;
	/**
	 * This field contains dealer of the fame
	 */
	private String dealer;
	/**
	 * This field contains the object GameStage sent by the observable
	 */
	private GameStageClassic gameStage;


	/**
	 * Override of update method
	 */
	@Override
	public void update(Observable o, Object arg) {
		
		//dati relativi al turno appena concluso
		
		if (arg instanceof Boolean) this.getFrame().gameWin(gameStage.getPlayers().get(gameStage.getCurrentPlayer()).getNickname());
		else {
			gameStage=(GameStageClassic)arg;   
			this.setMappa(gameStage.getHands());
			if (getFrame() != null) {
				this.getFrame().updateAreaEvents(gameStage.getEvent());
				this.getFrame().setTurn(gameStage.getCurrentPlayer());
				this.getFrame().updateMainLabelGS(); 
									}
			else {
				this.setPlayers(gameStage.getPlayers());
				this.setDealer(gameStage.getDealer());}
	
		}}
	
	
	/**
	 * This method set map where to save the players' hands
	 */
	private void setMappa(TreeMap<String, List<Card>> mappa) {this.mappa=mappa;}
	
	/**
	 * This method @return map where to save the players' hands
	 */
	public TreeMap<String, List<Card>> getMappa() { return this.mappa;}
	
	/**
	 * This method  @return list of player
	 */
	public ArrayList<User> getPlayers() {return players;}

	/**
	 * This method set the dealer of the game
	 * @param dealer
	 */
	private void setDealer(String dealer) {this.dealer=dealer;}
	
	/**
	 * This method @return the dealer of the game
	 */
	public String getDealer() {return dealer;}
	
	/**
	 * This method set the list of players
	 * @param players
	 */
	private void setPlayers(ArrayList<User> players) {this.players = players;}

	/**
	 * This method @return FrameViewGS
	 */
	public FrameViewGS getFrame() {return frame;}

	/**
	 * This method set FrameViewGS
	 * @param frame
	 */
	public void setFrame(FrameViewGS frame) {this.frame = frame;}

	}

		
		
	
	



		