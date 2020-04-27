package copiaturbinada;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class TXTInput implements Input{

	@Override
	public String input() {
		String input = "";
		
		try {
			File file = new File(InputHandler.getFileName());
			Scanner reader = new Scanner(file);
			
			while (reader.hasNextLine()) {
				input += reader.nextLine() + System.lineSeparator();
			}
			
			reader.close();
			return input;
		} catch (IOException e) {
			if (e instanceof FileNotFoundException) {
				input = "ERROR: Input File " + InputHandler.getFileName() + " not found!"; 
				System.out.println(input);
				return input;
			} else {
				input = "ERROR: Couldn't read file " + InputHandler.getFileName(); 
				System.out.println(input);
				return input;
			}
		}
	}

}
