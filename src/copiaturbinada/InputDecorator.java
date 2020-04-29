package copiaturbinada;

public abstract class InputDecorator implements Input {
	Input input;
	
	public InputDecorator(Input input) {
		this.input = input;
	}

	@Override
	public String input() {
		return input.input();
	}

}
