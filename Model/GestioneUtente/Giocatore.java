package Model.GestioneUtente;

import java.io.File;

public class Giocatore extends Utente {
	
	/**
	 * Constructor of this class, take:
	 * @param nickname
	 * and create a new Giocatore with this name and nickname and statistics
	 * @throws UtenteNotExistException 
	 */
	public Giocatore(String nickname)  { //VEDI STA ECCEZIONE
		
		this.setNickname(nickname);
		
		this.setStatistics(new Statistics());
		saveLoad.saveNewUtente(this);
	
	
		
	}

	//TODO eredita i metodi che devo implementare di incrementa livello (in caso perchè ora non so come usarli)
	
	

	

}
