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
	
	
	
	
	/*buttons that is needed*/
	JButton btn1 = new JButton();
	JButton btn2 = new JButton();
	JButton btn3 = new JButton();
	JButton btn4 = new JButton();
	JButton btn5 = new JButton();
	JButton btn6 = new JButton();
	JButton btn7 = new JButton();
	JButton btn8 = new JButton();
	JButton btn9 = new JButton();
	JButton startButton = new JButton("Start");
	JButton restartButton = new JButton("Restart");
	JButton clearButton = new JButton("Clear");
	
	
	
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
	
	/*Icon*/
	
	
	
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
		Font modeFont = new Font("Sansserif", Font.BOLD, 35);//font setting
		ImageIcon logoIcon = new ImageIcon("Logo.png");
		iconLabel = new JLabel();
		iconLabel.setIcon(logoIcon);
		iconLabel.setBounds(30,30,300,60);
		timeDisplay = new JTextField();
		timeDisplay.setFont(modeFont);
		
		
		
		frame = new JFrame("Fun Number Puzzle made by Jaeho Oh and Nathan Chen");//title
		
		
		/*center panel for playing*/
		playingPane = new JPanel();
		playingPane.setBackground(new Color(203,208,204));
		playingPane.setBounds(100,100,500,500);
		playingPane.add(btn1);playingPane.add(btn2);playingPane.add(btn3);
		playingPane.add(btn4);playingPane.add(btn5);playingPane.add(btn6);
		playingPane.add(btn7);playingPane.add(btn8);playingPane.add(btn9);
		playingPane.setLayout(new GridLayout(3,3,4,4));
		
		
		/*panel that is on right side for the components*/
		rightPane = new JPanel();
		rightPane.setLayout(new BorderLayout());
		
		rightPane.add(iconLabel);
		
		
		/*panel that is on right bottom for history*/
		historyPane = new JPanel();
		
		
		/*adding panels to frame*/
		frame.add(playingPane);
		frame.add(rightPane);
		frame.add(historyPane);
		
		
		rightPane.setBounds(630,0,400,700);
		rightPane.setBackground(Color.yellow);
		rightPane.add(clearButton);
		clearButton.setBounds(650,400,10,10);
		
		
		/*option list for the size of the game*/
		gameOptionsList = new JComboBox(sizeOptions);
		DefaultListCellRenderer centerRenderer = new DefaultListCellRenderer();
		centerRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		gameOptionsList.setFont(modeFont);
		gameOptionsList.setRenderer(centerRenderer);
		
		JLabel dimTitle = new JLabel("Dim : ");
		dimTitle.setFont(modeFont);

		rightPane.add(dimTitle);
		rightPane.add(gameOptionsList);
		dimTitle.setBounds(50,115,180,40);
		
		gameOptionsList.setBounds(150,115,180,40);
		
		JLabel dummyLabel = new JLabel(); 
		
		
		/*Mode option*/
		r1 = new JRadioButton("Design");
		r2 = new JRadioButton("Play");
		r1.setBounds(150,160,80,60);
		r2.setBounds(230,160,50,60);
		r1.setBackground(Color.yellow);
		r2.setBackground(Color.yellow);
		r1.setMnemonic(KeyEvent.VK_D);
		r2.setMnemonic(KeyEvent.VK_P);
		JLabel modeTitle = new JLabel("Mode: ");
		
		ButtonGroup modeGroup = new ButtonGroup();
		modeTitle.setBounds(90,150,40,80);
		rightPane.add(modeTitle);
		modeGroup.add(r1);modeGroup.add(r2);
		
		rightPane.add(r1);rightPane.add(r2);
		rightPane.add(dummyLabel);
		
		
		/*to actually launch the program*/
		frame.addWindowListener(this);
		frame.setLayout(null);
		frame.pack();
		
		
		
		
		frame.setSize(new Dimension(1000,700));//size of the application
		
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
		
	}
}
