package project.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.view.MainView;
public class SpeedController implements ActionListener{
	public MainView speedcontrol;
	
	public SpeedController (MainView speedControl) {
		this.speedcontrol = speedControl;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equalsIgnoreCase("Slower")) {
			
		}
		else if(src.equalsIgnoreCase("Faster")) {
			
		}
		
	}
}
