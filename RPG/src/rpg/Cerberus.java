package rpg;

public class Cerberus extends MonsterUnit implements BossMob {
	private int shield;
	private boolean isBurn;

	public Cerberus(int shield) {
		super("케르베로스", 7000, 200, 50, 50);
		this.shield = shield;
	}

	@Override
	public void attackPlayer(Unit player) {
		System.out.println(String.format("[%s]의 공격\n", this.getName()));
		int hit = random.nextInt(power) + 1;

		hit = hit - player.getDefence() / 5;

		if (hit <= 0) {
			hit = 0;
			System.out.println("MISS");
		}

		player.setHp(player.getHp() - hit);

		if (player.getHp() <= 0) {
			player.setHp(0);
		}

		System.out.println(String.format("[%s]에게 [%d]만큼의 데미지를 입혔다.\n", player.getName(), hit));
	}

	@Override
	public void skill(Unit player) {
		System.out.println(String.format("[%s]의 스킬 [Fire Breath]\n", this.getName()));
		int firePower = random.nextInt(power) + 10;

		firePower = firePower - player.getDefence() / 5;

		// 20% 확률로 케르베로스 스킬에 화상을 입어 지속적인 고통을 받습니다
		int burnChance = random.nextInt(5) + 1;
		if (burnChance == 0) {
			this.isBurn = true;

			while (this.isBurn) {
				player.setHp(player.getHp() - 10);
				// stage turn 만들 때 turn 조절하기
				// 임시로 true 넣어둔 상태
				if (true) {
					this.isBurn = false;
				}
			}
		}
		// 다중 공격되게 for문 나중에 돌리고. .
		player.setHp(player.getHp() - firePower);

		if (player.getHp() <= 0) {
			player.setHp(0);
		}

		System.out.println(String.format("[%s]에게 [%d]만큼의 데미지를 입혔다.\n", player.getName(), firePower));
	}

}
