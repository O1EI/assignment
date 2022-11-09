package puzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Random;
import java.util.Timer;

import javax.swing.JButton;

public class GameController {

	GameView gameView = new GameView();
	ActionListener cbActionListener;
	ActionListener shuffleActionListener;
	ActionListener typeActionListener;
	ActionListener startActionListener;
	ActionListener radioDesignActionListener;
	ActionListener radioPlayActionListener;
	ActionListener inputActionListener;
	Random rand = new Random();//to shuffle the board
	protected Timer timer;
	
	/**
	 * Default constructor
	 */
	public GameController() {		
	}
	
	public GameController(GameModel gameModel, GameView gameView) {
		
		addActionListeners();
		
	}
		
		
		
	private void addActionListeners() {
		
		gameView.addListeners(
		 cbActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				gameView.gameSize = (String) gameView.gameOptionsList.getSelectedItem();
				
				//System.out.println(gameSize);
				gameView.dimSize = Character.getNumericValue(gameView.gameSize.charAt(0));
				//System.out.println(dimSize);
				
				gameView.puzzleDimension(gameView.dimSize);	
			}
		},
		
		
		 shuffleActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(gameView.playingArray != null) {
					for(int i = 0; i< gameView.playingArray.length ; i++) {
						int randIndexNum = rand.nextInt(gameView.playingArray.length);
						JButton temp = gameView.playingArray[randIndexNum];
						gameView.playingArray[randIndexNum] = gameView.playingArray[i];
						gameView.playingArray[i]= temp;
					}
					for(int i = 0 ; i< gameView.playingArray.length; i++)
						gameView.playingPane.add(gameView.playingArray[i]);
					gameView.playingPane.revalidate();
				}
			}		
		},
		
		
		typeActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				String typeOptionSelected;
				typeOptionSelected = (String) gameView.typeOptionList.getSelectedItem();
				
				switch(typeOptionSelected) {
				case "Num":
//					System.out.println("Num");
					gameView.puzzleDimension(gameView.dimSize);
					break;	
				case "Text":
//					System.out.println("text");
					if(gameView.textValue != null)
						gameView.putText(gameView.textValue,gameView.dimSize);
					break;
				default:
//					System.out.println("df");
					gameView.puzzleDimension(gameView.dimSize);	
				}		
			}
		},
		
		inputActionListener = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			    	  gameView.textValue = gameView.inputText.getText(); 
			      }
			
		},
		
		
		
		startActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				//System.out.println("Game Start");
				gameView.hideButton.setEnabled(false);
				gameView.typeOptionList.setEnabled(false);
				gameView.gameOptionsList.setEnabled(true);
				gameView.loadButton.setEnabled(false);
				gameView.startButton.setText("Pause");
			}
		},
		
		
		
		radioDesignActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				//System.out.println("Design");
				gameView.hideButton.setEnabled(true);
				gameView.typeOptionList.setEnabled(true);
				gameView.gameOptionsList.setEnabled(true);
				gameView.startButton.setText("Start");
				gameView.loadButton.setEnabled(true);
				timer.wait();
				gameView.seconds = 0;
				gameView.minutes = 0;
				gameView.timeDisplay.setText("0:00");
			}
		},
		
		radioPlayActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				//System.out.println("Play");
				gameView.hideButton.setEnabled(false);
				gameView.typeOptionList.setEnabled(false);
				gameView.gameOptionsList.setEnabled(true);
				gameView.startButton.setText("Start");
				gameView.loadButton.setEnabled(true);
			}
		});
	}
	
	
	

}
