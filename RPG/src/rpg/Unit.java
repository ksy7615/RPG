package rpg;

public abstract class Unit {
	private String name;
	public final int MAX_HP;
	private int hp;
	private int power;
	private int defence;
	
	public Unit(String name, int hp, int power, int defence) {
		this.name = name;
		MAX_HP = hp;
		this.hp = hp;
		this.power = power;
		this.defence = defence;
	}
	
}
