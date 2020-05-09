package org.frogger.gameModel;

import org.frogger.gameController.GameController;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * <h1>Frog</h1>
 * <p>
 * This class extends {@code Actor} class's properties and features.
 * <p>
 * {@code Frog} object plays an important role through the entire game, because
 * player needs to manipulate the frog to get over the challenges by pressing 
 * "W", "A", "S", "D". When programming, it needs to handle different cases and implement 
 * different actions, especially when the frog intersects with different game elements.<p>
 * More specifically, 
 * <ul>
 * <li>when the frog is hit by moving obstacles, it will lose a life;
 * <li>when the frog stands on a log or a turtle, it will move with the log;
 * <li>when the frog is eaten by the crocodile, it will lose a life;
 * <li>When the frog jumps into the water, it will lose a life;
 * <li>When the frog reaches home, a new frog will appear in the initial position.
 * </ul>
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 * @see Actor
 */
public class Frog extends Actor {
    private Image imgW1, imgA1, imgS1, imgD1, imgW2, imgA2, imgS2, imgD2;
    private int points = 0;
    private int end = 0;
    private int life = 5;
    private boolean second = false;
    private boolean noMove = false;
    private double movement = 13.3333333 * 2;
    private double movementX = 10.666666 * 2;
    private int imgSize = 40;
    private boolean death = false;
    private boolean changeScore = false;
    private int froggerD = 0;
    private double w = 800;

    /**
     * This constructor receives an image link and sets keyboard events
     * 
     * @param imageLink  a string of an image link
     */
    public Frog(String imageLink) {
        setFroggerImage(imageLink);
        pressKey();
        releaseKey();
    }

    /**
     * <strong>Sets actions for the game</strong>
     * <p>
     * The game needs to check the frog's position and status.
     * <p>
     * This method overrides its parent class's method.
     */
    @Override
    public void act(long now) {
    	checkPosition();
        checkDeath(now);
        checkIntersection();
    }    

    /**
     * <strong>Checks whether the game stops or no life remaining</strong>
     * 
     * @return boolean -- true if the game stops, otherwise false.
     */
    public boolean getStop() {
        return (end == 5 || life == 0); 
    }

    /**
     * <strong>Gets scores the player currently obtains</strong>
     * 
     * @return points -- the value of the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * <strong>Checks whether the score is changed currently</strong>
     * 
     * @return boolean -- true if the score is changed, otherwise false
     */
    public boolean changeScore() {
        if (changeScore) {
            changeScore = false;
            return true;
        }
        return false;

    }

    /**
     * <strong>Sets different frogs' images and its position</strong>
     * 
     * @param imageLink -- a link of frog image
     */
    public void setFroggerImage(String imageLink) {
        setImage(new Image(imageLink, imgSize, imgSize, true, true));
        setX(275);
        setY(679.8 + movement);
        String path = "/org/frogger/image/frog/";
        imgW1 = new Image(path + "froggerUp.png", imgSize, imgSize, true, true);
        imgA1 = new Image(path + "froggerLeft.png", imgSize, imgSize, true, true);
        imgS1 = new Image(path + "froggerDown.png", imgSize, imgSize, true, true);
        imgD1 = new Image(path + "froggerRight.png", imgSize, imgSize, true, true);
        imgW2 = new Image(path + "froggerUpJump.png", imgSize, imgSize, true, true);
        imgA2 = new Image(path + "froggerLeftJump.png", imgSize, imgSize, true, true);
        imgS2 = new Image(path + "froggerDownJump.png", imgSize, imgSize, true, true);
        imgD2 = new Image(path + "froggerRightJump.png", imgSize, imgSize, true, true);
    }

    /**
     * <strong>Handles keyboard events when the player is pressing the key</strong>
     * <p>
     * This method is used to control frog movement.
     */
    public void pressKey() {
        setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (!noMove) {
                    if (second) {
                        if (event.getCode() == KeyCode.W) {
                            move(0, -movement);
                            changeScore = false;
                            setImage(imgW1);
                        } else if (event.getCode() == KeyCode.A) {
                            move(-movementX, 0);
                            setImage(imgA1);
                        } else if (event.getCode() == KeyCode.S) {
                            move(0, movement);
                            setImage(imgS1);
                        } else if (event.getCode() == KeyCode.D) {
                            move(movementX, 0);
                            setImage(imgD1);
                        }
                        second = false;
                    } else {
                        if (event.getCode() == KeyCode.W) {
                            move(0, -movement);
                            setImage(imgW2);
                        } else if (event.getCode() == KeyCode.A) {
                            move(-movementX, 0);
                            setImage(imgA2);
                        } else if (event.getCode() == KeyCode.S) {
                            move(0, movement);
                            setImage(imgS2);
                        } else if (event.getCode() == KeyCode.D) {
                            move(movementX, 0);
                            setImage(imgD2);
                        }
                    }
                }
            }
        });
    }

    /**
     * <strong>Handles keyboard events when the player is releasing the key</strong>
     * <p>
     * This method is used to control frog movement.
     */
    public void releaseKey() {
        setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (!noMove) {
                    if (event.getCode() == KeyCode.W) {
                        if (getY() < w) {
                            changeScore = true;
                            w = getY();
                            points += 10;
                        }
                        move(0, -movement);
                        setImage(imgW1);
                    } else if (event.getCode() == KeyCode.A) {
                        move(-movementX, 0);
                        setImage(imgA1);
                    } else if (event.getCode() == KeyCode.S) {
                        move(0, movement);
                        setImage(imgS1);
                    } else if (event.getCode() == KeyCode.D) {
                        move(movementX, 0);
                        setImage(imgD1);
                    }
                    second = false;
                }
            }
        });
    }

    /**
     * <strong>Checks whether the frog is dead in this round</strong>
     * 
     * @param now  current time
     */
    public void checkDeath(long now) {
        if (death) {
            noMove = true;
            if ((now) % 11 == 0) {
                froggerD++;
            }

            if (froggerD == 1) {
                setImage(new Image("/org/frogger/image/gameOverEffect/death1.png", imgSize, imgSize, true, true));
            } else if (froggerD == 2) {
                setImage(new Image("/org/frogger/image/gameOverEffect/death2.png", imgSize, imgSize, true, true));
            } else if (froggerD == 3) {
                setImage(new Image("/org/frogger/image/gameOverEffect/death3.png", imgSize, imgSize, true, true));
            } else if (froggerD == 4) {
                death = false;
                tryAgain();
            }
        }
    }

    /**
     * <strong>Handles cases when the frog jumps out of the game window</strong>
     * <p>
     * This method makes a boundary and frog will step back immediately if it is out of boundary.
     */
    public void checkPosition() {
    	if (getY() < 0 || getY() > 735) {
            setX(275);
            setY(679.8 + movement);
        }

        if (getX() < 0) {
            move(movement * 2, 0);
        }

        if (getX() > 600) {
            move(-movement * 2, 0);
        }
    }
    
    /**
     * <strong>Handles cases when frog intersects with other game elements</strong>
     * <ul>
     * <li>The frog will die if it intersects with obstacles.
     * <li>The frog will die if it intersects with zombies.
     * <li>The frog will die if a crocodile is eating or will be static relative to them if it jumps onto a sleeping crocodile.
     * <li>The frog will die if it is sunk or will be static relative to logs if it jumps onto the turtle.
     * <li>The frog will be static relative to logs if it jumps onto the logs.
     * <li>The frog will recover to initial status if it reaches habitat.
     * </ul>
     */
    public void checkIntersection() {
    	if (getIntersectingObjects(Obstacle.class).size() >= 1) {
            death = true;
        } else if (getIntersectingObjects(Zombie.class).size() >= 1) {
        	death = true;
        } else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
            if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
                death = true;
            } else {
                move(getIntersectingObjects(WetTurtle.class).get(0).getSpeed(), 0);
            }
        } else if (getIntersectingObjects(Crocodile.class).size() >= 1) {
        	if (getIntersectingObjects(Crocodile.class).get(0).isEaten()) {
                death = true;
            } else {
                move(getIntersectingObjects(Crocodile.class).get(0).getSpeed(), 0);
            }
        } else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
            move(getIntersectingObjects(Turtle.class).get(0).getSpeed(), 0);
        } else if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
            move(getIntersectingObjects(Log.class).get(0).getSpeed(), 0);
        } else if (getIntersectingObjects(Habitat.class).size() >= 1) {
            if (getIntersectingObjects(Habitat.class).get(0).isActivated()) {
            	move(0, movement*1.5);
            	points -= 10;
            } else {
	            points += 50;
	            changeScore = true;
	            w = 800;
	            getIntersectingObjects(Habitat.class).get(0).setEnd();
	            end++;
	            setX(275);
	            setY(679.8 + movement);
            }
        } else if (getY() < 390) {
            death = true; 
        }
    }
    
    /**
     * <strong>Gets how many lives remaining</strong>
     * 
     * @return life -- the number of lives.
     */
    public int getLife() {
    	return life;
    }
    
    /**
     * <strong>Recovers the frog initial status and position</strong>
     */
    public void tryAgain() {
    	setX(275);
        setY(679.8 + movement);
        life--;
        GameController.setlife(life);
        froggerD = 0;
        setImage(new Image("/org/frogger/image/frog/froggerUp.png", imgSize, imgSize, true, true));
        noMove = false;
        if (points > 50) {
            points -= 50;
            changeScore = true;
        }
    }
}
