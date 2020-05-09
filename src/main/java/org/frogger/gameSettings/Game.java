package org.frogger.gameSettings;

import org.frogger.gameController.GameController;
import org.frogger.gameController.GameTimerController;
import org.frogger.gameModel.BackgroundImage;
import org.frogger.Main;

import javafx.scene.Scene;

/**
 * <h1>Game</h1>
 * <p>
 * This is an abstract class implementing Components interface, 
 * which can be inherented by games in different modes. 
 * <p>
 * This class is essential to create a game UI and add basic 
 * game elements to the game board.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see Components
 */
public abstract class Game implements Components {
	protected static World background;
	
	/**
	 * <strong>Gets background</strong>
	 * <p>
	 * This method is set to be static making it easier to call 
	 * and access the private static variable {@code animal}. 
	 * Because in other parts of code, we may use background 
	 * to add additional game elements.
	 * 
	 * @return World -- game background  
	 * @see org.frogger.gameSettings.World
	 */
	public static World getStage() {
		return background;
	}
	
	/**
	 * <strong>Sets the game background and starts the game</strong>
	 * <p>
	 * This method sets a scene to the stage and 
	 * adds buttons and texts to the scene.
	 * <p>
	 * This method contains {@code GameTimerController} to achieve 
	 * animation and {@code GameController} to set JavaFX components.
	 * 
	 * @see GameTimerController
	 * @see org.frogger.gameController.GameController
	 */
	public void startGame() {
		// add a game background
	    background = new World();
		BackgroundImage froggerback = new BackgroundImage();
		background.add(froggerback);	
		
		// set a window
		Scene scene = new Scene(background, 576, 815);				
		Main.getPrimaryStage().setTitle("Playing...");
		Main.getPrimaryStage().setScene(scene);
		Main.getPrimaryStage().show(); 
		Main.getPrimaryStage().setResizable(false);			
		
		GameController gc = new GameController();
		gc.setQuitButton();											// set a quit button
		gc.setPauseButton();										// set a pause button
		gc.setNewText();											// set a text
		
		GameTimerController gt = new GameTimerController();
		gt.createTimer();
		gt.BGstart();  												// start game with a timer
	}

}
