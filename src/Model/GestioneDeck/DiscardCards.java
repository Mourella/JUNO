package Model.GestioneDeck;

import java.util.ArrayList;

/**
 * This class represents an instance
 * of the discarded cards
 * @author Davide Morelli
 *
 */
public class DiscardCards {

	/**
	 * This field represents ArraList of card to create a discarded cards
	 */
	private ArrayList<Card> discard;
	
	/**
	 * Constructor of this class
	 */
	public DiscardCards() {
		this.discard=new ArrayList<>();
	}
	/**
	 * This method adds card to discarded cards
	 * @param card to discarded cards
	 */
	public void addCard(Card card) {
		discard.add(card);
	}
	
	/**
	 * This method @return the last card discarded
	 */
	public Card getLastCard() {
		return discard.get(discard.size()-1);
	}
	
	/**
	 * This method @return ArrayList<Card> of discarded cards
	 */
	public ArrayList<Card> getDiscard() {return discard;}
	
	/**
	 * This method empties the deck of discarded cards
	 */
	public void clear() {
		discard.clear();
	}
}
