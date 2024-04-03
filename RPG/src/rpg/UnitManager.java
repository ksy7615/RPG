package rpg;

import java.util.ArrayList;
import java.util.Random;

public class UnitManager {
	private Random random = new Random();
	public ArrayList<PlayerUnit> playerList = new ArrayList<>();
	public ArrayList<MonsterUnit> monsterList = new ArrayList<>();
	private String path = "rpg.";
	private String[] generalMonsters = { "Slime", "Mimic", "Goblin", "Orc" };
	private String[] bossMonsters = { "Cerberus", "Hades" };

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
	}

	public void setGeneralMob(int size) {
		for (int i = 0; i < size; i++) {
			int num = random.nextInt(generalMonsters.length);
			try {
				Class<?> clazz = Class.forName(path + generalMonsters[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();

				MonsterUnit temp = (MonsterUnit) obj;
				monsterList.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setCerberus() {
		try {
			Class<?> clazz = Class.forName(path + bossMonsters[0]);
			Class<?>[] params = new Class<?>[] { int.class };

			Object obj = clazz.getDeclaredConstructor(params).newInstance(1000);

			MonsterUnit temp = (MonsterUnit) obj;
			monsterList.add(temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setHades() {
		try {
			Class<?> clazz = Class.forName(path + bossMonsters[1]);
			Class<?>[] params = new Class<?>[] { int.class };

			Object obj = clazz.getDeclaredConstructor(params).newInstance(5000);

			MonsterUnit temp = (MonsterUnit) obj;
			monsterList.add(temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
