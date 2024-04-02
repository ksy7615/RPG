package rpg;

import java.util.ArrayList;

public class UnitManager {
	private ArrayList<PlayerUnit> playerList = new ArrayList<>();
	private ArrayList<MonsterUnit> monsterList = new ArrayList<>();

	public UnitManager() {
		// 1.체력 2.마나 3.공격력 4.방어력 5.레벨 6.경험치 7.포션
		Warrior warrior = new Warrior("전사", 1, 1, 1, 1, 1, 1, 1);
		Tanker tanker = new Tanker("탱커", 1, 1, 1, 1, 1, 1, 1);
		Wizard wizard = new Wizard("마법사", 1, 1, 1, 1, 1, 1, 1);
		Healer healer = new Healer("힐러", 1, 1, 1, 1, 1, 1, 1);
		
		playerList.add(warrior);
		playerList.add(tanker);
		playerList.add(wizard);
		playerList.add(healer);
		
		// 1.체력 2.공격력 3.방어력 4.레벨 (+5. 쉴드)
		Slime slime = new Slime("슬라임", 1, 1, 1, 1);
		Mimic mimic = new Mimic("미믹", 1, 1, 1, 1);
		Goblin goblin = new Goblin("고블린", 1, 1, 1, 1);
		Orc orc = new Orc("오크", 1, 1, 1, 1);
		Cerberus cerberus = new Cerberus("케르베로스", 1, 1, 1, 1, 1);
		Hades hades = new Hades("하데스", 1, 1, 1, 1, 1);
		
		monsterList.add(slime);
		monsterList.add(mimic);
		monsterList.add(goblin);
		monsterList.add(orc);
		monsterList.add(cerberus);
		monsterList.add(hades);
	}
	
}
