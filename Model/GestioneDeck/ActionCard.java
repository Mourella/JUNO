package Model.GestioneDeck;

/**
 * This class represents an action card
 * @author Davide Morelli
 *
 */
public class ActionCard extends Card {

	/**
	 * Constructor of this card
	 * @param color card
	 * @param what kind of action card it is
	 */
	public ActionCard(Color color,Action action) {
		this.color=color;
		this.action=action;
		this.typeCard="Action";
	}
	
	
	@Override
	public int getCardPoints() {
		return this.getAction().getPoints();
	}
	
	/**
	 * @return toString of an action card
	 */
	public String toString() {
		return this.getColor()+"_"+this.getAction();
	}


	/**
	 * @return String with type card
	 */
	@Override
	public String getTypeCard() {
		return this.typeCard;
	}


	


}
