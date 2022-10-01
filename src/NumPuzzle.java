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
	
	private JFrame frame; // main frame

	
	/* Panels for the puzzle and options */
	private JPanel playingPane,rightPane;
	
	
	/* Size and font of the buttons and options */
	Font modeFont = new Font("Sansserif", Font.BOLD, 35);
	Font buttonFont = new Font("Arial", Font.PLAIN, 50);
	
	
	JButton[] btnArray; // Array of buttons
	
	
	/* Buttons needed for the puzzle */
	JButton btn1;JButton btn2;JButton btn3;JButton btn4;JButton btn5;
	JButton btn6;JButton btn7;JButton btn8;JButton btn9;JButton btn10;
	JButton btn11;JButton btn12;JButton btn13;JButton btn14;JButton btn15;
	JButton btn16;JButton btn17;JButton btn18;JButton btn19;JButton btn20;
	JButton btn21;JButton btn22;JButton btn23;JButton btn24;JButton btn25;
	
	
	/* Buttons needed for the options */
	JButton startButton = new JButton("Start");
	JButton restartButton = new JButton("Restart");
	JButton clearButton = new JButton("Clear");
	JButton saveButton = new JButton("Save");
	JButton loadButton = new JButton("Load");
	JButton randButton = new JButton("Shuffle");
	JButton hideButton = new JButton("Hide");
	JButton finButton = new JButton("Finish");
	
	
	/* Menu variables */
//	private JMenu menu;
//	private JMenuItem gameItem, helpItem;
	
	
	/* Label variables */
	private JLabel iconLabel;
//	private JLabel timeLabel,scoreLabel,logoLabel;
	
	
//	/* check box for mode */
//	private Checkbox modeCheckBox = new Checkbox("Mode :");
	
	
	/* Options for game */
	private String sizeOptions[] = 	{"2x2","3x3","4x4","5x5"};	
	private String typeOption[] = {"Text","Num"};
	
	
	/* Combobox for type options, game options */
	private JComboBox<String> typeOptionList;
	private JComboBox<String> gameOptionsList;
	
	
	/* Variables for the dimensions */
	private int dimSize;
	private String gameSize;
	
	
	/* Radio button for the options */
	private JRadioButton r1;
	private JRadioButton r2;
	
	
	/* Text field for time and point */
	private JTextField timeDisplay;
	private JTextField pointDisplay;
	
	
	/* Text field for history(log) */
	private JTextArea logArea;
	
	
	/* Method to start */
	public NumPuzzle() {
		setAndLaunch();
		puzzleDimension(gameSize, dimSize);
	}
	
	
	/*launch*/
	private void setAndLaunch() {
		
		
		/* Logo icon and size */
		ImageIcon logoIcon = new ImageIcon("Logo.png");
		iconLabel = new JLabel();
		iconLabel.setIcon(logoIcon);
		iconLabel.setBounds(50,30,300,60);
		iconLabel.setBackground(new Color(203,208,204));
		timeDisplay = new JTextField();
		timeDisplay.setFont(modeFont);
		
		
		frame = new JFrame("Fun Number Puzzle made by Jaeho Oh and Nathan Chen"); // Title
		
		
		/* Center panel for playing */
		playingPane = new JPanel();
//		playingPane.setBounds(100,100,500,500);		
		playingPane.setBounds(10,10,650,650);
		playingPane.setBackground(new Color(203,208,204));

		
		/* Right panel for components */
		rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		
		
		rightPane.add(iconLabel); // Add icon to right pane
		
		
		/* Add panels to the frame */
		frame.add(rightPane);
		frame.add(playingPane);
		
		
		rightPane.setBounds(670,0,400,850);
		rightPane.setBackground(new Color(231,235,218));
		rightPane.add(clearButton);

		clearButton.setBounds(650,400,10,10);
		clearButton.setBounds(140,600,100,50);
		clearButton.setBackground(new Color(228,160,016));

		
		/* Option list (drop-down) for the dimensions of the game */
		gameOptionsList = new JComboBox<String>(sizeOptions);

		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		gameOptionsList.setFont(modeFont);
		//gameOptionsList.setRenderer(centerRenderer);
		
		/* Add buttons for the center panel */
		btn1 = new JButton("1");
		btn1.setBackground(new Color(228,160,016));
		btn2 = new JButton("2");
		btn2.setBackground(new Color(228,160,016));
		btn3 = new JButton("3");
		btn3.setBackground(new Color(228,160,016));
		btn4 = new JButton("4");
		btn4.setBackground(new Color(228,160,016));
		btn5 = new JButton("5");
		btn5.setBackground(new Color(228,160,016));
		btn6 = new JButton("6");
		btn6.setBackground(new Color(228,160,016));
		btn7 = new JButton("7");
		btn7.setBackground(new Color(228,160,016));
		btn8 = new JButton("8");
		btn8.setBackground(new Color(228,160,016));
		btn9 = new JButton("9");
		btn9.setBackground(new Color(228,160,016));
		btn10 = new JButton("10");
		btn10.setBackground(new Color(228,160,016));
		btn11 = new JButton("11");
		btn11.setBackground(new Color(228,160,016));
		btn12 = new JButton("12");
		btn12.setBackground(new Color(228,160,016));
		btn13 = new JButton("13");
		btn13.setBackground(new Color(228,160,016));
		btn14 = new JButton("14");
		btn14.setBackground(new Color(228,160,016));
		btn15 = new JButton("15");
		btn15.setBackground(new Color(228,160,016));
		btn16 = new JButton("16");
		btn16.setBackground(new Color(228,160,016));
		btn25 = new JButton(" ");
		btn25.setBackground(new Color(203,208,204));		
		
		
		/* Actions */
		ActionListener cbActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				gameSize = (String) gameOptionsList.getSelectedItem();
				
				//System.out.println(gameSize);
				dimSize = Character.getNumericValue(gameSize.charAt(0));
				//System.out.println(dimSize);
				
				puzzleDimension(gameSize, dimSize);
			}
		};
		
		
		gameOptionsList.addActionListener(cbActionListener);
		
		
		JLabel dimTitle = new JLabel("Dim : ");
		dimTitle.setFont(modeFont);
		
		rightPane.add(dimTitle);
		rightPane.add(gameOptionsList);
		gameOptionsList.addActionListener(this);
		
		
		dimTitle.setBounds(60,115,180,40);
		
		gameOptionsList.setBounds(160,115,180,40);
		gameOptionsList.setBackground(new Color(203,208,204));
		
		JLabel dummyLabel = new JLabel(); 
		
		
		/* Mode option */
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
		
		
		/* Button options for the right panel */
		saveButton.setBounds(55,230,80,50);
		saveButton.setBackground(new Color(228,160,016));
		rightPane.add(saveButton);
		
		loadButton.setBounds(150,230,80,50);
		loadButton.setBackground(new Color(228,160,016));
		rightPane.add(loadButton);
		
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
		typeOptionList.setBackground(new Color(203,208,204));
		rightPane.add(typeOptionList);
		
		
		/* Type font and size */
		JLabel typeTitle = new JLabel("Type : ");
		typeTitle.setFont(new Font("Sansserif", Font.BOLD, 15));
		typeTitle.setBounds(45, 380, 55, 30);
		rightPane.add(typeTitle);
		
		
		/*time and point displays*/
		timeDisplay = new JTextField("0");
		pointDisplay = new JTextField("0");
		
		timeDisplay.setFont(new Font("Sansserif", Font.BOLD, 15));
		timeDisplay.setEditable(false);
		pointDisplay.setFont(new Font("Sansserif", Font.BOLD, 15));
		pointDisplay.setEditable(false);
		
		timeDisplay.setBounds(100,420,70,30);
		timeDisplay.setBackground(new Color(203,208,204));
		pointDisplay.setBounds(100,460,70,30);
		pointDisplay.setBackground(new Color(203,208,204));
		
		
		JLabel timeTitle = new JLabel("Time");
		JLabel pointTitle = new JLabel("Point");
		
		timeTitle.setFont(new Font("Sansserif", Font.BOLD, 15));
		pointTitle.setFont(new Font("Sansserif", Font.BOLD, 15));
		timeTitle.setBounds(45,420,55,30);
		pointTitle.setBounds(45,460,55,30);
		
		
		rightPane.add(timeDisplay);rightPane.add(pointDisplay);
		rightPane.add(timeTitle);rightPane.add(pointTitle);
		
		
		/*Text input area*/
		JTextField inputText = new JTextField();
		inputText.setBounds(45,500,135,30);
		inputText.setFont(new Font("Sansserif", Font.BOLD, 13));
		rightPane.add(inputText);
		
		
		/*log history area*/
		logArea = new JTextArea("Your move");		
		logArea.setBounds(200,380,130,150);
		logArea.setBackground(new Color(203,208,204));
		logArea.setEditable(false);
		logArea.setBackground(new Color(203,208,204));
		logArea.setFont(new Font("Sansserif", Font.BOLD, 15));
		rightPane.add(logArea);
	
		
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
	
	private void puzzleDimension(String gameSize, int dimSize) {
		playingPane.removeAll();
		
		
		/* The dimensions for the puzzle in the center panel */
		switch(dimSize) {
			case 2: // If the dimension is 2x2
				playingPane.revalidate();
				playingPane.add(btn1);
				playingPane.add(btn2);
				playingPane.add(btn3);
				playingPane.add(btn25);
				playingPane.setLayout(new GridLayout(2,2,4,4));
				break;
			case 3: // If the dimension is 3x3
				playingPane.revalidate();
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
			case 4: // If the dimension is 4x4
				playingPane.revalidate();
				playingPane.add(btn1);
				playingPane.add(btn2);
				playingPane.add(btn3);
				playingPane.add(btn4);
				playingPane.add(btn5);
				playingPane.add(btn6);
				playingPane.add(btn7);
				playingPane.add(btn8);
				playingPane.add(btn9);
				playingPane.add(btn10);
				playingPane.add(btn11);
				playingPane.add(btn12);
				playingPane.add(btn13);
				playingPane.add(btn14);
				playingPane.add(btn15);
				playingPane.add(btn25);
				playingPane.setLayout(new GridLayout(4,4,4,4));
				break;
			default: // Dimension is 3x3 by default
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
	
	
	private Timer timer = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			seconds++;
			seconds_String = String.format("%01d", seconds);
		}
	});
	
	
	/* Score and seconds variables */
	private int score;
	private int seconds = 0;
	private boolean started = false;
	private String seconds_String = String.format("%01d", seconds);
	private String score_String = String.format("%d", score);
	
	
	ImageIcon logo = new ImageIcon("Logo.gif");
	
	
	public static void main(String[] args) {
		new NumPuzzle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*button logic*/
		
	}
}