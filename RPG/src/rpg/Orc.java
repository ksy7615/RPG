package rpg;

public class Orc extends MonsterUnit {
	private int hit;

	public Orc() {
		super("오크", 1000, 70, 30, 1);
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
