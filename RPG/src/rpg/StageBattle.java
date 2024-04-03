package rpg;

import java.util.ArrayList;

public class StageBattle extends Stage {
	private UnitManager unitManager = new UnitManager();
	private ArrayList<PlayerUnit> playerList = new ArrayList<>();
	private ArrayList<MonsterUnit> monsterList = new ArrayList<>();

	@Override
	public boolean update() {
		return false;
	}

}
