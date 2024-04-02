package rpg;

public class Mimic extends MonsterUnit {
	private int hit;

	public Mimic(String name, int hp, int power, int defence, int level) {
		super(name, hp, power, defence, level);
	}

	@Override
	public void defaultAttack(Unit player) {
		// 50% 확률로 괴물일 수도 있지만 보물 상자일 수도 있음
		int probability = random.nextInt(2);

		// 괴물일 땐 공격
		if (probability == 0) {
			System.out.println(String.format("[%s]이다!!!\n", this.getName()));
			System.out.println(String.format("[%s]의 기본 공격\n", this.getName()));
			this.hit = random.nextInt(power) + 1;
			
			// 플레이어 방어력 비례 공격력 설정
			this.hit = this.hit - player.getDefence()/5;
			
			if(this.hit <= 0) {
				this.hit = 0;
				System.out.println("MISS");
			}
			
			player.setHp(player.getHp() - this.hit);

			if (player.getHp() <= 0) {
				player.setHp(0);
			}
			
			System.out.println(String.format("[%s]에게 [%d]만큼의 데미지를 입혔다.\n", player.getName(), this.hit));
		}
		
		// 보물 상자라면 상자를 깐 플레이어에게 포션을 3개 줍니다.
		else {
			System.out.println("[보물상자]다!!!");
			this.setHp(1);
			
			if(this.getHp() < 0)
				this.setHp(0);
			
			player.setPotion(player.getPotion() + 3);
		}
	}

	@Override
	public void skill(Unit unit) {
		
	}

}
