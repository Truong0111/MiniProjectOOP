package project.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.view.MainView;

public class MenuController implements ActionListener{
	public MainView control;
	
	public MenuController(MainView control) {
		this.control = control;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String src = e.getActionCommand();
		
		int[] arr = this.control.initArr;
		int length = this.control.arrLength;

		if(src.equalsIgnoreCase("Start")) {	
			System.out.println("Start");
			this.control.Start();
		}
		else if(src.equalsIgnoreCase("Input")) {
			System.out.println("Input Elements");
		}
		else if(src.equalsIgnoreCase("Pause") || src.equalsIgnoreCase("Continue")) {
			if(src.equalsIgnoreCase("Pause")) {
				this.control.Pause();
			}
			else {
				this.control.Continue();
			}
		}
//		else if(src.equalsIgnoreCase("Create Array")) {
//			this.control.createRandomElements();
//		}
		else if(src.equalsIgnoreCase(" Delete Array ")) {
			System.out.println("Delete Array");
			this.control.removeAllElements();
		}
		else if(src.equalsIgnoreCase("Random")) {
			System.out.println("Random");
			this.control.createRandomElements();
		}
		else if(src.equalsIgnoreCase("Faster")) {
			System.out.println("Faster");
			this.control.Faster();
		}
		else if(src.equalsIgnoreCase("Slower")) {
			System.out.println("Slower");
			this.control.Slower();
		}
	}
}
