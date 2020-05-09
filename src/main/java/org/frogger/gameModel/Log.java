package org.frogger.gameModel;

import javafx.scene.image.Image;

/**
 * <h1>Log</h1>
 * <p>
 * This class extends Actor class's properties and features.
 * This class is a {@code Log} model containing setters and 
 * getters relevant to different parameters. 
 * <p>
 * The {@code Log} object will show animation repeatedly.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see Actor
 */
public class Log extends Actor {
	private double speed;
	
	/**
	 * This constructor receives an image link and corresponding parameters for initialization.
	 * 
	 * @param imageLink  a string of an image link
	 * @param size  size of the log images
	 * @param xpos  position in horizontal direction
	 * @param ypos  position in vertical direction
	 * @param s  speed of logs
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	/**
	 * <strong>Moves logs from the other side if they are out of the stage</strong>
	 */
	@Override
	public void act(long now) {
		move(getSpeed() , 0);
		if (getX() > 600 && getSpeed() > 0)
			setX(-200); 
		if (getX()<-300 && getSpeed() < 0)
			setX(600);
	}
	
	/**
	 * <strong>Checks whether the image goes left</strong>
	 * 
	 * @return boolean -- true if the image goes left, otherwise false
	 */
	public boolean getLeft() {
		return getSpeed() < 0;
	}

	/**
	 * <strong>Gets the speed of logs</strong>
	 * 
	 * @return speed -- the speed of logs
	 */
	public double getSpeed() {
		return speed;
	}

}
