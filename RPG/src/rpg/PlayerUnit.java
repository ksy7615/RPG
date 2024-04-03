package rpg;

abstract class PlayerUnit extends Unit {

	public PlayerUnit(String name, int hp, int mp, int power, int defence, int level, int exp, int potion) {
		super(name, hp, mp, power, defence, level, exp, potion);
	}

	public abstract void defaultAttack(Unit unit);

	public abstract void defaultAttackBoss(Unit unit);

	public abstract void skill(Unit unit);

	public abstract void recovery();

	public String toString() {
		String info = "";
		info += "╔══════════════════════════════╗\n";
		info += "  직업 : " + this.getName() + "\n";
		info += "  ❤️ HP: " + this.getHp() + " / 💧 MP: " + this.getMp() + "\n";
		info += "  💪 Power: " + this.power + " / 🛡️ Defence: " + this.getDefence() + "\n";
		info += "  🎮 Level: " + this.getLevel() + " / 🌟 Exp: " + this.getExp() + "\n";
		info += "  🍵 Potion: " + this.getPotion() + "\n";
		info += "╚══════════════════════════════╝";

		return info;
	}
}
