package rpg;

public class StageLobby extends Stage {

	@Override
	public boolean update() {
		System.out.println("===== LOBBY =====");
		System.out.println("│[1] 전투  [2] 종료│");
		System.out.println("=================");
		
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
