package rpg;

import java.util.ArrayList;

public class UnitManager {
	private ArrayList<PlayerUnit> playerList = new ArrayList<>();
	private ArrayList<MonsterUnit> monsterList = new ArrayList<>();
	private String path = "rpg";
	private String[] generalMonsters = {"Slime", "Mimic", "Goblin", "Orc"};
	private String[] BossMonsters = {"Cerberus", "Hades"};
	
	public UnitManager() {
		Warrior warrior = new Warrior("전사", 1, 1, 1, 1, 1, 1, 1);
		Tanker tanker = new Tanker("탱커", 1, 1, 1, 1, 1, 1, 1);
		Wizard wizard = new Wizard("마법사", 1, 1, 1, 1, 1, 1, 1);
		Healer healer = new Healer("힐러", 1, 1, 1, 1, 1, 1, 1);
		
		playerList.add(warrior);
		playerList.add(tanker);
		playerList.add(wizard);
		playerList.add(healer);
	}
	
}
