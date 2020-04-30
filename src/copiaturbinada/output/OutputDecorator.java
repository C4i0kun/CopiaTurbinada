package copiaturbinada.output;

public abstract class OutputDecorator implements Output {
	Output output;
	
	public OutputDecorator(Output output) {
		this.output = output;
	}
	
	@Override
	public void output(String input) {
		output.output(input);
	}
}
