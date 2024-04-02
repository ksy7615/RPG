package rpg;

public class Healer extends PlayerUnit {
	private int hit;
	private int pray;
	private int potion;

	public Healer(String name, int hp, int mp, int power, int defence, int level, int exp, int potion) {
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

		System.out.println(String.format("[%s]의 기본 공격\n", super.getName()));
		System.out.println(String.format("[%s]에게 [%d]만큼의 데미지를 입혔다.\n", monster.getName(), this.hit));
	}

	// 힐러 스킬 다른 파티 플레이어들 모두 피 회복 해주기
	@Override
	public void skill(Unit monster) {
		
	}

	@Override
	public void recovery() {
		// TODO Auto-generated method stub
		
	}
	
	

}
