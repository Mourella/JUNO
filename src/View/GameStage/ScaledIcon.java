package View.GameStage;

import java.awt.Dimension;

import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 * This interface contains two method of utility
 * @author Davide Morelli
 *
 */
public interface ScaledIcon {

	/**
	 * This method fit icons into buttons
	 * @param path
	 * @param bottone
	 * @param height
	 * @param width
	 */
	static void setIconButton(String path,JButton bottone,int height, int width) {
		bottone.setPreferredSize(new Dimension(height,width));
		Image ima= new ImageIcon(path).getImage();
		ima=ima.getScaledInstance(height, width, Image.SCALE_SMOOTH);
		bottone.setIcon(new ImageIcon(ima));
	}
	/**
	 * This method fit labels
	 * @param path
	 * @param height
	 * @param width
	 * @return
	 */
	static Image setIconLabel(String path,int height,int width) {
		Image ima=new ImageIcon(path).getImage();
		ima=ima.getScaledInstance(height, width, Image.SCALE_SMOOTH);
		return ima;
	}
	
	
}
