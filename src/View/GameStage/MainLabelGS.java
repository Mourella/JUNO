package View.GameStage;


import java.awt.BorderLayout;
import java.util.List;
import java.util.TreeMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Model.GestioneDeck.Card;
import Model.GestioneUtente.User;

/**
 * This class is the label most important for the FrameViewGS
 */
class MainLabelGS extends JLabel {

	/**
	 * This field contains seriaVersionUID
	 */
	private static final long serialVersionUID = -1859874002422896962L;
	/**
	 * This field contains LabelPlayerHand for the real player
	 */
	private LabelPlayerHand labelPlayerHand;
	/**
	 * This field contains LabelPlayerHandBot for the bot player
	 */
	private LabelPlayerHandBot lphb4,lphb3,lphb2;
	/**
	 * This field contains LabelCenterGS for the deck, discards and buttons
	 */
	private LabelCenterGS labelCenterGS;
	
	/**
	 * Constructor of this class
	 * @param mapCards
	 * @param players
	 * add labels and sets size
	 */
	MainLabelGS(TreeMap<String,List<Card>> mapCards,List<User> players) {
		super(new ImageIcon("Image\\altro\\Table_4.png"));
		setLayout(new BorderLayout());	
			
		labelCenterGS=new LabelCenterGS(mapCards.get("Discards"),players);
		add(labelCenterGS,BorderLayout.CENTER);
		
		//me
		labelPlayerHand=new LabelPlayerHand(mapCards.get(players.get(0).getNickname()));
		add(labelPlayerHand,BorderLayout.PAGE_END);	
		
		//sx 
		lphb2=new LabelPlayerHandBot(60,40,"DeckHoDx.png",mapCards.get(players.get(3).getNickname()));
		add(lphb2,BorderLayout.LINE_START); 
		
		lphb3=new LabelPlayerHandBot(40,60,"DeckDown.png",mapCards.get(players.get(2).getNickname()));
		add(lphb3,BorderLayout.PAGE_START);
		//dx
		lphb4=new LabelPlayerHandBot(60,40,"DeckHoSx.png",mapCards.get(players.get(1).getNickname()));
		add(lphb4,BorderLayout.LINE_END);	
	
	}
	
	/**
	 * This method set turn of the current player in the labelCenterGS
	 * @param index
	 */
	void setTurnLabelCenterGS(int index) {labelCenterGS.setIndexTurn(index);}
	
	/**
	 * This method update labelCenterGS with the turn od current player
	 * @param index
	 */
	void updateTurns() {
		labelCenterGS.turnPlayers();
		labelCenterGS.updateUI();}
	/**
	 * This method update discards in the labelCenterGS
	 * @param index
	 */
	void updateDiscards() {
		labelCenterGS.remove(labelCenterGS.getDiscards());
		labelCenterGS.addDiscard();
		labelCenterGS.updateUI();
	}
	
	/**
	 * This method update cards in the LabelPlayerHandBot
	 */
	void updatePlayerHandBot() {
		lphb2.removeAll();
		lphb3.removeAll();
		lphb4.removeAll();
		lphb2.addJLabel();lphb2.updateUI();
		lphb3.addJLabel();lphb3.updateUI();
		lphb4.addJLabel();lphb4.updateUI();
	}
	/**
	 * This method update cards in the LabelPlayerHand
	 */
	void updatePlayerHand() {
		labelPlayerHand.removeAll();
		labelPlayerHand.addButton();
		labelPlayerHand.updateUI();
	}

}
