package org.frogger.gameController;

import org.frogger.gameModel.HighScoreList;
import org.frogger.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 * <h1>HighScorePageController</h1>
 * <p>
 * This class represents a controller to control the {@code HighScorePage} Model,
 * which includes buttons allowing user interaction and handles user input events.
 * <p>
 * This class integrates the methods to allow user interaction. The top-10 high scores 
 * with corresponding players' names will be shown on the game board.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 25/11/2019
 * @see org.frogger.gameView.HighScorePage
 */
public class HighScorePageController {
	/**
	 * A label to display high scores
	 */
	@FXML
	private Label scoreLabel;
	
	/** 
	 * A label to display names
	 */
	@FXML
	private Label nameLabel;
	
	/**
	 * <strong>Handles a button event to move to starting page</strong>
	 * 
	 * @throws Exception  FXML Loading Error
	 * @see Main
	 */
	@FXML
	public void changeTOStartingPage() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/org/frogger/FXML/StartingPage.fxml"));
		Main.sceneSetting(root,"Starting Game");
	}
	
	/**
	 * <strong>Initilizes the starting page</strong>
	 * <p>
	 * This method is called to show high scores and corresponding players. 
	 * 
	 * @throws Exception  File Reading/Writing Error
	 * @see org.frogger.gameModel.HighScoreList
	 */
	public void initialize() throws Exception {
		HighScoreList list = HighScoreList.getInstance();
		list.modifyList();
		String nameList = list.showNameList();
		String scoreList = list.showScoreList();
		nameLabel.setText(nameList);
		scoreLabel.setText(scoreList);
	}
	
	
}
