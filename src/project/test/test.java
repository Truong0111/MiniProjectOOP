package project.test;

import javax.swing.JFrame;
import javax.swing.UIManager;

import project.view.MainView;

public class test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			MainView  v = new MainView();
			v.startApp();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
