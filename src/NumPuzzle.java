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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.html.ImageView;

public class NumPuzzle extends WindowAdapter implements ActionListener {
	
	private JFrame frame;//main frame
	
	
	//panels that I need
	private JPanel playingPane,rightPane,historyPane;
	
	/*Font*/
	Font modeFont = new Font("Sansserif", Font.BOLD, 35);
	Font buttonFont = new Font("Arial", Font.PLAIN, 50);
	
	/*buttons that is needed*/
	JButton[] btnArray;
	
	JButton btn1;JButton btn2;JButton btn3;JButton btn4;JButton btn5;
	JButton btn6;JButton btn7;JButton btn8;JButton btn9;JButton btn10;
	JButton btn11;JButton btn12;JButton btn13;JButton btn14;JButton btn15;
	JButton btn16;JButton btn17;JButton btn18;JButton btn19;JButton btn20;
	JButton btn21;JButton btn22;JButton btn23;JButton btn24;JButton btn25;
	
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
	
	
	
//	/*check box for mode*/
//	private Checkbox modeCheckBox = new Checkbox("Mode :");
	
	
	
	
	/*Options for game*/
	private String sizeOptions[] = 	{"2x2","3x3","4x4","5x5"};	
	private String timeOptions[] = {"UP","DOWN"};
	
	
	/*Combobox for time options, game options*/
	private JComboBox timeOptionList;
	private JComboBox gameOptionsList;
	
	/*Variable*/
	private int dimSize;
	
	
	/*Radio button*/
	private JRadioButton r1;
	private JRadioButton r2;
	
	
	/*text field for time and point*/
	private JTextField timeDisplay;
	private JTextField pointDisplay;
	
	
	
	/*text field for history(log)*/
	private JTextArea logArea;
	
	
	
	
	/*method to start*/
	public NumPuzzle(){
		setAndLaunch();
	}
	
	
	/*launch*/
	private void setAndLaunch() {
		
		ImageIcon logoIcon = new ImageIcon("Logo.png");
		iconLabel = new JLabel();
		iconLabel.setIcon(logoIcon);
		iconLabel.setBounds(50,30,300,60);
		timeDisplay = new JTextField();
		timeDisplay.setFont(modeFont);
		
		
		frame = new JFrame("Fun Number Puzzle made by Jaeho Oh and Nathan Chen");//title
		
		
		/*center panel for playing*/
		playingPane = new JPanel();
		playingPane.setBackground(new Color(203,208,204));
<<<<<<< HEAD
		playingPane.setBounds(100,100,500,500);
		
		
		playingPane.setLayout(new GridLayout(3,3,4,4));
		
=======
		playingPane.setBounds(10,10,650,650);
>>>>>>> branch 'master' of https://github.com/O1EI/NumberPuzzle.git
		
		/*panel that is on right side for the components*/
		rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		
		rightPane.add(iconLabel);
		
		
		/*panel that is on right bottom for history*/
		historyPane = new JPanel();
		
			
		/*adding panels to frame*/
		frame.add(rightPane);
		frame.add(playingPane);
		frame.add(historyPane);
		
		
		rightPane.setBounds(670,0,400,850);
		rightPane.setBackground(Color.yellow);
		rightPane.add(clearButton);
<<<<<<< HEAD
		clearButton.setBounds(650,400,10,10);
=======
		clearButton.setBounds(140,600,100,50);
>>>>>>> branch 'master' of https://github.com/O1EI/NumberPuzzle.git
		
		
		/*option list for the size of the game*/
		gameOptionsList = new JComboBox<String>(sizeOptions);
		
		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		gameOptionsList.setFont(modeFont);
		gameOptionsList.setRenderer(centerRenderer);
		
		//playingPane.addActionListener(new ActionListener() {
		ActionListener cbActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s = (String) gameOptionsList.getSelectedItem();
				
				System.out.println(s);
				
				switch(s) {
					case "2x2":
						playingPane.add(btn1);
						playingPane.add(btn2);
						playingPane.add(btn3);
						playingPane.add(btn9);
						break;
					case "3x3":
						playingPane.add(btn1);
						playingPane.add(btn2);
						playingPane.add(btn3);
						playingPane.add(btn4);
						playingPane.add(btn5);
						playingPane.add(btn6);
						playingPane.add(btn7);
						playingPane.add(btn8);
						playingPane.add(btn9);
						break;
				}
			}
		};
		
		gameOptionsList.addActionListener(cbActionListener);
	
		/*button text size and font*/
		btn1.setFont(new Font("Arial", Font.PLAIN, 50));
		btn2.setFont(new Font("Arial", Font.PLAIN, 50));
		btn3.setFont(new Font("Arial", Font.PLAIN, 50));
		btn4.setFont(new Font("Arial", Font.PLAIN, 50));
		btn5.setFont(new Font("Arial", Font.PLAIN, 50));
		btn6.setFont(new Font("Arial", Font.PLAIN, 50));
		btn7.setFont(new Font("Arial", Font.PLAIN, 50));
		btn8.setFont(new Font("Arial", Font.PLAIN, 50));
		btn9.setFont(new Font("Arial", Font.PLAIN, 50));
		
		/*allows buttons to perform actions*/
		btn1.addActionListener(this);  
		btn2.addActionListener(this);  
		btn3.addActionListener(this);  
		btn4.addActionListener(this);  
		btn5.addActionListener(this);  
		btn6.addActionListener(this);  
		btn7.addActionListener(this);  
		btn8.addActionListener(this);  
		btn9.addActionListener(this);
		
		JLabel dimTitle = new JLabel("Dim : ");
		dimTitle.setFont(modeFont);
		
		rightPane.add(dimTitle);
		rightPane.add(gameOptionsList);
		gameOptionsList.addActionListener(this);
		char gameSize = gameOptionsList.getActionCommand().charAt(0);
		dimSize = Character.getNumericValue(gameSize);
		dimSize = 5;
		
		btnArray = new JButton[25];
		
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		
		btn1.setFont(buttonFont);
		btn2.setFont(buttonFont);
		btn3.setFont(buttonFont);
		btn1.addActionListener(this);  
		btn2.addActionListener(this);  
		btn3.addActionListener(this);  
		
		playingPane.add(btn1);playingPane.add(btn2);playingPane.add(btn3);
		btnArray[0] = btn1;
		btnArray[1] = btn2;
		btnArray[2] = btn3;
		
		if(dimSize >2) {
			JButton btn4 = new JButton("4");
			JButton btn5 = new JButton("5");
			JButton btn6 = new JButton("6");
			JButton btn7 = new JButton("7");
			JButton btn8 = new JButton("8");
			
			btn4.setFont(buttonFont);
			btn5.setFont(buttonFont);
			btn6.setFont(buttonFont);
			btn7.setFont(buttonFont);
			btn8.setFont(buttonFont);
			btn4.addActionListener(this);  
			btn5.addActionListener(this);  
			btn6.addActionListener(this);  
			btn7.addActionListener(this);  
			btn8.addActionListener(this); 
			
			playingPane.add(btn4);playingPane.add(btn5);playingPane.add(btn6);
			playingPane.add(btn7);playingPane.add(btn8);
			btnArray[3] = btn4;
			btnArray[4] = btn5;
			btnArray[5] = btn6;
			btnArray[6] = btn7;
			btnArray[7] = btn8;
		}
		if(dimSize >3) {
			JButton btn9  = new JButton("9");
			JButton btn10 = new JButton("10");
			JButton btn11 = new JButton("11");
			JButton btn12 = new JButton("12");
			JButton btn13 = new JButton("13");
			JButton btn14 = new JButton("14");
			JButton btn15 = new JButton("15");
			
			btn9.setFont(buttonFont);
			btn10.setFont(buttonFont);
			btn11.setFont(buttonFont);
			btn12.setFont(buttonFont);
			btn13.setFont(buttonFont);
			btn14.setFont(buttonFont);
			btn15.setFont(buttonFont);
			btn9.addActionListener(this);
			
			
			playingPane.add(btn9);playingPane.add(btn10);playingPane.add(btn11);
			playingPane.add(btn12);playingPane.add(btn13);playingPane.add(btn14);
			playingPane.add(btn15);
			
			btnArray[8] = btn9;
			btnArray[9] = btn10;
			btnArray[10] = btn11;
			btnArray[11] = btn12;
			btnArray[12] = btn13;
			btnArray[13] = btn14;
			btnArray[14] = btn15;
		}
		if(dimSize >4) {
			JButton btn16 = new JButton("16");
			JButton btn17 = new JButton("17");
			JButton btn18 = new JButton("18");
			JButton btn19 = new JButton("19");
			JButton btn20 = new JButton("20");
			JButton btn21 = new JButton("21");
			JButton btn22 = new JButton("22");
			JButton btn23 = new JButton("23");
			JButton btn24 = new JButton("24");
			
			
			btn16.setFont(buttonFont);
			btn17.setFont(buttonFont);
			btn18.setFont(buttonFont);
			btn19.setFont(buttonFont);
			btn20.setFont(buttonFont);
			btn21.setFont(buttonFont);
			btn22.setFont(buttonFont);
			btn23.setFont(buttonFont);
			btn24.setFont(buttonFont);
			
			playingPane.add(btn16);playingPane.add(btn17);playingPane.add(btn18);
			playingPane.add(btn19);playingPane.add(btn20);playingPane.add(btn21);
			playingPane.add(btn22);playingPane.add(btn23);playingPane.add(btn24);
		
			btnArray[15] = btn16;
			btnArray[16] = btn17;
			btnArray[17] = btn18;
			btnArray[18] = btn19;
			btnArray[19] = btn20;
			btnArray[20] = btn21;
			btnArray[21] = btn22;
			btnArray[22] = btn23;
			btnArray[23] = btn24;
		
		}
		
		
		
			
		JButton btn25 = new JButton(" ");
		btnArray[btnArray.length-1] = btn25;
		
		
		playingPane.setLayout(new GridLayout(dimSize,dimSize,4,4));
		
		dimTitle.setBounds(60,115,180,40);
		
		gameOptionsList.setBounds(160,115,180,40);
		
		JLabel dummyLabel = new JLabel(); 
		
		
		/*Mode option*/
		r1 = new JRadioButton("Design");
		r2 = new JRadioButton("Play");
		r1.setBounds(160,160,80,60);
		r2.setBounds(240,160,50,60);
		r1.setBackground(Color.yellow);
		r2.setBackground(Color.yellow);
		r1.setMnemonic(KeyEvent.VK_D);
		r2.setMnemonic(KeyEvent.VK_P);
		JLabel modeTitle = new JLabel("Mode: ");
		
		ButtonGroup modeGroup = new ButtonGroup();
		modeTitle.setBounds(100,150,40,80);
		rightPane.add(modeTitle);
		modeGroup.add(r1);modeGroup.add(r2);
		
		rightPane.add(r1);rightPane.add(r2);
		
		
		
		//rightPane.add(startButton);rightPane.add(hideButton);rightPane.add(saveButton);
		//rightPane.add(loadButton);rightPane.add(randButton);rightPane.add(finButton);
		
		
		saveButton.setBounds(55,230,80,50);
		rightPane.add(saveButton);
		
		loadButton.setBounds(150,230,80,50);
		rightPane.add(loadButton);
		
		randButton.setBounds(245,230,80,50);
		rightPane.add(randButton);
		
		startButton.setBounds(55,300,125,50);
		rightPane.add(startButton);
		
		hideButton.setBounds(200,300,125,50);
		rightPane.add(hideButton);
		

		for(int i = 0; i<dimSize;i++) {
		
		}
		
		
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
	
	
	
	
	
	private Timer timer = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			seconds++;
			seconds_String = String.format("%01d", seconds);
		}
	});
	
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
