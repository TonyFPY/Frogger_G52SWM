package org.frogger.gameModel;

import javafx.scene.image.Image;
import org.frogger.elementFactory.TurtleGroup;

/**
 * <h1>Turtle</h1>
 * <p>
 * This class extends Actor class's properties and features.
 * This class is a {@code Turtle} model containing setters 
 * and getters relevant to different parameters.
 * <p>
 * The {@code Turtle} object will show animation repeatedly.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see Actor
 * @see TurtleGroup
 */
public class Turtle extends Actor{
	Image turtle1,turtle2,turtle3;
	private int speed;
	
	/**
	 * This constructor receives an image link and corresponding parameters for initialization.
	 * 
	 * @param xpos  position in horizontal direction
	 * @param ypos  position in vertical direction
	 * @param s  value of turtle's speed
	 * @param w  value of image's width
	 * @param h  value of image's height
	 */
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("/org/frogger/image/turtle/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("/org/frogger/image/turtle/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("/org/frogger/image/turtle/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	/**
	 * <strong>Moves turtles from the other side if they are out of the stage</strong>
	 */
	@Override
	public void act(long now) {
		if (now/900000000  % 3 ==0) {
			setImage(turtle2);
			
		} else if (now/900000000 % 3 == 1) {
			setImage(turtle1);
			
		} else if (now/900000000 %3 == 2) {
			setImage(turtle3);	
		}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -150 && speed<0)
			setX(600);
	}
	
	/**  
	 * <strong>Gets the speed of the turtle</strong>
	 * 
	 * @return speed -- The value of the crocodile's speed.
	 */
	public double getSpeed() {
		return speed;
	}
}
