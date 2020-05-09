package org.frogger.elementFactory;

import org.frogger.gameModel.Habitat;
import org.frogger.gameSettings.World;

/**
 * <h1>HabitatGroup</h1>
 * <p>
 * The {@code HabitatGroup} class represents a group of frogs's habitats
 * to be added to stage with different parameters.
 * <p>
 * The {@code HabitatGroup} object encapsulates the process of
 * instantiating {@code Habitat} objects with different initial position. 
 * And it also hides the process of adding Habitat images to the game board. 
 * <p>
 * The encapsulation of the class achieves a well-organized project structure, 
 * especially {@code addElements()} method, where we can adjust the parameters
 * without interfering with other classes.
 * <p>
 * The class implements {@code Integration} interface to add game elements.
 *
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see org.frogger.elementFactory.ElementsFactory
 * @see org.frogger.gameSettings.World
 * @see org.frogger.gameModel.Habitat
 */
public class HabitatGroup implements Integration {
    /** 
     * This private local variable is used to add game elements
     */
    private World bg;

    /**
     * This constructor passes background to the private local variable {@code bg}.
     * 
     * @param bg  a background where the game elements can be added
     */
    public HabitatGroup(World bg) {
        this.bg = bg;
    }

    /**
     * <strong>Adds the frogs's habitats to the game</strong>
     * <p>
     * This method adds five habitats to the game, which are the destinations of frogs in the game.
     *
     * @param level  a string tells the method which level of logs should be added with corresponding parameters
     */
    public void addElements(String level) {
        bg.add(new Habitat(10, 96));
        bg.add(new Habitat(130, 96));
        bg.add(new Habitat(255, 96));
        bg.add(new Habitat(375, 96));
        bg.add(new Habitat(495, 96));
    }
}
