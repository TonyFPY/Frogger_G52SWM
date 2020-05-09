package org.frogger.gameView;

import org.frogger.Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * <h1>HighScorePage</h1>
 * <p>
 * This class aims to let player to view the high score page.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see org.frogger.gameController.HighScorePageController
 */
public class HighScorePage {
	/**
	 * <strong>Loads high score page</strong>
	 * 
	 * @throws Exception  FXML Loading Error
	 */
	public void loadPage() throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/frogger/FXML/HighScorePage.fxml"));
		Parent score = loader.load();
		Main.sceneSetting(score,"High Scores");	
	}
	
}
