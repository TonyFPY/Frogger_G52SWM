package org.frogger.gameView;

import org.frogger.Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * <h1>EndPage</h1>
 * <p>
 * This class aims to let player to view the end page.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see org.frogger.gameController.EndPageController
 */
public class EndPage {
	
	/**
	 * <strong>Loads end page</strong>
	 * 
	 * @throws Exception  FXML Loading Error
	 */
	public void loadPage() throws Exception {
		Parent end = FXMLLoader.load(getClass().getResource("/org/frogger/FXML/EndPage.fxml"));
		Main.sceneSetting(end,"Congratulations !");
	}
}
