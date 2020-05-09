package org.frogger.elementFactory;

import org.frogger.gameModel.Frog;
import org.frogger.gameModel.Digit;
import org.frogger.gameSettings.World;

/**
 * <h1>ElementsFactory</h1>
 * The {@code ElementsFactory} class represents a group of game elements to be added
 * to stage with different parameters.
 * <p>
 * The {@code ElementsFactory} object encapsulates the process of
 * instantiating {@code CrocodileGroup, HabitatGroup, LogGroup,}
 * {@code ObstacleGroup, TurtleGroup, ZombieGroup}. And it also hides
 * the process of adding {@code Digit} and {@code Frog}images to the game board.
 * <p>
 * The encapsulation of the class achieves a well-organized project structure, 
 * because it integrates all the instantiation of objects and put all game
 * elements in one method. According to the string {@code level} passed to the
 * method, the method can choose the corresponding level of the turtle objects.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see CrocodileGroup
 * @see HabitatGroup
 * @see LogGroup
 * @see ObstacleGroup
 * @see TurtleGroup
 * @see ZombieGroup
 */
public class ElementsFactory {
    private World bg;
    private static Frog animal;

    /**
     * This constructor passes background to the private local variable {@code bg}.
     * 
     * @param bg  a background where the game elements can be added
     */
    public ElementsFactory(World bg) {
        this.bg = bg;
    }
    
    /**
     * <strong>Gets an animal object</strong>
     * <p>
     * This method is set to be static making it easier to call and access the private static variable animal.
     * <p>
     * Because in other parts of the code, we may use animal to access different method, such as getPoints().
     * 
     * @return animal -- a frog in the game
     * @see org.frogger.gameModel.Frog
     */
    public static Frog getAnimal() {
    	return animal;
    }

    /**
     * <strong>Adds all the game elements to the game</strong>
     * <p>
     * This method passes the variable {@code level} to decide which game level of game elements need to be added.
     * <p>
     * The game elements includes logs, obstacles, turtles, crocodiles, zombies, habitats, animal. 
     * <p>
     * The String {@code level} has a value of "easy" or "hard" or "medium" to indicate the game mode.
     * 
     * @param level  a string tells the methods which level of the game elements should be added with corresponding parameters
     */
    public void setElements(String level) {

        LogGroup n_logs = new LogGroup(bg);
        n_logs.addElements(level);

        TurtleGroup n_turtles = new TurtleGroup(bg);
        n_turtles.addElements(level);

        HabitatGroup n_ends = new HabitatGroup(bg);
        n_ends.addElements(level);

        ObstacleGroup n_obstacles = new ObstacleGroup(bg);
        n_obstacles.addElements(level);

        CrocodileGroup n_crocodiles;
        if (level.equals("medium")) {
        	n_crocodiles = new CrocodileGroup(bg);
        	n_crocodiles.addElements(level);
        }
        
        if (level.equals("hard")) {
        	n_crocodiles = new CrocodileGroup(bg);
        	n_crocodiles.addElements(level);

            ZombieGroup n_zombie = new ZombieGroup(bg);
        	n_zombie.addElements(level);
        }

		animal = new Frog("/org/frogger/image/frog/froggerUp.png");
		bg.add(animal);
        
        bg.add(new Digit(0, 30, 450, 10)); // score
        bg.add(new Digit(0, 30, 420, 10));
        bg.add(new Digit(0, 30, 390, 10));
        bg.add(new Digit(5, 30, 450, 45)); // HP

    }
}
