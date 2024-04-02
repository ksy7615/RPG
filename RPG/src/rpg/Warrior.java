package rpg;

public class Warrior extends PlayerUnit {
	private int hit;
	private int slash;

	public Warrior(String name, int hp, int mp, int power, int defence, int level, int exp, int potion) {
		super(name, hp, mp, power, defence, level, exp, potion);
	}

	@Override
	public void defaultAttack(Unit monster) {
		System.out.println(String.format("[%s]의 기본 공격\n", super.getName()));
		this.hit = random.nextInt(this.power);

		if (this.hit == 0) {
			System.err.println("MISS");
			return;
		}

		// 몬스터의 방어력 비례 피해량 수정 필요
		monster.setHp(monster.getHp() - this.hit);

		if (monster.getHp() <= 0) {
			monster.setHp(0);
		}
		System.out.println(String.format("[%s]에게 [%d]만큼의 데미지를 입혔다.\n", monster.getName(), this.hit));
	}

	// 용사의 스킬 > 기본 공격의 3배 데미지 & 미스X 유효타 & 몬스터 방어력 무시
	@Override
	public void skill(Unit monster) {
		System.out.println(String.format("[%s]의 스킬 [Slash Blast]\n", super.getName()));
		this.slash = 3 * (random.nextInt(this.power) + 1);

		monster.setHp(monster.getHp() - this.slash);

		if (monster.getHp() <= 0) {
			monster.setHp(0);
		}
		this.setMp(this.getMp() - 20);
		System.out.println(String.format("[%s]에게 [%d]만큼의 데미지를 입혔다.\n", monster.getName(), this.hit));
		System.out.println(String.format("[%s]의 현재 HP %s\n", monster.getName(), monster));
	}

	// 포션 HP, MP 모두 최대로 회복
	@Override
	public void recovery() {
		if (this.getPotion() > 0) {
			setHp(MAX_HP);
			setMp(MAX_MP);
			this.setPotion(this.getPotion() - 1);
			System.out.println(String.format("[%s] %s\n", super.getName(), this));
			System.out.println("완전히 회복되었습니다!\n");
		} else if (this.getPotion() == 0) {
			System.err.println("텅 -\n");
		}
	}

}
