package Controller.Controllers;

import Controller.ActionListener.ActionListenerPlayers;
import Controller.Observers.ObserverDataPlayers;
import Model.GestioneUtente.SaveLoadData;
import View.Home.FramePlayers;


/**
 * This class represents the controller of FramePlayers
 * @author Davide Morelli
 *
 */
public class ControllerPlayers {
		
	/**
	 * 
	 * The constructor creates a SaveLoadData instance, listeners for the frame Players .
	 * I add observers to the list of the observable.I create the FramePlayers for the view
	 */
	 
	@SuppressWarnings("deprecation")
	public ControllerPlayers() {
		
		SaveLoadData saveLoadData= SaveLoadData.getInstance();
		ObserverDataPlayers observerStatistics=new ObserverDataPlayers();
		saveLoadData.addObserver(observerStatistics);
		FramePlayers framePlayers=new FramePlayers();
		ActionListenerPlayers alp=ActionListenerPlayers.getInstance();
		alp.setFramePlayers(framePlayers); //add the frame to the observer
		observerStatistics.setFramePlayers(framePlayers);
		saveLoadData.updatePlayersDataOB(); //update statistics
		framePlayers.writePlayers(); //write data in the textField
	
	}
	
}

