package copiaturbinada;

import java.io.File;

import copiaturbinada.utils.StringUtils;
import net.codejava.crypto.CryptoException;
import net.codejava.crypto.CryptoUtils;

public class EncryptedInputDecorator extends InputDecorator {
	public EncryptedInputDecorator(Input input) {
		super(input);
	}
	
	@Override
	public String input() {
		File inputFile = new File(InputHandler.getFileName());
		String outputFileName = StringUtils.takeExtensionAway(InputHandler.getFileName());
		File outputFile = new File(outputFileName);
		try {
			CryptoUtils.decrypt(InputHandler.getKey(), inputFile, outputFile);
			InputHandler.setFileName(outputFileName);
		} catch (CryptoException e) {
			System.out.println("Error to decrypt " + InputHandler.getFileName());
		}		
		return super.input();
	}

}
