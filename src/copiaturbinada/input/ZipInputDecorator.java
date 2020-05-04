//thanks to baeldung.com/java-compress-and-uncompress

package copiaturbinada.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import copiaturbinada.utils.StringUtils;

public class ZipInputDecorator extends InputDecorator {

	public ZipInputDecorator(Input input) {
		super(input);
	}

	@Override
	public String input() {
		String input = "";
		
		byte[] buffer = new byte[2048];
		
		try {
			FileInputStream fIS = new FileInputStream(InputHandler.getFileName());
			ZipInputStream zIS = new ZipInputStream(fIS);
			
			ZipEntry zipEntry = zIS.getNextEntry();
			while (zipEntry != null) {
				File newFile = new File(zipEntry.getName());
				FileOutputStream fOS = new FileOutputStream(newFile);
				int size;
				while ((size = zIS.read(buffer)) > 0) {
					fOS.write(buffer, 0, size);
				}
				
				InputHandler.setFileName(zipEntry.getName());
				input += super.input();
				
				newFile.delete();
				
				fOS.close();
				zipEntry = zIS.getNextEntry();
			}
			zIS.closeEntry();
			zIS.close();
		} catch (IOException e) {
			if (e instanceof FileNotFoundException) {
				System.out.println("ERROR: The file " + InputHandler.getFileName() + " wasn't found!");
			} else {
				System.out.println("ERROR: Couldn't unzip file " + InputHandler.getFileName());
			}
		}
		
		return input;
	}
}
