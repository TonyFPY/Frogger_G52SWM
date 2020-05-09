package org.frogger.gameModel;

import javafx.scene.image.Image;
import org.frogger.elementFactory.CrocodileGroup;

/**
 * <h1>Crocodile</h1>
 * <p>
 * This class extends Actor class's properties and features.
 * <p>
 * This class is a {@code Crocodile} model containing setters 
 * and getters relevant to different parameters. {@code Crocodile} 
 * has two status in the game. One is closing mouth and the other is 
 * opening mouth. They appear one after another and repeat until the game ends.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see Actor
 * @see CrocodileGroup
 */
public class Crocodile extends Actor{
	Image crocodile1,crocodile2;
	private int speed;
	boolean eat = false;
	
	/**
	 * This constructor passes parameters to this class for initialization.
	 * 
	 * @param xpos  position in horizontal direction
	 * @param ypos  position in vertical direction
	 * @param s  value of crocodile's speed
	 * @param w  value of image's width
	 * @param h  value of image's height
	 */
	public Crocodile(int xpos, int ypos, int s, int w, int h) {
		crocodile1 = new Image("/org/frogger/image/crocodile/crocodile1.png", w, h, true, true);
		crocodile2 = new Image("/org/frogger/image/crocodile/crocodile2.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(crocodile1);
	}
	
	/**
	 * <strong>Sets different actions during a certain time period</strong>
	 */
	@Override
	public void act(long now) {
		if (now/900000000  % 3 ==0) {
			setImage(crocodile2);
			eat = true;
		} 
		
		if (now/900000000 % 3 == 1 || now/900000000 % 3 == 2) {
			setImage(crocodile1);
			eat = false;
		}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -150 && speed<0)
			setX(600);
	}
	
	/**
	 * <strong>Checks whether the crocodile is eating</strong>
	 * 
	 * @return boolean -- true if the crocodile is eating, otherwise false
	 */
	public boolean isEaten() {
		return eat;
	}
	
	/**  
	 * <strong>Gets the speed of the corcodile</strong>
	 * 
	 * @return speed -- the value of the crocodile's speed.
	 */
	public double getSpeed() {
		return speed;
	}
}
