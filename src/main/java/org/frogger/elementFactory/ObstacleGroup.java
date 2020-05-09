package org.frogger.elementFactory;

import org.frogger.gameModel.Obstacle;
import org.frogger.gameSettings.World;

/**
 * <h1>ObstacleGroup class</h1>
 * <p>
 * The {@code ObstacleGroup} class represents a group of obstacles
 * to be added to stage with different parameters.
 * <p>
 * The {@code ObstacleGroup} object encapsulates the process of
 * instantiating {@code Obstacle} objects with different parameters,
 * such as initial status, speed, log types. And it also hides the 
 * process of adding log images to the game board. 
 * <p>
 * The encapsulation of the class achieves a well-organized project structure, 
 * especially {@code addElements(String level)} method, where we can adjust the
 * parameters without interfering with other classes.
 * <p>
 * The class implements {@code Integration} interface to add game elements.
 *  
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see ElementsFactory
 * @see org.frogger.gameSettings.World
 * @see org.frogger.gameModel.Obstacle
 */
public class ObstacleGroup implements Integration {
    /** 
     * This private local variable is used to add game elements
     */
    private World bg;

    /**
     * This constructor passes background to the private local variable {@code bg}.
     * 
     * @param bg  a background where the game elements can be added
     */
    public ObstacleGroup(World bg) {
        this.bg = bg;
    }

    /**
     * <strong>Adds obstacles to the game</strong>
     * <p>
     * This method passes the variable {@code level} to decide which game level of obstacles need to be added.
     * <p>
     * The String {@code level} has a value of "easy" or "hard" or "medium" to indicate the game mode.
     * 
     * @param level  a string that tells the method which level of obstacles should be added with corresponding parameters
     */
    @Override
    public void addElements(String level){
        String path = "/org/frogger/image/obstacle/";
        
        int[] speed = new int[] { 2, -2, 3, -5 }; // medium level

        if (level.equals("easy")) {
            speed = new int[] { 2, -1, 1, -5 };   // easy level
        }

        if (level.equals("hard")) {
            speed = new int[] { 4, -4, 5, -10 };  // hard level
        }

        bg.add(new Obstacle(path + "truck1Right.png", 0, 645, speed[0], 120, 120));
        bg.add(new Obstacle(path + "truck1Right.png", 300, 645, speed[0], 120, 120));
        bg.add(new Obstacle(path + "truck1Right.png", 600, 645, speed[0], 120, 120));
        bg.add(new Obstacle(path + "car1Left.png", 50, 595, speed[1], 50, 50));
        bg.add(new Obstacle(path + "raceLeft.png", 250, 590, speed[1], 60, 60));
        bg.add(new Obstacle(path + "car1Left.png", 450, 595, speed[1], 50, 50));
        bg.add(new Obstacle(path + "raceLeft.png", 650, 590, speed[1], 60, 60));
        bg.add(new Obstacle(path + "trainRight.png", 0, 535, speed[2], 250, 250));
        bg.add(new Obstacle(path + "trainRight.png", 450, 535, speed[2], 250, 250));
        bg.add(new Obstacle(path + "car1Left.png", 500, 485, speed[3], 50, 50));
        bg.add(new Obstacle(path + "car2Left.png", 100, 480, speed[3], 50, 50));
    }

}
