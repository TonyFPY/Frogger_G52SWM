package org.frogger.elementFactory;

import org.frogger.gameModel.Log;
import org.frogger.gameSettings.World;

/**
 * <h1>LogGroup</h1>
 * The {@code LogGroup} class represents a group of logs
 * to be added to stage with different parameters.
 * <p>
 * The {@code LogGroup} object encapsulates the process of
 * instantiating {@code Log} objects with different parameters,
 * such as initial position, speed. And it also hides
 * the process of adding log images to the game board. 
 * <p>
 * The encapsulation of the class achieves a well-organized project structure, 
 * especially {@code addElements(String level)} method, where we can
 * adjust the parameters without interfering with other classes.
 * According to the string {@code level} passed to the method, the method can
 * choose the corresponding level of the log objects.
 * <p>
 * The class implements {@code Integration} interface to add game elements.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see ElementsFactory
 * @see org.frogger.gameModel.Log
 * @see org.frogger.gameSettings.World
 */
public class LogGroup implements Integration {
    /** 
     * This private local variable is used to add game elements
     */
    private World bg;

    /**
     * This constructor passes background to the private local variable {@code bg}.
     * 
     * @param bg  a background where the game elements can be added
     */
    public LogGroup(World bg) {
        this.bg = bg;
    }

    /**
     * <strong>Adds logs to the game</strong>
     * <p>
     * This method passes the variable {@code level} to decide which game level of logs need to be added.
     * <p>
     * The String {@code level} has a value of "easy" or "hard" or "medium" to indicate the game mode.
     * 
     * @param level  a string tells the method which level of logs should be added with corresponding parameters
     */
    public void addElements(String level) {
        String path = "/org/frogger/image/log/";
        int[][] xpos = { { 0, 250, 500 }, { 0, 400 }, { 0, 400, 490 } };
        double[] speed = new double[]{2.0, -4.0, 2.0};     // medium level

        if (level.equals("easy")) {
            speed = new double[] { 0.5, -0.5, 0.5 }; // easy level
        }

        if (level.equals("hard")) {
            speed = new double[] { 4.0, -8.0, 4.0 }; // hard level
        }

        for (int i = 0; i < 3; i++) {
            bg.add(new Log(path + "log3.png", 150, xpos[0][i], 170, speed[0]));
        }

        for (int i = 0; i < 2; i++) {
            bg.add(new Log(path + "logs.png", 300, xpos[1][i], 275, speed[1]));
            bg.add(new Log(path + "log2.png", 200, xpos[2][i], 378, speed[2]));
        }
    }

}
