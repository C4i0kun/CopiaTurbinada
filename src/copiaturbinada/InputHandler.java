package copiaturbinada;

public abstract class InputHandler {
	private static InputOptions inputOption;
	private static FileExtensions fileExtension;
	private static String key;
	
	private static String fileName;
	
	public static String getFileName() {
		return fileName;
	}

	public static String getKey() {
		return key;
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
	
	public static void setKey(String key) {
		InputHandler.key = key;
	}
	
	public static Input getInput() {
		switch (inputOption) {
		case FILE:
			switch (fileExtension) {
			case GENERAL:
				return new FileInput();
			case CRIPT:
				return new EncryptedInputDecorator(new FileInput());
			case ZIP:
				return new ZipInputDecorator(new FileInput());
			case ZIP_CRIPT:
				return new EncryptedInputDecorator(new ZipInputDecorator(new FileInput()));
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
