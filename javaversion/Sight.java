
public class Sight {

	private int level = 0;

	public String inspectStats(Enemy enemy) {
		String description = "Enemy Stats :\n";
		if(level >= 0) {
			description += formatLine(enemy.getHealth());
			if(level >= 1) {
				description += formatLine(enemy.getDamage());
				if(level >= 2) {
					description += formatLine(enemy.geXp());
				}
			}
		} else {
			description += formatLine("???");
		}

		return description;
	}

	public static String formatLine(String line) {
		return "\t" + line + "\n";
	}

	public String toString() {
		return "A sight of level " + this.level;
	}

}