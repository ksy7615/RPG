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
	public void defaultAttack() {
	}

	@Override
	public void skill() {
		
	}

}
