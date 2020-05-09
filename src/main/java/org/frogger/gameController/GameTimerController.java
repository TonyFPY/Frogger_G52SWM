package org.frogger.gameController;

import org.frogger.elementFactory.ElementsFactory;
import org.frogger.gameModel.HighScoreList;
import org.frogger.gameSettings.Game;
import org.frogger.gameSettings.Music;
import org.frogger.gameView.EndPage;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * <h1>GameTimerController</h1>
 * <p>
 * This class applies timer to the game and checks game status. It checks whether
 * the game stops, whether the point is changed. 
 * <p>
 * Some methods can be called to control the background music. When the game 
 * finishes, background music will be stopped.
 * <p>
 * The game information will be dynamically conveyed to other class. The final score 
 * that player gets will be conveyed to the end page and high score "database" if it
 * satisfies the condition to be uploaded on the high score list.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see Game
 */
public class GameTimerController {
	private static AnimationTimer BGtimer;
	private Label timeCount;
	private Integer timeLimit = 100;
	private Integer interval = 0;
	private Integer current;
	
	/**
	 * <strong>Handles the timer events and check whether the score changes or the game stops</strong>
	 * <p>
	 * In this method, current score will be passed to {@code GameController} to 
	 * visualize the score on the game board.
	 * <p>
	 * If the game is over, high score will be passed to to{@code HighScorePageController} 
	 * to visualize in the high score page.
	 * 
	 * @see GameController
	 */
	public void createTimer() {
		setTimer();
        BGtimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if(interval % 60 == 0) {
            		current = timeLimit - interval/60;
                	timeCount.setText("Time remaining : " + current);
            	}    
            	interval++;
            	if (ElementsFactory.getAnimal().changeScore()) {
            		GameController.setScore(ElementsFactory.getAnimal().getPoints());
            	}
            	if (ElementsFactory.getAnimal().getStop() || current.equals(Integer.valueOf(0))) {
            		showEndPage();
            	}
            }
        };
    }
	
	/**
	 * <strong>Calls {@code createTimer()} to creates a timer for the game to activate animation</strong>
	 */
	public static void BGstart() {
		Game.getStage().ActorStart();
		BGtimer.start();
    }
	
	/**
	 * <strong>Stops timer and background music</strong>
	 */
	public static void BGstop() {
		Game.getStage().ActorStop();
		Music.INSTANCE.stopMusic();
		BGtimer.stop();
    }
	
	/**
	 * <strong>Sets a timer coundown for the game</strong>
	 */
    public void setTimer() { 
    	timeCount = new Label();
    	timeCount.setLayoutX(180);
    	timeCount.setLayoutY(770);
    	timeCount.setFont(Font.font ("Arcade", 30));
    	timeCount.setTextFill(Color.WHITE);
    	Game.getStage().getChildren().add(timeCount);
    }
    
    /**
     * <strong>Goes to the end page</strong>
     */
    public void showEndPage() {
    	BGstop();
		try {
			HighScoreList.setScore(ElementsFactory.getAnimal().getPoints());
			HighScoreList hList = new HighScoreList();
			hList.modifyList();
			EndPage e = new EndPage();
			e.loadPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
