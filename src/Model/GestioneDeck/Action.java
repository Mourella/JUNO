package Model.GestioneDeck;

/**
 * This enum contains the actions of the cards
 * @author Davide Morelli
 *
 */
public enum Action {
	
	SKIP(20),REVERSE(20),DRAWTWO(20);

	/**
	 * This field represents the points of the cards Action
	 */
	private int points;
	
	/**
	 * Constructor 
	 * @param points of the cards Action
	 */
	private Action(int points) {this.points=points;}
	
	/** 
	 *  This method @return points of the Value cards 
	 */
	public int getPoints() {return this.points;}
	
}
