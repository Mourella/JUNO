package View.Home;


import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import Controller.ActionListener.ActionListenerHome;

import javax.swing.WindowConstants;

/**
 * This class represents the view for the Home
 * @author Davide Morelli
 *
 */
public class FrameHome extends JFrame {

	/**
	 * This field contains seriaVersionUID
	 */
	private static final long serialVersionUID=1L;
	/**
	 * This constructor create FrameHome. Set size, label, icon.
	 */
	public FrameHome() {
		super("JUNO");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		add(new LabelBackgroundHome());
		try {setIconImage(ImageIO.read(new File("Image\\altro\\Icon.png")));}
		catch (IOException e) {e.printStackTrace();}
		pack();
		setSize(1100,699);
		setLocationRelativeTo(null);
		setResizable(false);
	
	}
	/**
	 * Inner class. This class create a label. I add this label in the frame.
	 * This label contains:
	 * Border, Buttons,JTextField
	 * @author Davide Morelli
	 *
	 */
	private class LabelBackgroundHome extends JLabel {

		/**
		 * This field contains seriaVersionUID
		 */
		private static final long serialVersionUID = 4582683071516221594L;
		/**
		 * This field contains JButtons
		 */
		private JButton gioca,aiuto,statistiche;
		
		/**
		 * This constructor create Label. Set all components in the label
		 */
		private LabelBackgroundHome() {
			super("Juno",new ImageIcon("Image\\altro\\Table_0.png"),CENTER);
			setLayout(null);
			
			//setTitle JUNO
			setForeground(Color.WHITE);
			setFont(new Font("Sans-serif",Font.BOLD,200));
			setHorizontalTextPosition(CENTER);
			setVerticalTextPosition(TOP);
			setIconTextGap(-250); 
			
			//buttons
			gioca=new JButton("Gioca");
			gioca.setBounds(445,220, 200, 100);
			gioca.setActionCommand("Gioca");
			gioca.setContentAreaFilled(false);
			gioca.setForeground(Color.WHITE);
			gioca.setFont(new Font("Sans-serif",Font.BOLD,20));
			gioca.setFocusable(false);
			gioca.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
			gioca.addActionListener(ActionListenerHome.getInstance());
			add(gioca);

			aiuto= new JButton("Come giocare");
			aiuto.setBounds(445, 470, 200, 100);
			aiuto.setContentAreaFilled(false);
			aiuto.setFocusable(false);
			aiuto.setForeground(Color.WHITE);
			aiuto.setFont(new Font("Sans-serif",Font.BOLD,20));
			aiuto.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
			aiuto.addActionListener(ActionListenerHome.getInstance());
			add(aiuto);
			
			
			statistiche=new JButton("Statistiche");
			statistiche.setBounds(445, 345, 200, 100);
			statistiche.setContentAreaFilled(false);
			statistiche.setFocusable(false);
			statistiche.setForeground(Color.WHITE);
			statistiche.setFont(new Font("Sans-serif",Font.BOLD,20));
			statistiche.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
			statistiche.addActionListener(ActionListenerHome.getInstance());
			add(statistiche);
		
		}
		}

}
