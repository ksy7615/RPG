package rpg;

abstract class MosterUnit extends Unit {

	public MosterUnit(String name, int hp, int power, int defence, int level) {
		super(name, hp, power, defence, level);
	}
	
	public abstract void defaultAttack(Unit unit);

	public abstract void skill(Unit unit);	
}
