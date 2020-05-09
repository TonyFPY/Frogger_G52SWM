package org.frogger.test;

import org.frogger.gameModel.Crocodile;

import static org.junit.Assert.*;
import javafx.embed.swing.JFXPanel;
import org.junit.Test;

/**
 * <h1>CrocodileTest</h1>
 * <p>
 * This test aims to check validity of object's movement and initialization.
 *
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 5/12/2019
 */
class CrocodileTest {
    private Crocodile c;
    JFXPanel jfxPanel;

    /**
     * <strong>Checks whether the picture is reset to the expected position when it moves out of boundary</strong>
     */
    @Test
    public void testAct() {
        jfxPanel = new JFXPanel();
        c = new Crocodile(300, 300, 1, 30, 30);
        c.setX(601);
        c.act(0);
        double  reset = c.getX();
        assertEquals(-200, reset);
    }

    /**
     * <strong>Checks the object's status</strong>
     */
    @Test
    public void testIsEaten() {
        c = new Crocodile(300, 300, 1, 30, 30);
        c.act(900000000);
        assertEquals(true, c.isEaten());
    }

    /**
     * <strong>Checks the speed of the object</strong>
     */
    @Test
    public void testGetSpeed() {
        jfxPanel = new JFXPanel();
        c = new Crocodile(300, 300, 1, 30, 30);
        assertEquals(1, c.getSpeed());
    }

}
