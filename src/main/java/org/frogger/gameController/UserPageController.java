package org.frogger.gameController;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import org.frogger.gameModel.HighScoreList;
import org.frogger.gameView.LevelPage;

/**
 * <h1>UserPageController</h1>
 * <p>
 * This class represents a controller to control the {@code UserPage} Model, 
 * which includes buttons allowing user interaction and handles user input events.
 * <p>
 * This class integrates the methods to allow different user interaction. It allows
 * player to enter his/her name. After clicking "OK !", the name will be conveyed to 
 * {@code HighScoreList} and the player can starting to choose the game level.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 25/11/2019
 * @see org.frogger.gameView.UserPage
 */
public class UserPageController {
	/**
	 * A TextField to let players to input their names
	 */
	@FXML 
	private TextField username;
	
	/**
	 * <strong>Records player's name and handles a button event to reach level page</strong>
	 * <p>
	 * Player has a choice not to enter name.
	 * 
	 * @throws Exception  FXML Loading Error
	 * @see org.frogger.gameView.LevelPage
	 */
	@FXML
	public void changeTOLevelPage() throws Exception {
		
		if (username.getText().equals("")) {
			HighScoreList.setUsername("Anonymous player");
		}
		HighScoreList.setUsername(username.getText());
		
		LevelPage lp = new LevelPage();
		lp.loadPage();
	}
}
