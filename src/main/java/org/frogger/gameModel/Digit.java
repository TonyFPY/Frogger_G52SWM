package org.frogger.gameModel;

import javafx.scene.image.Image;

/**
 * <h1>Digit</h1>
 * <p>
 * This class extends Actor class's properties and features.
 * <p>
 * This class is a {@code Digit} model containing setters and getters relevant to different parameters.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 */
public class Digit extends Actor{
	private Image im1;
	
	/**
	 * This constructor passes parameters for initilization.
	 * 
	 * @param n  the digit to be displayed
	 * @param dim  size of the image
	 * @param x	 position in horizontal direction
	 * @param y  position in vertical direction
	 */
	public Digit(int n, int dim, int x, int y) {
		im1 = new Image("/org/frogger/image/score/"+n+".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}

	@Override
	public void act(long now){}
}
