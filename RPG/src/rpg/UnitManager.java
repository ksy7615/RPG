package rpg;

import java.util.ArrayList;

public class UnitManager {
	private ArrayList<PlayerUnit> playerList = new ArrayList<>();
	private ArrayList<MonsterUnit> monsterList = new ArrayList<>();

	public UnitManager() {
		// 1.체력 2.마나 3.공격력 4.방어력 5.레벨 6.경험치 7.포션
		Warrior warrior = new Warrior("전사", 700, 300, 100, 50, 1, 0, 3);
		Tanker tanker = new Tanker("탱커", 800, 200, 30, 80, 1, 0, 3);
		Wizard wizard = new Wizard("마법사", 500, 500, 50, 30, 1, 0, 3);
		Healer healer = new Healer("힐러", 500, 500, 30, 30, 1, 0, 3);
		
		playerList.add(warrior);
		playerList.add(tanker);
		playerList.add(wizard);
		playerList.add(healer);
		
		// 1.체력 2.공격력 3.방어력 4.레벨 (+5. 쉴드)
		Slime slime = new Slime("슬라임", 300, 30, 5, 1);
		Mimic mimic = new Mimic("미믹", 400, 45, 10, 1);
		Goblin goblin = new Goblin("고블린", 800, 60, 20, 1);
		Orc orc = new Orc("오크", 1000, 70, 30, 1);
		Cerberus cerberus = new Cerberus("케르베로스", 7000, 200, 50, 50, 1000);
		Hades hades = new Hades("하데스", 10000, 400, 100, 75, 5000);
		
		monsterList.add(slime);
		monsterList.add(mimic);
		monsterList.add(goblin);
		monsterList.add(orc);
		monsterList.add(cerberus);
		monsterList.add(hades);
	}
	
}
