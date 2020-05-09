package org.frogger.test;

import static org.junit.Assert.*;
import javafx.embed.swing.JFXPanel;

import org.frogger.gameModel.Log;
import org.junit.Test;


/**
 * <h1>LogTest</h1>
 * <p>
 * This test aims to check validity of object's movement and initialization.
 *
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 5/12/2019
 */
class LogTest {
    private Log log;
    private String path = "file:resource/image/log/logs.png";
    private JFXPanel jfxPanel;

    /**
     * <strong>Checks whether the position of the picture is expected.</strong>
     */
    @Test
    public void testGetXY() {
        log = new Log(path, 30, 200, 400, 1.5);
        double x = log.getX();
        double y = log.getY();
        assertEquals(true, x == 200 && y == 400);
    }

    /**
     * <strong>Checks whether the picture is reset to the expected position when it moves out of boundary</strong>
     */
    @Test
    public void testAct() {
        jfxPanel = new JFXPanel();
        jfxPanel.setMaximumSize(null);
        log = new Log(path, 30, 200, 200, 1.5);
        log.setX(601);
        log.act(0);
        double reset = log.getX();
        assertEquals(-200, reset);
    }

    /**
     * <strong>Checks the direction of movement</strong>
     */
    @Test
    public void testGetLeft() {
        log = new Log(path, 30, 200, 200, 1.5);
        assertEquals(false, log.getLeft());
    }

    /**
     * <strong>Checks the speed of the object</strong>
     */
    @Test
    public void testGetSpeed() {
        jfxPanel = new JFXPanel();
        log = new Log(path, 30, 200, 200, 1.5);
        assertEquals(1.5, log.getSpeed());
    }

    /**
     * <strong>Checks whether the object reaches the expected position after a movement</strong>
     */
    @Test
    public void testMove() {
        log = new Log(path, 30, 200, 200, 1.5);
        log.move(100, -50);
        double x = log.getX();
        double y = log.getY();
        assertEquals(true, x == 300 && y == 150);
    }
}
