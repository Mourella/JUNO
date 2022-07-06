package Model.GameStage;

import Model.GestioneUtente.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.stream.Collectors;
import java.util.TreeMap;

import Model.GestioneUtente.*;

import Model.GestioneDeck.*;


public class GameStage extends Observable{

	/**
	 * This field contains the object deck
	 */
	private final Deck deck;
	/**
	 * This field contains the players of this game
	 */
	private final ArrayList<Utente> players;
	/**
	 * This field contais the index of players  in the list players
	 */
	private int currentPlayer; //indice della lista
	/**
	 * This field contains the numbers of players of this game
	 */
	private  int numbersPlayers;
	/**
	 * This field contains TreeMap: 
	 * key = players' nickname| value=hand
	 */
	private TreeMap<String,List<Card>> hands; //contiene nomi e mani 
	
	/**
	 * This field contains a pile of discards
	 */
	private DiscardCards discards;
	/**
	 * This filed contains the game Direction
	 * false: left
	 * true:right
	 */
	private boolean gameDirection;
	/**
	 * nel costruttore ottengo il deck che desidero, creo la lista dei giocatori
	 * @param deck
	 * @param giocatore
	 * @param numberPlayers
	 */
	public GameStage(Deck deck,Giocatore giocatore,final int numberPlayers) {
		//TODO: eccezione, i gicatori devono essere almeno 2
		
		this.deck=deck;
		this.discards=DiscardCards.getInstance();
		this.numbersPlayers=numbersPlayers;//Numero di giocatori
		this.players=new ArrayList<>(); //lista di giocatori	
		this.gameDirection=false;    //giro settato a sinistra di default
		this.hands=new TreeMap<>();
		players.add(giocatore); //aggiungo giocatore mio
		//-1 perchè non devi contarti
		for(int k=0;k<numberPlayers-1;k++) {players.add(new GiocatoreArtificiale(k));}	//aggiunge gli artificiale con i nomi di default nella lista
		
	}
	

	//oservatore
	public  void nuovaMano() {
		
		this.setChanged(); 
		
		this.notifyObservers(hands);
	}
	
	
	public void nuovoMazziere() {
		this.setChanged(); 
		
		this.notifyObservers(players.get(currentPlayer).getNickname() );
	}
	
	public TreeMap<String,List<Card>> getHands(){
		return hands;
	}
	
	/**
	 * This method
	 * @return arraylist of players
	 */
	public ArrayList<Utente> getPlayers(){return this.players;}
	/**
	 * This method
	 * @return deck
	 */
	public Deck getDeck() {return this.deck;}
	/**
	 * This method
	 * @return index of current player
	 */
	public int getCurrentPlayer() {return this.currentPlayer;}
	/**
	 * This method
	 * @return game direction
	 */
	public boolean getGameDirection() {return this.gameDirection;}
	
	/**
	 * This method set the game direction
	 * @param boolean
	 * True:right
	 * False:left
	 */
	public void setGameDirection(boolean direction) {this.gameDirection=direction;}
	
	/**
	 * This method set the next player (1 position)
	 */
	public void setCurrentPlayer() {
		if(gameDirection==false) {
			currentPlayer=(currentPlayer-1)%players.size();
			if(currentPlayer==-1) currentPlayer=players.size()-1;}
		else currentPlayer=(currentPlayer+1)%players.size();
	}
	
	/**
	 * this method prepares the start of the game
	 */
	public void startGame() {
		this.currentPlayer=dealer(); //setto mazziere
		nuovoMazziere();
		deck.shuffle(); //mischio mazzo
		dealtCards(); //distribuisco carte
		firstDiscardCard();
		nuovaMano();
		
	}
	/**
	 * This method
	 * @return the index of dealer
	 */
	public int dealer() {
		
		List<Integer> valueCards=Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		Collections.shuffle(valueCards);
		int maxAt = 0; int index=0;
		valueCards=valueCards.subList(0, players.size());
		for (int i = 0; i < valueCards.size(); i++) {
			if (valueCards.get(i)>maxAt) { maxAt=valueCards.get(i); index=i;}}
		return index;
	}
	
	
	/**
	 * This method deals the 7 starting cards and it updates the deck
	 */
	public  void dealtCards() {
		for(int k=0;k<players.size();k++) {
			hands.put(players.get(k).getNickname(),deck.getDeck().subList(0, 7));
			deck.setDeck(new ArrayList<>(deck.getDeck().subList(7, deck.getSizeDeck())));
			
		}
	}
	
	/**
	 * This method 
	 * @param card
	 * @param index
	 * add card into pile of discards and removes tthe card from the deck
	 */
	private void addFromDeckToDiscards(Card card,int index) {
		discards.addCard(card);
		deck.removeCard(0);
	}
	
	public void drawCards(int numbersCards,int indexPlayer) {
		while(numbersCards-->0) {
		
			hands.get(players.get(indexPlayer).getNickname()).add(deck.getCard(0)); //add new card to player's hand
			deck.removeCard(0);
			  }	
	}
	
	/**
	 * This method adds the top card to the discard pile and updates the current player if needed
	 */
	//in questo momento il current player è ancora il mazziere
	public void firstDiscardCard() {
		Card card=deck.getCard(0);
		
		if (card.getTypeCard().equals("Value")) {
			addFromDeckToDiscards(card,0);
			setCurrentPlayer();
		}
		else if (card.getTypeCard().equals("Action")) {
			if (card.getAction().equals(Action.DRAWTWO)) {
				//la successiva pesca due carte  e il current diventa quello dopo ancora
				setCurrentPlayer();
				drawCards(2, currentPlayer);
				setCurrentPlayer();
				addFromDeckToDiscards(card,0);
				
			}
			else if (card.getAction().equals(Action.REVERSE)) {
				//il mazziere comincia e il gioco verso destra
				setGameDirection(true);
				addFromDeckToDiscards(card,0);
			}
			else if(card.getAction().equals(Action.SKIP)) {
				//il giocatore a sinistra del mazziere viene saltato e va quello ancora dopo
				setCurrentPlayer();setCurrentPlayer();
				addFromDeckToDiscards(card,0);
			}	
		}
		else if (card.getTypeCard().equals("Jolly")) {
			deck.getDeck().remove(0); deck.getDeck().add(card); firstDiscardCard(); //per ora se non gestisci lascio questo
			//if (card.getJolly().equals(Jolly.JOLLYDRAWFOUR)) {System.out.println("JOLLYDRAWFOUR");deck.getDeck().remove(0); deck.getDeck().add(card); firstDiscardCard();}//la carta viene rimessa dentro
			//else if (card.getJolly().equals(Jolly.JOLLY)) {addFromDeckToDiscards(card,0);}//il tizio a sinistra del mazziere sceglie il colore 
		}
		
		hands.put("Discards", discards.getDiscard());
	}


	

	//TODO: ROUND, una schermata che dice "procedere con il prossimo round e semplicemente istanzia una nuova partita
}
