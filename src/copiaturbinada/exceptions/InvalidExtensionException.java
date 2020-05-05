package copiaturbinada.exceptions;

import java.io.IOException;

import copiaturbinada.enums.FileExtensions;

public class InvalidExtensionException extends IOException {
	private static final long serialVersionUID = 1L;

	private String fileName;
	private FileExtensions fileExtension;
	private boolean exit;
	
	public InvalidExtensionException(String fileName, FileExtensions fileExtension, boolean exit) {
		this.fileName = fileName;
		this.fileExtension = fileExtension;
		this.exit = exit;
	}
	
	public void showMessage() {
		switch(fileExtension) {
		case ZIP:
			System.out.println("ERROR: The file " + fileName + " is not a '.zip' file");
			break;
		case CRIPT:
			System.out.println("ERROR: The file " + fileName + " is not a '.cript' file");
			break;
		case ZIP_CRIPT:
			System.out.println("ERROR: The file " + fileName + " is not a '.zip.cript' file");
			break;
		default:
			System.out.println("ERROR: Invalid file " + fileName + " extension!");
			break;
		}
		
		if (exit == true) {
			System.exit(0);
		}
	}
}
