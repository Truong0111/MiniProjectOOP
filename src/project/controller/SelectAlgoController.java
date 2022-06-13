package project.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import project.view.MainView;

public class SelectAlgoController implements ActionListener{
	
public MainView sortingSelect;
	
	public SelectAlgoController(MainView sortingSelect) {
		this.sortingSelect = sortingSelect;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();

		if(src.equalsIgnoreCase("Bubble sort")) {
			System.out.println("Sorting: Bubble sort");
			this.sortingSelect.algorithmSelected = "Bubble sort";
		}
		else if(src.equalsIgnoreCase("Selection sort")) {
			System.out.println("Sorting: Selection sort");
			this.sortingSelect.algorithmSelected = "Selection sort";
		}
		else if(src.equalsIgnoreCase("Merge sort")) {
			System.out.println("Sorting: Merge sort");
			this.sortingSelect.algorithmSelected = "Merge sort";
		}
		else if(src.equalsIgnoreCase("Bucket sort")) {
			System.out.println("Sorting: Bucket sort");
			this.sortingSelect.algorithmSelected = "Bucket sort";
		}
		
	}
}
