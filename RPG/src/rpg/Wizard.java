package rpg;

public class Wizard extends PlayerUnit {
	private int hit;
	private int energy;

	public Wizard(String name, int hp, int mp, int power, int defence, int level, int exp, int potion) {
		super(name, hp, mp, power, defence, level, exp, potion);
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

		System.out.println(String.format("[%s]의 기본 공격\n", super.getName()));
		System.out.println(String.format("[%s]에게 [%d]만큼의 데미지를 입혔다.\n", monster.getName(), this.hit));
	}

	// 모든 몹들 공격하게 하기 >> 게임에서 for문으로 구현
	@Override
	public void skill(Unit monster) {
		System.out.println(String.format("[%s]의 스킬 [Energy Bolt]\n", super.getName()));
		// 마법사 마법력 > 공격력 스탯의 3배로 잡아서 무조건 유효타 인정
		this.energy = random.nextInt(this.power * 3) + 1;
		
		// (밸런스를 위해..) 몬스터의 방어력 비례 피해량 수정 필요
		monster.setHp(monster.getHp() - this.energy);
		
		if(monster.getHp() <= 0) {
			monster.setHp(0);
		}
		
		this.setMp(this.getMp() - 100);
		
		System.out.println(String.format("[%s]에게 [%d]만큼의 데미지를 입혔다.\n", monster.getName(), this.energy));
		System.out.println(String.format("[%s]의 현재 HP %s\n", monster.getName(), monster));
	}

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
