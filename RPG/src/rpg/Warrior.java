package rpg;

public class Warrior extends Unit {
	private int hit;
	private int slice;
	
	private int potion;
	private final int MAX_MP;
	private int mp;

	public Warrior(String name, int hp, int power, int defence, int level, int exp, int potion, int mp) {
		super(name, hp, power, defence, level, exp);
		this.potion = potion;
		MAX_MP = mp;
		this.mp = mp;
	}

	@Override
	public void defaultAttack(Unit monster) {
		this.hit = random.nextInt(this.power);
		
		if(this.hit == 0)
			System.err.println("MISS");
		
		monster.setHp(monster.getHp() - this.hit);
		
		if(monster.getHp() <= 0)
			monster.setHp(0);
		
		System.out.println(String.format("[%s]의 기본 공격", super.getName()));
		System.out.println(String.format("[%s]에게 [%d]만큼의 데미지를 입혔다.", monster.getName()));
	}

	@Override
	public void skill(Unit monster) {
		
	}

}
