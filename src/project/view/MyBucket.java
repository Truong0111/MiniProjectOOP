package project.view;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MyBucket extends JLabel {
	private int side = 50;
	private int numElementInBucket = 0;
	private Border lineBorder = BorderFactory.createLineBorder(Color.GRAY);
	private int[] JL = new int[30];
	
	public int getNum() {
		return numElementInBucket;
	}
	

	public void addElement(int i) {
		JL[numElementInBucket] = i;
		this.numElementInBucket++;
	}

	public int getElement(int k) {
		return JL[k];
	}
	
	public void deleteElement() {
		numElementInBucket = 0;
	}
	
	public MyBucket() {
		this.setSize(side, side);
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		this.setBorder(lineBorder);
		this.setVerticalAlignment(JLabel.CENTER);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(new Font("Arial", Font.PLAIN, 20));
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
	
	
}
