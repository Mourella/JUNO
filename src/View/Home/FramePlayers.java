package View.Home;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import Controller.ActionListener.ActionListenerPlayers;
import Model.GestioneUtente.RealPlayer;
import Model.GestioneUtente.User;

/**
 * This class represents the view for the choice of players
 * @author Davide Morelli
 *
 */
public class FramePlayers extends JFrame {
	
	/**
	 * This field contains seriaVersionUID
	 */
	private static final long serialVersionUID = -5800288961668033410L;
	/**
	 * This field contains a label
	 */
	private LabelBackgroundPlayers label;
	/**
	 * This field contains saved players
	 */
	private Map<String, User> mapPlayers;
	/*
	 * This field contains an instance of the RealPlayers
	 */
	private RealPlayer utenteScelto;
	/*
	 * This field contains an JTextField
	 */
	private JTextField createPlayer;
	/*
	 * This field contains path for the avatar
	 */
	private String avatar;
	
	
	/**
	 * This constructor create FramePlayers. Set size, label, icon.
	 */
	public FramePlayers() {
		super("Scegli giocatori");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		try {setIconImage(ImageIO.read(new File("Image\\altro\\Icon.png")));}
		catch (IOException e) {e.printStackTrace();}
		label=new LabelBackgroundPlayers();
		add(label);
		pack();
		setSize(1100,699);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		}
		
	/**
	 * 
	 * This method @return an user
	 */
	public RealPlayer getUtenteScelto() {return utenteScelto;}
	
	/**
	 * This method writes players on JTextArea
	 */
	public void writePlayers() {label.addButtonsPlayers();}

	/**
	 * This method set saved player thank to observer: "ObserverStatistics"
	 * @param mapPlayers
	 */
	public void setMapPlayers(Map<String, User> mapPlayers) {this.mapPlayers = mapPlayers;}

	/**
	 * This method @return JTextField
	 */
	public JTextField getTextFieldCreatePlayer() {return createPlayer;}
	
	/**
	 * This method updates the label
	 */
	public void updateLabelSavedPlayers() {
		label.removeAll();
		label.createLabel();
		writePlayers();
		label.updateUI();
	}
	
	/**
	 * This method @return path of the avatar
	 */
	public String getAvatar() {return avatar;}

	//Anonymous class. It represents a listener of this label
	private ActionListener listenerFramePlayers = new ActionListener()
    {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().contains("avatar")) avatar=e.getActionCommand();
			else utenteScelto=(RealPlayer) mapPlayers.get(e.getActionCommand());} 
    };
	
	
	
	/**
	 * Inner class. This class create a label. I add this label in the frame.
	 * This label contains:
	 * Border, Buttons,JTextField
	 * @author Davide Morelli
	 *
	 */
	private class LabelBackgroundPlayers extends JLabel {

		/**
		 * This field contains seriaVersionUID
		 */
		private static final long serialVersionUID = 4582683071516221594L;
		/*
		 * This field contains two JLabel
		 */
		private JLabel savedPlayers,avatar;
		
		/**
		 * Constructor of this class. Create label
		 */
		private LabelBackgroundPlayers() {
			super(new ImageIcon("Image\\altro\\Table_4.png"),CENTER);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);	
			setLayout(null);
			createLabel();
		}
		/**
		 * This private method, add all components in the label
		 */
		private void createLabel() {
			savedPlayers=new JLabel();
			savedPlayers.setLayout(new GridLayout(5,0));
			TitledBorder borderSavedPlayers=BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE, 3)," Seleziona un profilo salvato ",2,0);
			TitledBorder borderCreatePlayers=BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE, 5)," Create un nuovo giocatore ",2,0);
			TitledBorder borderCreateNickname=BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE, 3)," Inserisci un nickname ",2,0);
			
			borderSavedPlayers.setTitleColor(Color.WHITE);
			borderCreatePlayers.setTitleColor(Color.WHITE);
			borderCreateNickname.setTitleColor(Color.WHITE);
			
			JLabel cornice= new JLabel();
			cornice.setBounds(85,280,900,250);
			cornice.setOpaque(false);
			cornice.setBorder(borderCreatePlayers);
			add(cornice);
			
			JScrollPane scroll = new JScrollPane(savedPlayers,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setBounds(85, 40 , 900, 200);
			scroll.setBounds(85, 40 , 900, 200);
			scroll.getViewport().setOpaque(false);
			scroll.setOpaque(false);
			scroll.setBorder(borderSavedPlayers);
			add(scroll);
			JButton play= new JButton("Gioca");
			play.setActionCommand("Gioca");
			play.addActionListener(ActionListenerPlayers.getInstance());
			play.setBounds(890, 550,90, 50);
			play.setFocusable(false);
			play.setForeground(Color.WHITE);
			play.setBackground(Color.GREEN);
			add(play);
			
			createPlayer= new JTextField();
			createPlayer.setOpaque(false);
			createPlayer.setBounds(320, 370, 500, 55);
			createPlayer.setBorder(borderCreateNickname);
			createPlayer.setForeground(Color.WHITE);
			createPlayer.setFont(new Font("Sans-serif",Font.BOLD,15));
			add(createPlayer);
			JButton createPlayers = new JButton("Crea");
			createPlayers.setActionCommand("Crea");
			createPlayers.setContentAreaFilled(false);
			createPlayers.setForeground(Color.WHITE);
			createPlayers.setFocusable(false);
			createPlayers.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
			createPlayers.addActionListener(ActionListenerPlayers.getInstance());
			createPlayers.setBounds(860, 375,90, 48);
			add(createPlayers);
			
			avatar= new JLabel();
			avatar.setLayout(new GridLayout(2,1));
			avatar.setBounds(100,300 , 200, 200);
			avatar.setOpaque(true);
			addButtonsAvatar();
			add(avatar);
		
		}
		
		/**
		 * This private method add all button to choose avatars
		 */
		private void addButtonsAvatar() {
				JButton bottone1=new JButton(new ImageIcon("Image\\Avatar\\avatarM1.png"));
				JButton bottone2=new JButton(new ImageIcon("Image\\Avatar\\avatarM2.png"));
				JButton bottone3=new JButton(new ImageIcon("Image\\Avatar\\avatarW1.png"));
				JButton bottone4=new JButton(new ImageIcon("Image\\Avatar\\avatarW2.png")); 
				JButton bottone5=new JButton(new ImageIcon("Image\\Avatar\\avatarM3.png")); 
				JButton bottone6=new JButton(new ImageIcon("Image\\Avatar\\avatarW3.png")); 
				bottone1.addActionListener(listenerFramePlayers); bottone1.setActionCommand("Image\\Avatar\\avatarM1.png");
				bottone2.addActionListener(listenerFramePlayers); bottone2.setActionCommand("Image\\Avatar\\avatarM2.png");
				bottone3.addActionListener(listenerFramePlayers); bottone3.setActionCommand("Image\\Avatar\\avatarW1.png");
				bottone4.addActionListener(listenerFramePlayers); bottone4.setActionCommand("Image\\Avatar\\avatarW2.png");
				bottone5.addActionListener(listenerFramePlayers); bottone4.setActionCommand("Image\\Avatar\\avatarM3.png");
				bottone6.addActionListener(listenerFramePlayers); bottone4.setActionCommand("Image\\Avatar\\avatarW3.png");
		        avatar.add(bottone1);avatar.add(bottone2);avatar.add(bottone3);avatar.add(bottone4);avatar.add(bottone5);avatar.add(bottone6);
		}
		
		/**
		 * This private method add all button to choose saved players
		 */
		private void addButtonsPlayers() {
			
			if (!(mapPlayers.isEmpty())){
				int font= mapPlayers.size()<12? 20:10;
				for(Entry<String, User> m :mapPlayers.entrySet()){
			         JButton bottone=new JButton("Nickname: "+m.getValue().getNickname()+" Livello: "+m.getValue().getStatistics().getLevel()); 
			         bottone.setContentAreaFilled(false);
			         bottone.setForeground(Color.WHITE);
			         bottone.setFont(new Font("Sans-serif",Font.BOLD,font));
			         bottone.setFocusable(false);
			         bottone.setActionCommand(m.getKey());
			         bottone.addActionListener(listenerFramePlayers);
			         savedPlayers.add(bottone);}
									}

							}
			}
	
} 

