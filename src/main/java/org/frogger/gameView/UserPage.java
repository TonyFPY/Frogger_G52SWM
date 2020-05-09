package org.frogger.gameView;

import org.frogger.Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * <h1>UserPage</h1>
 * <p>
 * This class aims to let player to view the user input page.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 */
public class UserPage {
	/**
	 * <strong>Loads user page</strong>
	 * 
	 * @throws Exception  FXML Loading Error
	 */
	public void loadPage() throws Exception {
		Parent level = FXMLLoader.load(getClass().getResource("/org/frogger/FXML/UserPage.fxml"));
		Main.sceneSetting(level,"Please enter your name here");
	}
}
