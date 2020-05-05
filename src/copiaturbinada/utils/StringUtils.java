package copiaturbinada.utils;

public abstract class StringUtils {
	public static String takeExtensionAway(String fileName) {
		int index = fileName.lastIndexOf('.');
		char[] array = new char[index];
		for (int i = 0; i < index; i++) {
			array[i] = fileName.charAt(i);
		}
		return String.copyValueOf(array);
	}
	
	public static String to16Bytes(String entry) {
		char[] array = new char[16];
		
		for (int i = 0; i < entry.length(); i++) {
			if (i >= 16) {
				break;
			}
			
			array[i] = entry.charAt(i);
		}
		
		if (entry.length() < 16) {
			for (int i = entry.length(); i < 16; i++) {
				array[i] = ' ';
			}
		}
		
		return String.copyValueOf(array);
	}
	
	public static String getExtension(String fileName) {
		int index = fileName.indexOf('.');
		
		if (index == -1) {
			return "";
		}
		
		int arraySize = fileName.length() - index;
		char[] array = new char[arraySize];
		
		for (int i = 0; i < arraySize; i++) {
			array[i] = fileName.charAt(index + i);
		}
		
		return String.copyValueOf(array);
	}
}
