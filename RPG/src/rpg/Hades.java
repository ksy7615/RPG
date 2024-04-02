package rpg;

public class Hades extends MonsterUnit implements BossMob {

	public Hades(String name, int hp, int power, int defence, int level) {
		super(name, hp, power, defence, level);
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

	@Override
	public void skill(Unit unit) {

	}

}
