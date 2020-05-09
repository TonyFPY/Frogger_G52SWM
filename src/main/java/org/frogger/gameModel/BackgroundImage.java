package org.frogger.gameModel;

import javafx.scene.image.Image;

/**
 * <h1>BackgroundImage</h1>
 * <p>
 * This class extends Actor class's properties and features.
 * <p>
 * The {@code BackgroundImage} object aims to set background image to the game board.

 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see Actor
 */
public class BackgroundImage extends Actor{
	private String path = "/org/frogger/image/background/GameBG.png";
	
	/**
	 * This constructor passes an image URL to this class for initializaiton.
	 */
	public BackgroundImage() {
		setImage(new Image(path, 576, 815, true, true));
	}
	
	@Override
	public void act(long now) {}

}
