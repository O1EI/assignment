package puzzle;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GameView {
	
	private JFrame frame;//main frame

	
	JTextField inputText;
	
	//panels that I need
	protected JPanel playingPane,rightPane;
	
	/*Font*/
	Font modeFont = new Font("Sansserif", Font.BOLD, 35);
	Font buttonFont = new Font("Arial", Font.PLAIN, 50);
	
	/*buttons that is needed*/
	protected JButton[] btnArray;
	protected JButton[] answerArray;
	protected JButton[] playingArray;
	
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
	protected JComboBox<String> typeOptionList;
	protected JComboBox<String> gameOptionsList;
	
	/*Variable*/

	protected int dimSize = 3;

	protected String gameSize;
	protected String textValue;
	
	//Time variables
	
	
	/*Radio button*/
	private JRadioButton r1;
	private JRadioButton r2;
	
	
	/*text field for time and point*/
	protected JTextField timeDisplay;
	private JTextField pointDisplay;
	
	
	/*text field for history(log)*/
	private JTextArea logArea;
	
	JMenuBar menuBar;
	JMenu gameMenu,helpMenu;
	JMenuItem itemNew,itemSolution,itemExit,itemColors,itemAbout;
	
	
	/**
	 * Default Constructor
	 */
	public GameView() {
		setAndLaunch();
		puzzleDimension(dimSize);
	}
	
	
	/**
	 * To Launch the game
	 */
	private void setAndLaunch() {
		
		ImageIcon logoIcon = new ImageIcon("images/Logo.png");
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
		
		menuBar = new JMenuBar();
		
		gameMenu = new JMenu("Game");
		gameMenu.setMnemonic(KeyEvent.VK_G);
		menuBar.add(gameMenu);
		
		itemNew = new JMenuItem("New",new ImageIcon("images/iconnew.png"));
		itemNew.setMnemonic(KeyEvent.VK_N);
		itemSolution = new JMenuItem("Solution",new ImageIcon("images/iconsol.png"));
		itemSolution.setMnemonic(KeyEvent.VK_S);
		itemExit = new JMenuItem("Exit",new ImageIcon("images/iconext.png"));
		itemExit.setMnemonic(KeyEvent.VK_E);
		gameMenu.add(itemNew);
		gameMenu.add(itemSolution);
		gameMenu.add(itemExit);
		
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		menuBar.add(helpMenu);
		
		itemColors = new JMenuItem("Colors",new ImageIcon("images/iconcol.png"));
		itemColors.setMnemonic(KeyEvent.VK_C);
		itemAbout = new JMenuItem("About",new ImageIcon("images/iconabt.png"));
		itemAbout.setMnemonic(KeyEvent.VK_A);
		helpMenu.add(itemColors);
		helpMenu.add(itemAbout);
		
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

		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		gameOptionsList.setFont(modeFont);
		gameOptionsList.setRenderer(centerRenderer);
		
		JLabel dimTitle = new JLabel("Dim : ");
		dimTitle.setFont(modeFont);
		
		rightPane.add(dimTitle);
		rightPane.add(gameOptionsList);	
		
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
		
//		
		
		randButton.setBounds(245,230,80,50);
		randButton.setBackground(new Color(228,160,016));		
		rightPane.add(randButton);
		
		startButton.setBounds(55,300,125,50);
		startButton.setBackground(new Color(228,160,016));
		rightPane.add(startButton);
		
		hideButton.setBounds(200,300,125,50);
		hideButton.setBackground(new Color(228,160,016));
		rightPane.add(hideButton);
		
		
		
		/*type selection here*/
		typeOptionList = new JComboBox<String>(typeOption);
		typeOptionList.setFont(new Font("Sansserif", Font.BOLD, 15));
		typeOptionList.setRenderer(centerRenderer);
		typeOptionList.setBounds(100,380,70,30);
		
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
		inputText = new JTextField();
		inputText.setBounds(45,500,135,30);
		inputText.setFont(new Font("Sansserif", Font.BOLD, 13));
		
		  
		
		rightPane.add(inputText);
		logArea = new JTextArea("Your move");		
		logArea.setBounds(200,380,130,150);
		logArea.setEditable(false);
		logArea.setBackground(new Color(203,208,204));
		logArea.setFont(new Font("Sansserif", Font.BOLD, 15));
		rightPane.add(logArea);
		
		
		
		rightPane.add(dummyLabel);
		
		
		/*to actually launch the program*/
		
		frame.setLayout(null);
		frame.pack();
		frame.setJMenuBar(menuBar);
		
		frame.setSize(new Dimension(1080,740));//size of the application
		
		frame.setResizable(false);//if the user can re size the window
		
		frame.setLocationByPlatform(true);
				
		frame.setVisible(true);
		
		
	}
	
	
	public void addListeners(
			ActionListener cbActionListener,
			ActionListener shuffleActionListener,
			ActionListener typeActionListener,
			ActionListener inputActionListener,
			ActionListener radioDesignActionListener,
			ActionListener startActionListener,
			ActionListener radioPlayActionListener 
			) {
		
		gameOptionsList.addActionListener(cbActionListener);
		randButton.addActionListener(shuffleActionListener);
		typeOptionList.addActionListener(typeActionListener);
		inputText.addActionListener(inputActionListener);
		r1.addActionListener(radioDesignActionListener);
		startButton.addActionListener(startActionListener);
		r2.addActionListener(radioPlayActionListener);
		
	}
	
	/**
	 * Method to set and generate the puzzle
	 * 
	 * @param dimSize for set the size of dimension
	 */
	protected void puzzleDimension( int dimSize) {
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
	
	

	/**
	 * Method to put the text for puzzle
	 * @param textValue for input from user to put text
	 * @param dimSize for size of the dimension
	 */

//	private Timer timer = new Timer(1000, new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			seconds++;
//			seconds_String = String.format("%01d", seconds);
//		}
//	});
	
	private int score;
	//private int seconds = 0;
	private boolean started = false;
//	private String seconds_String = String.format("%01d", seconds);
	private String score_String = String.format("%d", score);
	
	
	ImageIcon logo = new ImageIcon("Logo.gif");
	
	
	
	
	
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
	
	/**
	 * Method to put numbers into puzzle
	 * @param dimSize for size of the dimension
	 */
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
	
	public String getAnswer() {
		String answer = String.valueOf(dimSize)+ " : ";
		for(int i = 0; i < 25 ; i++) {
			answer = answer + String.valueOf(answerArray[i]);
		}
		return answer;
	}

	public void btnAddActionListener(ActionListener btnacl) {
		for(int i = 0; i < 25 ; i++) {
			btnArray[i].addActionListener(btnacl);
		}
	}
	
	public void menuAddActionListener(ActionListener newAction, ActionListener solAction,
			ActionListener exitAction, ActionListener colorAction,ActionListener abtAction) {
		itemNew.addActionListener(newAction);
		itemSolution.addActionListener(solAction);
		itemExit.addActionListener(exitAction);
		itemColors.addActionListener(colorAction);
		itemAbout.addActionListener(abtAction);
	}
		
	
}
