package org.frogger.gameSettings;

/**
 * <h1>Components</h1>
 * <p>
 * This interface groups the method to set various game elements to the game.
 * <p>
 * Because games of different levels use the same method with different contents. 
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 23/11/2019
 * @see Game
 * @see GameEasyLevel
 * @see GameHardLevel
 * @see GameMediumLevel
 */
public interface Components {
	/**
	 * <strong>Integrates all the game elements and adds them to the game</strong>
	 */
	public void setGameElements();
	
	/**
	 * <strong>Starts game</strong>
	 */
	public void startGame();
}
