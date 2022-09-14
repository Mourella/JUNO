package Model.GestioneDeck;
/**
 * This enum contains the value of the cards
 * @author Davide Morelli
 *
 */
public enum Value {
	
	
	ZERO(0),ONE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9);
	
	/**
	 * this field represents the points of the cards value
	 */
	private int points;
	
	/**
	 * Constructor 
	 * @param points of the cards Value
	 */
	private Value(int points) {this.points=points;}
	
	/** 
	 *  This method @return points of the Value cards 
	 */
	public int getPoints() {return this.points;}
	
	
	
	
	

	
}
