package org.frogger.gameModel;

import javafx.scene.image.Image;

/**
 * <h1>Obstacles</h1>
 * <p>
 * This class extends Actor class's properties and features.
 * This class is a {@code Obstacle} model containing setters 
 * and getters relevant to different parameters. 
 * <p>
 * The {@code Obstacles} object will show animation repeatedly.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see Actor
 */
public class Obstacle extends Actor {
	private int speed;
	
	/**
	 * This constructor receives an image link and corresponding parameters for initialization.
	 * 
	 * @param imageLink  the link of a image
	 * @param xpos  position in horizontal direction
	 * @param ypos  position in vertical direction
	 * @param s  value of obstacle's speed
	 * @param w  value of image's width
	 * @param h  value of image's height
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}
	
	/**
	 * <strong>Moves obstacles from the other side if they are out of the stage</strong>
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 650 && speed>0)
			setX(-250);
		if (getX() < -150 && speed<0)
			setX(600);
	}
	

}
