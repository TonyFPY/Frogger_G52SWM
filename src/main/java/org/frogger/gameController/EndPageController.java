package org.frogger.gameController;

import org.frogger.elementFactory.ElementsFactory;
import org.frogger.Main;
import org.frogger.gameSettings.Music;
import org.frogger.gameView.HighScorePage;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * <h1>EndPageController</h1>
 * This class represents a controller to control the {@code EndPage} Model, 
 * which includes buttons allowing user interaction and handles user input events.
 * <p>
 * This class integrates the methods to allow different user interaction and
 * a new background music will be played to indicate that player has completed the game.
 * <ul>
 * <li> When reaching the end page, it tells player points he/she gets.
 * <li> Player can click "High Score" to see the top 10 high scores.
 * <li> Player can click "QUIT" to close the game.
 * </ul>
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 25/11/2019
 * @see org.frogger.gameView.EndPage
 */
public class EndPageController {
	/**
	 * A label to display the score list
	 */
	@FXML 
	private Label finalScoreLabel;
	
	/**
	 * <strong>Handles a button event to move to high score page and stop current music</strong>
	 * 
	 * @throws Exception  FXML Loading Error
	 * @see org.frogger.gameView.HighScorePage
	 */
	@FXML
	public void changeTOHighScorePage() throws Exception {
		HighScorePage hsl = new HighScorePage();
		hsl.loadPage();
		Music.INSTANCE.stopMusic();
	}
	
	/**
	 * <strong>Handles a button event to quit the game</strong>
	 */
	@FXML 
	public void quitGame() {
		Main.getPrimaryStage().close();
	}
	
	/**
	 * <strong>Initilizes the end page</strong>
	 * <p>
	 * This method is called to play background music and show playe's score. 
	 */
	public void initialize() {
		Music.INSTANCE.playMusic("Avenger");
		int points = ElementsFactory.getAnimal().getPoints();
		finalScoreLabel.setText(Integer.toString(points));
	}
}
