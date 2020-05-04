//thanks to baeldung.com/java-compress-and-uncompress

package copiaturbinada.output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import copiaturbinada.enums.FileExtensions;
import copiaturbinada.utils.StringUtils;

public class ZipOutputDecorator extends OutputDecorator {

	public ZipOutputDecorator(Output output) {
		super(output);
	}
	
	@Override
	public void output(String input) {
		String originalOutputName = OutputHandler.getFileName();
		String temporaryFileName = temporaryFileName() + ".compressed";
		OutputHandler.setFileName(temporaryFileName);
		
		super.output(input);
		
		OutputHandler.setFileName(originalOutputName);
		
		try {
			FileOutputStream fOS = new FileOutputStream(OutputHandler.getFileName());
			ZipOutputStream zipOS = new ZipOutputStream(fOS);
			
			File fileToZip = new File(temporaryFileName);
			FileInputStream fIS = new FileInputStream(fileToZip);
			
			ZipEntry zipEntry = new ZipEntry(temporaryFileName);
			zipOS.putNextEntry(zipEntry);
			
			byte[] bytes = new byte[2048];
			int size;
			while((size = fIS.read(bytes)) >= 0) {
				zipOS.write(bytes, 0, size);
			}
			
			fileToZip.delete();
			
			zipOS.close();
			fIS.close();
			fOS.close();
		} catch (IOException e) {
			if (e instanceof FileNotFoundException) {
				System.out.println("ERROR: Temporary file to zip output wasn't found");
			} else {
				System.out.println("ERROR: Couldn't zip output");
			}
		}
		
		if (OutputHandler.getFileExtension() == FileExtensions.ZIP_CRIPT) {
			OutputHandler.setFileName(originalOutputName);
		}
		
	}
	
	private String temporaryFileName() {
		String temporaryFileName = OutputHandler.getFileName();
		temporaryFileName = StringUtils.takeExtensionAway(temporaryFileName);
		
		return temporaryFileName;
	}
}
