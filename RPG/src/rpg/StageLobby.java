package rpg;

public class StageLobby extends Stage {

	@Override
	public boolean update() {
		System.out.println();
		System.out.println("          𝓛𝓞𝓑𝓑𝓨          ");
		System.out.println("╔══════════════════════╗");
	    System.out.println("║ [1] 전투       [2] 종료 ║");
	    System.out.println("╚══════════════════════╝");
		
		int select = Game.scanner.nextInt();
		
		if(select == 1) {
			Game.nextStage = "BATTLE";
		} else if(select == 2) {
			Game.nextStage = "";
		} else {
			Game.nextStage = "";
		}
		
		return false;
	}

}
