package rpg;

abstract class PlayerUnit extends Unit {

	public PlayerUnit(String name, int hp, int mp, int power, int defence, int level, int exp, int potion) {
		super(name, hp, mp, power, defence, level, exp, potion);
	}

	public abstract void defaultAttack(Unit unit);

	public abstract void skill(Unit unit);
	
	public abstract void recovery();
}
