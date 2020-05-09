package org.frogger.gameView;

import org.frogger.Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * <h1>StartingPage</h1>
 * <p>
 * This class aims to let player to view the starting page.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see org.frogger.gameController.StartingPageController
 */
public class StartingPage {
	/**
	 * <strong>Loads starting page</strong>
	 * 
	 * @throws Exception  FXML Loading Error
	 */
	public void loadPage() throws Exception {
		Parent start = FXMLLoader.load(getClass().getResource("/org/frogger/FXML/StartingPage.fxml"));
		Main.sceneSetting(start,"Starting Game");
	}
}
