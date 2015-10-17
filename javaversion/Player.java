
public class Player {

	private Health health = new Health(30);

	private int minHeal = 1;
	private int maxHeal = 7;

	private int minDamage = 0;
	private int maxDamage = 10;

	private int battleXP = 0;
	private int sightXP = 0;

	private int battleLevel = 0;
	private int sightLevel  = 0;

	private int gold = 0;


	private int pet = 0;
	private boolean whistle = false;


	public int attack() {
		return (int)(Math.random() * (maxDamage - minDamage)) + minDamage;
	}

	public void getHit(int hit) {
		this.health.alterCurrent(- hit);
	}



}