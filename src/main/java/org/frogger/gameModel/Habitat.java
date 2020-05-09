package org.frogger.gameModel;

import javafx.scene.image.Image;
import org.frogger.elementFactory.HabitatGroup;

/**
 * <h1>Habitat</h1>
 * <p>
 * This class extends Actor class's properties and features.
 * This class is a {@code Habitat} model containing setters and getters relevant to different parameters.
 * <p>
 * The End image with a frog will appear if the frog successfully reaches home.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see Actor
 * @see HabitatGroup
 */
public class Habitat extends Actor{
	boolean activated = false;
	
	/**
	 * This constructor passes the parameters for initialization.
	 * 
	 * @param x  position in horizontal direction
	 * @param y  position in vertical direction
	 */
	public Habitat(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("/org/frogger/image/frog/End.png", 60, 60, true, true));
	}
	
	/**
	 * <strong>Sets the image if a frog reaches home</strong>
	 */
	public void setEnd() {
		setImage(new Image("/org/frogger/image/frog/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	/** 
	 * <strong>Checks whether a frog reaches home</strong>
	 * 
	 * @return activated -- true if a frog reaches home, otherwise false
	 */
	public boolean isActivated() {
		return activated;
	}
	
	@Override
	public void act(long now) {}

}
