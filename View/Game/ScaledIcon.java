package View.Game;

import java.awt.Dimension;

import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JButton;


//ridimensiona il bottone secondo le misure in input e aggiunge e ridimensiona l'icona al suo interno
public interface ScaledIcon {

	static void setIconButton(String path,JButton bottone,int height, int width) {
		bottone.setPreferredSize(new Dimension(height,width));
		Image ima= new ImageIcon(path).getImage();
		ima=ima.getScaledInstance(height, width, Image.SCALE_SMOOTH);
		bottone.setIcon(new ImageIcon(ima));
	}
	
	static Image setIconLabel(String path,int height,int width) {
		Image ima=new ImageIcon(path).getImage();
		ima=ima.getScaledInstance(height, width, Image.SCALE_SMOOTH);
	
		return ima;
	
	}
	
	
}
