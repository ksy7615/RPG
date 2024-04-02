package rpg;

import java.util.Random;

public abstract class Unit {
	public Random random;
	
	private String name;
	public final int MAX_HP;
	private int hp;
	public int power;
	private int defence;
	private int level;
	private int exp;
	
	// 몬스터 >> 몬스터는 경험치를 가질 수 없으므로 override
	public Unit(String name, int hp, int power, int defence, int level) {
		this.name = name;
		MAX_HP = hp;
		this.hp = hp;
		this.power = power;
		this.defence = defence;
		this.level = level;
		
		random = new Random();
	}
	
	// 플레이어용
	public Unit(String name, int hp, int power, int defence, int level, int exp) {
		this.name = name;
		MAX_HP = hp;
		this.hp = hp;
		this.power = power;
		this.defence = defence;
		this.level = level;
		this.exp = exp;
		
		random = new Random();
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
	
	public int getExp() {
		return this.exp;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public abstract void defaultAttack(Unit unit);
	
	public abstract void skill(Unit unit);
	
	@Override
	public String toString() {
		return String.format("[%d/%d]", this.hp, MAX_HP);
	}
	
}
