package org.frogger.gameView;

import org.frogger.Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * <h1>InfoPage</h1>
 * <p>
 * This class aims to let player to view the info page.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see org.frogger.gameController.EndPageController
 */
public class InfoPage {
	/**
	 * <strong>Loads information page</strong>
	 * 
	 * @throws Exception  FXML Loading Error
	 */
	public void loadPage() throws Exception {
		Parent info = FXMLLoader.load(getClass().getResource("/org/frogger/FXML/InfoPage.fxml"));
		Main.sceneSetting(info,"Here is the instruction!");
	}
}
