package org.frogger.gameModel;

import javafx.scene.image.Image;

/**
 * <h1>Zombie</h1>
 * <p>
 * This class extends Actor class's properties and features.
 * This class is a {@code Zombie} model containing setters 
 * and getters relevant to different parameters.
 * <p>
 * The {@code Zombie} object will show animation repeatedly,
 * moving from right to left.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see Actor
 */
public class Zombie extends Actor{
	Image Z1,Z2,Z3,Z4,Z5,Z6;
	private double speed;

	/**
	 * This constructor receives an image link and corresponding parameters for initialization.
	 * 
	 * @param xpos  position in horizontal direction
	 * @param ypos  position in vertical direction
	 * @param s  value of turtle's speed
	 * @param w  value of image's width
	 * @param h  value of image's height
	 */
	public Zombie(int xpos, int ypos, double s, int w, int h) {
		Z1 = new Image("/org/frogger/image/zombie/Zombie1.png", w, h, true, true);
		Z2 = new Image("/org/frogger/image/zombie/Zombie2.png", w, h, true, true);
		Z3 = new Image("/org/frogger/image/zombie/Zombie3.png", w, h, true, true);
		Z4 = new Image("/org/frogger/image/zombie/Zombie4.png", w, h, true, true);
		Z5 = new Image("/org/frogger/image/zombie/Zombie5.png", w, h, true, true);
		Z6 = new Image("/org/frogger/image/zombie/Zombie6.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(Z1);
	}
	
	/**
	 * <strong>Moves zombies from the other side if they are out of the stage</strong>
	 */
	@Override
	public void act(long now) {
		if (now/100000000  % 6 == 0) {
			setImage(Z1);
		} else if (now/100000000 % 6 == 1) {
			setImage(Z2);
		} else if (now/100000000 % 6 == 2) {
			setImage(Z3);
		} else if (now/100000000 % 6 == 3) {
			setImage(Z4);
		} else if (now/100000000 % 6 == 4) {
			setImage(Z5);
		} else if (now/100000000 % 6 == 5) {
			setImage(Z6);
		}
			
		move(speed , 0);
		// can be deleted
		if (getX() > 600 && speed>0)
			setX(-200);
		
		if (getX() < -50 && speed<0)
			setX(580);
	}

}
