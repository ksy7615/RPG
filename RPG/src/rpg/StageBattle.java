package rpg;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle extends Stage {
	private Random random = new Random();
	private ArrayList<PlayerUnit> playerList = new ArrayList<>();
	private ArrayList<MonsterUnit> monsterList = new ArrayList<>();
	private UnitManager unitManager = new UnitManager();

	public StageBattle() {
		unitManager.setGeneralMob(4);
		playerList = unitManager.playerList;
		monsterList = unitManager.monsterList;
	}

	private void printState() {
		// 나중에 상태창 수정 필요
		System.out.println("=== PLAYER ===");
		for (int i = 0; i < playerList.size(); i++) {
			System.out.println(playerList.get(i));
		}
		System.out.println("=== MONSTER ===");
		for (int i = 0; i < monsterList.size(); i++) {
			System.out.println(monsterList.get(i));
		}
	}

	private void attackPlayer(int index) {
		PlayerUnit player = playerList.get(index);

		if (player.getHp() == 0) {
			return;
		}

		System.out.println(String.format("===[%s]의 차례===", player.getName()));
		System.out.println("=== [1]기본공격 [2]스킬 ===");
		System.out.println(">> 원하는 행동을 선택하십쇼");
		int select = Game.scanner.nextInt();

		if (select == 1)
			while (true) {
				int idx = random.nextInt(monsterList.size());

				if (monsterList.get(idx).getHp() > 0) {
					player.defaultAttack(monsterList.get(idx));
					break;
				}
			}
		else if (select == 2)
			while (true) {
				int idx = random.nextInt(monsterList.size());

				if (monsterList.get(idx).getHp() > 0) {
					player.skill(monsterList.get(idx));
					break;
				}
			}
	}

	@Override
	public boolean update() {
		return false;
	}

}
