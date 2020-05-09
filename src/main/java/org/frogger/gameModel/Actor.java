package org.frogger.gameModel;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

import org.frogger.gameController.GameTimerController;
import org.frogger.gameSettings.World;

/**
 * <h1>Actor</h1>
 * <p>
 * This is an abstract class for some specific game elements to make actions
 * and implement game animations. The class integrates methods to let {@code Actor}
 * objects to react to different cases. The subclasses of this class will extends its
 * properties and features to implement different actions.
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see GameTimerController
 * @see org.frogger.gameController.GameController
 */
public abstract class Actor extends ImageView{
	/**
	 * <strong>Moves the actor to next position</strong>
	 * 
	 * @param dx  a distance in horizontal direction
	 * @param dy  a distance in vertical direction
	 */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * <strong>Gets game world</strong>
     * 
     * @return parent -- the parent of this node 
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * <strong>Gets the width of game window</strong>
     * 
     * @return width -- the width of the game window
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }
    
    /**
     * <strong>Gets the height of game window</strong>
     * 
     * @return height -- the height of the game window
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * <strong>Checks intersection between different objects</strong>
     * 
     * @param <A>  a class that extends Actor class
     * @param cls  name of a specific class
     * @return someArray -- a array of objects in same class
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(Class<A> cls){
        ArrayList<A> someArray = new ArrayList<>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }

    /**
     * This is an abstract method to be overriden by subclasses
     * 
     * @param now  current time
     */
    public abstract void act(long now);
}
