package Model.GestioneDeck;

/**
 * This class represents an wild card
 * @author Davide Morelli
 *
 */
class WildCard extends Card {

	/**
	 * Constructor of this card
	 * @param what kind of wild it is
	 */
	WildCard(Wild wild) {
		this.wild=wild;
		this.typeCard="Wild";
		this.color=null;
	}
	@Override
	public int getCardPoints() {
		return this.getWild().getPoints();
	}

	/**
	 * @return toString of an wild card
	 */
	@Override
	public String toString() {
		return this.getWild()+"";
	}

	/**
	 * @return String with type card
	 */
	@Override
	public String getTypeCard() {
		return this.typeCard;
	}	
}
