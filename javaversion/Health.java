public class Health {

	private int maximum;
	private int current;

	public Health(int maximum) {
		this.maximum = maximum;
		this.current = maximum;
	}

	public String toString() {
		return this.current + "/" + this.maximum + " HP";
	}

	public int getMaximum() {
		return this.maximum;
	}

	public int getCurrent() {
		return this.current;
	}

	public void alterMaximum(final int amount) {
		this.maximum += amount;
	}

	public void alterCurrent(final int amount) {
		this.current += amount;
	}

	public void fullHeal() {
		this.current = this.maximum;
	}

	public boolean isDead() {
		return this.current <= 0;
	}

	public boolean isFull() {
		return this.maximum == this.current;
	}

}