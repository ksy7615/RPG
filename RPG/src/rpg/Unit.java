package rpg;

import java.util.Random;

public abstract class Unit {
	public Random random;
	
	private String name;
	public final int MAX_HP;
	private int hp;
	public final int MAX_MP;
	private int mp;
	public int power;
	private int defence;
	private int level;
	private int exp;
	private int potion;
	
	// 몬스터 >> 몬스터는 경험치를 가질 수 없고 마나 없이 확률로 스킬 사용(override)
	public Unit(String name, int hp, int power, int defence, int level) {
		this.name = name;
		MAX_HP = hp;
		this.hp = hp;
		MAX_MP = 0;
		this.power = power;
		this.defence = defence;
		this.level = level;
		
		random = new Random();
	}

	// 플레이어용
	public Unit(String name, int hp, int mp, int power, int defence, int level, int exp, int potion) {
		this.name = name;
		MAX_HP = hp;
		this.hp = hp;
		MAX_MP = mp;
		this.mp = mp;
		this.power = power;
		this.defence = defence;
		this.level = level;
		this.exp = exp;
		this.potion = potion;
		
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
	
	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
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
	
	public int getPotion() {
		return potion;
	}

	public void setPotion(int potion) {
		this.potion = potion;
	}
	
}
