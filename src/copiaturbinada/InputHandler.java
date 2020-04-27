package copiaturbinada;

public abstract class InputHandler {
	private static InputOptions inputOption;
	private static FileExtensions fileExtension;
	
	private static String fileName;
	
	public static String getFileName() {
		return fileName;
	}
	
	public static void setFileName(String fileName) {
		InputHandler.fileName = fileName;
	}

	public static void setInputOption(InputOptions inputOption) {
		InputHandler.inputOption = inputOption;
	}
	
	public static void setFileExtension(FileExtensions fileExtension) {
		InputHandler.fileExtension = fileExtension;
	}
	
	public static Input getInput() {
		switch (inputOption) {
		case FILE:
			switch (fileExtension) {
			case TXT:
				return new TXTInput();
			case CRIPT:
				break;
			case ZIP:
				break;
			case ZIP_CRIPT:
				break;
			default:
				break;
			}
		case KEYBOARD:
			return new KeyboardInput();
		default:
			break;
		}
		
		return null;
	}

}
