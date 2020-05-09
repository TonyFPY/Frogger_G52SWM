package org.frogger.elementFactory;

/**
 * <h1>Integration</h1>
 * <p>
 * This interface groups the method to add a group of a specific game elements to the game.
 * <p>
 * Because games of different levels use the same method with different contents.
 *
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 23/11/2019
 * @see ElementsFactory
 */
public interface Integration {
    /**
     * <strong>Adds a group of a specific game elements to the game</strong>
     * @param level a background where the game elements can be added
     */
    public void addElements(String level);
}
