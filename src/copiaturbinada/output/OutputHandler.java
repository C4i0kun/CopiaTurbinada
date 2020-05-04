package copiaturbinada.output;

import copiaturbinada.enums.FileExtensions;
import copiaturbinada.enums.OutputOptions;

public abstract class OutputHandler {
	private static OutputOptions outputOption;
	private static FileExtensions fileExtension;
	private static String key;
	private static String fileName;
	
	public static String getFileName() {
		return fileName;
	}
	
	public static String getKey() {
		return key;
	}
	
	public static FileExtensions getFileExtension() {
		return fileExtension;
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
	
	public static void setKey(String key) {
		OutputHandler.key = key;
	}
	
	public static Output getOutput() {
		switch (outputOption) {
		case FILE:
			switch (fileExtension) {
			case GENERAL:
				return new FileOutput();
			case CRIPT:
				return new EncryptedOutputDecorator(new FileOutput());
			case ZIP:
				return new ZipOutputDecorator(new FileOutput());
			case ZIP_CRIPT:
				return new EncryptedOutputDecorator(new ZipOutputDecorator(new FileOutput()));
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
