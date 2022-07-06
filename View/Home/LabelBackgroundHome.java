package View.Home;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class LabelBackgroundHome extends JLabel {

	private static final long serialVersionUID = 4582683071516221594L;
	private JButton gioca,aiuto,giocatori;
	
	public LabelBackgroundHome() {
		super("Juno",new ImageIcon("C:\\Users\\Davide Morelli\\Desktop\\Sapienza\\Java2k22\\JUNO\\Image\\Table_0.png"),CENTER);
		setLayout(null);
		
		//setTitle JUNO
		setForeground(Color.WHITE);
		setFont(new Font("Sans-serif",Font.BOLD,200));
		setHorizontalTextPosition(CENTER);
		setVerticalTextPosition(TOP);
		setIconTextGap(-250); //posizione testo
		
		//bottoni
		gioca=new JButton(new ImageIcon("C:\\Users\\Davide Morelli\\Desktop\\Sapienza\\Java2k22\\JUNO\\Image\\BGiocaHome.png"));
		gioca.setBounds(445,200, 200, 100);
		add(gioca);
		Icon icona=new ImageIcon("C:\\Users\\Davide Morelli\\Desktop\\Sapienza\\Java2k22\\JUNO\\Image\\prova.png");
		
		aiuto= new JButton(icona);
		
		//vedi setPressedIcon

		aiuto.setBounds(445, 325, 200, 100);
		add(aiuto);
		giocatori=new JButton("giocatori");
		giocatori.setBounds(445, 450, 200, 100);
		add(giocatori);
		//TODO: migliora qualità bottoni. How to improve quality of icon

	
		
		
	
	
		
	
		
		
	
		
	
	}

	
	
	
	
	
	}