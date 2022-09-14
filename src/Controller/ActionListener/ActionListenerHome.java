package Controller.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.Controllers.ControllerPlayers;
import Controller.Controllers.ControllerStatistics;
import View.Home.FrameHelp;

/**
 * This class represents the listener for the home buttons.
 * Implements ActionListener
 * This is a singleton class
 * @author Davide Morelli
 *
 */
public class ActionListenerHome implements ActionListener {

	/*
	 * This field contains an instance of this class
	 */
	private static ActionListenerHome instance;
	
	 /**
	  * This method @return a single instance of this class
	  */
	public static ActionListenerHome getInstance() {
		if (instance==null) instance=new ActionListenerHome();
		return instance;
	}
	
	
	/**
	 * Override of actionPerformed
	 * If the button pressed is "GIOCA", the choice of players opens and then the game
	 * If the button pressed is "COME GIOCARE" we can read the rules
	 * If the button pressed is "Statistiche" we can read the statistics of the players
	 */
	@Override
	public void actionPerformed(ActionEvent e) {	
		switch(e.getActionCommand()) {
		case "Gioca" -> {new ControllerPlayers();}
		case "Come giocare" -> new FrameHelp();
		case "Statistiche"-> new ControllerStatistics();
		}
	
	}

}
