package Model.GestioneDeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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
	 * This method
	 * @return what kind of deck it is
	 */
	public DeckType getType() {return this.type;}
	/**
	 * This method
	 * @return ArrayList<Card>.It represents deck
	 */
	public ArrayList<Card> getDeck(){return this.deck;}
	/**
	 * print Deck
	 */
	public void printDeck() {
		deck.forEach(x->System.out.println(x));
	}
	
	
	
	
	
	/**
	 * This method
	 * @return one card
	*/ 

	public Card getCard (int index) {
		//TODO:ECCEZIONE SE SIZE è MAGGIORE DI 1 PUO Darla altrimenti no
		return deck.get(index);
	}
	/**
	 * This method
	 * @return size of deck
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
