package rpg;

public class Wizard extends PlayerUnit {
	private int hit;
	private int energy;

	public Wizard(String name, int hp, int mp, int power, int defence, int level, int exp, int potion) {
		super(name, hp, mp, power, defence, level, exp, potion);
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
