package rpg;

public interface BossMob {
	
	public abstract void skill(Unit unit);
	
	public int getShield();

	public void setShield(int shield);
	
}
