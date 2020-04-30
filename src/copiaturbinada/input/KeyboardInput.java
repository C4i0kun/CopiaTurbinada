package copiaturbinada.input;

import java.util.Scanner;

public class KeyboardInput implements Input{

	@Override
	public String input() {
		String input;
		
		Scanner keyboard = new Scanner(System.in);
		
		input = keyboard.nextLine();
		
		keyboard.close();
		return input;
	}
}
