package org.frogger.gameController;

import org.frogger.gameView.HighScorePage;
import org.frogger.gameView.InfoPage;
import org.frogger.gameView.UserPage;

import javafx.fxml.FXML;
import org.frogger.Main;

/**
 * <h1>StartingPageController</h1>
 * <p>
 * This class represents a controller to control the {@code StartingPage} Model, 
 * which includes buttons allowing user interaction and handles user input events.
 * <p>
 * This class integrates the methods to allow different user interaction. 
 * <ul>
 * <li> Player can click "start" button to go to the user page;
 * <li> Player can click "High Score" to view the top 10 high scores;
 * <li> Player can click "Game Guidance" to look through the game instructions.
 * </ul>
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 25/11/2019
 * @see Main
 */
public class StartingPageController {
	/**
	 * <strong>Handles a button event to reach user page</strong>
	 * 
	 * @throws Exception  FXML Loading Error
	 * @see org.frogger.gameView.UserPage
	 */
	@FXML
	public void changeTOUserPage() throws Exception {	
		UserPage usp = new UserPage();
		usp.loadPage();
	}
	
	/**
	 * <strong>Handles a button event to move to high score page</strong>
	 * 
	 * @throws Exception  FXML Loading Error
	 * @see org.frogger.gameView.HighScorePage
	 */
	@FXML
	public void changeTOScore() throws Exception {	
		HighScorePage hsl = new HighScorePage();
		hsl.loadPage();
	}
	
	/**
	 * <strong>Handles a button event to move to info page</strong>
	 * 
	 * @throws Exception  FXML Loading Error
	 * @see org.frogger.gameView.InfoPage
	 */
	@FXML
	public void changeTOInfoPage() throws Exception {	
		InfoPage info = new InfoPage();
		info.loadPage();
	}
}
