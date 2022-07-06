package Controller.ActionListenerHome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.Home.Home;

public class ActionListenerHome implements ActionListener {


	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		
		//command intercetta il comando 
		if (command=="Gioca") {
			Home home=new Home();
			home.setVisible(true);
		}
		
	}

}
