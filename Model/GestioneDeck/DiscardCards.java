package Model.GestioneDeck;

import java.util.ArrayList;

/**
 * This class is a singleton and represents an instance
 * of the discarded cards
 * @author Davide Morelli
 *
 */
public class DiscardCards {
	
	/**
	 * This field contains instance of this class
	 */
	private static DiscardCards instance;
	/**
	 * This field represents ArraList of card to create a discarded cards
	 */
	private ArrayList<Card> discard;
	
	/**
	 * Constructor of this class
	 * 
	 */
	private DiscardCards() {
		this.discard=new ArrayList<>();
	}
	
	/**
	 * This method
	 * @return an instance of discarded cards
	 */
	public static DiscardCards  getInstance() {
		 if (instance==null) instance=new DiscardCards ();
		 return instance;
	}
	
	/**
	 * This method adds
	 * @param card to discarded cards
	 */
	public void addCard(Card card) {
		discard.add(card);
	}
	
	/**
	 * This method
	 * @return the last card discarded
	 */
	public Card getLastCard() {
		return discard.get(discard.size()-1);
	}
	
	/**
	 * This method
	 * @return ArrayList<Card> of discarded cards
	 */
	public ArrayList<Card> getDiscard() {return discard;}
	
	/**
	 * this method empties the deck of discarded cards
	 */
	public void clear() {
		discard.clear();
	}
}
