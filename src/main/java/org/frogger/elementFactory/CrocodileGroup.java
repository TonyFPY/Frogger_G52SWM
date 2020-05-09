package org.frogger.elementFactory;

import org.frogger.gameModel.Crocodile;
import org.frogger.gameSettings.World;

/**
 * <h1>CrocodileGroup</h1>
 * <p>
 * The {@code CrocodileGroup} class represents a group of crocodiles
 * to be added to stage with different parameters.
 * <p>
 * The {@code CrocodileGroup} object encapsulates the process of
 * instantiating {@code Crocodile} objects with different parameters,
 * such as initial position, speed, initial status. And it also hides
 * the process of adding crocodile images to the game board. 
 * <p>
 * The encapsulation of the class achieves a well-organized project structure, 
 * especially {@code addElements(String level)} method, where we can
 * adjust the parameters without interfering with other classes.
 * According to the string {@code level} passed to the method, the method can
 * choose the corresponding level of the crocodile objects.
 * <p>
 * The class implements {@code Integration} interface to add game elements.
 *
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see ElementsFactory
 * @see org.frogger.gameSettings.World
 * @see org.frogger.gameModel.Crocodile
 */
public class CrocodileGroup implements Integration {
	
    /** 
     * This private local variable is used to add game elements
     */
    private World bg;

    /**
     * This constructor passes background to the private local variable {@code bg}.
     *
     * @param bg  a background where the game elements can be added
     */
    public CrocodileGroup(World bg) {
        this.bg = bg;
    }

    /**
     * <strong>Adds crocodiles to the game.</strong>
     * <p>
     * This method passes the variable {@code level} to decide which level of crocodiles need to be added.
     * <p>
     * The String {@code level} has a value of "easy" or "hard" or "medium" to indicate the game mode.
     *
     * @param level  a string tells the method which level of crocodiles should be added with corresponding parameters
     */
    public void addElements(String level) {
        int[] speed = new int[] { -1, -2, -4 }; // different levels of the game
        int curSpeed = speed[1]; 				// medium level

        if (level.equals("easy")) {
            curSpeed = speed[0]; 				// easy level
        }
        if (level.equals("hard")) {
            curSpeed = speed[2]; 				// hard level
        }

        bg.add(new Crocodile(400, 190, curSpeed, 150, 125));
        bg.add(new Crocodile(750, 295, curSpeed, 150, 125));

    }
}
