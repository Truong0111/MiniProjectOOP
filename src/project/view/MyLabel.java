package project.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel {
	private int side = 50;
	
	public MyLabel() {
		this.setText("0");
		this.setSize(side, side);
		this.setBackground(new Color(192,192,192));
		this.setOpaque(true);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(new Font("Arial", Font.PLAIN, 20));
	}
	
	public void setInitColor() {
		this.setBackground(new Color(192,192,192));
	}
	
	public void setProcesColor() {
		this.setBackground(Color.YELLOW);
	}
	
	public void setDoneColor() {
		this.setBackground(Color.GREEN);
	}
	
	public void setSelectedColor() {
		this.setBackground(new Color(250,128,114));
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

}