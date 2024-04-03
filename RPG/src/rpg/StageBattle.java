package rpg;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle extends Stage {
	private Random random = new Random();
	private ArrayList<PlayerUnit> playerList = new ArrayList<>();
	private ArrayList<MonsterUnit> monsterList = new ArrayList<>();
	private UnitManager unitManager = new UnitManager();

	private int livePlayer;
	private int liveMonster;

	public StageBattle() {
		unitManager.setGeneralMob(4);
		unitManager.setCerberus();
		unitManager.setHades();
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

	private void attackMonster(int index) {
		MonsterUnit monster = monsterList.get(index);

		if (monster.getHp() == 0) {
			return;
		}

		while (true) {
			int idx = random.nextInt(playerList.size());

			if (monster instanceof BossMob) {
				// 보스몹 확률로 스킬 사용하게 하는 메소드 설정이 제대로 안돼있으므로
				// 우선 임의로 넣어둔 상태
				if (playerList.get(idx).getHp() > 0) {
					((BossMob) monster).skill(playerList.get(idx));
					break;
				}
			} else {
				if (playerList.get(idx).getHp() > 0) {
					monster.attackPlayer(playerList.get(idx));
					break;
				}
			}
		}
	}

	private void checkDead() {
		int num = 0;
		for (int i = 0; i < playerList.size(); i++) {
			if (playerList.get(i).getHp() == 0) {
				num += 1;
			}
		}
		this.livePlayer = playerList.size() - num;

		num = 0;
		for (int i = 0; i < monsterList.size(); i++) {
			if (monsterList.get(i).getHp() == 0) {
				num += 1;
				// 임의로 준 경험치 값
				playerList.get(i).setExp(50);

				if (playerList.get(i).getExp() > 100) {
					playerList.get(i).setLevel(playerList.get(i).getLevel() + 1);
					playerList.get(i).setExp(playerList.get(i).getExp() - 100);
				}
			}
		}
		this.liveMonster = monsterList.size() - num;
	}

	@Override
	public boolean update() {
		boolean isRun = true;
		boolean turn = true;
		int playerIndex = 0;
		int monsterIndex = 0;

		while (isRun) {
			if (turn) {
				printState();
				if (playerIndex < playerList.size()) {
					attackPlayer(playerIndex);

					playerIndex += 1;
				} else {
					turn = !turn;
					playerIndex = 0;
				}
			} else {
				if (monsterIndex < monsterList.size()) {
					attackMonster(monsterIndex);

					monsterIndex += 1;
				} else {
					turn = !turn;
					monsterIndex = 0;
				}
			}
			checkDead();
			
			if(livePlayer <= 0 || liveMonster <= 0) {
				break;
			}
		}
		Game.nextStage = "LOBBY";
		return false;
	}

}
