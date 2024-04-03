package rpg;

abstract class MonsterUnit extends Unit {

	public MonsterUnit(String name, int hp, int power, int defence, int level) {
		super(name, hp, power, defence, level);
	}
	
	public abstract void attackPlayer(Unit unit);
	
	@Override
	public String toString() {
		String info = "";
		info += this.getName() + "/" + this.getHp() + "/" + this.power + "/" + this.getDefence() + "/" + this.getLevel();
		
		return info;
	}

}
