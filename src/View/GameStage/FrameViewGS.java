package View.GameStage;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import Model.GestioneDeck.Card;
import Model.GestioneUtente.User;
/**
 *  This class represent a frame for the game stage
 * @author Davide Morelli
 */
public class FrameViewGS extends JFrame {
	
	/**
	 * This field contains seriaVersionUID
	 */
	private static final long serialVersionUID = 4777569774138519934L;
	/**
	 * This field contains MainLabel (JLabel)
	 */
	private MainLabelGS mainLabelGS;
	/**
	 * This field contains LabelTopGS (JLabel)
	 */
	private LabelTopGS labelTopGS;
	
	/**
	 * This constructor create FrameViewGS. Set size, labels, icon.
	 */
	public FrameViewGS(TreeMap<String,List<Card>> mapCards,String dealer,List<User> players) {
		super("JUNO");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		try {setIconImage(ImageIO.read(new File("Image\\altro\\Icon.png")));}
		catch (IOException e) {e.printStackTrace();}
		mainLabelGS=new MainLabelGS(mapCards,players);
		labelTopGS=new LabelTopGS(dealer);
		add(labelTopGS,BorderLayout.PAGE_START);
		add(mainLabelGS,BorderLayout.CENTER);
		pack();  
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	}
	
	/**
	 * This method create JOptionPane when a player wins the game
	 * @param nickname
	 */
	public void gameWin(String nickname) {
		JOptionPane.showMessageDialog(null, nickname+" "+ "ha vinto la partita\nTorna alla home per giocare di nuovo!");
		this.dispose();
		}
	
	/**
	 * This method update JTextArea events
	 * @param event
	 */
	public void updateAreaEvents(String event) {labelTopGS.addLineAreaEvents(event);}
	
	/**
	 * This method set the current player
	 * @param index
	 */
	public void setTurn(int index) {mainLabelGS.setTurnLabelCenterGS(index);}
	
	/**
	 * This method update MainLabel
	 * @param event
	 */
	public void updateMainLabelGS() {
		mainLabelGS.updateTurns();
		mainLabelGS.updateDiscards();
		mainLabelGS.updatePlayerHand();
		mainLabelGS.updatePlayerHandBot();
	}
	

}
