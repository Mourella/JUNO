package View.Home;
import java.awt.Color;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultCaret;
import Model.GestioneUtente.User;



/**
 * This class represents the view for read stats of players
 * @author Davide Morelli
 *
 */
public class FrameStatistics extends JFrame {
	
	/**
	 * This field contains seriaVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This field contains saved players
	 */
	private Map<String, User> mapStatistics;
	/**
	 * This field contains a label
	 */
	private LabelBackgroundStatistics label;
	
	/**
	 * This constructor create FrameStatistics. Set size, label, icon.
	 */
	public FrameStatistics() {
	super("JUNO");
	setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	try {setIconImage(ImageIO.read(new File("Image\\altro\\Icon.png")));}
	catch (IOException e) {e.printStackTrace();}
	label=new LabelBackgroundStatistics(getMapStatistics());
	add(new JScrollPane(label,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
	pack();
	setLocationRelativeTo(null);
	setResizable(false);
	setVisible(true);

	
	}
	
	
	/**
	 * This method writes player statistics on the frame
	 */
	public void writeStatistics() {
		label.addStringStatistics(mapStatistics);
	}
	
	private  Map<String, User> getMapStatistics() {
		return mapStatistics;
	}

	/**
	 * This method set Map Statistics
	 * @param mapStatistics
	 */
	public void setMapStatistics(Map<String, User> mapStatistics) {
		this.mapStatistics = mapStatistics;
	}


	/**
	 * Inner class. This class create a label. I add this label in the frame.
	 * This label contains:
	 * Border, Buttons,JTextField
	 * @author Davide Morelli
	 *
	 */
	private class LabelBackgroundStatistics extends JLabel {

		/**
		 * This field contains seriaVersionUID
		 */
		private static final long serialVersionUID = 4582683071516221594L;	
		/**
		 * This field contains a JTextArea
		 */
		private JTextArea areaStatistics;
		/**
		 * This constructor create Label. Set all components in the label
		 */
		private LabelBackgroundStatistics(Map<String, User> mapStatistics) {
			super("Statistiche giocatori",new ImageIcon("Image\\altro\\Table_4.png"),CENTER);
			setLayout(null);
			
			//setTitle JUNO
			setForeground(Color.WHITE);
			setFont(new Font("Sans-serif",Font.BOLD,50));
			setHorizontalTextPosition(CENTER);
			setVerticalTextPosition(TOP);
			setIconTextGap(-70);
			
			//set JTextArea with scrool pane
			areaStatistics=new JTextArea();
			areaStatistics.setEditable(false);
			areaStatistics.setLineWrap(true);
			areaStatistics.setOpaque(false);
			areaStatistics.setForeground(Color.WHITE);
			areaStatistics.setFont(new Font("Sans-serif",Font.BOLD,50));
			DefaultCaret caret = (DefaultCaret)areaStatistics.getCaret(); caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE); //scorrimento automatico
			JScrollPane scroll = new JScrollPane(areaStatistics,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scroll.setBounds(120, 150 , 1050, 500);
			scroll.getViewport().setOpaque(false);
			scroll.setOpaque(false);
			scroll.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
			add(scroll);
			
			//create JTextFiedl
			JTextField nameColumns= new JTextField("Nickname Livello  Esperienza  Partite  Vinte  Perse");
			nameColumns.setEditable(false);
			nameColumns.setOpaque(false);
			nameColumns.setForeground(Color.WHITE);
			nameColumns.setFont(new Font("Sans-serif",Font.BOLD,30));
			nameColumns.setBounds(120,95, 1000, 60);
			nameColumns.setBorder(null);
			add(nameColumns);
		}
		/**
		 * This method add all players stats
		 * @param mapStatistics
		 */
		private void addStringStatistics(Map<String, User> mapStatistics) {
			 if (mapStatistics.isEmpty()) areaStatistics.append(" Non ci sono statistiche disponibili");
			 else {
			 for(Entry<String, User> m :getMapStatistics().entrySet()){
		           areaStatistics.append(" "+m.getKey()+" "+m.getValue().getStatistics()+"\n");  }}
		}
		}
	}
