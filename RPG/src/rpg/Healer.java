package rpg;

public class Healer extends PlayerUnit {
	private int hit;
	private int pray;

	public Healer(String name, int hp, int mp, int power, int defence, int level, int exp, int potion) {
		super(name, hp, mp, power, defence, level, exp, potion);
	}

	@Override
	public void defaultAttack(Unit monster) {
		System.out.println(String.format("[%s]의 기본 공격\n", this.getName()));
		this.hit = random.nextInt(this.power);

		if (this.hit == 0)
			System.err.println("MISS");

		// 몬스터의 방어력 비례 피해량 수정 필요
		monster.setHp(monster.getHp() - this.hit);

		if (monster.getHp() <= 0) {
			monster.setHp(0);
		}
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

	// 다른 파티 플레이어 피 100씩 회복 해주기
	@Override
	public void skill(Unit player) {
		System.out.println(String.format("[%s]의 스킬 [Pray]\n", this.getName()));
		this.pray = 100;

		player.setHp(player.getHp() + this.pray);
		this.setMp(this.getMp() - 50);

		System.out.println(String.format("[%s]가 기도를 올려 모두를 [%d]만큼 회복 시켰습니다!\n", this.getName(), this.pray));
	}

	@Override
	public void recovery() {
		if (this.getPotion() > 0) {
			setHp(MAX_HP);
			setMp(MAX_MP);
			this.setPotion(this.getPotion() - 1);
			System.out.println(String.format("[%s] %s\n", this.getName(), this));
			System.out.println("완전히 회복되었습니다!\n");
		} else if (this.getPotion() == 0) {
			System.err.println("텅 -\n");
		}
	}

}
