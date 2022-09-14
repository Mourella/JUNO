package Model.GestioneDeck;

/**
 * This class represents a contract to create a Card
 * @author Davide Morelli
 *
 */
public abstract class Card {
	/**
	 * This field represents color card
	 */
	protected  Color color;
	/**
	 * This field represents value of my card
	 */
	protected Value value;
	/**
	 * This field represents action card
	 */
	protected Action action;
	/**
	 * This field represents wild card
	 */
	protected Wild wild;
	
	/**
	 * This field represents the type of card
	 */
	protected String typeCard;
	
	/**
	 * This method @return color of my card
	 */
	public Color getColor() {return this.color;}
	/**
	 * This method @return what kind of value card it is
	 */
	public Value getValue() {return this.value;}
	/**
	 * This method @return what kind of action card it is
	 */
	public Action getAction() {return this.action;}
	/**
	 * This method @return  what kind of jolly it is
	 */
	public Wild getWild() {return this.wild;}
	
	/**
	 * This method setColor of Card
	 * @param color
	 */
	public void setColor(Color color) {
		switch(color) {
		case BLUE-> this.color=Color.BLUE;
		case GREEN-> this.color=Color.GREEN;
		case RED-> this.color=Color.RED;
		case YELLOW->this.color=Color.YELLOW;
		}
	}
	
	/**
	 * 
	 * This method @return card points
	 */
	abstract public int getCardPoints();
	
	/**
	 * This method @return card type 
	 */
	abstract public String getTypeCard();	
}
	
	