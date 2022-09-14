package Model.GestioneUtente;

import java.io.Serializable;

/**
 * This class contains player stats:
 *  games won, lost, level, experience
 *  In this class Many of the methods are private in fact
 *  it is possible to set only the games won or lost, because thanks to them we can increase the experience and consequently the level
 * @author Davide Morelli
 *
 */
public class Statistics implements Serializable {

	/**
	 * This field contains seriaVersionUID
	 */
	private static final long serialVersionUID = -7807783580952687895L;
	
	/**
	 * This field contains the the player's level
	 */
	private int level;
	/**
	 * This field contains the the player's experience
	 */
	private int experience;
	/**
	 * This field contains the games won by the player
	 */
	private int gamesWin;
	/**
	 * This field contains the games lost by the player
	 */
	private int gamesLose;
	
	/**
	 * Constructor of this class.
	 * When the player is created set the level to 1, experience 0, gamesLose=0, gamesWin=0
	 */
	public Statistics() {
		this.level=1;
		this.experience=0;
		this.gamesLose=0;
		this.gamesWin=0;
	}
	
	/**
	 * This method
	 * @return User's level
	 */
	public int getLevel() { checkStatistics(); return this.level;}
	/**
	 * This method increase the level by one
	 */
	private void setLevel() {this.level++;}
	
	/**
	 * This method  @return User's experience
	 */
	private int getExperience() {return this.experience;}
	
	/**
	 * This method @return the games won
	 */
	private int getGamesWin() {return this.gamesWin;}

	/**
	 * This method @return the games lost
	 */
	private int getGamesLose() {return this.gamesLose;}
	
	/**
	 * This method @return the games played
	 */
	private int getGames() {return getGamesLose()+getGamesWin();}
	
	
	/**
	 * Useful for setting the experience to 0 as the player progresses in level*/
	private void setExperience() {this.experience++;}

	/**
	 * This method increase the increases lost games by one
	 */
	public void setGamesLose() {this.gamesLose++;}
	/**
	 * This method increase the increases won games by one and increases the experience
	 */
	public void setGamesWin() {this.gamesWin++; setExperience();}
	
	/**
	 * This method increases player level automatically once experience increases
	 */
	private void checkStatistics() { 
		if (getExperience()>0 ) {if (getExperience()%10==0) setLevel();}}
	
	/**
	 * This method return a String that represents the statistics of a User.
	 */
	public String toString() {
	
		return this.getLevel()+"-"+this.getExperience()+"-"+getGames()+"-"+this.getGamesWin()+"-"+this.getGamesLose();
	}
	

	
	
	
	
}
