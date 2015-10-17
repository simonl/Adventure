
public interface Fighter {

	public void getHit(int damage);
	public int attack();

	public boolean isDead();

	public void loot(Loot l);
	public Loot reward();

}