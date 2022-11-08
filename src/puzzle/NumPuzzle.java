package puzzle;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.html.ImageView;

public class NumPuzzle extends WindowAdapter implements ActionListener {
	
	private JFrame frame;//main frame

	Random rand = new Random();//to shuffle the board
	
	//panels that I need
	private JPanel playingPane,rightPane;
	
	/*Font*/
	Font modeFont = new Font("Sansserif", Font.BOLD, 35);
	Font buttonFont = new Font("Arial", Font.PLAIN, 50);
	
	/*buttons that is needed*/
	JButton[] btnArray;
	JButton[] answerArray;
	JButton[] playingArray;
	
	JButton btn1;JButton btn2;JButton btn3;JButton btn4;JButton btn5;
	JButton btn6;JButton btn7;JButton btn8;JButton btn9;JButton btn10;
	JButton btn11;JButton btn12;JButton btn13;JButton btn14;JButton btn15;
	JButton btn16;JButton btn17;JButton btn18;JButton btn19;JButton btn20;
	JButton btn21;JButton btn22;JButton btn23;JButton btn24;
	final JButton btn25 = new JButton("");

	
	JButton startButton = new JButton("Start");
	JButton restartButton = new JButton("Restart");
	JButton clearButton = new JButton("Clear");
	JButton saveButton = new JButton("Save");
	JButton loadButton = new JButton("Load");
	JButton randButton = new JButton("Shuffle");
	JButton hideButton = new JButton("Hide");
	JButton finButton = new JButton("Finish");

	
	/*Menu variables*/
	private JMenu menu;
	private JMenuItem gameItem, helpItem;
	
	
	/*Label variables*/
	private JLabel timeLabel,scoreLabel,logoLabel,iconLabel;
	
	
	/*check box for mode*/
	private Checkbox modeCheckBox = new Checkbox("Mode :");
	
	
	/*Options for game*/
	private String sizeOptions[] = 	{"2x2","3x3","4x4","5x5"};	
	private String typeOption[] = {"Num","Text"};
	
	/*Combobox for type options, game options*/
	private JComboBox<String> typeOptionList;
	private JComboBox<String> gameOptionsList;
	
	/*Variable*/

	private int dimSize = 3;

	private String gameSize;
	private String textValue;
	
	//Time variables
	private Timer timer;
	private int seconds = 0, minutes = 0;
	private String dSeconds, dMinutes;
	DecimalFormat dFormat = new DecimalFormat("00");
	
	/*Radio button*/
	private JRadioButton r1;
	private JRadioButton r2;
	
	
	/*text field for time and point*/
	private JTextField timeDisplay;
	private JTextField pointDisplay;
	
	
	/*text field for history(log)*/
	private JTextArea logArea;
	
	
	/*method to start*/
	public NumPuzzle() {
		setAndLaunch();
		puzzleDimension(dimSize);
	}
	
	
	/*launch*/
	private void setAndLaunch() {
		
		ImageIcon logoIcon = new ImageIcon("Logo.png");
		iconLabel = new JLabel();
		iconLabel.setIcon(logoIcon);
		iconLabel.setBounds(50,30,300,60);
		iconLabel.setBackground(new Color(203,208,204));
		
		timeDisplay = new JTextField();
		timeDisplay.setFont(modeFont);
		
		
		frame = new JFrame("Fun Number Puzzle made by Jaeho Oh and Nathan Chen");//title
		
		
		/*center panel for playing*/
		playingPane = new JPanel();
		playingPane.setBackground(new Color(203,208,204));
		playingPane.setBounds(100,100,500,500);		
		playingPane.setBounds(10,10,650,650);

		
		/*panel that is on right side for the components*/
		rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		
		rightPane.add(iconLabel);
		
		
		/*adding panels to frame*/
		frame.add(rightPane);
		frame.add(playingPane);
		
		
		/*buttons */
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btn10 = new JButton("10");
		btn11 = new JButton("11");
		btn12 = new JButton("12");
		btn13 = new JButton("13");
		btn14 = new JButton("14");
		btn15 = new JButton("15");
		btn16 = new JButton("16");
		btn17 = new JButton("17");
		btn18 = new JButton("18");
		btn19 = new JButton("19");
		btn20 = new JButton("20");
		btn21 = new JButton("21");
		btn22 = new JButton("22");
		btn23 = new JButton("23");
		btn24 = new JButton("24");


		/*Putting values in array*/
		btnArray = new JButton[25];
		btnArray[0] = btn1;
		btnArray[1] = btn2;
		btnArray[2] = btn3;
		btnArray[3] = btn4;
		btnArray[4] = btn5;
		btnArray[5] = btn6;
		btnArray[6] = btn7;
		btnArray[7] = btn8;
		btnArray[8] = btn9;
		btnArray[9] = btn10;
		btnArray[10] = btn11;
		btnArray[11] = btn12;
		btnArray[12] = btn13;
		btnArray[13] = btn14;
		btnArray[14] = btn15;
		btnArray[15] = btn16;
		btnArray[16] = btn17;
		btnArray[17] = btn18;
		btnArray[18] = btn19;
		btnArray[19] = btn20;
		btnArray[20] = btn21;
		btnArray[21] = btn22;
		btnArray[22] = btn23;
		btnArray[23] = btn24;
		btnArray[24] = btn25;
		
		btn1.addActionListener(this);
	    btn2.addActionListener(this);
	    btn3.addActionListener(this);
	    btn4.addActionListener(this);
	    btn5.addActionListener(this);
	    btn6.addActionListener(this);
	    btn7.addActionListener(this);
	    btn8.addActionListener(this);
	    btn9.addActionListener(this);
	    btn10.addActionListener(this);
	    btn11.addActionListener(this);
	    btn12.addActionListener(this);
	    btn13.addActionListener(this);
	    btn14.addActionListener(this);
	    btn15.addActionListener(this);
	    btn16.addActionListener(this);
	    btn17.addActionListener(this);
	    btn18.addActionListener(this);
	    btn19.addActionListener(this);
	    btn20.addActionListener(this);
	    btn21.addActionListener(this);
	    btn22.addActionListener(this);
	    btn23.addActionListener(this);
	    btn24.addActionListener(this);
	    btn25.addActionListener(this);
		
		for(int i = 0; i<25;i++) {
			btnArray[i].setBackground(new Color(228,160,016));
		}

		
		btnArray[24].setBackground(new Color(203,208,204));
				

		rightPane.setBounds(670,0,400,850);
		rightPane.setBackground(new Color(231,235,218));
		rightPane.add(clearButton);
		

		clearButton.setBounds(650,400,10,10);

		clearButton.setBounds(140,600,100,50);

		clearButton.setBounds(140,600,100,50);
		clearButton.setBackground(new Color(228,160,016));


		/*option list for the size of the game*/
		gameOptionsList = new JComboBox<String>(sizeOptions);
//		System.out.println(gameOptionsList.getSelectedItem());
		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		gameOptionsList.setFont(modeFont);
		gameOptionsList.setRenderer(centerRenderer);
		
		gameOptionsList.addActionListener(cbActionListener);
		
		
		JLabel dimTitle = new JLabel("Dim : ");
		dimTitle.setFont(modeFont);
		
		rightPane.add(dimTitle);
		rightPane.add(gameOptionsList);
		gameOptionsList.addActionListener(this);
		
		
		dimTitle.setBounds(60,115,180,40);
		
		gameOptionsList.setBounds(160,115,180,40);
		
		JLabel dummyLabel = new JLabel(); 
		
		
		/*Mode option*/
		r1 = new JRadioButton("Design");
		r2 = new JRadioButton("Play");
		r1.setBounds(160,160,80,60);
		r2.setBounds(240,160,50,60);
		r1.setBackground(new Color(231,235,218));
		r2.setBackground(new Color(231,235,218));
		r1.setMnemonic(KeyEvent.VK_D);
		r2.setMnemonic(KeyEvent.VK_P);
		JLabel modeTitle = new JLabel("Mode: ");
		
		ButtonGroup modeGroup = new ButtonGroup();
		modeTitle.setBounds(100,150,40,80);
		rightPane.add(modeTitle);
		modeGroup.add(r1);modeGroup.add(r2);
		
		rightPane.add(r1);rightPane.add(r2);
		

		/*Buttons*/
		saveButton.setBounds(55,230,80,50);
		saveButton.setBackground(new Color(228,160,016));
		rightPane.add(saveButton);
		
		loadButton.setBounds(150,230,80,50);
		loadButton.setBackground(new Color(228,160,016));
		rightPane.add(loadButton);
		
		
		ActionListener shuffleActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(playingArray != null) {
					for(int i = 0; i< playingArray.length; i++) {
						int randIndexNum = rand.nextInt(playingArray.length);
						JButton temp = playingArray[randIndexNum];
						playingArray[randIndexNum]=playingArray[i];
						playingArray[i]=temp;
					}
					for(int i = 0 ; i<playingArray.length; i++) {
						playingPane.add(playingArray[i]);
					}
					playingPane.revalidate();
				}
			}		
		};
	
		
		randButton.setBounds(245,230,80,50);
		randButton.setBackground(new Color(228,160,016));
		randButton.addActionListener(shuffleActionListener);
		rightPane.add(randButton);
		
		startButton.setBounds(55,300,125,50);
		startButton.setBackground(new Color(228,160,016));
		rightPane.add(startButton);
		
		hideButton.setBounds(200,300,125,50);
		hideButton.setBackground(new Color(228,160,016));
		rightPane.add(hideButton);
		
		ActionListener typeActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				String typeOptionSelected;
				typeOptionSelected = (String) typeOptionList.getSelectedItem();
				
				switch(typeOptionSelected) {
				case "Num":
//					System.out.println("Num");
					puzzleDimension(dimSize);
					break;	
				case "Text":
//					System.out.println("text");
					if(textValue != null)
						putText(textValue,dimSize);
					break;
				default:
//					System.out.println("df");
					puzzleDimension(dimSize);	
				}		
			}
		};
		
		
		/*type selection here*/
		typeOptionList = new JComboBox<String>(typeOption);
		typeOptionList.setFont(new Font("Sansserif", Font.BOLD, 15));
		typeOptionList.setRenderer(centerRenderer);
		typeOptionList.setBounds(100,380,70,30);
		typeOptionList.addActionListener(typeActionListener);
		rightPane.add(typeOptionList);
		
		
		JLabel typeTitle = new JLabel("Type : ");
		typeTitle.setFont(new Font("Sansserif", Font.BOLD, 15));
		typeTitle.setBounds(45, 380, 55, 30);
		rightPane.add(typeTitle);
		
		
		/*time and point displays*/
		timeDisplay = new JTextField("0:00");
		pointDisplay = new JTextField("0");
		
		
		timeDisplay.setFont(new Font("Sansserif", Font.BOLD, 15));
		timeDisplay.setEditable(false);
		pointDisplay.setFont(new Font("Sansserif", Font.BOLD, 15));
		pointDisplay.setEditable(false);
		
		
		timeDisplay.setBounds(100,420,70,30);
		pointDisplay.setBounds(100,460,70,30);
		
		
		JLabel timeTitle = new JLabel("Time");
		JLabel pointTitle = new JLabel("Point");
		
		
		timeTitle.setFont(new Font("Sansserif", Font.BOLD, 15));
		pointTitle.setFont(new Font("Sansserif", Font.BOLD, 15));
		timeTitle.setBounds(45,420,55,30);
		pointTitle.setBounds(45,460,55,30);
		
		
		rightPane.add(timeDisplay);
		rightPane.add(pointDisplay);
		rightPane.add(timeTitle);
		rightPane.add(pointTitle);
		
		
		/*Text input area*/
		JTextField inputText = new JTextField();
		inputText.setBounds(45,500,135,30);
		inputText.setFont(new Font("Sansserif", Font.BOLD, 13));
		inputText.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  textValue = inputText.getText(); 
		      }
		});
		  
		
		rightPane.add(inputText);
		logArea = new JTextArea("Your move");		
		logArea.setBounds(200,380,130,150);
		logArea.setEditable(false);
		logArea.setBackground(new Color(203,208,204));
		logArea.setFont(new Font("Sansserif", Font.BOLD, 15));
		rightPane.add(logArea);
		
		ActionListener radioDesignActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				//System.out.println("Design");
				hideButton.setEnabled(true);
				typeOptionList.setEnabled(true);
				gameOptionsList.setEnabled(true);
				inputText.setEnabled(true);
				loadButton.setEnabled(true);
				randButton.setEnabled(true);
				startButton.setEnabled(false);
				timer.stop();
				seconds = 0;
				minutes = 0;
				timeDisplay.setText("0:00");
			}
		};
		
		r1.addActionListener(radioDesignActionListener);
		
		ActionListener radioPlayActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				//System.out.println("Play");
				hideButton.setEnabled(false);
				typeOptionList.setEnabled(false);
				gameOptionsList.setEnabled(true);
				inputText.setEnabled(false);
				loadButton.setEnabled(true);
				randButton.setEnabled(true);
				startButton.setEnabled(true);
				timer.stop();
				seconds = 0;
				minutes = 0;
				timeDisplay.setText("0:00");
			}
		};
		
		r2.addActionListener(radioPlayActionListener);
		
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seconds++;
				dSeconds = dFormat.format(seconds);
				dMinutes = dFormat.format(minutes);
				timeDisplay.setText(minutes + ":" + dSeconds);
				
				if(seconds == 60) {
					seconds = 0;
					minutes++;
					
					dSeconds = dFormat.format(seconds);
					dMinutes = dFormat.format(minutes);
					timeDisplay.setText(minutes + ":" + dSeconds);
				}
			}
		});
		
		ActionListener startActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				//System.out.println("Game Start");
				hideButton.setEnabled(false);
				typeOptionList.setEnabled(false);
				gameOptionsList.setEnabled(false);
				inputText.setEnabled(false);
				loadButton.setEnabled(false);
				randButton.setEnabled(false);
				startButton.setEnabled(false);
				timer.start();
			}
		};
		
		startButton.addActionListener(startActionListener);
		
		
		rightPane.add(dummyLabel);
		
		
		/*to actually launch the program*/
		frame.addWindowListener(this);
		frame.setLayout(null);
		frame.pack();
		
		
		frame.setSize(new Dimension(1080,710));//size of the application
		
		frame.setResizable(false);//if the user can re size the window
		
		frame.setLocationByPlatform(true);
		
		frame.setVisible(true);
	}
	
	private void puzzleDimension( int dimSize) {
		/*center panel for playing*/
		playingPane.removeAll();
		switch(dimSize) {
			case 2:
				putNumber(dimSize);
				playingPane.revalidate();
				answerArray = playingArray;
				playingPane.setLayout(new GridLayout(2,2,4,4));
				break;
			case 3:
				putNumber(dimSize);
				playingPane.revalidate();
				answerArray = playingArray;
				playingPane.setLayout(new GridLayout(3,3,4,4));
				break;
			case 4:
				putNumber(dimSize);
				answerArray = playingArray;
				playingPane.setLayout(new GridLayout(4,4,4,4));
				playingPane.revalidate();
				break;
			case 5:
				putNumber(dimSize);
				answerArray = playingArray;
				playingPane.setLayout(new GridLayout(5,5,4,4));
				playingPane.revalidate();
				break;
			default:
				playingPane.add(btn1);
				playingPane.add(btn2);
				playingPane.add(btn3);
				playingPane.add(btn4);
				playingPane.add(btn5);
				playingPane.add(btn6);
				playingPane.add(btn7);
				playingPane.add(btn8);
				playingPane.add(btn25);
				playingPane.setLayout(new GridLayout(3,3,4,4));
				break;			
		}
	}
	
	
//	private Timer timer = new Timer(1000, new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			seconds++;
//			seconds_String = String.format("%01d", seconds);
//		}
//	});
	
	private int score;
	//private int seconds = 0;
	private boolean started = false;
	private String seconds_String = String.format("%01d", seconds);
	private String score_String = String.format("%d", score);
	
	
	ImageIcon logo = new ImageIcon("Logo.gif");
	
	
	ActionListener cbActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			gameSize = (String) gameOptionsList.getSelectedItem();
			
			//System.out.println(gameSize);
			dimSize = Character.getNumericValue(gameSize.charAt(0));
			//System.out.println(dimSize);
			
			puzzleDimension(dimSize);	
		}
	};
	
	
	@SuppressWarnings("deprecation")
	public void putText(String textValue, int dimSize) {
		String[] textArray = new String[25];
		for(int i = 0 ; i < 25;i++) {
			if(textValue != null) {
				if(textValue.length()> i)
					textArray[i]= String.valueOf(textValue.charAt(i));
				else
					textArray[i] =" ";
			}
		}
		playingArray = new JButton[dimSize * dimSize];
		answerArray = new JButton[dimSize* dimSize];
		for(int i = 0 ;i <dimSize*dimSize-1;i++) {
			playingArray[i] = btnArray[i];
			btnArray[i].setLabel(textArray[i]);
			playingPane.add(playingArray[i]);
		}
		playingArray[playingArray.length-1] = btnArray[24];
		playingPane.add(btn25);
		answerArray = playingArray;
		playingPane.revalidate();	
	}
	
	
	public void putNumber(int dimSize) {
		playingPane.revalidate();
		playingArray = new JButton[dimSize * dimSize];
		answerArray = new JButton[dimSize* dimSize];
		for(int i = 0 ;i <dimSize*dimSize-1;i++) {
			
			playingArray[i] = btnArray[i];
			String.valueOf(i+1);
			playingPane.add(playingArray[i]);
		}
		playingArray[playingArray.length-1] = btnArray[24];
		playingPane.add(btn25);
		answerArray = playingArray;

		playingPane.repaint();
	}
	
	
	public static void main(String[] args) {
		new NumPuzzle();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*button logic*/
		if(dimSize == 2 && timer.isRunning()) {
			if(e.getSource() == playingArray[0]) { 
				String label = playingArray[0].getLabel(); 
				if(playingArray[1].getLabel().equals("")) { 
					playingArray[1].setLabel(label);
					playingArray[1].setBackground(new Color(228,160,016));
					playingArray[0].setLabel("");
					playingArray[0].setBackground(new Color(203,208,204));
				} 
				if(playingArray[2].getLabel().equals("")) { 
					playingArray[2].setLabel(label);
					playingArray[2].setBackground(new Color(228,160,016));
					playingArray[0].setLabel(""); 
					playingArray[0].setBackground(new Color(203,208,204));
				} 		
			}
			
			if(e.getSource() == playingArray[1]) { 
				String label = playingArray[1].getLabel(); 
				if(playingArray[0].getLabel().equals("")) { 
					playingArray[0].setLabel(label);
					playingArray[0].setBackground(new Color(228,160,016));
					playingArray[1].setLabel("");
					playingArray[1].setBackground(new Color(203,208,204));
				} 
				if(playingArray[3].getLabel().equals("")) { 
					playingArray[3].setLabel(label);
					playingArray[3].setBackground(new Color(228,160,016));
					playingArray[1].setLabel("");
					playingArray[1].setBackground(new Color(203,208,204));
				} 		
			} 
			
			if(e.getSource() == playingArray[2]) { 
				String label = playingArray[2].getLabel(); 
				if(playingArray[0].getLabel().equals("")) { 
					playingArray[0].setLabel(label);
					playingArray[0].setBackground(new Color(228,160,016));
					playingArray[2].setLabel(""); 
					playingArray[2].setBackground(new Color(203,208,204));
				} 
				if(playingArray[3].getLabel().equals("")) { 
					playingArray[3].setLabel(label);
					playingArray[3].setBackground(new Color(228,160,016));
					playingArray[2].setLabel("");
					playingArray[2].setBackground(new Color(203,208,204));
				} 		
			} 
			
			if(e.getSource() == playingArray[3]) { 
				String label = playingArray[3].getLabel(); 
				if(playingArray[1].getLabel().equals("")) { 
					playingArray[1].setLabel(label);
					playingArray[1].setBackground(new Color(228,160,016));
					playingArray[3].setLabel("");
					playingArray[3].setBackground(new Color(203,208,204));
				} 
				if(playingArray[2].getLabel().equals("")) { 
					playingArray[2].setLabel(label); 
					playingArray[2].setBackground(new Color(228,160,016));
					playingArray[3].setLabel(""); 
					playingArray[3].setBackground(new Color(203,208,204));
				} 		
			}
			
//			if(playingArray[0].getLabel().equals("1") && playingArray[1].getLabel().equals("2") &&
//				playingArray[2].getLabel().equals("3") && playingArray[3].getLabel().equals("4")) {
//				System.out.println("WIN");
//				logArea.setText("YOU WON!!!");
//			}
		}
		
		if(dimSize == 3 && timer.isRunning()) {
			if(e.getSource() == playingArray[0]) { 
				String label = playingArray[0].getLabel(); 
				if(playingArray[1].getLabel().equals("")) { 
					playingArray[1].setLabel(label);
					playingArray[1].setBackground(new Color(228,160,016));
					playingArray[0].setLabel(""); 
					playingArray[0].setBackground(new Color(203,208,204));
				} 
				if(playingArray[3].getLabel().equals("")) { 
					playingArray[3].setLabel(label);
					playingArray[3].setBackground(new Color(228,160,016));
					playingArray[0].setLabel("");
					playingArray[0].setBackground(new Color(203,208,204));
				} 
			} 
			
			if(e.getSource() == playingArray[1]) { 
				String label = playingArray[1].getLabel(); 
				if(playingArray[0].getLabel().equals("")) { 
					playingArray[0].setLabel(label);
					playingArray[0].setBackground(new Color(228,160,016));
					playingArray[1].setLabel("");
					playingArray[1].setBackground(new Color(203,208,204));
				} 
				if(playingArray[2].getLabel().equals("")) { 
					playingArray[2].setLabel(label); 
					playingArray[2].setBackground(new Color(228,160,016));
					playingArray[1].setLabel("");
					playingArray[1].setBackground(new Color(203,208,204));
				} 
				if(playingArray[4].getLabel().equals("")) { 
					playingArray[4].setLabel(label);
					playingArray[4].setBackground(new Color(228,160,016));
					playingArray[1].setLabel("");
					playingArray[1].setBackground(new Color(203,208,204));
				} 
			} 
				
			if(e.getSource() == playingArray[2]) { 
				String label = playingArray[2].getLabel(); 
				if(playingArray[1].getLabel().equals("")) { 
					playingArray[1].setLabel(label);
					playingArray[1].setBackground(new Color(228,160,016));
					playingArray[2].setLabel("");
					playingArray[2].setBackground(new Color(203,208,204));
				} 
				if(playingArray[5].getLabel().equals("")) { 
					playingArray[5].setLabel(label);
					playingArray[5].setBackground(new Color(228,160,016));
					playingArray[2].setLabel("");
					playingArray[2].setBackground(new Color(203,208,204));
				} 
			} 
				
			if(e.getSource() == playingArray[3]) { 
				String label = playingArray[3].getLabel(); 
				if(playingArray[0].getLabel().equals("")) { 
					playingArray[0].setLabel(label);
					playingArray[0].setBackground(new Color(228,160,016));
					playingArray[3].setLabel("");
					playingArray[3].setBackground(new Color(203,208,204));
				} 
				if(playingArray[6].getLabel().equals("")) { 
					playingArray[6].setLabel(label);
					playingArray[6].setBackground(new Color(228,160,016));
					playingArray[3].setLabel("");
					playingArray[3].setBackground(new Color(203,208,204));
				} 
				if(playingArray[4].getLabel().equals("")) { 
					playingArray[4].setLabel(label);
					playingArray[4].setBackground(new Color(228,160,016));
					playingArray[3].setLabel("");
					playingArray[3].setBackground(new Color(203,208,204));
				} 
			} 
				
			if(e.getSource() == playingArray[4]) { 
				String label = playingArray[4].getLabel(); 
				if(playingArray[1].getLabel().equals("")) { 
					playingArray[1].setLabel(label);
					playingArray[1].setBackground(new Color(228,160,016));
					playingArray[4].setLabel("");
					playingArray[4].setBackground(new Color(203,208,204));
				} 
				if(playingArray[5].getLabel().equals("")) { 
					playingArray[5].setLabel(label);
					playingArray[5].setBackground(new Color(228,160,016));
					playingArray[4].setLabel("");
					playingArray[4].setBackground(new Color(203,208,204));
				} 
				if(playingArray[3].getLabel().equals("")) { 
					playingArray[3].setLabel(label);
					playingArray[3].setBackground(new Color(228,160,016));
					playingArray[4].setLabel("");
					playingArray[4].setBackground(new Color(203,208,204));
				} 
				if(playingArray[7].getLabel().equals("")) { 
					playingArray[7].setLabel(label);
					playingArray[7].setBackground(new Color(228,160,016));
					playingArray[4].setLabel("");
					playingArray[4].setBackground(new Color(203,208,204));
				} 
			} 
				
			if(e.getSource() == playingArray[5]) { 
				String label = playingArray[5].getLabel(); 
				if(playingArray[8].getLabel().equals("")) { 
					playingArray[8].setLabel(label);
					playingArray[8].setBackground(new Color(228,160,016));
					playingArray[5].setLabel("");
					playingArray[5].setBackground(new Color(203,208,204));
				} 
				if(playingArray[2].getLabel().equals("")) { 
					playingArray[2].setLabel(label);
					playingArray[2].setBackground(new Color(228,160,016));
					playingArray[5].setLabel("");
					playingArray[5].setBackground(new Color(203,208,204));
				} 
				if(playingArray[4].getLabel().equals("")){ 
					playingArray[4].setLabel(label);
					playingArray[4].setBackground(new Color(228,160,016));
					playingArray[5].setLabel("");
					playingArray[5].setBackground(new Color(203,208,204));
				} 
			} 
			
			if(e.getSource() == playingArray[6]) { 
				String label = playingArray[6].getLabel(); 
				if(playingArray[3].getLabel().equals("")) { 
					playingArray[3].setLabel(label);
					playingArray[3].setBackground(new Color(228,160,016));
					playingArray[6].setLabel("");
					playingArray[6].setBackground(new Color(203,208,204));
				} 
				if(playingArray[7].getLabel().equals("")) { 
					playingArray[7].setLabel(label);
					playingArray[7].setBackground(new Color(228,160,016));
					playingArray[6].setLabel("");
					playingArray[6].setBackground(new Color(203,208,204));
				} 
			} 
			
			if(e.getSource() == playingArray[7]) {
				String label = playingArray[7].getLabel(); 
				if(playingArray[8].getLabel().equals("")) { 
					playingArray[8].setLabel(label);
					playingArray[8].setBackground(new Color(228,160,016));
					playingArray[7].setLabel("");
					playingArray[7].setBackground(new Color(203,208,204));
				} 
				if(playingArray[6].getLabel().equals("")) { 
					playingArray[6].setLabel(label);
					playingArray[6].setBackground(new Color(228,160,016));
					playingArray[7].setLabel("");
					playingArray[7].setBackground(new Color(203,208,204));
				} 
				if(playingArray[4].getLabel().equals("")){ 
					playingArray[4].setLabel(label);
					playingArray[4].setBackground(new Color(228,160,016));
					playingArray[7].setLabel("");
					playingArray[7].setBackground(new Color(203,208,204));
				} 
			}
			
			if(e.getSource() == playingArray[8]) {
				String label = playingArray[8].getLabel(); 
				if(playingArray[5].getLabel().equals("")) { 
					playingArray[5].setLabel(label);
					playingArray[5].setBackground(new Color(228,160,016));
					playingArray[8].setLabel("");
					playingArray[8].setBackground(new Color(203,208,204));
				} 
				if(playingArray[7].getLabel().equals("")) { 
					playingArray[7].setLabel(label);
					playingArray[7].setBackground(new Color(228,160,016));
					playingArray[8].setLabel("");
					playingArray[8].setBackground(new Color(203,208,204));
				} 
			}
		}
		
		if(dimSize == 4 && timer.isRunning()) {
			
		}
		
		if(dimSize == 5 && timer.isRunning()) {
			
		}
	}
}