package rpg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
	public static Scanner scanner = new Scanner(System.in);
	Map<String, Stage> stageList = new HashMap<String, Stage>();
	public static String nextStage = "";
	private String curStage = "";

	public Game() {
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());

		nextStage = "LOBBY";
	}

	private boolean changeStage() {
		if (curStage.equals(nextStage)) {
			return true;
		}

		curStage = nextStage;
		Stage stage = stageList.get(curStage);

		boolean isRun = true;
		while (true) {
			isRun = stage.update();
			if (!isRun)
				break;
		}

		if (nextStage.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public void run() {
		System.out.println("╔══════════════════════╗");
		System.out.println("║⚔️✨🛡️ 𝓡𝓟𝓖 𝓖𝓐𝓜𝓔  ⚔️✨🛡️║");
		System.out.println("╚══════════════════════╝");
		while (true) {
			changeStage();
		}
	}
}
