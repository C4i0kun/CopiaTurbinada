package copiaturbinada.input;

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
		String temporaryFileName = StringUtils.takeExtensionAway(InputHandler.getFileName());
		File temporaryFile = new File(temporaryFileName);
		
		try {
			CryptoUtils.decrypt(InputHandler.getKey(), inputFile, temporaryFile);
			InputHandler.setFileName(temporaryFileName);
		} catch (CryptoException e) {
			System.out.println("Error to decrypt " + InputHandler.getFileName());
		}
		
		String input = super.input();
		temporaryFile.delete();
		return input;
	}

}
