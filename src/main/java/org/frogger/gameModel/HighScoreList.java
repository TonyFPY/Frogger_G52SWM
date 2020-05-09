package org.frogger.gameModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <h1>HighScoreList</h1>
 * <p>
 * This class represents a high score list.
 * This class is a {@code HighScoreList} model containing 
 * setters and getters relevant to different parameters.
 * Because {@code HighScoreList} is served as a "database", 
 * it should be designed in Singleton pattern to avoid duplication
 * and influencing the data.
 * <p>
 * In this class, Map structure is used to store name and score, 
 * such as {@code <key = "Tony", Value = "800">}. And some map-related
 * implementations are applied to sort the high score list by value
 * and add new pairs into the list.
 * <p>
 * To permanently store the high scores, a .txt file is used to 
 * document all the information. There are top 10 scores in the list. 
 * When the game starts, the file will be read and visulized on the 
 * game board. When game finishes, if the final score is higher than 
 * one of the score in the list. The lowest score will be removed 
 * from the list and the current score will be added into the list.
 * This process is involved with file-reading/writing implementation
 * and build-in map-sorting algorithm, which ensures the scores 
 * stored in the file are in the descending order.
 * <p>
 * Here, linked hash map is used to store the information which is read from the
 * file, because this data structure will temporally store {@code <key, value>} 
 * pairs in the order that is same as that of reading from the file. 
 * 
 * @author Pinyuan Feng (scypf1)
 * @version 1.0
 * @since 20/11/2019
 */
public class HighScoreList {
	private Map<String, String> scoreMap ; 
	private static String username;
	private static int score;
	private String path = "src/main/resources/org/frogger/HighScoreList/HighScoreList.txt";
	private static HighScoreList single_instance = null; 
	
	/**
	 * <strong>Gets an object with Singleton pattern</strong>
	 * 
	 * @return single_instance -- a instance of HighScoreList class
	 */
	public static HighScoreList getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new HighScoreList(); 
  
        return single_instance; 
    } 
	
	/**
	 * <strong>Builds a linked HashMap to store players' names and scores</strong>
	 */
	public void buildMap() {
		scoreMap = new LinkedHashMap<String, String>();
	}
	
	/**
	 * <strong>Sets player's name obtained from user page</strong>
	 * <p>
	 * This method is set to be set making it easier to obtain name.
	 * 
	 * @param name  a string of player's name
	 */
	public static void setUsername(String name) {
		username = name;
	}
	
	/**
	 * <strong>Sets player's name obtained from game board</strong>
	 * 
	 * This method is set to be set making it easier to obtain score.
	 * 
	 * @param s  the value of final score
	 */
	public static void setScore(int s) {
		score = s;
	}
	
	/**
	 * <strong>Gets player's name</strong>
	 * 
	 * @return username -- player's name
	 */
	public String getName() {
		return username;
	}
	
	/**
	 * <strong>Gets player's score</strong>
	 * 
	 * @return score -- player's score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * <strong>Gets game score list</strong>
	 * 
	 * @return scoreMap -- game high score list
	 */
	public Map<String, String> getScoreMap(){
		return scoreMap;
	}

	/**
	 * <strong>Sorts the high score list by value</strong>
	 * 
	 * @return list -- a sorted list of {@code <name, score>}
	 */
	public List<Entry<String, String>> sortByValue() {
		List<Entry<String, String>> list = new ArrayList<Entry<String, String>>(scoreMap.entrySet());
		
		Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
			@Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2)
            {
                int compare = (Integer.valueOf(o1.getValue())).compareTo(Integer.valueOf(o2.getValue()));
                return -compare;
            }

        });
		
		return list;
	}
	
	/**
	 * <strong>Inserts a new high score in the list</strong>
	 * <p>
	 * This method checks whether the new score is higher than one of the scores in high score list.<br>
	 * If so, it removes the smallest pair and inserts the new pair.
	 * 
	 * @throws Exception  Type Converting Error
	 */
	public void insertMap() throws Exception {
		if(username == null) {
			return;
		}

		int max_num_username = 10;
		if(scoreMap.size() == max_num_username) {
	    	String key = "";
	    	String value = "";
			Iterator<Entry<String, String>> entries = scoreMap.entrySet().iterator();	 
			while (entries.hasNext()) {
			    Entry<String, String> entry = entries.next();
			    if(entries.hasNext() != true) {
			    	key = entry.getKey();
			    	value = entry.getValue(); 
			    }
			}

			if(Integer.valueOf(value) < score) {
				scoreMap.remove(key, value);
				scoreMap.put(username, String.valueOf(score));
			}
		} else {
			scoreMap.put(username, String.valueOf(score));
		}
	}

	/**
	 * <strong>Reads high score list from a .txt file and stores them into a map structure</strong>
	 */
	public void readList() {
		String n_key;
        String s_value;
		try {
			BufferedReader in = new BufferedReader(new FileReader(path)); 
			do {
				n_key = in.readLine();
				if(n_key == null) {
					break;
				}
				s_value = String.valueOf(in.readLine());
				scoreMap.put(n_key, s_value);
			}while(n_key != null);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <strong>Writes a updated high score list to the file</strong>
	 */
	public void writeList() {
		if(username == null) {
			return;
		}
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(path));
			List<Entry<String, String>> list = sortByValue();
	        for (Entry<String, String> e: list) {
	            String n_key = e.getKey();
	            out.write(n_key);
	            out.newLine(); 
	            String s_value = e.getValue();
	            out.write(s_value);
	            out.newLine(); 
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <strong>Modifies the high score list</strong>
	 * <p>
	 * This method integrates buildMap(), readList(), insertMap(), writeList().
	 * 
	 * @throws Exception  File Reading/Writing Error
	 */
	public void modifyList() throws Exception {
		buildMap();
		readList();
		insertMap();
		writeList();
	}

	/**
	 * <strong>Extracts names of high-score player</strong>
	 *   
	 * @return list -- a sorted list of names
	 */
	public String showNameList() {
		String list = "";
		for (Entry<String, String> entry : scoreMap.entrySet()) {
			list += entry.getKey() + "\n";
		}	
		return list;
	}
	
	/**
	 * <strong>Extracts scores of high-score player</strong>
	 * 
	 * @return list -- a sorted list of scores
	 */
	public String showScoreList() {
		String list = "";
		for (Entry<String, String> entry : scoreMap.entrySet()) {
			list += entry.getValue() + "\n";
		}	
		return list;
	}
}
