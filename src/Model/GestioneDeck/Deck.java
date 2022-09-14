package Model.GestioneDeck;

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class represents a contract to create a deck
 * @author Davide Morelli
 *
 */
public abstract class Deck  {
	
	/**
	 * This field represents my deck
	 */
	protected ArrayList<Card> deck;
	/**
	 * This field represents deck's type
	 */
	private DeckType type;
	
	/**
	 * Constructor of this class
	 * @param what kind of deck it is
	 */
	public Deck(DeckType type) {
		this.type=type;
	}
	
	
	/**
	 * This method  @return what kind of deck it is
	 */
	public DeckType getType() {return this.type;}
	/**
	 * This method @return ArrayList<Card>.It represents deck
	 */
	public ArrayList<Card> getDeck(){return this.deck;}
	
	/**
	 * This method @return one card
	 * @throws DeckSizeException 
	*/ 

	public Card getCard (int index) {
		return deck.size()>1? deck.get(index):null;
	}
	/**
	 * This method @return size of deck
	 */
	public int getSizeDeck() {return this.deck.size();}
	
	/**
	 * This method set a new deck
	 * @param newDeck
	 */
	public void setDeck(ArrayList<Card> newDeck) {
		this.deck= newDeck;
	}
	
	/**
	 * This method remove a card 
	 * @param index card
	 */
	public void removeCard(int index)  {
		deck.remove(index);
	}
	
	/**
	 * This method shuffles the deck
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}

	
	
	

	
}
