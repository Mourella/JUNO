package Model.GestioneUtente;

import java.util.Random;

public abstract class Utente {

	private String nickname;
	private Statistics statistics;
	
	protected SaveLoadData saveLoad=SaveLoadData.getInstance();

	/**
	 * This method  @return Utente's nickname
	 */
	public String getNickname() {return this.nickname;}
	
	
	/**
	 * This method
	 * @return the statistics of this player
	 */
	public Statistics getStatistics() {return this.statistics;}
	
	/**
	 * 
	 * This method take a @param nick and set the user nick
	 */
	protected void setNickname(String nick) {this.nickname=nick;}
	

	/**
	 * This method set the statistics of this player
	 * @param statistics
	 */
	protected void setStatistics(Statistics statistics) {this.statistics=statistics;}
	
	public String toString() {
		return this.getNickname();
	}
	
}
