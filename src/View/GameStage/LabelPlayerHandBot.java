package View.GameStage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Model.GestioneDeck.Card;



/**
 * 
 * @author Davide Morelli
 *This class is label for  bot  player cards
 *It contains cards.
 */
class LabelPlayerHandBot extends JLabel implements ScaledIcon {

	/**
	 * This field contains seriaVersionUID
	 */
	private static final long serialVersionUID = 3344713034003073176L;
	/**
	 * This field contains path for the icon
	 */
	private final String NAME_ICON;
	/**
	 * This field contains size for the labels (cards)
	 */
	private final int LABEL_HEIGHT,LABEL_WIDTH; 
	/**
	 * This field contains list of cards
	 */
	private List<Card> cards;
	
	/**
	 * Constructor of this class. Set size and adds the labels
	 * @param buttonHeight
	 * @param buttonWidth
	 * @param nameIcon
	 * @param list
	 */
	LabelPlayerHandBot(int buttonHeight, int buttonWidth,String nameIcon,List<Card> list) {
		this.NAME_ICON=nameIcon;
		this.LABEL_HEIGHT=buttonHeight;
		this.LABEL_WIDTH=buttonWidth;
		this.cards=list;
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(90,90)); //size JLabel
		addJLabel();
		
	}
	/**
	 * This method adds the labels that represent the cards
	 */
	void addJLabel() {
		int size= cards.size()>10 ? 10:cards.size();
		for (int k=0;k<size;k++) {
			add(new JLabel(new ImageIcon(ScaledIcon.setIconLabel("Image\\Cards\\"+NAME_ICON,LABEL_HEIGHT,LABEL_WIDTH))));
		}
	}
}
