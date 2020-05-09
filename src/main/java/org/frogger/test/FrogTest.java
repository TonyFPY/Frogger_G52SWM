package org.frogger.test;

import org.frogger.gameModel.Frog;

import org.junit.Test;
import static org.junit.Assert.*;
import javafx.embed.swing.JFXPanel;

/**
 * <h1>FrogTest</h1>
 * <p>
 * This test aims to check validity of object's movement and initialization.
 *
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 5/12/2019
 */
public class FrogTest {
    Frog a;
    String path = "file:resource/image/frogger/froggerUp.png";
    JFXPanel jfxPanel = new JFXPanel();

    /**
     * <strong>Checks whether the frog is stopped</strong>
     */
    @Test
    public void testGetStop() {
        a = new Frog(path);
        assertEquals(false, a.getStop());
    }

    /**
     * <strong>Checks the correctness of points</strong>
     */
    @Test
    public void testGetPoints() {
        a = new Frog(path);
        assertEquals(0, a.getPoints());
    }

    /**
     * <strong>Checks whether the score needs to be changed</strong>
     */
    @Test
    public void testChangeScore() {
        a = new Frog(path);
        assertEquals(false, a.changeScore());
    }

    /**
     * <strong>Checks the validity of image setting</strong>
     */
    @Test
    public void testSetFroggerImage() {
        a = new Frog(path);
        double x = a.getX();
        double y = a.getY();
        assertEquals(false, x == 300 && y == 679.8);
    }

    /**
     * <strong>Checks the correctness of current position</strong>
     */
    @Test
    public void testCheckPosition() {
        a = new Frog(path);
        a.checkPosition();
        assertEquals(false, 679.8 == a.getY());
    }


    /**
     * <strong>Checks the correctness of current HP value</strong>
     */
    @Test
    public void testGetLife() {
        a = new Frog(path);
        assertEquals(5, a.getLife());
    }
}