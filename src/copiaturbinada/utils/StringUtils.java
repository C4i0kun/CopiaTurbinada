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
}
