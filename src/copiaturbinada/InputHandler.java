package copiaturbinada;

public abstract class InputHandler {
	private static InputOptions inputOption;
	private static FileExtensions fileExtension;
	
	public static void setInputOption(InputOptions inputOption) {
		InputHandler.inputOption = inputOption;
	}
	
	public static void setFileExtension(FileExtensions fileExtension) {
		InputHandler.fileExtension = fileExtension;
	}
	
	public static Input getInput() {
		switch (inputOption) {
		case FILE:
			//nothing yet
			break;
		case KEYBOARD:
			return new KeyboardInput();
		default:
			break;
		}
		
		return null;
	}

}
