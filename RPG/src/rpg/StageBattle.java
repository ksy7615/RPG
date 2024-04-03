package rpg;

import java.util.ArrayList;

public class StageBattle extends Stage {
	private UnitManager unitManager = new UnitManager();
	private ArrayList<PlayerUnit> playerList = new ArrayList<>();
	private ArrayList<MonsterUnit> monsterList = new ArrayList<>();

	public StageBattle() {
		unitManager.setGeneralMob(4);
		playerList = unitManager.playerList;
		monsterList = unitManager.monsterList;
	}
	
	private void printState() {
		// 나중에 상태창 수정 필요
		System.out.println("=== PLAYER ===");
		for(int i=0; i<playerList.size(); i++) {
			System.out.println(playerList.get(i));
		}
		System.out.println("=== MONSTER ===");
		for(int i=0; i<monsterList.size(); i++) {
			System.out.println(monsterList.get(i));
		}
	}
	
	@Override
	public boolean update() {
		return false;
	}

}
