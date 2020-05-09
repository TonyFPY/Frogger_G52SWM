package org.frogger.elementFactory;

import org.frogger.gameModel.Turtle;
import org.frogger.gameModel.WetTurtle;
import org.frogger.gameSettings.World;

/**
 * <h1>TurtleGroup</h1>
 * The {@code TurtleGroup} class represents a group of turtles
 * to be added to stage with different parameters.
 * <p>
 * The {@code TurtleGroup} object encapsulates the process of
 * instantiating {@code Turtle} and {@code WetTurtle} objects with different parameters,
 * such as initial position, speed, initial status. And it also hides
 * the process of adding turtle images to the game board. 
 * <p>
 * The encapsulation of the class achieves a well-organized project structure, 
 * especially {@code addElements(String level)} method, where we can
 * adjust the parameters without interfering with other classes.
 * According to the string {@code level} passed to the method, the method can
 * choose the corresponding level of the turtle objects.
 * <p>
 * The class implements {@code Integration} interface to add game elements.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see ElementsFactory
 * @see org.frogger.gameModel.Turtle
 * @see org.frogger.gameModel.WetTurtle
 * @see org.frogger.gameSettings.World
 */
public class TurtleGroup implements Integration {
    /** 
     * This private local variable is used to add game elements
     */
    private World bg;

    /**
     * This constructor passes background to the private local variable {@code bg}.
     * 
     * @param bg  a background where the game elements can be added
     */
    public TurtleGroup(World bg) {
        this.bg = bg;
    }

    /**
     * <strong>Adds turtles to the game</strong>
     * <p>
     * This method passes the variable {@code level} to decide which game level of turtles need to be added.
     * <p>
     * The String {@code level} has a value of "easy" or "hard" or "medium" to indicate the game mode.
     * 
     * @param level  a string tells the methods which level of turtles should be added with corresponding parameters
     */
    public void addElements(String level) {
        int[] speed = new int[] { -1, -2, -4 };
        int curSpeed = speed[1]; // medium level

        if (level.equals("easy")) {
            curSpeed = speed[0]; // easy level
        }
        if (level.equals("hard")) {
            curSpeed = speed[2]; // hard level
        }
        bg.add(new WetTurtle(500, 320, curSpeed, 130, 130));
        bg.add(new Turtle(300, 320, curSpeed, 130, 130));
        bg.add(new Turtle(600, 215, curSpeed, 130, 130));
        bg.add(new Turtle(100, 215, curSpeed, 130, 130));
        
        if (level.equals("easy")) {
        	bg.add(new WetTurtle(750, 320, curSpeed, 130, 130));
        	bg.add(new WetTurtle(400, 215, curSpeed, 130, 130));
        }
    }
}