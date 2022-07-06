package Model.GestioneDeck;

/**
 * This class represents an jolly card
 * @author Davide Morelli
 *
 */
public class WildCard extends Card {

	/**
	 * Constructor of this card
	 * @param what kind of jolly it is
	 */
	public WildCard(Wild jolly) {
		this.jolly=jolly;
		this.typeCard="Jolly";
	}
	@Override
	public int getCardPoints() {
		return this.getJolly().getPoints();
	}

	/**
	 * @return toString of an jolly card
	 */
	@Override
	public String toString() {
		return this.getJolly()+"";
	}

	/**
	 * @return String with type card
	 */
	@Override
	public String getTypeCard() {
		return this.typeCard;
	}

}
