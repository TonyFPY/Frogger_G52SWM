package org.frogger.gameSettings;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * <h1>Music</h1>
 * This class is used to handle music events.
 * <p>
 * This class is applied to singleton design pattern to avoid duplication.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 06/12/2019
 */
public enum Music {
	INSTANCE;
	private MediaPlayer mediaPlayer;
	private String musicFile;
	
	/**
	 * <strong>Chooses background music</strong>
	 * <p>
	 * This method uses String {@code music} to decide which music to be played.
	 * 
	 * @param music  a string that decides which music to be played
	 */
	public void playMusic(String music) {
		if (music.equals("Frogger")) {
			musicFile = "src/main/resources/org/frogger/music/Frogger.mp3";
		}
		if (music.equals("Avenger")) {
			musicFile = "src/main/resources/org/frogger/music/avengers.mp3";
		}
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
	}
	
	/**
	 * <strong>Stops playing music</strong>
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}
}
