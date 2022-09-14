package View.GameStage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * This class represents the JOptionPane useful for choosing the color of the wild cards
 * @author Davide Morelli
 *
 */
public class OptionPaneWild {
	private final JButton[] BUTTONS;
	private String colore;
	
	public OptionPaneWild() {
		JButton  red= new JButton();
		JButton blue= new JButton();
		JButton yellow= new JButton();
		JButton green= new JButton();
	    red.setBackground(Color.RED);
		red.setPreferredSize(new Dimension(40,40));
		blue.setPreferredSize(new Dimension(40,40));
		yellow.setPreferredSize(new Dimension(40,40));
		green.setPreferredSize(new Dimension(40,40));
		blue.setBackground(Color.BLUE);
		yellow.setBackground(Color.YELLOW);
		green.setBackground(Color.GREEN);
		this.BUTTONS = new JButton[]{ red,blue,yellow,green };
		red.addActionListener(listenerJOptionPane);
		red.setActionCommand("RED");
		blue.addActionListener(listenerJOptionPane);
		blue.setActionCommand("BLUE");
		yellow.addActionListener(listenerJOptionPane);
		yellow.setActionCommand("YELLOW");
		green.addActionListener(listenerJOptionPane);
		green.setActionCommand("GREEN");
	    
	}
	
	/**
	 * This method create an JOptionPane and customize it
	 */
	public void createOptionPane() {
		UIManager.put("OptionPane.background", Color.white);
		UIManager.put("Panel.background", Color.white);
		JOptionPane.showOptionDialog(null, null, "SCEGLI CON CHE COLORE CONTINUARE", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, BUTTONS, BUTTONS[0]);
	}
	
	/**
	 * This method @return a Color card
	 */
     public Model.GestioneDeck.Color getColorCard() {
    	switch(getColor()) {
 		case "BLUE": return  Model.GestioneDeck.Color.BLUE;
 		case "GREEN": return Model.GestioneDeck.Color.GREEN;
 		case "RED": return Model.GestioneDeck.Color.RED;
 		case "YELLOW": return Model.GestioneDeck.Color.YELLOW;
 		}
		return null;
 	
     }
	
	private String getColor() {return colore;}

	private void setColor(String color) {this.colore = color;}

	/**
	 * Anonymous class for listener 
	 */
	private ActionListener listenerJOptionPane = new ActionListener()
	    {
	        public void actionPerformed(ActionEvent e) 
	        {
	            setColor(e.getActionCommand());
	            JOptionPane.getRootFrame().dispose();
	           
	        }
	    };

}
