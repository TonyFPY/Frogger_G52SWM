package org.frogger.gameSettings;

import org.frogger.elementFactory.ElementsFactory;

/**
 * <h1>GameMediumLevel</h1>
 * <p>
 * The {@code GameMediumLevel} class extends properties and features 
 * from {@code Game} class, representing medium-mode games.
 * <p>
 * This class implements {@code Components} interface.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see Game
 * @see Components
 */
public class GameMediumLevel extends Game implements Components{
	/**
	 * <strong>Sets all medium-level elements to the game</strong>
	 * <p>
	 * This method instantiates an {@code ShowElements} object calling 
	 * {@code setElements}, which sets all game elements to the game world.
	 * <p>
	 * The game elements includes logs, obstacles, turtles, crocodiles, zombies, habitats, animal.
	 */
	@Override
	public void setGameElements() {
		// initialize car, truck, log, turtle in medium mode
		ElementsFactory new_entities = new ElementsFactory(background);
		new_entities.setElements("medium");
	}
}
