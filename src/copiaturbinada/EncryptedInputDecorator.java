package copiaturbinada;

public class EncryptedInputDecorator extends InputDecorator {
	public EncryptedInputDecorator(Input input) {
		super(input);
	}
	
	@Override
	public String input() {
		System.out.println("Decrypt!!");
		return super.input();
	}
}
