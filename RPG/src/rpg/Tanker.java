package rpg;

public class Tanker extends PlayerUnit {
	private int hit;
	public static boolean provoke;

	public Tanker(String name, int hp, int mp, int power, int defence, int level, int exp, int potion) {
		super(name, hp, mp, power, defence, level, exp, potion);
	}

	@Override
	public void defaultAttack(Unit monster) {
		this.hit = random.nextInt(this.power);
		
		this.hit = this.hit - monster.getDefence()/5;

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
	
	@Override
	public void defaultAttackBoss(Unit monster) {
		System.out.println(String.format("[%s]의 기본 공격\n", super.getName()));
		this.hit = random.nextInt(this.power);
		
		this.hit = this.hit - monster.getDefence()/5;
		
		if (this.hit == 0) {
			System.err.println("MISS");
			return;
		}
		
		if(monster instanceof BossMob) {
			if(((BossMob) monster).getShield() > 0) {
				int broke = ((BossMob) monster).getShield() - this.hit;
				
				if(broke > 0) {
					((BossMob) monster).setShield(broke);
				} else {
					((BossMob) monster).setShield(0);
					monster.setHp(monster.getHp() - broke);
				}
			} else {
				monster.setHp(monster.getHp() - this.hit);
			}
		}
		
		if(monster.getHp() <= 0) {
			monster.setHp(0);
		}
		
		System.out.println(String.format("[%s]에게 [%d]만큼의 데미지를 입혔다.\n", monster.getName(), this.hit));
	}

	// 탱커 스킬 > 자기가 다 맞기
	@Override
	public void skill(Unit monster) {
		System.out.println(String.format("[%s]의 스킬 [도발]\n", super.getName()));
		this.provoke = true;

		// 한 턴 방어력 증가 + 맞아주기
		if (this.provoke) {
			this.setDefence(this.getDefence() + 30);
			System.out.println(String.format("[%s]의 방어력이 30 올라갔습니다.\n", super.getName()));
			System.out.println(String.format("[현재 방어력] %d", this.getDefence()));
		}

		// 다시 돌려주고
		this.provoke = false;
		// 때리는 건 몬스터 몫이니까 >> static 놓고 미루기
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
