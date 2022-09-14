package Controller.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Controller.Controllers.ControllerGameStageClassic;
import Model.GameStage.PlayersException;
import Model.GestioneUtente.RealPlayer;
import Model.GestioneUtente.SaveLoadData;
import View.Home.FramePlayers;


/**
 * This class represents the listener for frame players (choice of players), thanks to this we can choose the players and play the game
 * Implements ActionListener
 * This is a singleton class. 
 * @author Davide Morelli
 *
 */
public class ActionListenerPlayers implements ActionListener {

	/*
	 * This field contains an instance of this class
	 */
	private static ActionListenerPlayers instance;
	/*
	 * This field contains an instance of FramePlayers
	 */
	private FramePlayers framePlayers;
	
	 /**
	  * This method @return a single instance of this class
	  */
	public static ActionListenerPlayers getInstance() {
		if (instance==null) instance=new ActionListenerPlayers();
		return instance;
	}
	/**
	 * Override of actionPerformed
	 * If the button pressed is "GIOCA", I can play the game with the chosen player
	 * If the button pressed is "CREA!" we can create a new Players
	 * If the button pressed is "PASSA" we can skip turn
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		switch (e.getActionCommand()) {
		case "Gioca" ->{ 
			
						if (getFramePlayers().getUtenteScelto()!=null) {
							try {new ControllerGameStageClassic(getFramePlayers().getUtenteScelto());} 
							catch (PlayersException e1) {e1.printStackTrace();} 
							
						getFramePlayers().dispose();}
						else JOptionPane.showMessageDialog(null,"Seleziona o crea un nuovo giocatore " );}
		
		case "Crea" -> {
		
			if (!(getFramePlayers().getTextFieldCreatePlayer().getText().isEmpty()) && (!(getFramePlayers().getAvatar().isEmpty()))) {
				new RealPlayer(getFramePlayers().getTextFieldCreatePlayer().getText(), getFramePlayers().getAvatar());
				getFramePlayers().getTextFieldCreatePlayer().setText(null);  
				SaveLoadData.getInstance().updatePlayersDataOB(); 
				getFramePlayers().updateLabelSavedPlayers();} 
			else
				{JOptionPane.showMessageDialog(null,"Devi digitare un nickname e scegliere l'avatar prima di creare il tuo nuovo giocatore");}
		}
	}
	
	}

	/**
	 * This method
	 * @return an instance of FramePlayers
	 */
	private FramePlayers getFramePlayers() {
		return framePlayers;
	}
	/**
	 * This method set Frame Players
	 */
	public void setFramePlayers(FramePlayers framePlayers) {
		this.framePlayers = framePlayers;
	}
	

}
