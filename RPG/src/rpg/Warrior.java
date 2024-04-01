package rpg;

public class Warrior extends Unit {
	private int potion;

	public Warrior(String name, int hp, int power, int defence, int potion) {
		super(name, hp, power, defence);
		this.potion = potion;
	}

	@Override
	public void defaultAttack() {
		
	}

	@Override
	public void skill() {
		// TODO Auto-generated method stub
		
	}

}
