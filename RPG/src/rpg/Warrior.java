package rpg;

public class Warrior extends PlayerUnit {
	private int hit;
	private int slice;
	private int potion;

	public Warrior(String name, int hp, int mp, int power, int defence, int level, int exp, int potion) {
		super(name, hp, mp, power, defence, level, exp);
		this.potion = potion;
	}

	@Override
	public void defaultAttack(Unit monster) {
		this.hit = random.nextInt(this.power);

		if (this.hit == 0)
			System.err.println("MISS");

		// 몬스터의 방어력 비례 피해량 수정 필요
		monster.setHp(monster.getHp() - this.hit);

		if (monster.getHp() <= 0) {
			monster.setHp(0);
		}

		System.out.println(String.format("[%s]의 기본 공격", super.getName()));
		System.out.println(String.format("[%s]에게 [%d]만큼의 데미지를 입혔다.", monster.getName()));
	}

	// 용사의 스킬 > 공격력 2배 & 미스X 유효타
	@Override
	public void skill(Unit monster) {
		this.slice = 2 * (random.nextInt(this.power) + 1);
		
	}

	@Override
	public void recovery() {
		// TODO Auto-generated method stub

	}

}
