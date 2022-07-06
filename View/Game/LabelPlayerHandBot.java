package View.Game;

import java.awt.Dimension;
import java.awt.FlowLayout;


import javax.swing.ImageIcon;

import javax.swing.JLabel;


//TODO: maggiori di un tot di carte non si creano più, minori si tolgono
public class LabelPlayerHandBot extends JLabel implements ScaledIcon {


	private static final long serialVersionUID = 3344713034003073176L;
	private String nameIcon;
	private int labelHeight,labelWidth,sizeHand;
	
	
	public LabelPlayerHandBot(int buttonHeight, int buttonWidth,String nameIcon,int sizeHand) {
		this.nameIcon=nameIcon;
		this.labelHeight=buttonHeight;
		this.labelWidth=buttonWidth;
		this.sizeHand=sizeHand;
		
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(100,100)); //size JLabel
		addButton();
		//setOpaque(true);
	}
	
	public void addButton() {
		for (int k=0;k<this.sizeHand;k++) {
			add(new JLabel(new ImageIcon(ScaledIcon.setIconLabel("C:\\Users\\Davide Morelli\\Desktop\\Sapienza\\Java2k22\\JUNO\\Image\\"+nameIcon,labelHeight,labelWidth))));
		}
	}
}
