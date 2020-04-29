package copiaturbinada;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements Output {

	@Override
	public void output(String input) {
		try {
			File file = new File(OutputHandler.getFileName());
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(input);
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("ERROR: Couldn't write file " + OutputHandler.getFileName());
		}

	}

}
