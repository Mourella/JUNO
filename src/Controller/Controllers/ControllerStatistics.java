package Controller.Controllers;

import Controller.Observers.ObserverDataPlayers;
import Model.GestioneUtente.SaveLoadData;
import View.Home.FrameStatistics;


/**
 * This class represents the controller of Statistics
 * @author Davide Morelli
 *
 */
public class ControllerStatistics {
	@SuppressWarnings("deprecation")
	/**
	 * 
	 * The constructor creates a SaveLoadData instance.
	 * I add observers to the list of the observable.I create the FrameStatistics for the view
	 */
	public ControllerStatistics() {
		
		SaveLoadData saveLoadData= SaveLoadData.getInstance();
		ObserverDataPlayers observerStatistics=new ObserverDataPlayers();
		saveLoadData.addObserver(observerStatistics);
		FrameStatistics frameStatistics=new FrameStatistics();
		observerStatistics.setFrameStatistics(frameStatistics);
		saveLoadData.updatePlayersDataOB();
		frameStatistics.writeStatistics();
		
	}
	
	
}
