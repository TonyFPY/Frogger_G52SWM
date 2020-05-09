package org.frogger;

import org.frogger.gameView.StartingPage;
import org.frogger.gameSettings.Music;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * <h1>Main</h1>
 * This class contains {@code main()} method for player to start the whole program.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 */
public class Main extends Application {
	private static Stage primaryStage;
	
	/**
	 * <strong>Sets primaryStage to a local private static variable</strong>
	 * 
	 * @param stage  primary stage passed to the class
	 */
	public void setPrimaryStage(Stage stage) {
		Main.primaryStage = stage;
	}
	
	/**
	 * <strong>Gets primary stage</strong>
	 * <p>
	 * This method is set to static making it easier to call and access {@code primaryStage}.
	 * <p>
	 * Because in other parts of code, we may use {@code primaryStage} 
	 * to set different scenes, such as starting page, high score page.
	 * 
	 * @return primaryStage -- a stage used to display scenes
	 */
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	/**
	 * <strong>Sets a scene to the primary stage</strong>
	 * <p>
	 * This method sets a scene to the {@code primaryStage} to visualize the UI.
	 * 
	 * @param root  FXML resource
	 * @param title  text to be shown on the top of the window
	 */
	public static void sceneSetting(Parent root, String title) {
		Scene scene = new Scene(root, 576, 815);
		Main.getPrimaryStage().setTitle(title);
		Main.getPrimaryStage().setScene(scene);
		Main.getPrimaryStage().show(); 
		Main.getPrimaryStage().setResizable(false);
	}
	
	/**
	 * <strong>Starts the game and loads FXML resource</strong>
	 * <p>
	 * This method is called by {@code main()} method.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		Music.INSTANCE.playMusic("Frogger");
		StartingPage start = new StartingPage();
		start.loadPage();
	}
	
	/**
	 * <strong>Starts the entire program through main() methods</strong>
	 * 
	 * @param args  argument used to launch the whole program
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
