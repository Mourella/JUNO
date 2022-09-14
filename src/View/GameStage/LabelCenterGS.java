package View.GameStage;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Controller.ActionListener.ActionListenerLabelCenter;
import Model.GestioneDeck.Card;
import Model.GestioneUtente.User;
/**
 * 
 * @author Davide Morelli
 *This class is a container for the centre of Frame.
 *It contains discards and three buttos: Juno, deck , skip turn
 */
class LabelCenterGS extends JLabel implements ScaledIcon {
	
	/**
	 * This field contains seriaVersionUID
	 */
	private static final long serialVersionUID = -7744949427186861941L;
	/**
	 * This field contains list of cards
	 */
	private List<Card> cards;
	/**
	 * This field contains JTextField
	 */
	private JTextField realPlayer,botSx,botUp,botDx;
	/**
	 * This field contains index of current player
	 */
	private int indexTurn;
	/**
	 * This field contains JLabel
	 */
	private JLabel avatarBotSx,avatarBotDx,avatarBotUp, avatarRealPlayer,discards;
	
	/**
	 * Constructor of this class
	 * @param card
	 * @param players
	 * Set card, players, size, buttons, JTextFiedl and labels
	 */
	LabelCenterGS(List<Card> card,List<User> players) {
		setLayout(null);
		this.cards=card;
		addDiscard();
	
		//Buttons deck, pass, juno
		JButton deck = new JButton(new ImageIcon(ScaledIcon.setIconLabel("Image\\Cards\\Deck.png",70,90)));
		deck.setBounds(430, 215, 70, 90);
		deck.setContentAreaFilled(false);
		deck.setBorder(null);
		deck.setActionCommand("Deck");
		deck.addActionListener(ActionListenerLabelCenter.getInstance());
		JButton pass= new JButton("Passa");
		pass.setBounds(900,450,60,60);
		pass.setContentAreaFilled(false);
		pass.setForeground(Color.WHITE);
		pass.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
		pass.addActionListener(ActionListenerLabelCenter.getInstance());
		add(pass);
		JButton buttonJUNO=new JButton("JUNO!");
		buttonJUNO.setBounds(800,450,60,60);
		buttonJUNO.setContentAreaFilled(false);
		buttonJUNO.setForeground(Color.WHITE);
		buttonJUNO.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
		buttonJUNO.addActionListener(ActionListenerLabelCenter.getInstance());
		add(buttonJUNO);
		add(discards);
		add(deck);
		
		//Field for nickname of the players and label for the avatars
		realPlayer=new JTextField(players.get(0).getNickname());
		realPlayer.setFont(new Font("Sans-serif",Font.BOLD,20));
		realPlayer.setForeground(Color.WHITE);
		realPlayer.setBounds(470, 475, 150, 50);
		realPlayer.setHorizontalAlignment(JTextField.CENTER);
		realPlayer.setFocusable(false);
		realPlayer.setOpaque(false);
		realPlayer.setBorder(null);
		add(realPlayer);
		avatarRealPlayer= new JLabel(new ImageIcon(players.get(0).getPathAvatar()));
		avatarRealPlayer.setBounds(495, 380, 100, 100);
		add(avatarRealPlayer);
		
		botSx=new JTextField(players.get(3).getNickname());
		botSx.setFont(new Font("Sans-serif",Font.BOLD,20));
		botSx.setForeground(Color.WHITE);
		botSx.setBounds(40, 280, 150, 50);
		botSx.setBorder(null);
		botSx.setHorizontalAlignment(JTextField.CENTER);
		botSx.setFocusable(false);
		botSx.setOpaque(false);
		add(botSx);
		avatarBotSx= new JLabel(new ImageIcon(players.get(3).getPathAvatar()));
		avatarBotSx.setBounds(65, 180, 100, 100);
		add(avatarBotSx);
		
		
		botUp=new JTextField(players.get(2).getNickname());
		botUp.setFont(new Font("Sans-serif",Font.BOLD,20));
		botUp.setForeground(Color.WHITE);
		botUp.setBounds(470, 0, 150, 50);
		botUp.setHorizontalAlignment(JTextField.CENTER);
		botUp.setFocusable(false);
		botUp.setOpaque(false);
		botUp.setBorder(null);
		add(botUp);
		avatarBotUp= new JLabel(new ImageIcon(players.get(2).getPathAvatar()));
		avatarBotUp.setBounds(495, 50, 100, 100);
		add(avatarBotUp);
		
		botDx=new JTextField(players.get(1).getNickname());
		botDx.setFont(new Font("Sans-serif",Font.BOLD,20));
		botDx.setForeground(Color.WHITE);
		botDx.setBounds(880, 280, 150, 50);
		botDx.setBorder(null);
		botDx.setHorizontalAlignment(JTextField.CENTER);
		botDx.setFocusable(false);
		botDx.setOpaque(false);
		add(botDx);
		avatarBotDx= new JLabel(new ImageIcon(players.get(1).getPathAvatar()));
		avatarBotDx.setBounds(905, 180, 100, 100);
		add(avatarBotDx);
	}
	
	/**
	 * This method set the turn of curret player
	 * @param index
	 */
	void setIndexTurn(int index) {
		this.indexTurn=index;
	}
	
	/**
	 * 
	 * @return index of current player
	 */
	int getIndexTurn() { return indexTurn;}
	
	/**
	 * 
	 * @return JLabel of discards
	 */
	JLabel getDiscards() {
		return discards;
	}
	
	/**
	 * This method colors the current player with red
	 */
	void turnPlayers() {

		botDx.setOpaque(false); avatarBotDx.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
		botUp.setOpaque(false); avatarBotUp.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
		botSx.setOpaque(false); avatarBotSx.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
		realPlayer.setOpaque(false); avatarRealPlayer.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
		switch(indexTurn) {
		case 0 -> {realPlayer.setOpaque(true);realPlayer.setBackground(Color.RED); avatarRealPlayer.setBorder(BorderFactory.createLineBorder(Color.RED, 4)); }
		case 1 -> {botDx.setOpaque(true); botDx.setBackground(Color.RED);  avatarBotDx.setBorder(BorderFactory.createLineBorder(Color.RED, 4));}
		case 2 -> {botUp.setOpaque(true);botUp.setBackground(Color.RED); avatarBotUp.setBorder(BorderFactory.createLineBorder(Color.RED, 4));}
		case 3 -> {botSx.setOpaque(true); botSx.setBackground(Color.RED); avatarBotSx.setBorder(BorderFactory.createLineBorder(Color.RED, 4));}
		}
	}
	
	/**
	 * this method update and add deck of discards
	 */
	void addDiscard() {
		discards=new JLabel((new ImageIcon(ScaledIcon.setIconLabel("Image\\Cards\\"+(cards.get(cards.size()-1))+".png",70,90))));
		discards.setBounds(580, 210, 100, 100);
		add(discards);
	}
}
