package View.Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class LabelTopGS extends JLabel {
	
	public LabelTopGS(String stringa) {
		
	setLayout(null);
	setBackground(Color.white);
	setOpaque(true);
	
	setText("   Mazziere: "+stringa);
	setPreferredSize(new Dimension(20,50));
	

	}
}
