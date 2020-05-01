package copiaturbinada.input;

import java.util.Scanner;

public class KeyboardInput implements Input{

	@Override
	public String input() {
		String input = "";
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Write what you want to copy below "
				+ "(After writing, create a new line with _@end_ written, to end input)");
		System.out.println("KEYBOARD INPUT:");
		System.out.println("----------------------");
		
		while (true) {
			String nextLine = keyboard.nextLine();
			if (nextLine.contentEquals("_@end_")) {
				break;
			}
			input += nextLine + System.lineSeparator();
		}
		
		System.out.println("----------------------");
		keyboard.close();
		return input;
	}
}
