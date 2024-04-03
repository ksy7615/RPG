package rpg;

public class Hades extends MonsterUnit implements BossMob {
	private int shield;

	public Hades(int shield) {
		super("하데스", 10000, 400, 100, 75);
		this.shield = shield;
	}

	@Override
	public void attackPlayer(Unit player) {
		System.out.println(String.format("[%s]의 공격\n", this.getName()));
		int hit = random.nextInt(power) + 20;

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

	// 20% 확률로 스킬을 써서 피1 만들기 >> 플레이어 포션 없으면 죽어야됨
	@Override
	public void skill(Unit player) {
		// 자세한 건 메소드 분리하고 . . 넣기
		System.out.println(String.format("[%s]의 스킬 [죽음의 손길]\n", this.getName()));

		player.setHp(1);
		System.out.println(String.format("[%s]는 시야가 흐릿해진다..", player.getName()));
		
		System.out.println(String.format("[%s]의 현재 HP %s\n", player.getName(), player));
	}

}
