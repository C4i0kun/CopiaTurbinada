package copiaturbinada.output;

public class ScreenOutput implements Output {

	@Override
	public void output(String input) {
		System.out.println("SCREEN OUTPUT:");
		System.out.println("----------------------");
		System.out.print(input);
		System.out.println("----------------------");
	}

}
