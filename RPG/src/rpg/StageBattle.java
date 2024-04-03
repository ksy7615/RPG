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
	
	@Override
	public boolean update() {
		return false;
	}

}
