package Model.GestioneUtente;

import java.io.Serializable;


/**
 * This class is a "contract" to create a real player or bot player
 * @author Davide Morelli
 *
 */
public abstract class User implements Serializable {

	/**
	 * This field contains seriaVersionUID
	 */
	private static final long serialVersionUID = 4665358141388539741L;
	/**
	 * This field contains the nickname 
	 */
	private String nickname;
	/**
	 * This field contains an object Statistics. 
	 * This object contains the player's statistics
	 */
	private Statistics statistics;
	/**
	 * This field contains a String, it refers to the path of the avatar.
	 */
	private String pathAvatar;
	
	/**
	 * This field contains an object SaveLoadData. 
	 * It's important when saving the new player or updating his stats.
	 * Thank to "transient" this field is not saved when saving the player
	 */
	protected transient SaveLoadData saveLoad=SaveLoadData.getInstance();

	/**
	 * This method  @return Utente's nickname
	 */
	public String getNickname() {return this.nickname;}
	
	
	/**
	 * This method  @return the statistics of this player
	 */
	public Statistics getStatistics() {return this.statistics;}
	
	/**
	 * This method take a @param nick and set the user nick
	 */
	protected void setNickname(String nick) {this.nickname=nick;}
	

	/**
	 * This method set the statistics of this player
	 * @param statistics
	 */
	protected void setStatistics(Statistics statistics) {this.statistics=statistics;}

	/**
	 * This method  @return The path of the avatar
	 */
	public String getPathAvatar() {return pathAvatar;}


	/**
	 * This method sets the path to the player
	 * @param pathAvatar
	 */
	protected void setPathAvatar(String pathAvatar) {this.pathAvatar = pathAvatar;}
	
	/**
	 *To string of this object
	 */
	public String toString() {return this.getNickname();}
}
