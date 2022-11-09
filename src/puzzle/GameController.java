package puzzle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.Random;


import javax.swing.JButton;
import javax.swing.Timer;

public class GameController {
	
	protected Timer timer;
	protected int seconds = 0, minutes = 0;
	protected String dSeconds, dMinutes;
	protected DecimalFormat dFormat = new DecimalFormat("00");

	GameView gameView;
	ActionListener cbActionListener;
	ActionListener shuffleActionListener;
	ActionListener typeActionListener;
	ActionListener startActionListener;
	ActionListener radioDesignActionListener;
	ActionListener radioPlayActionListener;
	ActionListener inputActionListener;
	ActionListener btnActionListener;
	ActionListener newActionListener;
	ActionListener solActionListener;
	ActionListener exitActionListener;
	ActionListener colActionListener;
	ActionListener abtActionListener;
	
	Random rand = new Random();//to shuffle the board

	


	
	/**
	 * Default constructor
	 */
	public GameController() {		
	}
	
	public GameController(GameModel gameModel, GameView gameView) {
		this.gameView = gameView;
		addActionListeners();
		addBtnActionListener();
		addMenuActionListener();
		
	}
	
	private void addMenuActionListener() {
		gameView.menuAddActionListener(
				newActionListener = new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						GameView tempGame = new GameView();
						gameView.terminate();
						gameView = tempGame;						
					}
				}, 
				solActionListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						gameView.btnArray = gameView.answerArray;
					}
				}, 
				exitActionListener = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						gameView.terminate();
					}
				}, btnActionListener, inputActionListener);
		
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
				gameView.hideButton.setEnabled(false);
				gameView.typeOptionList.setEnabled(false);
				gameView.gameOptionsList.setEnabled(false);
				gameView.inputText.setEnabled(false);
				gameView.loadButton.setEnabled(false);
				gameView.randButton.setEnabled(false);
				gameView.startButton.setEnabled(false);
				timer.start();
			}
		},
		
		radioDesignActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				//System.out.println("Design");
				gameView.hideButton.setEnabled(true);
				gameView.typeOptionList.setEnabled(true);
				gameView.gameOptionsList.setEnabled(true);
				gameView.inputText.setEnabled(true);
				gameView.loadButton.setEnabled(true);			
				gameView.randButton.setEnabled(true);
				gameView.startButton.setEnabled(false);
				timer.stop();
				seconds = 0;
				minutes = 0;
				gameView.timeDisplay.setText("0:00");
			}
		},
		
		radioPlayActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				gameView.hideButton.setEnabled(false);
				gameView.typeOptionList.setEnabled(false);
				gameView.gameOptionsList.setEnabled(true);
				gameView.inputText.setEnabled(false);
				gameView.loadButton.setEnabled(true);
				gameView.randButton.setEnabled(true);
				gameView.startButton.setEnabled(true);
				timer.stop();
				seconds = 0;
				minutes = 0;
				gameView.timeDisplay.setText("0:00");
			}
		}
		
		);
	}
	
	private void addBtnActionListener() {
		gameView.btnAddActionListener(
				btnActionListener = new ActionListener() {
	
		
	
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					/*button logic*/
					if(gameView.dimSize == 2 && timer.isRunning()) {
						if(e.getSource() == gameView.playingArray[0]) { 
							String label = gameView.playingArray[0].getLabel(); 
							if(gameView.playingArray[1].getLabel().equals("")) { 
								gameView.playingArray[1].setLabel(label);
								gameView.playingArray[1].setBackground(new Color(228,160,016));
								gameView.playingArray[0].setLabel("");
								gameView.playingArray[0].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[2].getLabel().equals("")) { 
								gameView.playingArray[2].setLabel(label);
								gameView.playingArray[2].setBackground(new Color(228,160,016));
								gameView.playingArray[0].setLabel(""); 
								gameView.playingArray[0].setBackground(new Color(203,208,204));
							} 		
						}
						
						if(e.getSource() == gameView.playingArray[1]) { 
							String label = gameView.playingArray[1].getLabel(); 
							if(gameView.playingArray[0].getLabel().equals("")) { 
								gameView.playingArray[0].setLabel(label);
								gameView.playingArray[0].setBackground(new Color(228,160,016));
								gameView.playingArray[1].setLabel("");
								gameView.playingArray[1].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[3].getLabel().equals("")) { 
								gameView.playingArray[3].setLabel(label);
								gameView.playingArray[3].setBackground(new Color(228,160,016));
								gameView.playingArray[1].setLabel("");
								gameView.playingArray[1].setBackground(new Color(203,208,204));
							} 		
						} 
						
						if(e.getSource() == gameView.playingArray[2]) { 
							String label = gameView.playingArray[2].getLabel(); 
							if(gameView.playingArray[0].getLabel().equals("")) { 
								gameView.playingArray[0].setLabel(label);
								gameView.playingArray[0].setBackground(new Color(228,160,016));
								gameView.playingArray[2].setLabel(""); 
								gameView.playingArray[2].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[3].getLabel().equals("")) { 
								gameView.playingArray[3].setLabel(label);
								gameView.playingArray[3].setBackground(new Color(228,160,016));
								gameView.playingArray[2].setLabel("");
								gameView.playingArray[2].setBackground(new Color(203,208,204));
							} 		
						} 
						
						if(e.getSource() == gameView.playingArray[3]) { 
							String label = gameView.playingArray[3].getLabel(); 
							if(gameView.playingArray[1].getLabel().equals("")) { 
								gameView.playingArray[1].setLabel(label);
								gameView.playingArray[1].setBackground(new Color(228,160,016));
								gameView.playingArray[3].setLabel("");
								gameView.playingArray[3].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[2].getLabel().equals("")) { 
								gameView.playingArray[2].setLabel(label); 
								gameView.playingArray[2].setBackground(new Color(228,160,016));
								gameView.playingArray[3].setLabel(""); 
								gameView.playingArray[3].setBackground(new Color(203,208,204));
							} 		
						}
						
			//			if(gameView.playingArray[0].getLabel().equals("1") && gameView.playingArray[1].getLabel().equals("2") &&
			//				gameView.playingArray[2].getLabel().equals("3") && gameView.playingArray[3].getLabel().equals("4")) {
			//				System.out.println("WIN");
			//				logArea.setText("YOU WON!!!");
			//			}
					}
					
					if(gameView.dimSize == 3 && timer.isRunning()) {
						if(e.getSource() == gameView.playingArray[0]) { 
							String label = gameView.playingArray[0].getLabel(); 
							if(gameView.playingArray[1].getLabel().equals("")) { 
								gameView.playingArray[1].setLabel(label);
								gameView.playingArray[1].setBackground(new Color(228,160,016));
								gameView.playingArray[0].setLabel(""); 
								gameView.playingArray[0].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[3].getLabel().equals("")) { 
								gameView.playingArray[3].setLabel(label);
								gameView.playingArray[3].setBackground(new Color(228,160,016));
								gameView.playingArray[0].setLabel("");
								gameView.playingArray[0].setBackground(new Color(203,208,204));
							} 
						} 
						
						if(e.getSource() == gameView.playingArray[1]) { 
							String label = gameView.playingArray[1].getLabel(); 
							if(gameView.playingArray[0].getLabel().equals("")) { 
								gameView.playingArray[0].setLabel(label);
								gameView.playingArray[0].setBackground(new Color(228,160,016));
								gameView.playingArray[1].setLabel("");
								gameView.playingArray[1].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[2].getLabel().equals("")) { 
								gameView.playingArray[2].setLabel(label); 
								gameView.playingArray[2].setBackground(new Color(228,160,016));
								gameView.playingArray[1].setLabel("");
								gameView.playingArray[1].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[4].getLabel().equals("")) { 
								gameView.playingArray[4].setLabel(label);
								gameView.playingArray[4].setBackground(new Color(228,160,016));
								gameView.playingArray[1].setLabel("");
								gameView.playingArray[1].setBackground(new Color(203,208,204));
							} 
						} 
							
						if(e.getSource() == gameView.playingArray[2]) { 
							String label = gameView.playingArray[2].getLabel(); 
							if(gameView.playingArray[1].getLabel().equals("")) { 
								gameView.playingArray[1].setLabel(label);
								gameView.playingArray[1].setBackground(new Color(228,160,016));
								gameView.playingArray[2].setLabel("");
								gameView.playingArray[2].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[5].getLabel().equals("")) { 
								gameView.playingArray[5].setLabel(label);
								gameView.playingArray[5].setBackground(new Color(228,160,016));
								gameView.playingArray[2].setLabel("");
								gameView.playingArray[2].setBackground(new Color(203,208,204));
							} 
						} 
							
						if(e.getSource() == gameView.playingArray[3]) { 
							String label = gameView.playingArray[3].getLabel(); 
							if(gameView.playingArray[0].getLabel().equals("")) { 
								gameView.playingArray[0].setLabel(label);
								gameView.playingArray[0].setBackground(new Color(228,160,016));
								gameView.playingArray[3].setLabel("");
								gameView.playingArray[3].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[6].getLabel().equals("")) { 
								gameView.playingArray[6].setLabel(label);
								gameView.playingArray[6].setBackground(new Color(228,160,016));
								gameView.playingArray[3].setLabel("");
								gameView.playingArray[3].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[4].getLabel().equals("")) { 
								gameView.playingArray[4].setLabel(label);
								gameView.playingArray[4].setBackground(new Color(228,160,016));
								gameView.playingArray[3].setLabel("");
								gameView.playingArray[3].setBackground(new Color(203,208,204));
							} 
						} 
							
						if(e.getSource() == gameView.playingArray[4]) { 
							String label = gameView.playingArray[4].getLabel(); 
							if(gameView.playingArray[1].getLabel().equals("")) { 
								gameView.playingArray[1].setLabel(label);
								gameView.playingArray[1].setBackground(new Color(228,160,016));
								gameView.playingArray[4].setLabel("");
								gameView.playingArray[4].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[5].getLabel().equals("")) { 
								gameView.playingArray[5].setLabel(label);
								gameView.playingArray[5].setBackground(new Color(228,160,016));
								gameView.playingArray[4].setLabel("");
								gameView.playingArray[4].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[3].getLabel().equals("")) { 
								gameView.playingArray[3].setLabel(label);
								gameView.playingArray[3].setBackground(new Color(228,160,016));
								gameView.playingArray[4].setLabel("");
								gameView.playingArray[4].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[7].getLabel().equals("")) { 
								gameView.playingArray[7].setLabel(label);
								gameView.playingArray[7].setBackground(new Color(228,160,016));
								gameView.playingArray[4].setLabel("");
								gameView.playingArray[4].setBackground(new Color(203,208,204));
							} 
						} 
							
						if(e.getSource() == gameView.playingArray[5]) { 
							String label = gameView.playingArray[5].getLabel(); 
							if(gameView.playingArray[8].getLabel().equals("")) { 
								gameView.playingArray[8].setLabel(label);
								gameView.playingArray[8].setBackground(new Color(228,160,016));
								gameView.playingArray[5].setLabel("");
								gameView.playingArray[5].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[2].getLabel().equals("")) { 
								gameView.playingArray[2].setLabel(label);
								gameView.playingArray[2].setBackground(new Color(228,160,016));
								gameView.playingArray[5].setLabel("");
								gameView.playingArray[5].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[4].getLabel().equals("")){ 
								gameView.playingArray[4].setLabel(label);
								gameView.playingArray[4].setBackground(new Color(228,160,016));
								gameView.playingArray[5].setLabel("");
								gameView.playingArray[5].setBackground(new Color(203,208,204));
							} 
						} 
						
						if(e.getSource() == gameView.playingArray[6]) { 
							String label = gameView.playingArray[6].getLabel(); 
							if(gameView.playingArray[3].getLabel().equals("")) { 
								gameView.playingArray[3].setLabel(label);
								gameView.playingArray[3].setBackground(new Color(228,160,016));
								gameView.playingArray[6].setLabel("");
								gameView.playingArray[6].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[7].getLabel().equals("")) { 
								gameView.playingArray[7].setLabel(label);
								gameView.playingArray[7].setBackground(new Color(228,160,016));
								gameView.playingArray[6].setLabel("");
								gameView.playingArray[6].setBackground(new Color(203,208,204));
							} 
						} 
						
						if(e.getSource() == gameView.playingArray[7]) {
							String label = gameView.playingArray[7].getLabel(); 
							if(gameView.playingArray[8].getLabel().equals("")) { 
								gameView.playingArray[8].setLabel(label);
								gameView.playingArray[8].setBackground(new Color(228,160,016));
								gameView.playingArray[7].setLabel("");
								gameView.playingArray[7].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[6].getLabel().equals("")) { 
								gameView.playingArray[6].setLabel(label);
								gameView.playingArray[6].setBackground(new Color(228,160,016));
								gameView.playingArray[7].setLabel("");
								gameView.playingArray[7].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[4].getLabel().equals("")){ 
								gameView.playingArray[4].setLabel(label);
								gameView.playingArray[4].setBackground(new Color(228,160,016));
								gameView.playingArray[7].setLabel("");
								gameView.playingArray[7].setBackground(new Color(203,208,204));
							} 
						}
						
						if(e.getSource() == gameView.playingArray[8]) {
							String label = gameView.playingArray[8].getLabel(); 
							if(gameView.playingArray[5].getLabel().equals("")) { 
								gameView.playingArray[5].setLabel(label);
								gameView.playingArray[5].setBackground(new Color(228,160,016));
								gameView.playingArray[8].setLabel("");
								gameView.playingArray[8].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[7].getLabel().equals("")) { 
								gameView.playingArray[7].setLabel(label);
								gameView.playingArray[7].setBackground(new Color(228,160,016));
								gameView.playingArray[8].setLabel("");
								gameView.playingArray[8].setBackground(new Color(203,208,204));
							} 
						}
					}
					
					if(gameView.dimSize == 4 && timer.isRunning()) {
						if(e.getSource() == gameView.playingArray[0]) {
							String label = gameView.playingArray[0].getLabel(); 
							if(gameView.playingArray[1].getLabel().equals("")) { 
								gameView.playingArray[1].setLabel(label);
								gameView.playingArray[1].setBackground(new Color(228,160,016));
								gameView.playingArray[0].setLabel(""); 
								gameView.playingArray[0].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[4].getLabel().equals("")) { 
								gameView.playingArray[4].setLabel(label);
								gameView.playingArray[4].setBackground(new Color(228,160,016));
								gameView.playingArray[0].setLabel("");
								gameView.playingArray[0].setBackground(new Color(203,208,204));
							} 
						}
						
						if(e.getSource() == gameView.playingArray[1]) {
							String label = gameView.playingArray[1].getLabel(); 
							if(gameView.playingArray[0].getLabel().equals("")) { 
								gameView.playingArray[0].setLabel(label);
								gameView.playingArray[0].setBackground(new Color(228,160,016));
								gameView.playingArray[1].setLabel(""); 
								gameView.playingArray[1].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[2].getLabel().equals("")) { 
								gameView.playingArray[2].setLabel(label);
								gameView.playingArray[2].setBackground(new Color(228,160,016));
								gameView.playingArray[1].setLabel("");
								gameView.playingArray[1].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[5].getLabel().equals("")) { 
								gameView.playingArray[5].setLabel(label);
								gameView.playingArray[5].setBackground(new Color(228,160,016));
								gameView.playingArray[1].setLabel(""); 
								gameView.playingArray[1].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[2]) {
							String label = gameView.playingArray[2].getLabel(); 
							if(gameView.playingArray[1].getLabel().equals("")) { 
								gameView.playingArray[1].setLabel(label);
								gameView.playingArray[1].setBackground(new Color(228,160,016));
								gameView.playingArray[2].setLabel(""); 
								gameView.playingArray[2].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[3].getLabel().equals("")) { 
								gameView.playingArray[3].setLabel(label);
								gameView.playingArray[3].setBackground(new Color(228,160,016));
								gameView.playingArray[2].setLabel("");
								gameView.playingArray[2].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[6].getLabel().equals("")) { 
								gameView.playingArray[6].setLabel(label);
								gameView.playingArray[6].setBackground(new Color(228,160,016));
								gameView.playingArray[2].setLabel(""); 
								gameView.playingArray[2].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[3]) {
							String label = gameView.playingArray[3].getLabel(); 
							if(gameView.playingArray[2].getLabel().equals("")) { 
								gameView.playingArray[2].setLabel(label);
								gameView.playingArray[2].setBackground(new Color(228,160,016));
								gameView.playingArray[3].setLabel(""); 
								gameView.playingArray[3].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[7].getLabel().equals("")) { 
								gameView.playingArray[7].setLabel(label);
								gameView.playingArray[7].setBackground(new Color(228,160,016));
								gameView.playingArray[3].setLabel("");
								gameView.playingArray[3].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[4]) {
							String label = gameView.playingArray[4].getLabel(); 
							if(gameView.playingArray[0].getLabel().equals("")) { 
								gameView.playingArray[0].setLabel(label);
								gameView.playingArray[0].setBackground(new Color(228,160,016));
								gameView.playingArray[4].setLabel(""); 
								gameView.playingArray[4].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[5].getLabel().equals("")) { 
								gameView.playingArray[5].setLabel(label);
								gameView.playingArray[5].setBackground(new Color(228,160,016));
								gameView.playingArray[4].setLabel("");
								gameView.playingArray[4].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[8].getLabel().equals("")) { 
								gameView.playingArray[8].setLabel(label);
								gameView.playingArray[8].setBackground(new Color(228,160,016));
								gameView.playingArray[4].setLabel(""); 
								gameView.playingArray[4].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[5]) {
							String label = gameView.playingArray[5].getLabel(); 
							if(gameView.playingArray[1].getLabel().equals("")) { 
								gameView.playingArray[1].setLabel(label);
								gameView.playingArray[1].setBackground(new Color(228,160,016));
								gameView.playingArray[5].setLabel(""); 
								gameView.playingArray[5].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[4].getLabel().equals("")) { 
								gameView.playingArray[4].setLabel(label);
								gameView.playingArray[4].setBackground(new Color(228,160,016));
								gameView.playingArray[5].setLabel("");
								gameView.playingArray[5].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[6].getLabel().equals("")) { 
								gameView.playingArray[6].setLabel(label);
								gameView.playingArray[6].setBackground(new Color(228,160,016));
								gameView.playingArray[5].setLabel(""); 
								gameView.playingArray[5].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[9].getLabel().equals("")) { 
								gameView.playingArray[9].setLabel(label);
								gameView.playingArray[9].setBackground(new Color(228,160,016));
								gameView.playingArray[5].setLabel(""); 
								gameView.playingArray[5].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[6]) {
							String label = gameView.playingArray[6].getLabel(); 
							if(gameView.playingArray[2].getLabel().equals("")) { 
								gameView.playingArray[2].setLabel(label);
								gameView.playingArray[2].setBackground(new Color(228,160,016));
								gameView.playingArray[6].setLabel(""); 
								gameView.playingArray[6].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[5].getLabel().equals("")) { 
								gameView.playingArray[5].setLabel(label);
								gameView.playingArray[5].setBackground(new Color(228,160,016));
								gameView.playingArray[6].setLabel("");
								gameView.playingArray[6].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[7].getLabel().equals("")) { 
								gameView.playingArray[7].setLabel(label);
								gameView.playingArray[7].setBackground(new Color(228,160,016));
								gameView.playingArray[6].setLabel(""); 
								gameView.playingArray[6].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[10].getLabel().equals("")) { 
								gameView.playingArray[10].setLabel(label);
								gameView.playingArray[10].setBackground(new Color(228,160,016));
								gameView.playingArray[6].setLabel(""); 
								gameView.playingArray[6].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[7]) {
							String label = gameView.playingArray[7].getLabel(); 
							if(gameView.playingArray[3].getLabel().equals("")) { 
								gameView.playingArray[3].setLabel(label);
								gameView.playingArray[3].setBackground(new Color(228,160,016));
								gameView.playingArray[7].setLabel(""); 
								gameView.playingArray[7].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[6].getLabel().equals("")) { 
								gameView.playingArray[6].setLabel(label);
								gameView.playingArray[6].setBackground(new Color(228,160,016));
								gameView.playingArray[7].setLabel("");
								gameView.playingArray[7].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[11].getLabel().equals("")) { 
								gameView.playingArray[11].setLabel(label);
								gameView.playingArray[11].setBackground(new Color(228,160,016));
								gameView.playingArray[7].setLabel(""); 
								gameView.playingArray[7].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[8]) {
							String label = gameView.playingArray[8].getLabel(); 
							if(gameView.playingArray[4].getLabel().equals("")) { 
								gameView.playingArray[4].setLabel(label);
								gameView.playingArray[4].setBackground(new Color(228,160,016));
								gameView.playingArray[8].setLabel(""); 
								gameView.playingArray[8].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[9].getLabel().equals("")) { 
								gameView.playingArray[9].setLabel(label);
								gameView.playingArray[9].setBackground(new Color(228,160,016));
								gameView.playingArray[8].setLabel("");
								gameView.playingArray[8].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[12].getLabel().equals("")) { 
								gameView.playingArray[12].setLabel(label);
								gameView.playingArray[12].setBackground(new Color(228,160,016));
								gameView.playingArray[8].setLabel(""); 
								gameView.playingArray[8].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[9]) {
							String label = gameView.playingArray[9].getLabel(); 
							if(gameView.playingArray[5].getLabel().equals("")) { 
								gameView.playingArray[5].setLabel(label);
								gameView.playingArray[5].setBackground(new Color(228,160,016));
								gameView.playingArray[9].setLabel(""); 
								gameView.playingArray[9].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[8].getLabel().equals("")) { 
								gameView.playingArray[8].setLabel(label);
								gameView.playingArray[8].setBackground(new Color(228,160,016));
								gameView.playingArray[9].setLabel("");
								gameView.playingArray[9].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[10].getLabel().equals("")) { 
								gameView.playingArray[10].setLabel(label);
								gameView.playingArray[10].setBackground(new Color(228,160,016));
								gameView.playingArray[9].setLabel(""); 
								gameView.playingArray[9].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[13].getLabel().equals("")) { 
								gameView.playingArray[13].setLabel(label);
								gameView.playingArray[13].setBackground(new Color(228,160,016));
								gameView.playingArray[9].setLabel(""); 
								gameView.playingArray[9].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[10]) {
							String label = gameView.playingArray[10].getLabel(); 
							if(gameView.playingArray[6].getLabel().equals("")) { 
								gameView.playingArray[6].setLabel(label);
								gameView.playingArray[6].setBackground(new Color(228,160,016));
								gameView.playingArray[10].setLabel(""); 
								gameView.playingArray[10].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[9].getLabel().equals("")) { 
								gameView.playingArray[9].setLabel(label);
								gameView.playingArray[9].setBackground(new Color(228,160,016));
								gameView.playingArray[10].setLabel("");
								gameView.playingArray[10].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[11].getLabel().equals("")) { 
								gameView.playingArray[11].setLabel(label);
								gameView.playingArray[11].setBackground(new Color(228,160,016));
								gameView.playingArray[10].setLabel(""); 
								gameView.playingArray[10].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[14].getLabel().equals("")) { 
								gameView.playingArray[14].setLabel(label);
								gameView.playingArray[14].setBackground(new Color(228,160,016));
								gameView.playingArray[10].setLabel(""); 
								gameView.playingArray[10].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[11]) {
							String label = gameView.playingArray[11].getLabel(); 
							if(gameView.playingArray[7].getLabel().equals("")) { 
								gameView.playingArray[7].setLabel(label);
								gameView.playingArray[7].setBackground(new Color(228,160,016));
								gameView.playingArray[11].setLabel("");
								gameView.playingArray[11].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[10].getLabel().equals("")) { 
								gameView.playingArray[10].setLabel(label);
								gameView.playingArray[10].setBackground(new Color(228,160,016));
								gameView.playingArray[11].setLabel(""); 
								gameView.playingArray[11].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[15].getLabel().equals("")) { 
								gameView.playingArray[15].setLabel(label);
								gameView.playingArray[15].setBackground(new Color(228,160,016));
								gameView.playingArray[11].setLabel(""); 
								gameView.playingArray[11].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[12]) {
							String label = gameView.playingArray[12].getLabel(); 
							if(gameView.playingArray[8].getLabel().equals("")) { 
								gameView.playingArray[8].setLabel(label);
								gameView.playingArray[8].setBackground(new Color(228,160,016));
								gameView.playingArray[12].setLabel(""); 
								gameView.playingArray[12].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[13].getLabel().equals("")) { 
								gameView.playingArray[13].setLabel(label);
								gameView.playingArray[13].setBackground(new Color(228,160,016));
								gameView.playingArray[12].setLabel("");
								gameView.playingArray[12].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[13]) {
							String label = gameView.playingArray[13].getLabel(); 
							if(gameView.playingArray[9].getLabel().equals("")) { 
								gameView.playingArray[9].setLabel(label);
								gameView.playingArray[9].setBackground(new Color(228,160,016));
								gameView.playingArray[13].setLabel(""); 
								gameView.playingArray[13].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[12].getLabel().equals("")) { 
								gameView.playingArray[12].setLabel(label);
								gameView.playingArray[12].setBackground(new Color(228,160,016));
								gameView.playingArray[13].setLabel("");
								gameView.playingArray[13].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[14].getLabel().equals("")) { 
								gameView.playingArray[14].setLabel(label);
								gameView.playingArray[14].setBackground(new Color(228,160,016));
								gameView.playingArray[13].setLabel(""); 
								gameView.playingArray[13].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[14]) {
							String label = gameView.playingArray[14].getLabel(); 
							if(gameView.playingArray[10].getLabel().equals("")) { 
								gameView.playingArray[10].setLabel(label);
								gameView.playingArray[10].setBackground(new Color(228,160,016));
								gameView.playingArray[14].setLabel(""); 
								gameView.playingArray[14].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[13].getLabel().equals("")) { 
								gameView.playingArray[13].setLabel(label);
								gameView.playingArray[13].setBackground(new Color(228,160,016));
								gameView.playingArray[14].setLabel("");
								gameView.playingArray[14].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[15].getLabel().equals("")) { 
								gameView.playingArray[15].setLabel(label);
								gameView.playingArray[15].setBackground(new Color(228,160,016));
								gameView.playingArray[14].setLabel(""); 
								gameView.playingArray[14].setBackground(new Color(203,208,204));
							}
						}
						
						if(e.getSource() == gameView.playingArray[15]) {
							String label = gameView.playingArray[15].getLabel(); 
							if(gameView.playingArray[11].getLabel().equals("")) { 
								gameView.playingArray[11].setLabel(label);
								gameView.playingArray[11].setBackground(new Color(228,160,016));
								gameView.playingArray[15].setLabel(""); 
								gameView.playingArray[15].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[14].getLabel().equals("")) { 
								gameView.playingArray[14].setLabel(label);
								gameView.playingArray[14].setBackground(new Color(228,160,016));
								gameView.playingArray[15].setLabel("");
								gameView.playingArray[15].setBackground(new Color(203,208,204));
							}
						}
					}
					
					if(gameView.dimSize == 5 && timer.isRunning()) {
						if(e.getSource() == gameView.playingArray[0]) {
							String label = gameView.playingArray[0].getLabel(); 
							if(gameView.playingArray[1].getLabel().equals("")) { 
								gameView.playingArray[1].setLabel(label);
								gameView.playingArray[1].setBackground(new Color(228,160,016));
								gameView.playingArray[0].setLabel(""); 
								gameView.playingArray[0].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[5].getLabel().equals("")) { 
								gameView.playingArray[5].setLabel(label);
								gameView.playingArray[5].setBackground(new Color(228,160,016));
								gameView.playingArray[0].setLabel("");
								gameView.playingArray[0].setBackground(new Color(203,208,204));
							} 
						}
						if(e.getSource() == gameView.playingArray[1]) {
							String label = gameView.playingArray[1].getLabel(); 
							if(gameView.playingArray[0].getLabel().equals("")) { 
								gameView.playingArray[0].setLabel(label);
								gameView.playingArray[0].setBackground(new Color(228,160,016));
								gameView.playingArray[1].setLabel(""); 
								gameView.playingArray[1].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[2].getLabel().equals("")) { 
								gameView.playingArray[2].setLabel(label);
								gameView.playingArray[2].setBackground(new Color(228,160,016));
								gameView.playingArray[1].setLabel("");
								gameView.playingArray[1].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[6].getLabel().equals("")) { 
								gameView.playingArray[6].setLabel(label);
								gameView.playingArray[6].setBackground(new Color(228,160,016));
								gameView.playingArray[1].setLabel("");
								gameView.playingArray[1].setBackground(new Color(203,208,204));
							} 
						}
						if(e.getSource() == gameView.playingArray[2]) {
							String label = gameView.playingArray[2].getLabel(); 
							if(gameView.playingArray[1].getLabel().equals("")) { 
								gameView.playingArray[1].setLabel(label);
								gameView.playingArray[1].setBackground(new Color(228,160,016));
								gameView.playingArray[2].setLabel(""); 
								gameView.playingArray[2].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[3].getLabel().equals("")) { 
								gameView.playingArray[3].setLabel(label);
								gameView.playingArray[3].setBackground(new Color(228,160,016));
								gameView.playingArray[2].setLabel("");
								gameView.playingArray[2].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[7].getLabel().equals("")) { 
								gameView.playingArray[7].setLabel(label);
								gameView.playingArray[7].setBackground(new Color(228,160,016));
								gameView.playingArray[2].setLabel("");
								gameView.playingArray[2].setBackground(new Color(203,208,204));
							} 
						}
						if(e.getSource() == gameView.playingArray[3]) {
							String label = gameView.playingArray[3].getLabel(); 
							if(gameView.playingArray[2].getLabel().equals("")) { 
								gameView.playingArray[2].setLabel(label);
								gameView.playingArray[2].setBackground(new Color(228,160,016));
								gameView.playingArray[3].setLabel(""); 
								gameView.playingArray[3].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[4].getLabel().equals("")) { 
								gameView.playingArray[4].setLabel(label);
								gameView.playingArray[4].setBackground(new Color(228,160,016));
								gameView.playingArray[3].setLabel("");
								gameView.playingArray[3].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[8].getLabel().equals("")) { 
								gameView.playingArray[8].setLabel(label);
								gameView.playingArray[8].setBackground(new Color(228,160,016));
								gameView.playingArray[3].setLabel("");
								gameView.playingArray[3].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[4]) {
							String label = gameView.playingArray[4].getLabel(); 
							if(gameView.playingArray[3].getLabel().equals("")) { 
								gameView.playingArray[3].setLabel(label);
								gameView.playingArray[3].setBackground(new Color(228,160,016));
								gameView.playingArray[4].setLabel("");
								gameView.playingArray[4].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[9].getLabel().equals("")) { 
								gameView.playingArray[9].setLabel(label);
								gameView.playingArray[9].setBackground(new Color(228,160,016));
								gameView.playingArray[4].setLabel("");
								gameView.playingArray[4].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[5]) {
							String label = gameView.playingArray[5].getLabel(); 
							if(gameView.playingArray[0].getLabel().equals("")) { 
								gameView.playingArray[0].setLabel(label);
								gameView.playingArray[0].setBackground(new Color(228,160,016));
								gameView.playingArray[5].setLabel(""); 
								gameView.playingArray[5].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[6].getLabel().equals("")) { 
								gameView.playingArray[6].setLabel(label);
								gameView.playingArray[6].setBackground(new Color(228,160,016));
								gameView.playingArray[5].setLabel("");
								gameView.playingArray[5].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[10].getLabel().equals("")) { 
								gameView.playingArray[10].setLabel(label);
								gameView.playingArray[10].setBackground(new Color(228,160,016));
								gameView.playingArray[5].setLabel("");
								gameView.playingArray[5].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[6]) {
							String label = gameView.playingArray[6].getLabel(); 
							if(gameView.playingArray[1].getLabel().equals("")) { 
								gameView.playingArray[1].setLabel(label);
								gameView.playingArray[1].setBackground(new Color(228,160,016));
								gameView.playingArray[6].setLabel(""); 
								gameView.playingArray[6].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[5].getLabel().equals("")) { 
								gameView.playingArray[5].setLabel(label);
								gameView.playingArray[5].setBackground(new Color(228,160,016));
								gameView.playingArray[6].setLabel("");
								gameView.playingArray[6].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[7].getLabel().equals("")) { 
								gameView.playingArray[7].setLabel(label);
								gameView.playingArray[7].setBackground(new Color(228,160,016));
								gameView.playingArray[6].setLabel("");
								gameView.playingArray[6].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[11].getLabel().equals("")) { 
								gameView.playingArray[11].setLabel(label);
								gameView.playingArray[11].setBackground(new Color(228,160,016));
								gameView.playingArray[6].setLabel("");
								gameView.playingArray[6].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[7]) {
							String label = gameView.playingArray[7].getLabel(); 
							if(gameView.playingArray[2].getLabel().equals("")) { 
								gameView.playingArray[2].setLabel(label);
								gameView.playingArray[2].setBackground(new Color(228,160,016));
								gameView.playingArray[7].setLabel(""); 
								gameView.playingArray[7].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[6].getLabel().equals("")) { 
								gameView.playingArray[6].setLabel(label);
								gameView.playingArray[6].setBackground(new Color(228,160,016));
								gameView.playingArray[7].setLabel("");
								gameView.playingArray[7].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[8].getLabel().equals("")) { 
								gameView.playingArray[8].setLabel(label);
								gameView.playingArray[8].setBackground(new Color(228,160,016));
								gameView.playingArray[7].setLabel("");
								gameView.playingArray[7].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[12].getLabel().equals("")) { 
								gameView.playingArray[12].setLabel(label);
								gameView.playingArray[12].setBackground(new Color(228,160,016));
								gameView.playingArray[7].setLabel("");
								gameView.playingArray[7].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[8]) {
							String label = gameView.playingArray[8].getLabel(); 
							if(gameView.playingArray[3].getLabel().equals("")) { 
								gameView.playingArray[3].setLabel(label);
								gameView.playingArray[3].setBackground(new Color(228,160,016));
								gameView.playingArray[8].setLabel(""); 
								gameView.playingArray[8].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[7].getLabel().equals("")) { 
								gameView.playingArray[7].setLabel(label);
								gameView.playingArray[7].setBackground(new Color(228,160,016));
								gameView.playingArray[8].setLabel("");
								gameView.playingArray[8].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[9].getLabel().equals("")) { 
								gameView.playingArray[9].setLabel(label);
								gameView.playingArray[9].setBackground(new Color(228,160,016));
								gameView.playingArray[8].setLabel("");
								gameView.playingArray[8].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[13].getLabel().equals("")) { 
								gameView.playingArray[13].setLabel(label);
								gameView.playingArray[13].setBackground(new Color(228,160,016));
								gameView.playingArray[8].setLabel("");
								gameView.playingArray[8].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[9]) {
							String label = gameView.playingArray[9].getLabel(); 
							if(gameView.playingArray[4].getLabel().equals("")) { 
								gameView.playingArray[4].setLabel(label);
								gameView.playingArray[4].setBackground(new Color(228,160,016));
								gameView.playingArray[9].setLabel(""); 
								gameView.playingArray[9].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[8].getLabel().equals("")) { 
								gameView.playingArray[8].setLabel(label);
								gameView.playingArray[8].setBackground(new Color(228,160,016));
								gameView.playingArray[9].setLabel("");
								gameView.playingArray[9].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[14].getLabel().equals("")) { 
								gameView.playingArray[14].setLabel(label);
								gameView.playingArray[14].setBackground(new Color(228,160,016));
								gameView.playingArray[9].setLabel("");
								gameView.playingArray[9].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[10]) {
							String label = gameView.playingArray[10].getLabel(); 
							if(gameView.playingArray[5].getLabel().equals("")) { 
								gameView.playingArray[5].setLabel(label);
								gameView.playingArray[5].setBackground(new Color(228,160,016));
								gameView.playingArray[10].setLabel(""); 
								gameView.playingArray[10].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[11].getLabel().equals("")) { 
								gameView.playingArray[11].setLabel(label);
								gameView.playingArray[11].setBackground(new Color(228,160,016));
								gameView.playingArray[10].setLabel("");
								gameView.playingArray[10].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[15].getLabel().equals("")) { 
								gameView.playingArray[15].setLabel(label);
								gameView.playingArray[15].setBackground(new Color(228,160,016));
								gameView.playingArray[10].setLabel("");
								gameView.playingArray[10].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[11]) {
							String label = gameView.playingArray[11].getLabel(); 
							if(gameView.playingArray[6].getLabel().equals("")) { 
								gameView.playingArray[6].setLabel(label);
								gameView.playingArray[6].setBackground(new Color(228,160,016));
								gameView.playingArray[11].setLabel(""); 
								gameView.playingArray[11].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[10].getLabel().equals("")) { 
								gameView.playingArray[10].setLabel(label);
								gameView.playingArray[10].setBackground(new Color(228,160,016));
								gameView.playingArray[11].setLabel("");
								gameView.playingArray[11].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[12].getLabel().equals("")) { 
								gameView.playingArray[12].setLabel(label);
								gameView.playingArray[12].setBackground(new Color(228,160,016));
								gameView.playingArray[11].setLabel("");
								gameView.playingArray[11].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[16].getLabel().equals("")) { 
								gameView.playingArray[16].setLabel(label);
								gameView.playingArray[16].setBackground(new Color(228,160,016));
								gameView.playingArray[11].setLabel("");
								gameView.playingArray[11].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[12]) {
							String label = gameView.playingArray[12].getLabel(); 
							if(gameView.playingArray[7].getLabel().equals("")) { 
								gameView.playingArray[7].setLabel(label);
								gameView.playingArray[7].setBackground(new Color(228,160,016));
								gameView.playingArray[12].setLabel(""); 
								gameView.playingArray[12].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[11].getLabel().equals("")) { 
								gameView.playingArray[11].setLabel(label);
								gameView.playingArray[11].setBackground(new Color(228,160,016));
								gameView.playingArray[12].setLabel("");
								gameView.playingArray[12].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[13].getLabel().equals("")) { 
								gameView.playingArray[13].setLabel(label);
								gameView.playingArray[13].setBackground(new Color(228,160,016));
								gameView.playingArray[12].setLabel("");
								gameView.playingArray[12].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[17].getLabel().equals("")) { 
								gameView.playingArray[17].setLabel(label);
								gameView.playingArray[17].setBackground(new Color(228,160,016));
								gameView.playingArray[12].setLabel("");
								gameView.playingArray[12].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[13]) {
							String label = gameView.playingArray[13].getLabel(); 
							if(gameView.playingArray[8].getLabel().equals("")) { 
								gameView.playingArray[8].setLabel(label);
								gameView.playingArray[8].setBackground(new Color(228,160,016));
								gameView.playingArray[13].setLabel(""); 
								gameView.playingArray[13].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[12].getLabel().equals("")) { 
								gameView.playingArray[12].setLabel(label);
								gameView.playingArray[12].setBackground(new Color(228,160,016));
								gameView.playingArray[13].setLabel("");
								gameView.playingArray[13].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[14].getLabel().equals("")) { 
								gameView.playingArray[14].setLabel(label);
								gameView.playingArray[14].setBackground(new Color(228,160,016));
								gameView.playingArray[13].setLabel("");
								gameView.playingArray[13].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[18].getLabel().equals("")) { 
								gameView.playingArray[18].setLabel(label);
								gameView.playingArray[18].setBackground(new Color(228,160,016));
								gameView.playingArray[13].setLabel("");
								gameView.playingArray[13].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[14]) {
							String label = gameView.playingArray[14].getLabel(); 
							if(gameView.playingArray[9].getLabel().equals("")) { 
								gameView.playingArray[9].setLabel(label);
								gameView.playingArray[9].setBackground(new Color(228,160,016));
								gameView.playingArray[14].setLabel(""); 
								gameView.playingArray[14].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[13].getLabel().equals("")) { 
								gameView.playingArray[13].setLabel(label);
								gameView.playingArray[13].setBackground(new Color(228,160,016));
								gameView.playingArray[14].setLabel("");
								gameView.playingArray[14].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[19].getLabel().equals("")) { 
								gameView.playingArray[19].setLabel(label);
								gameView.playingArray[19].setBackground(new Color(228,160,016));
								gameView.playingArray[14].setLabel("");
								gameView.playingArray[14].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[15]) {
							String label = gameView.playingArray[15].getLabel(); 
							if(gameView.playingArray[10].getLabel().equals("")) { 
								gameView.playingArray[10].setLabel(label);
								gameView.playingArray[10].setBackground(new Color(228,160,016));
								gameView.playingArray[15].setLabel(""); 
								gameView.playingArray[15].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[16].getLabel().equals("")) { 
								gameView.playingArray[16].setLabel(label);
								gameView.playingArray[16].setBackground(new Color(228,160,016));
								gameView.playingArray[15].setLabel("");
								gameView.playingArray[15].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[20].getLabel().equals("")) { 
								gameView.playingArray[20].setLabel(label);
								gameView.playingArray[20].setBackground(new Color(228,160,016));
								gameView.playingArray[15].setLabel("");
								gameView.playingArray[15].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[16]) {
							String label = gameView.playingArray[16].getLabel(); 
							if(gameView.playingArray[11].getLabel().equals("")) { 
								gameView.playingArray[11].setLabel(label);
								gameView.playingArray[11].setBackground(new Color(228,160,016));
								gameView.playingArray[16].setLabel(""); 
								gameView.playingArray[16].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[15].getLabel().equals("")) { 
								gameView.playingArray[15].setLabel(label);
								gameView.playingArray[15].setBackground(new Color(228,160,016));
								gameView.playingArray[16].setLabel("");
								gameView.playingArray[16].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[17].getLabel().equals("")) { 
								gameView.playingArray[17].setLabel(label);
								gameView.playingArray[17].setBackground(new Color(228,160,016));
								gameView.playingArray[16].setLabel("");
								gameView.playingArray[16].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[21].getLabel().equals("")) { 
								gameView.playingArray[21].setLabel(label);
								gameView.playingArray[21].setBackground(new Color(228,160,016));
								gameView.playingArray[16].setLabel("");
								gameView.playingArray[16].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[17]) {
							String label = gameView.playingArray[17].getLabel(); 
							if(gameView.playingArray[12].getLabel().equals("")) { 
								gameView.playingArray[12].setLabel(label);
								gameView.playingArray[12].setBackground(new Color(228,160,016));
								gameView.playingArray[17].setLabel(""); 
								gameView.playingArray[17].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[16].getLabel().equals("")) { 
								gameView.playingArray[16].setLabel(label);
								gameView.playingArray[16].setBackground(new Color(228,160,016));
								gameView.playingArray[17].setLabel("");
								gameView.playingArray[17].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[18].getLabel().equals("")) { 
								gameView.playingArray[18].setLabel(label);
								gameView.playingArray[18].setBackground(new Color(228,160,016));
								gameView.playingArray[17].setLabel("");
								gameView.playingArray[17].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[22].getLabel().equals("")) { 
								gameView.playingArray[22].setLabel(label);
								gameView.playingArray[22].setBackground(new Color(228,160,016));
								gameView.playingArray[17].setLabel("");
								gameView.playingArray[17].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[18]) {
							String label = gameView.playingArray[18].getLabel(); 
							if(gameView.playingArray[13].getLabel().equals("")) { 
								gameView.playingArray[13].setLabel(label);
								gameView.playingArray[13].setBackground(new Color(228,160,016));
								gameView.playingArray[18].setLabel(""); 
								gameView.playingArray[18].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[17].getLabel().equals("")) { 
								gameView.playingArray[17].setLabel(label);
								gameView.playingArray[17].setBackground(new Color(228,160,016));
								gameView.playingArray[18].setLabel("");
								gameView.playingArray[18].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[19].getLabel().equals("")) { 
								gameView.playingArray[19].setLabel(label);
								gameView.playingArray[19].setBackground(new Color(228,160,016));
								gameView.playingArray[18].setLabel("");
								gameView.playingArray[18].setBackground(new Color(203,208,204));
							}
							if(gameView.playingArray[23].getLabel().equals("")) { 
								gameView.playingArray[23].setLabel(label);
								gameView.playingArray[23].setBackground(new Color(228,160,016));
								gameView.playingArray[18].setLabel("");
								gameView.playingArray[18].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[19]) {
							String label = gameView.playingArray[19].getLabel(); 
							if(gameView.playingArray[14].getLabel().equals("")) { 
								gameView.playingArray[14].setLabel(label);
								gameView.playingArray[14].setBackground(new Color(228,160,016));
								gameView.playingArray[19].setLabel(""); 
								gameView.playingArray[19].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[18].getLabel().equals("")) { 
								gameView.playingArray[18].setLabel(label);
								gameView.playingArray[18].setBackground(new Color(228,160,016));
								gameView.playingArray[19].setLabel("");
								gameView.playingArray[19].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[24].getLabel().equals("")) { 
								gameView.playingArray[24].setLabel(label);
								gameView.playingArray[24].setBackground(new Color(228,160,016));
								gameView.playingArray[19].setLabel("");
								gameView.playingArray[19].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[20]) {
							String label = gameView.playingArray[20].getLabel(); 
							if(gameView.playingArray[15].getLabel().equals("")) { 
								gameView.playingArray[15].setLabel(label);
								gameView.playingArray[15].setBackground(new Color(228,160,016));
								gameView.playingArray[20].setLabel(""); 
								gameView.playingArray[20].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[21].getLabel().equals("")) { 
								gameView.playingArray[21].setLabel(label);
								gameView.playingArray[21].setBackground(new Color(228,160,016));
								gameView.playingArray[20].setLabel("");
								gameView.playingArray[20].setBackground(new Color(203,208,204));
							} 
						}
						if(e.getSource() == gameView.playingArray[21]) {
							String label = gameView.playingArray[21].getLabel(); 
							if(gameView.playingArray[16].getLabel().equals("")) { 
								gameView.playingArray[16].setLabel(label);
								gameView.playingArray[16].setBackground(new Color(228,160,016));
								gameView.playingArray[21].setLabel(""); 
								gameView.playingArray[21].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[20].getLabel().equals("")) { 
								gameView.playingArray[20].setLabel(label);
								gameView.playingArray[20].setBackground(new Color(228,160,016));
								gameView.playingArray[21].setLabel("");
								gameView.playingArray[21].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[22].getLabel().equals("")) { 
								gameView.playingArray[22].setLabel(label);
								gameView.playingArray[22].setBackground(new Color(228,160,016));
								gameView.playingArray[21].setLabel("");
								gameView.playingArray[21].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[22]) {
							String label = gameView.playingArray[22].getLabel(); 
							if(gameView.playingArray[17].getLabel().equals("")) { 
								gameView.playingArray[17].setLabel(label);
								gameView.playingArray[17].setBackground(new Color(228,160,016));
								gameView.playingArray[22].setLabel(""); 
								gameView.playingArray[22].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[21].getLabel().equals("")) { 
								gameView.playingArray[21].setLabel(label);
								gameView.playingArray[21].setBackground(new Color(228,160,016));
								gameView.playingArray[22].setLabel("");
								gameView.playingArray[22].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[23].getLabel().equals("")) { 
								gameView.playingArray[23].setLabel(label);
								gameView.playingArray[23].setBackground(new Color(228,160,016));
								gameView.playingArray[22].setLabel("");
								gameView.playingArray[22].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[23]) {
							String label = gameView.playingArray[23].getLabel(); 
							if(gameView.playingArray[18].getLabel().equals("")) { 
								gameView.playingArray[18].setLabel(label);
								gameView.playingArray[18].setBackground(new Color(228,160,016));
								gameView.playingArray[23].setLabel(""); 
								gameView.playingArray[23].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[22].getLabel().equals("")) { 
								gameView.playingArray[22].setLabel(label);
								gameView.playingArray[22].setBackground(new Color(228,160,016));
								gameView.playingArray[23].setLabel("");
								gameView.playingArray[23].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[24].getLabel().equals("")) { 
								gameView.playingArray[24].setLabel(label);
								gameView.playingArray[24].setBackground(new Color(228,160,016));
								gameView.playingArray[23].setLabel("");
								gameView.playingArray[23].setBackground(new Color(203,208,204));
							}
						}
						if(e.getSource() == gameView.playingArray[24]) {
							String label = gameView.playingArray[24].getLabel(); 
							if(gameView.playingArray[19].getLabel().equals("")) { 
								gameView.playingArray[19].setLabel(label);
								gameView.playingArray[19].setBackground(new Color(228,160,016));
								gameView.playingArray[24].setLabel(""); 
								gameView.playingArray[24].setBackground(new Color(203,208,204));
							} 
							if(gameView.playingArray[23].getLabel().equals("")) { 
								gameView.playingArray[23].setLabel(label);
								gameView.playingArray[23].setBackground(new Color(228,160,016));
								gameView.playingArray[24].setLabel("");
								gameView.playingArray[24].setBackground(new Color(203,208,204));
							} 
						}
					}
					
				}
				
			}
				);
	}
}
