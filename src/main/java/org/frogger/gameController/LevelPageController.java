package org.frogger.gameController;

import org.frogger.gameSettings.GameEasyLevel;
import org.frogger.gameSettings.GameHardLevel;
import org.frogger.gameSettings.GameMediumLevel;

import javafx.fxml.FXML;

/**
 * <h1>LevelPageController</h1>
 * <p>
 * This class represents a controller to control the {@code LevelPage} Model, 
 * which includes buttons allowing user interaction and handles user input events.
 * <p>
 * This class integrates the methods to allow different user interaction. The game
 * allows player to choose a game level and start playing the game. The three buttons
 * are three entries to the game-playing pages with "easy","medium","hard" levels.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 25/11/2019
 * @see org.frogger.gameView.LevelPage
 */
public class LevelPageController {
	/**
	 * <strong>Handles a button event to go to easy-level mode</strong>
	 * 
	 * @throws Exception  FXML Loading Errors
	 * @see org.frogger.gameSettings.GameEasyLevel
	 */
	@FXML
	public void changeToEasyLevel() throws Exception {
		GameEasyLevel easy = new GameEasyLevel();
		easy.startGame();
		easy.setGameElements();
	}
	
	/**
	 * <strong>Handles a button event to go to medium-level mode</strong>
	 * 
	 * @throws Exception  FXML Loading Error
	 * @see org.frogger.gameSettings.GameMediumLevel
	 */
	@FXML
	public void changeToMediumLevel() throws Exception {
		GameMediumLevel medium = new GameMediumLevel();
		medium.startGame();
		medium.setGameElements();
	}
	
	/**
	 * <strong>Handles a button event to go to hard-level mode</strong>
	 * 
	 * @throws Exception  FXML Loading Error
	 * @see org.frogger.gameSettings.GameHardLevel
	 */
	@FXML
	public void changeToHardLevel() throws Exception {
		GameHardLevel hard = new GameHardLevel();
		hard.startGame();
		hard.setGameElements();
	}

}
