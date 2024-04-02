package rpg;

public class Warrior extends PlayerUnit {
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
	public void defaultAttack(Unit unit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skill(Unit unit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recovery() {
		// TODO Auto-generated method stub
		
	}

}
