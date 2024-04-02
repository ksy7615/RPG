package rpg;

public class Warrior extends PlayerUnit {
	private int hit;
	private int slice;

	private int potion;
	private final int MAX_MP;
	private int mp;

	public Warrior(String name, int hp, int mp, int power, int defence, int level, int exp, int potion) {
		super(name, hp, power, defence, level, exp);
		MAX_MP = mp;
		this.mp = mp;
		this.potion = potion;
	}

	@Override
	public void defaultAttack(Unit monster) {
		this.hit = random.nextInt(this.power);

		if (this.hit == 0)
			System.err.println("MISS");

		monster.setHp(monster.getHp() - this.hit);

		if (monster.getHp() <= 0) {
			monster.setHp(0);
		}

		System.out.println(String.format("[%s]의 기본 공격", super.getName()));
		System.out.println(String.format("[%s]에게 [%d]만큼의 데미지를 입혔다.", monster.getName()));
	}

	@Override
	public void skill(Unit monster) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recovery() {
		// TODO Auto-generated method stub

	}

}
