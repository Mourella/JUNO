package View.GameStage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

import Controller.ActionListener.ActionListenerHome;




/**
 * This class represents the label top. It contains a JTextArea, JTextField for the dealer and help button
 * @author Davide Morelli
 *
 */
class LabelTopGS extends JLabel {
	/**
	 * This field contains seriaVersionUID
	 */
	private static final long serialVersionUID = 1232010768248325713L;
	/**
	 * This field contains JTextField
	 */
	private JTextField mazziere;
	/**
	 * This field contains JTextArea
	 */
	private JTextArea areaEvents;
	/**
	 * This field contains an object calendar
	 */
	private Calendar calendar; 
	/**
	 * This field contains an simple date format
	 */
	private SimpleDateFormat dateFormat;


	/**
	 * Constructor of this class 
	 * @param dealer
	 */
    LabelTopGS(String dealer) {
		super(new ImageIcon("Image\\altro\\LabelTopBar.png"));
		setLayout(null);
		setBackground(Color.white);
		setOpaque(true);
		setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		setPreferredSize(new Dimension(20,70));
		
		TitledBorder borderMazziere = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE, 3),"Mazziere",2,0);
		borderMazziere.setTitleColor(Color.WHITE);
	
		//JtextField for the dealer
		mazziere=new JTextField(dealer);
		mazziere.setFont(new Font("Sans-serif",Font.BOLD,30));
		mazziere.setHorizontalAlignment(JTextField.CENTER);
		mazziere.setBorder(borderMazziere);
		mazziere.setForeground(Color.WHITE);
		mazziere.setFocusable(false);
		mazziere.setOpaque(false);
		mazziere.setBounds(10, 1 , 200, 60);
		add(mazziere);
	
		//buttons
		JButton aiuto=new JButton("?");
		aiuto.setFont(new Font("Sans-serif",Font.BOLD,30));
		aiuto.setForeground(Color.WHITE);
		aiuto.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		aiuto.setFocusable(false);
		aiuto.setContentAreaFilled(false);
		aiuto.setBounds(1200, 4, 60, 60);
		aiuto.addActionListener(ActionListenerHome.getInstance());
		aiuto.setActionCommand("Come giocare");
		add(aiuto);
		
		//JTextArea
		areaEvents=new JTextArea();
		areaEvents.setEditable(false);
		areaEvents.setLineWrap(true);
		areaEvents.setOpaque(false);
		DefaultCaret caret = (DefaultCaret)areaEvents.getCaret(); caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE); //scorrimento automatico
		JScrollPane scroll = new JScrollPane(areaEvents,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(380, 4 , 500, 60);
		scroll.getViewport().setOpaque(false);
		scroll.setOpaque(false);
		scroll.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		add(scroll);
		
		calendar=Calendar.getInstance(); 
		calendar.add(Calendar.HOUR_OF_DAY, 0);
		dateFormat = new SimpleDateFormat("HH:mm");

	}
	
    /**
     * This method adds lines in the JTextArea. 
     * @param event
     */
	void addLineAreaEvents(String event) {
		calendar=Calendar.getInstance(); 
		calendar.add(Calendar.HOUR_OF_DAY, 0);
		
		if (event.contains("-")) {
			String events=event.split("-")[0];
			String color=event.split("-")[1];
			switch(color) {
			case "YELLOW" -> areaEvents.setForeground(Color.YELLOW);
			case "BLUE" -> areaEvents.setForeground(Color.BLUE);
			case "RED" ->areaEvents.setForeground(Color.RED);
			case "GREEN" ->areaEvents.setForeground(Color.GREEN);
			}
			areaEvents.append(" "+dateFormat.format(calendar.getTime())+" "+events+" "+color+"\n");}
		else {areaEvents.setForeground(Color.WHITE); areaEvents.append(" "+dateFormat.format(calendar.getTime())+" "+event);}
		
	}
}
