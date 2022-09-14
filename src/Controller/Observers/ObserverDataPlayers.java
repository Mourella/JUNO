package Controller.Observers;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import Model.GestioneUtente.User;
import View.Home.FramePlayers;
import View.Home.FrameStatistics;

/**
 * This class represents observer of statistics. Thanks to this i can update
 * FrameStatistics and FramePlayers
 * @author Davide Morelli
 *
 */
@SuppressWarnings("deprecation")
public class ObserverDataPlayers  implements Observer {

	/**
	 * This field contains FrameStatistics
	 */
	private FrameStatistics frameStatistics;
	/**
	 * This field contains FramePalyers
	 */
	private FramePlayers framePlayers;
	
	/**
	 * Override of update method
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		if (getFrameStatistics()!=null) getFrameStatistics().setMapStatistics((Map<String, User>) arg);
		if (getFramePlayers()!=null) getFramePlayers().setMapPlayers((Map<String, User>) arg);
		
	}

	/**
	 * This method
	 * @return an object FrameStatistics
	 */
	private FrameStatistics getFrameStatistics() {
		return frameStatistics;
	}

	/**
	 * This method set FrameStatistics
	 */
	public void setFrameStatistics(FrameStatistics frameStatistics) {
		this.frameStatistics = frameStatistics;
	}

	/**
	 * This method
	 * @return framePlayers
	 */
	private FramePlayers getFramePlayers() {
		return framePlayers;
	}

	/**
	 * This method set FramePlayers
	 */
	public void setFramePlayers(FramePlayers framPlayers) {
		this.framePlayers = framPlayers;
	}

	
	

}
