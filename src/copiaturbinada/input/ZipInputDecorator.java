package copiaturbinada.input;

public class ZipInputDecorator extends InputDecorator {

	public ZipInputDecorator(Input input) {
		super(input);
	}

	@Override
	public String input() {
		System.out.println("Unzip!!");
		return super.input();
	}
}
