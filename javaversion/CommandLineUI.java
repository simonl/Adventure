
import java.util.Scanner;
import java.io.PrintStream;

public class CommandLineUI implements AbstractUI {

	private final PrintStream output = System.out;
	private final Scanner keyboard = new Scanner(System.in);

	private String prompt = ">>> ";

	public CommandLineUI() { }
	public CommandLineUI(String prompt) {
		this.prompt = prompt;
	}


	// Interaction

	public void declare(String... statements) {
		nextline();
		for(String s : statements)
			this.output.println(s);
	}

	public int select(String description, String... options) {
		nextline();
		this.output.println(description + " :");
		for(int i = 0; i < options.length; i++)
			this.output.println("\t" + i + ". " + options[i]);

		int result;
		do {
			showPrompt();
			result = this.keyboard.nextInt();
		} while(result >= options.length);

		return result;
	}

	public boolean query(String question) {
		nextline();
		this.output.println(question + " Y/N");

		showPrompt();
		return this.keyboard.next().charAt(0) == 'Y';
	}

	public String getInput(String description) {
		nextline();
		this.output.println(description);

		showPrompt();
		return this.keyboard.nextLine();
	}

	public String getInput() {
		nextline();

		showPrompt();
		return this.keyboard.nextLine();
	}



	// Settings

	private void nextline() {
		this.output.println();
	}

	private void showPrompt() {
		this.output.print(this.prompt);
	}

}