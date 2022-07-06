package View.Home;


import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout.Constraints;
import javax.swing.WindowConstants;

public class Home extends JFrame {

	private static final long serialVersionUID=1L;
	private Image image;
	


	public Home() {
		super("JUNO");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		
		LabelBackgroundHome back=new LabelBackgroundHome();
		
		
		add(back);
		//add(new LabelTitle());
		pack();
		
		
		
		
		setSize(1100,699);
		setLocationRelativeTo(null);
		setResizable(false);
		
	
		
		
	
		
	
		
	
		
		
		
		
	}

}
