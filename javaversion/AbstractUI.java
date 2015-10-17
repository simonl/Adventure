
public interface AbstractUI {

	public int select(String description, String... options);
	public boolean query(String question);
	public void declare(String... statements);

	public String getInput(String description);
	public String getInput();


}