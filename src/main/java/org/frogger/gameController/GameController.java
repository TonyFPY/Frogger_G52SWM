package org.frogger.gameController;

import java.util.Optional;

import org.frogger.gameModel.Digit;
import org.frogger.gameSettings.Game;
import org.frogger.Main;
import org.frogger.gameSettings.Music;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;

/**
 * <h1>GameController</h1>
 * This class represents a controller to control the {@code Game},
 * which includes buttons allowing user interaction and handles 
 * user input events. <br>Also, some methods can be called to update 
 * the game information displayed on the game board.
 * <p>
 * This class integrates the methods to update game status.
 * <ul>
 * <li> The score displayed on the game board will be updated when score is changed.
 * <li> HP value is set one the game board to indicate the number of lives remaining.
 * <li> Player can click "QUIT" to close the game if he/she gives up.
 * </ul>
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 25/11/2019
 * @see org.frogger.gameSettings.Game
 */
public class GameController {
	private static int pre_hundred_digit = 0;
	private int signal = 1;
	
	/**
	 * <strong>Displays player's current score on the game board</strong>
	 * <p>
	 * The methods is set to be static making it easier to get current score. 
	 * <p>
	 * This method can be used to access the final score when the game is over.
	 * 
	 * @param score  a number representing a score that a player currently gets
	 */
	public static void setScore(int score) {
    	int d, digit, shift = 0;
    	int hundred_digit = score/100;
    	
    	// separate a number and get a single digit in every loop
    	while (score > 0) {
    		  d = score / 10;
    		  digit = score - d * 10;
    		  score = d;
    		  Game.getStage().add(new Digit(digit, 30, 450 - shift, 10));
    		  shift += 30;
    	}
    	
    	// change the hundred digit
    	if(pre_hundred_digit > hundred_digit) {
    		Game.getStage().add(new Digit(hundred_digit, 30, 390, 10));
    	}
    	pre_hundred_digit = hundred_digit;
    	
    }
	
	/**
	 * <strong>Displays the number of current lives on the game board</strong>
	 * <p>
	 * The methods is set to be static making it easier to get current number of lives. 
	 * <p>
	 * This method can be called to access the current remaining lives.
	 * 
	 * @param life  a number representing the lives that the player currently has
	 */
	public static void setlife(int life) {
		Game.getStage().add(new Digit(life, 30, 450, 45));
    }

	/**
	 * <strong>Displays texts on the game board with proper style</strong>
	 */
	public void setNewText() {
		Text scoreText = new Text(300,40,"Score: ");
		scoreText.setFont(Font.font ("Arcade", 30));
		scoreText.setFill(Color.WHITE);
		Game.getStage().getChildren().add(scoreText);
		
		Text lifeText = new Text(300,75,"HP: ");
		lifeText.setFont(Font.font ("Arcade", 30));
		lifeText.setFill(Color.WHITE);
		Game.getStage().getChildren().add(lifeText);		
	}
	
	/**
	 * <strong>Adds a "QUIT" button to the game for user interaction</strong>
	 */
    public void setQuitButton() {
    	Button btn = new Button();
        btn.setText("QUIT");
        // click the button and an alert will be displayed
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	setQuitAlert();
            }
        });
        btn.setLayoutX(500);
        btn.setLayoutY(10);
        btn.setPrefSize(60, 25);
        Game.getStage().getChildren().add(btn);
    }
    
	/**
	 * <strong>Adds a "STOP" button to the game for user interaction</strong>
	 */
    public void setPauseButton() {
    	Button btn = new Button();
        btn.setText("STOP");
        // click the button and an alert will be displayed
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(signal == 1) {
            		GameTimerController.BGstop();
            		signal = 0;
            	} else {
            		GameTimerController.BGstart();
            		Music.INSTANCE.playMusic("Frogger");
            		signal = 1;
            	}
            }
        });
        btn.setLayoutX(500);
        btn.setLayoutY(45);
        btn.setPrefSize(60, 25);
        Game.getStage().getChildren().add(btn);
    }
    
    /**
     * <strong>Shows an alert when player clicks the "QUIT" button</strong>
     * <ul>
     * <li>If player clicks "OK", the game will close;
     * <li>else, the game continues.
     * </ul>
     */
    public void setQuitAlert() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Bye Bye!");
		alert.setHeaderText("Please consider carfully (^_^)");
		alert.setContentText("Are you sure to quit?\nYou will lose your current status and marks!");	
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			GameTimerController.BGstop();
	    	Main.getPrimaryStage().close();
		}
    }   
}
