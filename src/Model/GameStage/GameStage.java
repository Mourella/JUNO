package Model.GameStage;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.TreeMap;

import Model.GestioneDeck.Card;
import Model.GestioneDeck.Deck;
import Model.GestioneDeck.DiscardCards;
import Model.GestioneUtente.BotPlayer;
import Model.GestioneUtente.RealPlayer;
import Model.GestioneUtente.User;

/**
 * This class represents a contract to create a new Game stage
 * @author Davide Morelli
 *
 */
@SuppressWarnings("deprecation")
abstract class GameStage extends Observable {

	/**
	 * This field contains the object deck
	 */
	protected final Deck DECK;
	/**
	 * This field contains the players of this game
	 */
	protected final ArrayList<User> PLAYERS;
	/**
	 * This field contains the index of players  in the list players
	 */
	protected int currentPlayer; //indice della lista
	/**
	 * This field contains the events that occur during the game
	 */
	private String event;
	
	/**
	 * This field contains the numbers of players of this game
	 */
	private final int NUMBER_PLAYERS;
	/**
	 * This field contains TreeMap: 
	 * key = players'nickname| value=hand
	 */
	protected TreeMap<String,List<Card>> handsCards; //contiene nomi e mani 
	/**
	 * This field contains a pile of discards
	 */
	protected DiscardCards discards;
	/**
	 * This filed contains the game Direction
	 * false: left
	 * true:right
	 */
	private boolean gameDirection;
	/**
	 * This field contains the nickname of the dealer
	 */
	protected String dealer;
	/**
	 * This field contains if a player has won. 
	 * True : player has won
	 * False : otherwise
	 */
	protected boolean win;
	
	
	/**
	 * This is the constructor of this class
	 * @param Deck
	 * @param realPlayer
	 * @param N_PLAYERS
	 * @throws PlayersException
	 * and creates BotPlayer. 
	 * The real player is in position 0 on the player list
	 */
	
	public GameStage(Deck deck,RealPlayer realPlayer,final int N_PLAYERS) throws PlayersException {
		if (N_PLAYERS<1) throw new PlayersException();
		this.DECK=deck;
		this.discards=new DiscardCards();
		this.NUMBER_PLAYERS=N_PLAYERS;
		this.PLAYERS=new ArrayList<>(); 	
		this.win=false;
		this.gameDirection=false; 
		this.handsCards=new TreeMap<>();
		this.PLAYERS.add(realPlayer); 									
		for(int k=0;k<N_PLAYERS-1;k++) {PLAYERS.add(new BotPlayer());}
	}
	
	/**
	 * This method returns if a player has won.  @return true if a players has won, false otherwise 
	 */
	public boolean getWin() {return win;}
	
	/**
	 * This method @return the event in this moment
	 */
	public String getEvent() {return event;}

	/**
	 * This method @param event in this moment
	 */
	public void setEvent(String event) {this.event = event;}
	
	/**
	 * This method @return the map it contains the players and their cards
	 */
	public TreeMap<String,List<Card>> getHands(){return handsCards;}
	
	/**
	 * This method @return arraylist of players
	 */
	public ArrayList<User> getPlayers(){return this.PLAYERS;}


	/**
	 * This method @return index of current player
	 */
	public int getCurrentPlayer() {return this.currentPlayer;}
	/**
	 * This method @return game direction
	 */
	protected boolean getGameDirection() {return this.gameDirection;}
	
	/**
	 * This method set the game direction
	 * @param boolean
	 * True:right
	 * False:left
	 */
	protected void setGameDirection() {
		this.gameDirection=getGameDirection()? false:true;} 
	
	/**
	 * This method set the next player (1 position)
	 */
	public void setCurrentPlayer() {
		if(gameDirection==false) {
			currentPlayer=(currentPlayer-1)%PLAYERS.size();
			if(currentPlayer==-1) currentPlayer=PLAYERS.size()-1;}
		else currentPlayer=(currentPlayer+1)%PLAYERS.size();}
	
	/**
	 * This method @return numbers of players in this game
	 */
	public int getNumbersPlayers() {return NUMBER_PLAYERS;}
	/**
	 * This method @return dealer of this game
	 */
	public String getDealer() { return dealer;}
	
	
	/**
	 * This method makes the player draw cards
	 * @param numbersCards of cards to draw
	 * @param indexPlayer  who draws cards
	 */
	public void drawCards(int numbersCards,int indexPlayer) {
		 if(getCurrentPlayer()==indexPlayer) { //controlla effettivamente che chi pesca è di turno
			while(numbersCards-->0) {
				if (DECK.getSizeDeck()==0) updateDeck(); //se le carte da pescare sono finite,riempe nuovamente il deck con gli scarti
				handsCards.get(PLAYERS.get(indexPlayer).getNickname()).add(DECK.getCard(0)); //add new card to player's hand
				DECK.removeCard(0);
				 }	 } }
	
	/**
	 * This method updateDeck if the deck isEmpty
	 */
	private void updateDeck() {DECK.setDeck(discards.getDiscard());DECK.shuffle(); discards.clear();}
	
	/**
	 * This method adds card into pile of discards and removes the card from the deck
	 * @param card
	 * @param index

	 */
	protected void addFromDeckToDiscards(Card card,int index) {
		discards.addCard(card);
		DECK.removeCard(0);
	}

	/**
	 * This method deals the cards to the players
	 */
	protected void dealtCards(int numbersOfCards) {
		for(int k=0;k<PLAYERS.size();k++) {
			handsCards.put(PLAYERS.get(k).getNickname(),DECK.getDeck().subList(0, numbersOfCards));
			DECK.setDeck(new ArrayList<>(DECK.getDeck().subList(numbersOfCards, DECK.getSizeDeck())));	
		}
	}
	
	
	/**
	 * This method notifies the observer of the new GameStage object
	 */
	public void updateOb() {
		this.setChanged(); 
		this.notifyObservers(this);
	}

	/**
	 * This method notifies the observer the victory of the game
	 */
	protected void  updateWinOb() {
		this.setChanged(); 
		this.notifyObservers(win);}
	
	/**
	 * This method @return the index of dealer
	 */
	abstract int dealer();
	
	/**
	 * This method prepares the start of the game
	 */
	abstract void prepareGame();
	
	/**
	 * This method adds the top card to the discard pile and updates the current player if needed
	 */
	abstract void firstDiscardCard();
	
	/**
	 * This method manages card effects in this mode
	 * @param cartaGiocata by player
	 */
	abstract void cardsEffects(Card cartaGiocata);
	/**
	 * This method manages the behavior of the real player
	 * @param cartaGiocata by the player
	 */
	abstract public void playUser(Card cartaGiocata); 
	
	/**
	 * This method manages the behavior of the bot
	 */
	abstract void playBot();
	
	/**
	 * This method check after each move if the player whose turn it is has won the game. 
	 * In any case, it updates the statistics of the real player.Notify observer of the change
	 */
	abstract void checkWin();
	

	/**
	 * This method checks which cards the player can play according to the rules of the mode
	 * @return playable cards
	 */
	abstract public List<Card> checkHand();

}
