package rpg;

public abstract class Unit {
	private String name;
	public final int MAX_HP;
	private int hp;
	private int power;
	private int defence;
	private int level;
	
	public Unit(String name, int hp, int power, int defence, int level) {
		this.name = name;
		MAX_HP = hp;
		this.hp = hp;
		this.power = power;
		this.defence = defence;
		this.level = level;
	}

	public int getMAX_HP() {
		return this.MAX_HP;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getName() {
		return this.name;
	}

	public int getPower() {
		return this.power;
	}
	
	public void setPower(int power) {
		this.power = power;
	}

	public int getDefence() {
		return this.defence;
	}
	
	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public abstract void defaultAttack();
	
	public abstract void skill();
	
}
