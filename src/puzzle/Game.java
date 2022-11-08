package puzzle;

public class Game {
	
	
	public static void main(String args[]) {
		GameView gameView = new GameView();
		GameModel gameModel = new GameModel();
		GameController gameController = new GameController(gameModel, gameView);
		
		
			
	}
	

}
