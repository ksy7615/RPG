package rpg;

public class Cerberus extends MonsterUnit implements BossMob {
	private int shield;

	public Cerberus(String name, int hp, int power, int defence, int level, int shield) {
		super(name, hp, power, defence, level);
		this.shield = shield;
	}

	@Override
	public void attackPlayer(Unit unit) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void skill(Unit unit) {
		// TODO Auto-generated method stub
		
	}
	
}
