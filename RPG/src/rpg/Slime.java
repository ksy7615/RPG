package rpg;

public class Slime extends MonsterUnit {
	private int hit;

	public Slime(String name, int hp, int power, int defence, int level) {
		super(name, hp, power, defence, level);
	}

	@Override
	public void attackPlayer(Unit player) {
		System.out.println(String.format("[%s]의 공격\n", this.getName()));
		this.hit = random.nextInt(power) + 1;
		
		this.hit = this.hit - player.getDefence()/5;
		
		if(this.hit <= 0) {
			this.hit = 0;
			System.out.println("MISS");
		}
		
		player.setHp(player.getHp() - this.hit);

		if (player.getHp() <= 0) {
			player.setHp(0);
		}
		
		System.out.println(String.format("[%s]에게 [%d]만큼의 데미지를 입혔다.\n", player.getName(), this.hit));
	}
	
}
