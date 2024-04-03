package rpg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
	public static Scanner scanner = new Scanner(System.in);
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	public static String nextStage = "";
	
	public Game() {
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
	}
	
	public void run() {
		
	}
}
