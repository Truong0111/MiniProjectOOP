package project.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import project.controller.MenuController;
import project.controller.SelectAlgoController;

public class MainView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public int arrLength = 0;
	public int initArr[] = new int[30];
	
	private MyLabel[] JL_arr = new MyLabel[30];
	private int oldX[] = new int[30];
	private int JL_distance = 10;
	
	private Thread[] threads = new Thread[1000000];
	private int currThread = -1;
	
	public int timeSleep = 10;
	public int step = 5;
	
	public SpinnerModel spinnerModel = new SpinnerNumberModel(12, 2, 22, 1);
	public JSpinner spinner_create_array;
	public JSpinner spinner_speed;
	public String algorithmSelected = "Bubble sort";
	
	private MyBucket[] bucketArr = new MyBucket[20];
	private int bucketDistance = 10;
	private int bucketLength = 10;
	private int wLength;
	private int hLength;
	private JPanel Main_App;
	private JPanel panel_view_main_play = new JPanel();
	
	public MyButton btn_control;
	public MyButton btn_slower;
	public MyButton btn_faster;
	
	public void setView() {
		Main_App = new JPanel();
		Main_App.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Main_App);
		Main_App.setLayout(new BorderLayout(0,0));
		
		JPanel panel_view_title = new JPanel();
		Main_App.add(panel_view_title, BorderLayout.NORTH);
		panel_view_title.setLayout(new BorderLayout(0, 0));
		
		JLabel label_title_inside = new JLabel("DEMONSTRATE SORTING ALGORITHMS");
		label_title_inside.setHorizontalAlignment(SwingConstants.CENTER);
		label_title_inside.setFont(new Font("Arial", Font.BOLD, 20));
		panel_view_title.add(label_title_inside, BorderLayout.CENTER);
		
		JButton btn_info = new MyButton("Info");
		btn_info.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_view_title.add(btn_info, BorderLayout.EAST);
		
		JPanel panel_view_main = new JPanel();
		panel_view_main.setBackground(SystemColor.menu);
		panel_view_main.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Main View", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Main View", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_view_main.setLayout(new BorderLayout());
		
		panel_view_main_play = new JPanel();
		panel_view_main_play.setBackground(Color.WHITE);
		panel_view_main_play.setLayout(null);
		panel_view_main.add(panel_view_main_play);
		Main_App.add(panel_view_main, BorderLayout.CENTER);
		
//		wLength = panel_view_main_play.getWidth();
//		hLength = panel_view_main_play.getHeight();
		
		JPanel panel_view_sub = new JPanel();
		Main_App.add(panel_view_sub, BorderLayout.SOUTH);
		panel_view_sub.setLayout(new BoxLayout(panel_view_sub, BoxLayout.X_AXIS));
		
		JPanel panel_view_sub_data = new JPanel();
		panel_view_sub_data.setBorder(new TitledBorder(null, "Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_view_sub.add(panel_view_sub_data);
		panel_view_sub_data.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_create_array = new JPanel();
		panel_create_array.setBorder(new TitledBorder(null, "Create Array", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_view_sub_data.add(panel_create_array);
		panel_create_array.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel create_array_number = new JPanel();
		panel_create_array.add(create_array_number);
		create_array_number.setLayout(new BoxLayout(create_array_number, BoxLayout.X_AXIS));
		
		JSeparator separator_create_array_1 = new JSeparator();
		separator_create_array_1.setForeground(SystemColor.menu);
		separator_create_array_1.setBackground(SystemColor.menu);
		create_array_number.add(separator_create_array_1);
		
		JLabel label_create_array = new JLabel("Number of array:");
		label_create_array.setHorizontalAlignment(SwingConstants.CENTER);
		create_array_number.add(label_create_array);
		
		JSeparator separator_create_array_2 = new JSeparator();
		separator_create_array_2.setBackground(SystemColor.menu);
		separator_create_array_2.setForeground(SystemColor.menu);
		create_array_number.add(separator_create_array_2);
		
		spinner_create_array = new JSpinner(spinnerModel);
		spinner_create_array.setAlignmentX(Component.LEFT_ALIGNMENT);
		spinner_create_array.setModel(new SpinnerNumberModel(10, 5, 20, 1));
		create_array_number.add(spinner_create_array);
		
		JPanel create_array_option = new JPanel();
		panel_create_array.add(create_array_option);
		create_array_option.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btn_array_create = new MyButton("Create Array");
		create_array_option.add(btn_array_create);
		
		JButton btn_array_delete = new MyButton(" Delete Array ");
		create_array_option.add(btn_array_delete);
		
		JPanel create_element_panel = new JPanel();
		create_element_panel.setBorder(new TitledBorder(null, "Create Element", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_view_sub_data.add(create_element_panel);
		
		JButton btn_array_element_random = new MyButton("Random");
		create_element_panel.setLayout(new GridLayout(0, 2, 0, 0));
		create_element_panel.add(btn_array_element_random);
		
		JButton btn_array_element_input = new MyButton("Input");
		create_element_panel.add(btn_array_element_input);
		
		JPanel panel_view_sub_select = new JPanel();
		panel_view_sub.add(panel_view_sub_select);
		panel_view_sub_select.setLayout(new BoxLayout(panel_view_sub_select, BoxLayout.Y_AXIS));
		
		JPanel speed_panel = new JPanel();
		speed_panel.setBorder(new TitledBorder(null, "Speed", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_view_sub_select.add(speed_panel);
		speed_panel.setLayout(new BoxLayout(speed_panel, BoxLayout.Y_AXIS));
		
		JPanel panel_speed_slider = new JPanel();
		speed_panel.add(panel_speed_slider);
		panel_speed_slider.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JSlider speed_slider = new JSlider();
		speed_slider.setMinorTickSpacing(1);
		speed_slider.setMaximum(50);
		speed_slider.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_speed_slider.add(speed_slider);
		
		JSpinner spinner_speed = new JSpinner(spinnerModel);
		spinner_speed.setModel(new SpinnerNumberModel(25, 1, 50, 1));
		panel_speed_slider.add(spinner_speed);
		
		JPanel panel_speed_btn = new JPanel();
		speed_panel.add(panel_speed_btn);
		panel_speed_btn.setLayout(new GridLayout(0, 5, 0, 0));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.menu);
		separator_1.setForeground(SystemColor.menu);
		panel_speed_btn.add(separator_1);
		
		btn_slower = new MyButton("Slower");
		panel_speed_btn.add(btn_slower);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.menu);
		separator.setBackground(SystemColor.menu);
		panel_speed_btn.add(separator);
		
		btn_faster = new MyButton("Faster");
		panel_speed_btn.add(btn_faster);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(SystemColor.menu);
		separator_2.setForeground(SystemColor.menu);
		panel_speed_btn.add(separator_2);
		
		JPanel select_panel = new JPanel();
		select_panel.setBorder(new TitledBorder(null, "Select Sort Algorithms", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_view_sub_select.add(select_panel);
		select_panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		
		JRadioButton btn_select_1 = new MyRadioButton("Bubble sort");
		btn_select_1.setHorizontalAlignment(SwingConstants.LEFT);
		btn_select_1.setSelected(true);
		JRadioButton btn_select_2 = new MyRadioButton("Selection sort");
		btn_select_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JRadioButton btn_select_3 = new MyRadioButton("Merge sort");
		btn_select_3.setHorizontalAlignment(SwingConstants.LEFT);
		
		JRadioButton btn_select_4 = new MyRadioButton("Bucket sort");
		btn_select_4.setHorizontalAlignment(SwingConstants.LEFT);
		
		ButtonGroup bg_select = new ButtonGroup();
		bg_select.add(btn_select_1);
		bg_select.add(btn_select_2);
		bg_select.add(btn_select_3);
		bg_select.add(btn_select_4);
		
		select_panel.add(btn_select_1);
		select_panel.add(btn_select_2);
		select_panel.add(btn_select_3);
		select_panel.add(btn_select_4);
		
		
		JPanel panel_view_sub_control = new JPanel();
		panel_view_sub_control.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Control", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_view_sub.add(panel_view_sub_control);
	
		panel_view_sub_control.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_control_btn_inde = new JPanel();
		panel_view_sub_control.add(panel_control_btn_inde);
		panel_control_btn_inde.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton btn_increase = new MyRadioButton("Increase");
		btn_increase.setHorizontalAlignment(SwingConstants.CENTER);
		btn_increase.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_control_btn_inde.add(btn_increase);
		btn_increase.setSelected(true);
		
		JRadioButton btn_decrease = new MyRadioButton("Decrease");
		btn_decrease.setVerticalAlignment(SwingConstants.TOP);
		btn_decrease.setHorizontalAlignment(SwingConstants.CENTER);
		panel_control_btn_inde.add(btn_decrease);
		
		ButtonGroup bg_control = new ButtonGroup();
		bg_control.add(btn_decrease);
		bg_control.add(btn_increase);
		
		JPanel panel_control_btn_start = new JPanel();
		panel_view_sub_control.add(panel_control_btn_start);
		panel_control_btn_start.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btn_control = new MyButton("Start");
		panel_control_btn_start.add(btn_control);

		
		ActionListener menuController = new MenuController(this);
		btn_info.addActionListener(menuController);
		btn_array_create.addActionListener(menuController);
		btn_array_delete.addActionListener(menuController);
		btn_array_element_random.addActionListener(menuController);
		btn_array_element_input.addActionListener(menuController);
		btn_control.addActionListener(menuController);
		btn_faster.addActionListener(menuController);
		btn_slower.addActionListener(menuController);
		
		ActionListener selectAlgoController = new SelectAlgoController(this);
		btn_select_1.addActionListener(selectAlgoController);
		btn_select_2.addActionListener(selectAlgoController);
		btn_select_3.addActionListener(selectAlgoController);
		btn_select_4.addActionListener(selectAlgoController);
			
	}
	
	//createElements
		public void createElements(int a[], int length) {
			btn_control.setText("Start");
			wLength = panel_view_main_play.getWidth()/2;
			hLength = panel_view_main_play.getHeight()/2;
			for(int i = 0; i < length; i++) {
				JL_arr[i] = new MyLabel();
				JL_arr[i].setVisible(true);
				
				if(i == 0) {
					JL_arr[i].setLocation((int)(wLength - (length*JL_arr[i].getSide() + (length-1)*JL_distance)/2), hLength);
				}
				else {
					JL_arr[i].setLocation(JL_arr[i-1].getX() + JL_distance + JL_arr[i].getSide(), hLength);
				}
				
				JL_arr[i].setText(a[i] + "");
				initArr[i] = a[i];
				oldX[i] = JL_arr[i].getX();
				panel_view_main_play.add(JL_arr[i]);
			}
			
			this.add(panel_view_main_play);
			System.out.println(length);
		}
		
		public void removeAllElements() {
		
			for (int i = 0; i < arrLength; i++) {
				panel_view_main_play.remove(JL_arr[i]);
			}
		
			for (int i = 0; i < currThread; i++) {
				try {
					threads[i].interrupt();
				} 
				catch (Exception e) {
					
				}
			}
			currThread = -1;
			
			panel_view_main_play.revalidate();
			panel_view_main_play.repaint();
			
		}
		
		public int[] getRandomArr(int length) {
			int[] a = new int[length];
			
			Random rand = new Random();
			for (int i = 0; i < length; i++) {
				int ranNum = rand.nextInt(100) + 0;
				a[i] = ranNum;
			}
			return a;
		}

		public void createRandomElements() {
			
			this.removeAllElements();
			
			arrLength = (Integer)spinner_create_array.getValue();

			int[] arr = getRandomArr(arrLength);
		
			createElements(arr, arrLength);
			
			for (int i = 0; i < arrLength; i++) {
				System.out.println(arr[i]);
			}
		}


		public void Start() {
			btn_control.setText("Pause");
			
			int[] arr = new int[30];
			for (int i = 0; i < arrLength; i++) {
				arr[i] = initArr[i];
			}
			
			if(algorithmSelected.equalsIgnoreCase("Bubble sort")) {
				bubbleSort(arr, arrLength);
			}
			if(algorithmSelected.equalsIgnoreCase("Selection sort")) {
				selectionSort(arr, arrLength);
			}
			if(algorithmSelected.equalsIgnoreCase("Merge sort")) {
				mergeSort(arr, arrLength);
			}
			if(algorithmSelected.equalsIgnoreCase("Bucket sort")) {
				bucketSort(arr, arrLength);
			}
			
		}
		
		public void Pause() {
			btn_control.setText("Continue");
			btn_slower.setEnabled(false);
			btn_faster.setEnabled(false);
			
			step = 0; 
		}
		
		public void Continue() {
			btn_control.setText("Pause");
			btn_slower.setEnabled(true);
			btn_faster.setEnabled(true);
			
			step = 5;
		}
		
		public void Faster() {
			if(timeSleep > 1) {
				timeSleep /= 2;
			}
		}
		
		public void Slower() {
			if(timeSleep < 50) {
				timeSleep *= 2;
			}
		}
		
		//swaps
		public void SwapAnimation(int i, int j) {
			currThread++;
			
			int curr = currThread;
			wLength = panel_view_main_play.getWidth()/2;
			hLength = panel_view_main_play.getHeight()/2;
			threads[curr] = new Thread(new Runnable() {
			    @Override
			    public void run() {
			    	try {
			    		if (curr != 0) {
				    		threads[curr-1].join();
				    	}
			    		
						JL_arr[i].setProcesColor();
						JL_arr[j].setProcesColor();

			    		//Move up and down
						while (JL_arr[i].getY() > hLength - 125) {
							JL_arr[i].setLocation(JL_arr[i].getX(), JL_arr[i].getY() - step);
							JL_arr[j].setLocation(JL_arr[j].getX(), JL_arr[j].getY() + step);
				        	Thread.sleep(timeSleep);
				        }
						
						//Move left and right
				        while (JL_arr[i].getX() < oldX[j]) {
				        	JL_arr[i].setLocation(JL_arr[i].getX() + step, JL_arr[i].getY());
				        	JL_arr[j].setLocation(JL_arr[j].getX() - step, JL_arr[j].getY());
				        	Thread.sleep(timeSleep);
				        }
				        
				      //Move up and down
				        while (JL_arr[i].getY() < hLength - 20) {
				        	JL_arr[i].setLocation(JL_arr[i].getX(), JL_arr[i].getY() + step);
				        	JL_arr[j].setLocation(JL_arr[j].getX(), JL_arr[j].getY() - step);
				        	Thread.sleep(timeSleep);
				        }

				        JL_arr[i].setLocation(oldX[i], hLength);
				        JL_arr[j].setLocation(oldX[j], hLength);
				        
				        String txt_tmp = JL_arr[i].getText();
				        JL_arr[i].setText( JL_arr[j].getText());
				        JL_arr[j].setText(txt_tmp);
				        
				        //
				        JL_arr[i].setInitColor();
				        JL_arr[j].setInitColor();
						
				        Thread.sleep(timeSleep*20);
			    	} catch (Exception e) {
			    		//
			    	}	
			    }
			});
			threads[curr].start();
		}
		
		//Mark done
		public void markDone(int i) {
			currThread++;
			
			int curr = currThread;
			threads[curr] = new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					if (curr != 0) {
			    		try {
							threads[curr-1].join();
							JL_arr[i].setDoneColor();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	}
				}
			});
			threads[curr].start();
			
		}
		
		
		//Bubble sort
		public void bubbleSort(int[] arr, int length) {
			for(int i = 0; i < length; i++) {
				for(int j = length - 1; j > i; j--) {
					if(arr[i] > arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						SwapAnimation(i, j);
					}
				}		
				markDone(i);
			}
		}
		
		
		//Selection sort
		public void selectionSort(int[] arr, int length) {
			for(int i = 0; i < length; i++) {
				int k = i;
				
				for(int j = i + 1; j < length; j++) {
					if(arr[j] < arr[k]) {
						k = j;
					}
				}
				
				if(k != i) {
					int temp = arr[i];
					arr[i] = arr[k];
					arr[k] = temp;
					SwapAnimation(i, k);
				}
				
				markDone(i);
			}
		}

		
		//Merge sort
		public void moveYAnimation(int left, int right, int y) {
			currThread++;
			
			int cur = currThread;
			wLength = panel_view_main_play.getWidth()/2;
			hLength = panel_view_main_play.getHeight()/2;
			threads[cur] = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                try {
	                    if (cur != 0)
	                        threads[cur - 1].join();
	                    
	                    for (int i = left; i <= right; i ++) {
	                        JL_arr[i].setProcesColor();
	                    }
	                    
	                    //Move up
	                    if(y < 0) {
	                    	while (JL_arr[right].getY() > hLength + y) {
	                    		for (int i = left; i <= right; i ++) {
	                    			if (JL_arr[i].getY() > hLength + y)
	                    				JL_arr[i].setLocation(JL_arr[i].getX(), JL_arr[i].getY() - step);
	                    		}
	                    		Thread.sleep(timeSleep);
	                    	}
	                    }
	                    //Move down
	                    else {
	                    	while (JL_arr[right].getY() < hLength + y) {
	                    		for (int i = left; i <= right; i ++) {
	                    			if (JL_arr[i].getY() < hLength + y)
	                    				JL_arr[i].setLocation(JL_arr[i].getX(), JL_arr[i].getY() + step);
	                    		}
	                    		Thread.sleep(timeSleep);
	                    	}
	                    }
	                    
	                } catch (Exception e) {
	                }
	            }
	        });
	        threads[cur].start();
		}
		
		
		public void mergeAnimation(int currJL, int k, boolean isLastMerge) {
			int x1 = JL_arr[currJL].getX();
			
			currThread++;
			
			int curr = currThread;
			wLength = panel_view_main_play.getWidth()/2;
			hLength = panel_view_main_play.getHeight()/2;
			threads[curr] = new Thread(new Runnable() {
			    @Override
			    public void run() {
			    	try {
			    		if (curr != 0) {
				    		threads[curr-1].join();
				    	}
			    		
			    		JL_arr[currJL].setProcesColor();
			    		
			    		//Move down 
			    		while(JL_arr[currJL].getY() < hLength - 60) {
			    			JL_arr[currJL].setLocation(JL_arr[currJL].getX(), JL_arr[currJL].getY() + step);
		    				Thread.sleep(timeSleep);
			    		}
			    		
			    		//Move right
			    		if(x1 < oldX[k]) {
			    			while(JL_arr[currJL].getX() < oldX[k]) {
			    				JL_arr[currJL].setLocation(JL_arr[currJL].getX() + step, JL_arr[currJL].getY());
			    				Thread.sleep(timeSleep);
			    			}
			    		}
			    		
			    		//Move left
			    		else {
			    			while(JL_arr[currJL].getX() > oldX[k]) {
			    				JL_arr[currJL].setLocation(JL_arr[currJL].getX() - step, JL_arr[currJL].getY());
			    				Thread.sleep(timeSleep);
			    			}
			    		}       
			    		
			    		//Move down
			    		while(JL_arr[currJL].getY() < hLength) {
			    			JL_arr[currJL].setLocation(JL_arr[currJL].getX(), JL_arr[currJL].getY() + step);
		    				Thread.sleep(timeSleep);
			    		}
			    		
			    		if(isLastMerge) {
			    			JL_arr[currJL].setDoneColor();
			    		}
			    		else {
			    			JL_arr[currJL].setInitColor();
			    		}
			    		
			    		
				        Thread.sleep(timeSleep*20);
			    	} catch (Exception e) {
			    	}	
			    }
			});
			threads[curr].start();
		}
		
	    public void reLocation(int left, int right, int[] T) {
	    	currThread++;
	    	System.out.println(currThread);
	    	int cur = currThread;
	    	hLength = panel_view_main_play.getHeight()/2;
	    	threads[cur] = new Thread(new Runnable() {
	    		@Override
	    		public void run() {
	    			try {
	    				if (cur != 0)
	    					threads[cur - 1].join();
	    				
	    				for (int i = left; i <= right; i ++) {
	    					if (JL_arr[i].getX() != oldX[i]) {
	    						JL_arr[i].setLocation(oldX[i], hLength);
	    						JL_arr[i].setText(T[i - left] + "");
	    					}
	    					if(left == 0 && right == arrLength-1) {
	    						JL_arr[i].setDoneColor();
	    					}
	    				}
	    				
	    				Thread.sleep(timeSleep);
	    			} catch (Exception e) {
	    			}
	    		}
	    	});
	    	threads[cur].start();
	    }

		public void merge(int arr[], int l, int m, int r){
		    int n1 = m - l + 1;
		    int n2 = r - m;
		    int L[] = new int[n1];
		    int R[] = new int[n2];
		    int T[] = new int[n2 + n1];
		    //Divide
		    int i, j;
		    for(i = 0; i < n1; i++) {
		        L[i] = arr[l + i];
		    }
		    for(j = 0; j < n2; j++) {
		        R[j] = arr[m + 1 + j];
		    }
		    
		    boolean isLastMerge = (l == 0 && r == arrLength -1);
		    
		    moveYAnimation(l, r, -120);
		    
		    //Merge
		    int k = l;
		    i = 0; j = 0;
		    while(i < n1 && j < n2) {
		        if(L[i] <= R[j]) {
		            arr[k] = L[i];
		            mergeAnimation(l + i, k, isLastMerge);
		            i++;
		        }
		        else {
		            arr[k] = R[j];
		            mergeAnimation(m + j + 1, k, isLastMerge);
		            j++;
		        }
		        k++;
		    }
		    while(i < n1) {
		        arr[k] = L[i];
		        mergeAnimation(l + i, k, isLastMerge);
		        i++;
		        k++;
		    }
		    while(j < n2) {
		        arr[k] = R[j];
		        mergeAnimation(m + j + 1, k, isLastMerge);
		        j++;
		        k++;
		    }
		    
		    for (i = 0; i < n1 + n2; i ++)
	            T[i] = arr[l + i];

		    reLocation(l, r, T);
		}
		

		public void mergeRecursive(int a[], int l, int r){
		    if(r > l) {
		        int m = (l + r)/2;
		        mergeRecursive(a, l, m);
		        mergeRecursive(a, m + 1, r);
		        merge(a, l, m, r);
		    }
		}
		
		public void mergeSort(int[] arr, int length) {
			mergeRecursive(arr, 0, length - 1);
		}
		
		//Bucket sort
		public void createBuckets() {
			this.removeAllElements();
			
			this.createElements(initArr, arrLength);
			wLength = panel_view_main_play.getWidth()/2;
			hLength = panel_view_main_play.getHeight()/2;
			for(int i = 0; i < bucketLength; i++) {
				bucketArr[i] = new MyBucket();
				bucketArr[i].setVisible(true);
				bucketArr[i].setText(i + "");
				if(i == 0) {
					bucketArr[i].setLocation((int)(wLength - (bucketLength*bucketArr[i].getSide() + (bucketLength-1)*bucketDistance)/2), hLength + 215);
				}
				else {
					bucketArr[i].setLocation(bucketArr[i-1].getX() + bucketDistance + bucketArr[i].getSide(), hLength + 215);
				}
				panel_view_main_play.add(bucketArr[i]);
			}
			this.add(panel_view_main_play);
		}
		
		public void removeBuckets() {
			for(int i = 0; i < bucketLength; i++) {
				panel_view_main_play.remove(bucketArr[i]);
			}
			
			for (int i = 0; i < currThread; i++) {
				try {
					threads[i].interrupt();
				} 
				catch (Exception e) {
					
				}
			}
			currThread = -1;
			
			panel_view_main_play.revalidate();
			panel_view_main_play.repaint();
		}
		
		public void moveToBucketAnimation(int i, int k) {
			int x1 = JL_arr[i].getX();
			
			currThread++;
			
			int curr = currThread;
			wLength = panel_view_main_play.getWidth()/2;
			hLength = panel_view_main_play.getHeight()/2;
			threads[curr] = new Thread(new Runnable() {
			    @Override
			    public void run() {
			    	try {
			    		if (curr != 0) {
				    		threads[curr-1].join();
				    	}
			    		
			    		JL_arr[i].setProcesColor();
			    		
			    		bucketArr[k].addElement(i);
			    		
			    		//Move down
			    		while(JL_arr[i].getY() < hLength - 155) {
			    			JL_arr[i].setLocation(JL_arr[i].getX(), JL_arr[i].getY() + step);
		    				Thread.sleep(timeSleep);
			    		}
			    		
			    		//Move right
			    		if(x1 < bucketArr[k].getX()) {
			    			while(JL_arr[i].getX() < bucketArr[k].getX()) {
			    				JL_arr[i].setLocation(JL_arr[i].getX() + step, JL_arr[i].getY());
			    				Thread.sleep(timeSleep);
			    			}
			    		}
			    		
			    		//Move left
			    		else {
			    			while(JL_arr[i].getX() > bucketArr[k].getX()) {
			    				JL_arr[i].setLocation(JL_arr[i].getX() - step, JL_arr[i].getY());
			    				Thread.sleep(timeSleep);
			    			}
			    		}       
			    		
			    		//Move down  
			    		while(JL_arr[i].getY() < hLength + 215 -bucketArr[k].getNum()*(JL_arr[i].getSide() + JL_distance)) {
			    			JL_arr[i].setLocation(JL_arr[i].getX(), JL_arr[i].getY() + step);
		    				Thread.sleep(timeSleep);
			    		}
			    		
			    		JL_arr[i].setInitColor();
			    		
				        Thread.sleep(timeSleep*20);
			    	} catch (Exception e) {
			    	}	
			    }
			});
			threads[curr].start();
		}
		
		 public void sortElementInBucket() {
		    	currThread++;
		    	System.out.println(currThread);
		    	int cur = currThread;
		    	threads[cur] = new Thread(new Runnable() {
		    		@Override
		    		public void run() {
		    			try {
		    				if (cur != 0)
		    					threads[cur - 1].join();
		    				
		    				
		    				for(int k = 0; k < bucketLength; k++) {
		    					for(int i = 0; i < bucketArr[k].getNum(); i++) {
	    							JL_arr[bucketArr[k].getElement(i)].setProcesColor();
	    						}
		    					
		    					if(bucketArr[k].getNum() == 0) { 
		    						continue;
		    					}
		    					
		    					if(bucketArr[k].getNum() > 1) {
		    						int[] num = new int[30];
		    						int count = 0;
		    						for(int i = 0; i < bucketArr[k].getNum(); i++) {
		    							num[i] = initArr[bucketArr[k].getElement(i)];
		    						}
		    						
		    						for(int i = 0; i < bucketArr[k].getNum(); i++) {
		    							for(int j = bucketArr[k].getNum() - 1; j > i; j--) {
		    								if(num[i] < num[j]) {
		    									int temp = num[i];
		    									num[i] = num[j];
		    									num[j] = temp;
		    								}
		    							}	
		    						}
		    						
		    						for(int i = 0; i < bucketArr[k].getNum(); i++) {
		    							JL_arr[bucketArr[k].getElement(i)].setText(num[i] + "");
		    						}
		    					}
		    					
		    					Thread.sleep(timeSleep*100);
	    						for(int i = 0; i < bucketArr[k].getNum(); i++) {
	    							JL_arr[bucketArr[k].getElement(i)].setInitColor();
	    						}
		    				
		    				}
		    				Thread.sleep(timeSleep*100);
		    			} catch (Exception e) {
		    			}
		    		}
		    	});
		    	threads[cur].start();
		    }

		  public void moveBackAnimation() {
			  	currThread++;
			  	
		    	System.out.println(currThread);
		    	int cur = currThread;
		    	hLength = panel_view_main_play.getHeight()/2;
		    	threads[cur] = new Thread(new Runnable() {
		    		@Override
		    		public void run() {
		    			try {
		    				if (cur != 0)
		    					threads[cur - 1].join();
		    				
		    				int count = -1;
		    				
		    				for(int k = 0; k < bucketLength; k++) {		
		    					for(int i = bucketArr[k].getNum() - 1; i >= 0 ; i--) {
		    						
		    						int JL_index = bucketArr[k].getElement(i);
	    							count++;
		    						
	    							JL_arr[JL_index].setProcesColor();
	    							
		    						//Move up
	    							while(JL_arr[JL_index].getY() > hLength - 155) {
	    								JL_arr[JL_index].setLocation(JL_arr[JL_index].getX(), JL_arr[JL_index].getY() - step);
	    			    				Thread.sleep(timeSleep);
	    							}
	    							
	    							//Move right
	    							if(JL_arr[JL_index].getX() < oldX[count]) {
	    								while(JL_arr[JL_index].getX() < oldX[count]) {
	    									JL_arr[JL_index].setLocation(JL_arr[JL_index].getX() + step, JL_arr[JL_index].getY());
	    									Thread.sleep(timeSleep);
	    								}	
	    							}
	    							//Move left
	    							else {
	    								while(JL_arr[JL_index].getX() > oldX[count]) {
	    									JL_arr[JL_index].setLocation(JL_arr[JL_index].getX() - step, JL_arr[JL_index].getY());
	    									Thread.sleep(timeSleep);
	    								}	
	    							}
	    							
	    							//Move up
	    							while(JL_arr[JL_index].getY() >  hLength - 215) {
	    								JL_arr[JL_index].setLocation(JL_arr[JL_index].getX(), JL_arr[JL_index].getY() - step);
	    			    				Thread.sleep(timeSleep);
	    							}
	    							
	    							JL_arr[JL_index].setDoneColor();
	    					
	    						}
		    				}
		    				
		    				Thread.sleep(timeSleep*20);
		    				removeBuckets();
		    				
		    			} catch (Exception e) {
		    			}
		    			
		    		}
		    	});
		    	threads[cur].start();
		  }
		
		  public void bucketSort(int[] arr, int length) {
				
				this.createBuckets();
				
				moveYAnimation(0, arrLength - 1, -215);
				
				for(int i = 0; i < arrLength; i++) {
					int k = (int)(arr[i]/bucketLength);
					
					moveToBucketAnimation(i, k);
					System.out.println(bucketArr[k].getNum());
				}
				
				sortElementInBucket();
				moveBackAnimation();
//				moveYAnimation(0, arrLength - 1, 0);
			}
	public void startApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Application demonstrate sorting algorithms");
		setSize(1280,720);
		setLocationRelativeTo(null);
		setView();
		setVisible(true);
	}
}
