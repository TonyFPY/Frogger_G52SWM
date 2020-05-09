package org.frogger.elementFactory;

import org.frogger.gameModel.Zombie;
import org.frogger.gameSettings.World;

/**
 * <h1>ZombieGroup</h1>
 * <p>
 * The {@code ZombieGroup} class represents a group of zombie
 * to be added to stage with different parameters.
 * <p>
 * The {@code ZombieGroup} object encapsulates the process of
 * instantiating {@code Zombie} objects with different parameters,
 * such as initial position, speed, initial status. And it also hides
 * the process of adding zombie images to the game board. 
 * <p>
 * The encapsulation of the class achieves a well-organized project structure, 
 * especially {@code addElements(String level)} method, where we can
 * adjust the parameters without interfering with other classes.
 * According to the string {@code level} passed to the method, the method can
 * choose the corresponding level of the zombie objects.
 * <p>
 * The class implements {@code Integration} interface to add game elements.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see ElementsFactory
 * @see org.frogger.gameSettings.World
 * @see org.frogger.gameModel.Zombie
 */
public class ZombieGroup implements Integration{
    /** 
     * This private local variable is used to add game elements
     */
    private World bg;

    /**
     * This constructor passes background to the private local variable {@code bg}.
     * 
     * @param bg  a background where the game elements can be added
     */
    public ZombieGroup(World bg) {
        this.bg = bg;
    }

    /**
     * <strong>Adds zombies to the game</strong>
     * <p>
     * This method passes the variable {@code level} to decide which game level of zombies need to be added.
     * <p>
     * The String {@code level} has a value of "easy" or "hard" or "medium" to indicate the game mode.
     * 
     * @param level  a string tells the methods which level of zombies should be added with corresponding parameters
     */
    public void addElements(String level) {
        double[] speed = new double[] { -0.5, -1, -1.5 };
        double curSpeed = speed[1]; // medium level

        if (level.equals("easy")) {
            curSpeed = speed[0];    // easy level
        }
        if (level.equals("hard")) {
            curSpeed = speed[2];    // hard level
        }

        bg.add(new Zombie(400, 415, curSpeed, 150, 60));
        bg.add(new Zombie(100, 415, curSpeed, 150, 60));

    }
}
