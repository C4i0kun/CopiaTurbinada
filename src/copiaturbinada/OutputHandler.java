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

	public static void setOutputOption(OutputOptions outputOption) {
		OutputHandler.outputOption = outputOption;
	}
	
	public static void setFileExtension(FileExtensions fileExtension) {
		OutputHandler.fileExtension = fileExtension;
	}
	
	public static Output getOutput() {
		switch (outputOption) {
		case FILE:
			switch (fileExtension) {
			case GENERAL:
				return new FileOutput();
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
			return new ScreenOutput();
		default:
			break;
		}
		
		return null;
	}
}
