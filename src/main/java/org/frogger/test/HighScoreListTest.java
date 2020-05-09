package org.frogger.test;

import static org.junit.Assert.*;
import java.util.LinkedHashMap;
import java.util.Map;

import org.frogger.gameModel.HighScoreList;
import org.junit.Test;

/**
 * <h1>HighScoreListTest</h1>
 * <p>
 * This test aims to check validity of HighScoreList.
 *
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 5/12/2019
 */
class HighScoreListTest {
    private HighScoreList h;
    private Map<String, String> scoreMap;

    /**
     * <strong>Checks whether Singleton Design Pattern is applied to avoid duplicated "database"</strong>
     */
    @Test
    public void testGetInstance() {
        HighScoreList a = HighScoreList.getInstance();
        HighScoreList b = HighScoreList.getInstance();
        assertEquals(true, a == b);
    }

    /**
     * <strong>Checks the user input</strong>
     */
    @Test
    public void testGetUsername() {
        h = HighScoreList.getInstance();
        HighScoreList.setUsername("Tony");
        assertEquals("Tony", h.getName());
    }

    /**
     * <strong>Checks the user input</strong>
     */
    @Test
    public void testGetScore() {
        h = HighScoreList.getInstance();
        HighScoreList.setScore(100);
        assertEquals(100, h.getScore());
    }

    /**
     * <strong>Checks the validity of running a high score board</strong>
     * <p>
     * This test will integrate the tests of {@code readList()}, {@code writeList()}, {@code insertMap()}.
     * The three methods mentioned above are implemented through calling {@code modifyList()}.
     *
     * @throws Exception  File Reading/Writing Error
     */
    @Test
    public void testModifyList() throws Exception {
        h = HighScoreList.getInstance();
        HighScoreList.setUsername("Tony");
        HighScoreList.setScore(100);
        scoreMap = new LinkedHashMap<String, String>();
        scoreMap.put("Iron Man","800");
        scoreMap.put("Captain America", "750");
        scoreMap.put("Captain Marvel","750");
        scoreMap.put("Black Panther","700");
        scoreMap.put("Thor","700");
        scoreMap.put("Vision","700");
        scoreMap.put("Black Widow", "680");
        scoreMap.put("Hulk","650");
        scoreMap.put("Groot","500");
        scoreMap.put("Dr.Strange","450");
        h.modifyList();
        assertEquals(true, h.getScoreMap().equals(scoreMap));
    }
}
