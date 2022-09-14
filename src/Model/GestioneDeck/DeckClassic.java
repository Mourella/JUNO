package Model.GestioneDeck;

import java.util.ArrayList;


/**
 * This class extend Deck and it represents  an instance of Deck Classic
 * @author Davide Morelli
 *
 */
public class DeckClassic extends Deck {
	
	/**
	 * This field contains a number of cards
	 * of classic deck
	 */
	private static final int NUMBER_CARDS=108;
	
	/**
	 * Constructor of this class create the classic deck with three methods and pass the deck type to the super builder
	 */
	public DeckClassic() {
		super(DeckType.CLASSIC);
		this.deck=new ArrayList<Card>(NUMBER_CARDS);
		this.addValueCards();
		this.addActionCards();
		this.addWildCards();
		
		
	}
	
	/**
	 * This method adds the value cards to the deck
	 */
	private void addValueCards() {
		for (int i=0;i<Color.values().length;i++) {
			for (int k=0;k<Value.values().length;k++) {
				deck.add(new ValueCard(Color.values()[i],Value.values()[k]));
				if (k>0) deck.add(new ValueCard(Color.values()[i],Value.values()[k]));
			}
		}
	}
	
	
	/**
	 * This method adds the action cards to the deck
	 */
	private void addActionCards() {
		for (int i=0;i<Color.values().length;i++) {
			for (int k=0;k<Action.values().length;k++) {
				deck.add(new ActionCard(Color.values()[i],Action.values()[k]));
				deck.add(new ActionCard(Color.values()[i],Action.values()[k]));
			}
		}
	}
	
	/**
	 * This method adds the jolly cards to the deck
	 */
	private void addWildCards() {
		for (int i=0;i<Wild.values().length;i++) {
			for (int k=0;k<4;k++) {
				deck.add(new WildCard(Wild.values()[i]));
			}
		}
	}
	
	/**
	 * This method  @return number of cards
	 */
	public int getNumberCards() {return NUMBER_CARDS;}
	

	
	
	

}
