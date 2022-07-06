package Model.GestioneDeck;

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
	 * 
	 * @return points of the cards Jolly
	 */
	public int getPoints() {return this.points;}
	


}
