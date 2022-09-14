package Model.GestioneDeck;

/**
 * This enum contains the possible wild cards
 * @author Davide Morelli
 *
 */
public enum Wild {
	WILD(50),WILDDRAWFOUR(50);
	
	/**
	 * This field represents the points of the cards Jolly
	 */
	private int points;
	
	/**
	 * Constructor 
	 * @param points of the cards Jolly
	 */
	private Wild(int points) {this.points=points;}
	
	/** 
	 *  This method @return points of the wild cards 
	 */
	public int getPoints() {return this.points;}
	


}
