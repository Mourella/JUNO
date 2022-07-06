package Model.GestioneUtente;

public class Statistics {
	

	protected int level;
	protected int experience;
	protected int gamesWin;
	protected int gamesLose;
	
	
	public Statistics() {
		this.level=1;
		this.experience=0;
		this.gamesLose=0;
		this.gamesWin=0;
	}

	 * This method  @return Utente's level
	 */
	public int getLevel() {return this.level;}
	
	/**
	 * This method  @return Utente's experience
	 */
	public int getExperience() {return this.experience;}
	
	/**
	 * This method @return the games won
	 */
	public int getGamesWin() {return this.gamesWin;}

	/**
	 * This method @return the games lost
	 */
	public int getGamesLose() {return this.gamesLose;}
	
	/**
	 * This method @return the games 
	 */
	public int getGames() {return getGamesLose()+getGamesWin();}
	
	
	/**
	 * Useful for setting the experience to 0 as the player progresses in level*/
	protected void setExperience() {this.experience=0;}
	
	/////// VEDILI DECIDI COME INCREMENTARE, SE QUANDO VINCI UNA PARTITA RILASCI UN NUMERO che fa capire se incrementare uno o l'altro
	protected void setGamesLose() {this.gamesLose++;}
	protected void setGamesWin() {this.gamesWin++;}
	
	/**
	 * This method return a String that represents the statistics of a Utente.
	 * Thanks to this method i can save with method SaveNewUtente() (in class SaveLoadData)
	 * these data like 1-0-0-0-0 when a new utente is create
	 */
	public String toString() {
		return this.getLevel()+"-"+this.getExperience()+"-"+this.getGamesWin()+"-"+this.getGamesLose();
	}
	

	
	
	
	
}
