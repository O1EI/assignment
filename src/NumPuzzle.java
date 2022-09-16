import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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
	private JLabel timeLabel,scoreLabel,logoLabel;
	
	
	/*check box for mode*/
	private Checkbox modeCheckBox = new Checkbox("Mode :");
	
	
	
	/*Options for game*/
	private String sizeOptions[] = 	{"2x2","3x3","4x4","5x5"};	
	private String timeOptions[] = {"UP","DOWN"};
	
	
	private JComboBox timeOptionList;
	private JComboBox gameOptionsList;
	
	
	private JTextField timeDisplay;
	private JTextField pointDisplay;
	
	
	private JTextArea logArea;
	
	private String sizeOption;
	public NumPuzzle(){
		setAndLaunch();
	}
	
	private void setAndLaunch() {
		Font font1 = new Font("Sansserif", Font.BOLD, 20);
		timeDisplay = new JTextField();
		timeDisplay.setFont(font1);
		
		
		
		frame = new JFrame("Fun Number Puzzle made by Jaeho Oh and Nathan Chen");
		
		
		playingPane = new JPanel();
		playingPane.setBackground(new Color(203,208,204));
		playingPane.setBounds(100,100,500,500);
		playingPane.add(btn1);playingPane.add(btn2);playingPane.add(btn3);
		playingPane.add(btn4);playingPane.add(btn5);playingPane.add(btn6);
		playingPane.add(btn7);playingPane.add(btn8);playingPane.add(btn9);
		playingPane.setLayout(new GridLayout(3,3,4,4));
		
		
		rightPane = new JPanel();
		historyPane = new JPanel();
		
		frame.add(playingPane);
		frame.add(rightPane);
		frame.add(historyPane);
		gameOptionsList = new JComboBox(sizeOptions);
		
		gameOptionsList.setBounds(50,50,90,20);
		
		
		frame.addWindowListener(this);
		frame.setLayout(null);
		frame.pack();
		
		frame.setSize(new Dimension(1000,700));
		
		frame.setResizable(false);
		
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
