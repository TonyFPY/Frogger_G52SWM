package org.frogger.gameModel;

import javafx.scene.image.Image;
import org.frogger.elementFactory.TurtleGroup;

/**
 * <h1>WetTurtle</h1>
 * <p>
 * This class extends Turtle class's properties and features.
 * This class is a {@code WetTurtle} model containing setters 
 * and getters relevant to different parameters.
 * <p>
 * The {@code WetTurtle} object will show animation repeatedly.
 * <p>
 * The object has four status and They appear one after another and 
 * repeat until the game ends.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see Actor
 * @see TurtleGroup
 */
public class WetTurtle extends Turtle {
	Image turtle1, turtle2, turtle3, turtle4;
	private int speed;
	boolean sunk = false;
	
	/**
	 * This constructor receives an image link and corresponding parameters for initialization.
	 * 
	 * @param xpos  position in horizontal direction
	 * @param ypos  position in vertical direction
	 * @param s  value of wet turtle's speed
	 * @param w  value of image's width
	 * @param h  value of image's height
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		super(xpos, ypos, s, w, h);
		turtle1 = new Image("/org/frogger/image/turtle/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("/org/frogger/image/turtle/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("/org/frogger/image/turtle/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("/org/frogger/image/turtle/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	/**
	 * <strong>Moves wet turtles from the other side if they are out of the stage</strong>
	 */
	@Override
	public void act(long now) {
		if (now / 900000000 % 4 == 0) {
			setImage(turtle2);
			sunk = false;
		} else if (now / 900000000 % 4 == 1) {
			setImage(turtle1);
			sunk = false;
		} else if (now / 900000000 % 4 == 2) {
			setImage(turtle3);
			sunk = false;
		} else if (now / 900000000 % 4 == 3) {
			setImage(turtle4);
			sunk = true;
		}

		move(speed, 0);
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -150 && speed < 0)
			setX(600);
	}

	/**
	 * <strong>Checks whether the wet turtle is sunk</strong>
	 * 
	 * @return boolean -- true if the wet turtle is sunk, otherwise false
	 */
	public boolean isSunk() {
		return sunk;
	}
}
