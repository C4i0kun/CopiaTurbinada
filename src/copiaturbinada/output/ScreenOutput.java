package copiaturbinada.output;

public class ScreenOutput implements Output {

	@Override
	public void output(String input) {
		System.out.print(input);
	}

}
