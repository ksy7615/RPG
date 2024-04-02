package rpg;

abstract class MonsterUnit extends Unit {

	public MonsterUnit(String name, int hp, int power, int defence, int level) {
		super(name, hp, power, defence, level);
	}
	
	public abstract void attackPlayer(Unit unit);

}
