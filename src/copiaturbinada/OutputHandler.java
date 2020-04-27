package copiaturbinada;

public abstract class OutputHandler {
	private static OutputOptions outputOption;
	private static FileExtensions fileExtension;
	
	private static String fileName;
	
	public static String getFileName() {
		return fileName;
	}
	
	public static void setFileName(String fileName) {
		OutputHandler.fileName = fileName;
	}

	public static void setOUtputOption(InputOptions outputOption) {
		OutputHandler.outputOption = outputOption;
	}
	
	public static void setFileExtension(FileExtensions fileExtension) {

	}
	
	public static Output getOutput() {
		switch (outputOption) {
		case FILE:
			switch (fileExtension) {
			case TXT:
				break;
			case CRIPT:
				break;
			case ZIP:
				break;
			case ZIP_CRIPT:
				break;
			default:
				break;
			}
		case SCREEN:
			return new KeyboardInput();
		default:
			break;
		}
		
		return null;
	}
}
