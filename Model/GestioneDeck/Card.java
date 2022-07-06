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
	 * This field represents value of my  card
	 */
	protected Value value;
	/**
	 * This field represents action card
	 */
	protected Action action;
	/**
	 * This field represents jolly card
	 */
	protected Wild jolly;
	
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
	public Wild getJolly() {return this.jolly;}
	
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
	
	