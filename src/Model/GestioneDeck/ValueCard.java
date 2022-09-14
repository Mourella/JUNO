package Model.GestioneDeck;

/**
 * This class represents an value card
 * @author Davide Morelli
 *
 */
class ValueCard extends Card {
	
	/**
	 * Constructor of this card
	 * @param color card
	 * @param what kind of value card it is
	 */
	ValueCard(Color color,Value value) {
		this.color=color;
		this.value=value;
		this.typeCard="Value";
	
	}
	
	@Override
	public int getCardPoints() {
		return this.getValue().getPoints();
	}

	/**
	 * @return toString of an action card
	 */
	@Override
	public String toString() {
		return this.getColor()+"_"+this.getValue();
	}


	/**
	 * @return String with type card
	 */
	@Override
	public String getTypeCard() {
		return this.typeCard;
	}

}
