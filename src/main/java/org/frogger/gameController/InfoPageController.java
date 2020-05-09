package org.frogger.gameController;

import org.frogger.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 * <h1>InfoPageController</h1>
 * <p>
 * This class represents a controller to control the {@code InfoPage} Model, 
 * which includes buttons allowing user interaction and handles user input events.
 * <p>
 * This class integrates the methods to allow user to go to the previous page.
 * <p>
 * A set of game instructions will be shown on the game board.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 25/11/2019
 * @see org.frogger.gameView.InfoPage
 */
public class InfoPageController {
	/**
	 * A label displays instructions.
	 */
	@FXML
	private Label playLabel;
	
	/**
	 * <strong>Handles a button event to move to starting page </strong>
	 * 
	 * @throws Exception -- FXML Loading Error
	 * @see Main
	 */
	@FXML
	public void changeTOStartingPage() throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/org/frogger/FXML/StartingPage.fxml"));
		Main.sceneSetting(root,"Starting Game");
	}
	
	/**
	 * <strong>Initilizes the end page</strong>
	 * <p>
	 * This method is called to display a game instruction for players. 
	 */
	public void initialize() {
		String text = "Players control a frog which starts out at the\n"
				+     "bottom of the screen by pressing 'W','A','S','D'.\n"
				+     "The goal is to safely guide the frog across the\n"
				+     "road and river to one of the five habitats along in \n"
				+     "100 seconds. Along the way there are many dangers \n"
				+	  "that players need to navigate past. Players can \n"
				+     "also choose different levels of the game if they "
				+     "want to challenge themselves.";
		playLabel.setText(text);
	}
}
