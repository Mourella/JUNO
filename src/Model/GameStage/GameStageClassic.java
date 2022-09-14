package Model.GameStage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;
import Model.GestioneDeck.Card;
import Model.GestioneDeck.Color;
import Model.GestioneDeck.Deck;
import Model.GestioneDeck.Wild;
import Model.GestioneUtente.RealPlayer;
import Model.GestioneUtente.SaveLoadData;

/**
 * This class represents a game stage mode classic
 * @author Davide Morelli
 *
 */
public class GameStageClassic extends GameStage{


	/**
	 * This field contains an object Random
	 */
	private Random random=new Random();
	
	/**
	 * Constructor of this class, it builds an instance of a game stage mode classic
	 * @param deck
	 * @param giocatore
	 * @param numberPlayers
	 * @throws PlayersException 
	 */
	public GameStageClassic(Deck deck, RealPlayer giocatore, int numberPlayers) throws PlayersException {
		super(deck, giocatore, numberPlayers);}


	/**
	 * This method prepares the start of the game
	 */
	@Override
	public void prepareGame() {
		this.currentPlayer=dealer(); //set dealer
		DECK.shuffle(); //shuffle deck
		dealtCards(7); //dealts cards
		firstDiscardCard();
		this.setEvent(getDealer()+" estrae "+discards.getLastCard()+"-"+discards.getLastCard().getColor());
		updateOb();	
		
	}
	
	/**
	 * This method @return the index of dealer
	 */
	@Override
	public int dealer() {
		List<Integer> valueCards=Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		Collections.shuffle(valueCards);
		int maxAt = 0; int index=0;
		valueCards=valueCards.subList(0, PLAYERS.size());
		for (int i = 0; i < valueCards.size(); i++) {
			if (valueCards.get(i)>maxAt) { maxAt=valueCards.get(i); index=i;}}
		dealer=PLAYERS.get(index).getNickname();
		return index;
	}
	

	/**
	 * This method adds the top card to the discard pile and updates the current player if needed
	 */
	  @Override
	  void firstDiscardCard() {
		while(DECK.getCard(0).getTypeCard().equals("Wild")){DECK.shuffle();} //affinchè la prima carta è uguale a WILDFDRAWFOUR mischia il mazzo così come da regolamento
		Card card=DECK.getCard(0);
		cardsEffects(card);
		addFromDeckToDiscards(card,0);//questo perchè va negli scarti come prima carta
		handsCards.put("Discards", discards.getDiscard());
	  }
	
	

	  /**
	  * This method checks which cards the player can play according to the rules of the mode @return playable cards
	  */
	@Override
	public List<Card> checkHand() {	
		Card lastDiscard= discards.getLastCard();
		Color color=lastDiscard.getColor(); 
		var card=lastDiscard.getTypeCard().equals("Action")? lastDiscard.getAction() :
			lastDiscard.getTypeCard().equals("Wild")? lastDiscard.getWild():lastDiscard.getValue();
		
		
		var carteGiocabili= this.getHands().get(getPlayers().get(currentPlayer).getNickname())
		.stream().filter(x-> x.getValue()==card || x.getAction()==card || x.getColor()==color || x.getTypeCard()=="Wild").collect(Collectors.toList());
	
		
		return carteGiocabili.stream().filter(x->x.getColor()==discards.getLastCard().getColor()).count()>0? 
			       carteGiocabili.stream().filter(x->x.getWild()!=Wild.WILDDRAWFOUR).collect(Collectors.toList()):carteGiocabili;	
	}
	
	/**
	 * This method contains a timer for the bot player to play
	 */
	public void playGame() {
	
			if ((!win)) {
			
			new Timer().schedule(new TimerTask() 
				{
				@Override
				public void run() {playBot();}
						}, 5000);}}
			
				
	/**
	 * This method manages the behavior of the bot
	 */
	@Override
	void playBot()  {
			
		Card cartaGiocata = null;
		String lastPlayer=PLAYERS.get(getCurrentPlayer()).getNickname();
		int lastPlayerIndex=getCurrentPlayer();
	    List<Card> carteGiocabili=checkHand();

		if (carteGiocabili.isEmpty()) {      //no cards playable	 	
						setEvent(lastPlayer+" pesca una carta\n"); //set event
					drawCards(1, getCurrentPlayer()); //draw cards
			
					carteGiocabili=checkHand();  //check playable cards
				
					if (carteGiocabili.isEmpty()) setCurrentPlayer(); //empty? skip turn
					else { //no empty play card and update hands
						
						cartaGiocata=carteGiocabili.get(random.nextInt(0,carteGiocabili.size()));
						handsCards.get(PLAYERS.get(getCurrentPlayer()).getNickname()).remove(cartaGiocata); 
						checkWin();
						cardsEffects(cartaGiocata); 
					
						setEvent(handsCards.get(PLAYERS.get(lastPlayerIndex).getNickname()).size()==1? lastPlayer+" ha gridato JUNO!\n"
								:lastPlayer+" ha giocato "+cartaGiocata+"-"+cartaGiocata.getColor());
						}
						}
				else {
					cartaGiocata=carteGiocabili.get(random.nextInt(0,carteGiocabili.size()));
	
					handsCards.get(PLAYERS.get(getCurrentPlayer()).getNickname()).remove(cartaGiocata); 
					checkWin();
					cardsEffects(cartaGiocata);
					//check whether to say Juno or not
					setEvent(handsCards.get(PLAYERS.get(lastPlayerIndex).getNickname()).size()==1? lastPlayer+" ha gridato JUNO!\n"
							:lastPlayer+" ha giocato "+cartaGiocata+"-"+cartaGiocata.getColor());}
			    if (cartaGiocata!=null) {discards.addCard(cartaGiocata);}	
	    updateOb();//update observer
	
	    if (getCurrentPlayer()>0) playGame();
		}
	

	/**
	 * This method manages the behavior of the real player
	 * @param cartaGiocata by the player
	 */
	@Override
	public void playUser(Card cartaGiocata) {
		String lastPlayer=PLAYERS.get(getCurrentPlayer()).getNickname();
		handsCards.get(PLAYERS.get(0).getNickname()).remove(cartaGiocata);
		checkWin();
		cardsEffects(cartaGiocata);
		setEvent(lastPlayer+" ha giocato "+cartaGiocata+"-"+cartaGiocata.getColor());
		discards.addCard(cartaGiocata);
		updateOb(); //update observer
	}
	
	
	/**
	 * This method manages card effects in this mode
	 * @param cartaGiocata by player
	 */
	@Override
	void cardsEffects(Card cartaGiocata) {
		
		if (cartaGiocata.getTypeCard().equals("Action")) {
			switch(cartaGiocata.getAction()) {
				case DRAWTWO -> {setCurrentPlayer();drawCards(2, currentPlayer);setCurrentPlayer();}
				case REVERSE -> {
							if(discards.getDiscard().size()!=0) {setGameDirection(); setCurrentPlayer();}
							else setGameDirection(); 
									} 
				case SKIP ->  {setCurrentPlayer(); setCurrentPlayer();}
			}
		}
		else if (cartaGiocata.getTypeCard().equals("Value"))  setCurrentPlayer(); 
		else if (cartaGiocata.getTypeCard().equals("Wild")) {
			switch(cartaGiocata.getWild()) {
				case WILD -> {

					if (getCurrentPlayer()!=0) cartaGiocata.setColor(Color.values()[random.nextInt(0,Color.values().length)]); setCurrentPlayer();
					}
				case WILDDRAWFOUR -> {
					if (getCurrentPlayer()!=0) cartaGiocata.setColor(Color.values()[random.nextInt(0,Color.values().length)]);
					setCurrentPlayer();
					drawCards(4, getCurrentPlayer());
					updateOb();  //update observer
					setCurrentPlayer();}
										}
									}
				}

	
	/**
	 * This method check after each move if the player whose turn it is has won the game. 
	 * In any case, it updates the statistics of the real player.Notify observer of the change
	 */
	@Override
	void checkWin()  {
		if (handsCards.get(PLAYERS.get(getCurrentPlayer()).getNickname()).isEmpty()){
			win=true;
			if (getCurrentPlayer()==0) PLAYERS.get(0).getStatistics().setGamesWin();
			else PLAYERS.get(0).getStatistics().setGamesLose();
			SaveLoadData.getInstance().updateUserStatistics(PLAYERS.get(0));
			SaveLoadData.getInstance().updatePlayersDataOB();
			updateOb();
			updateWinOb();}
			}

	
	

	

}
