package View.Home;


import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
/**
 * This class represents the view for the help.
 * @author Davide Morelli
 *
 */
public class FrameHelp extends JFrame {
	
	
	private static final long serialVersionUID = 9132632216580225254L;

	public FrameHelp() {
		super("HELP");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);	
		try {setIconImage(ImageIO.read(new File("Image\\altro\\Icon.png")));}
		catch (IOException e) {e.printStackTrace();}
		JTextArea help= new JTextArea();
		help.setEditable(false);
		help.setLineWrap(true);
		help.setText(""
				+ "INIZIARE A GIOCARE\n"
				+ "Dalla Home selezionare 'Gioca' per giocare.\n"
				+ "Si aprirà una schermata per la scelta del giocatore, da cui il giocatore può scegliere uno dei profili salvati o creare "
				+ "altri profili.\n"
				+ "\n"
				+ "SCHERMATA DI GIOCO\n"
				+ "Nella schermata saranno presenti:\n"
				+ " 1. Un mazzo da cui pescare le carte\n"
				+ " 2. Due tasti, Juno! e Passa per gridare Juno e passare il turno\n"
				+ " 3. Una chat in alto con scritto tutti gli eventi della partita. La chat si colora in base al colore attualmente in uso\n"
				+ " 4. Le tue carte con cui giocare\n"
				+ "\n"
				+ "PREPARATIVI\n"
				+ " 1. Ogni giocatore pesca una carta; il giocatore che pesca la carta più alta sarà il mazziere.\n(Le carte simbolo valgono 0)\n"
				+ " 2. Il mazziere mischia le carte e ne distribuisce 7 ad ogni giocatore\n"
				+ " 3. Girate la prima carta del deck per iniziare il mazzo degli scarti\n"
				+ " \n"
				+ " COME GIOCARE\n"
				+ " Il giocatore alla sinistra del mazziere inizia il turno.\n"
				+ " Quando arriva il vostro turno dovete abbinare una carta della vostra mano alla prima carta in cima al mazzo\n di SCARTO, per numero, colore o simbolo.\n"
				+ " Se non si hanno carte da scartare si è costretti a pescare dal mazzo al centro del tavolo.\n Se la carta pescata è utile la sì scarta; se invece non lo è, la si deve tenere in mano assieme alle altre.\n"
				+ " II turno passa ora al giocatore successivo.\n"
				+ " \n"
				+ " CARTE AZIONE\n"
				+ " E' possibile scartare una di queste carte se il suo colore o il suo simbolo corrispondono al colore o al simbolo\n dell'ultima carta scartata.\n"
				+ " Pesca +2: se viene scartata questa carta, il giocatore successivo deve pescare 2 carte e saltare il turno di gioco.\n"
				+ " Cambia giro: quando viene scartata questa carta, l'ordine di gioco viene invertito. Si prosegue cioè il gioco\n in senso antiorario. Se in seguito viene giocata una altra carta \"CAMBIO\", si riprende a giocare in senso orario come all'inizio, e così via.\n"
				+ " Salta il turno: quando viene scartata questa carta, il giocatore successivo salta il turno.\n"
				+ " Jolly: queste carte possono essere scartate quando si vuole, indipendentemente dall'ultima carta scartata.\n La carta \"JOLLY\" vale per il colore che si dichiara al momento di scartare. II giocatore successivo dovrà giocare tenendo conto del colore dichiarato.\n"
				+ " Jolly+4: con questa carta si obbliga il giocatore successivo a pescare 4 carte e a saltare un turno.\n Questa carta, diversamente dal JOLLY, può essere giocata SOLO se non si ha in mano nessuna carta del colore dell'ultima carta scartata.\n"
				+ "\n"
				+ " COME SI GIOCA IL \"JOLLY +4\"\n"
				+ " 1. L'ultima carta scartata è un \"4 ROSSO\". II giocatore di turno oltre alla carta \"JOLLY +4\" non possiede carte rosse, ma ha una carta \"4 BLU\"\n (che in teoria potrebbe essere scartata). In questo caso I giocatore può decidere di giocare la carta \"JOLLY +4\".\n"
				+ " 2. L'ultima carta scartata e un \"6 BLU\". II giocatore di turno oltre alla carta \"JOLLY +4\" possiede una carta \"SALTA IL TURNO\" di colore blu.\n In questo caso non pub giocare la carta \"JOLLY +4\" in quanto possiede una carta dello stesso colore dell'ultima carta scartata.\n"
				+ " 3. L'ultima carta scartata e un \"5 ROSSO\". 11 giocatore di turno ha sia la carta \"JOLLY\" che la carta \"JOLLY +4\".\n In questo caso pub giocare \"JOLLY +4\" in quanta la carta \"JOLLY\" non rap- presenta un colore preciso.\n"
				+ " Giocando la carta JOLLY +4 si deve dichiarare il colore con il quale proseguire il gioco."
				);
		help.setFont(new Font("Sans-serif",Font.BOLD,20));
		JScrollPane scroll = new JScrollPane(help,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(760, 4 , 500, 60);
		scroll.getViewport().setOpaque(false);
		scroll.setOpaque(false);
		add(scroll);
		setPreferredSize(new Dimension(1500,800));
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

}
