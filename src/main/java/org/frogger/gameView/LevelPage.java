package org.frogger.gameView;

import org.frogger.Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * <h1>LevelPage</h1>
 * <p>
 * This class aims to let player to view the level page.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see org.frogger.gameController.LevelPageController
 */
public class LevelPage {
	/**
	 * <strong>Loads level page</strong>
	 * 
	 * @throws Exception  FXML Loading Error
	 */
	public void loadPage() throws Exception {
		Parent level = FXMLLoader.load(getClass().getResource("/org/frogger/FXML/LevelPage.fxml"));
		Main.sceneSetting(level,"Choosing Game Level");
	}
}
