package rpg;

abstract class PlayerUnit extends Unit {

	public PlayerUnit(String name, int hp, int power, int defence, int level, int exp) {
		super(name, hp, power, defence, level, exp);
	}

	public abstract void defaultAttack(Unit unit);

	public abstract void skill(Unit unit);

}
