package copiaturbinada.output;

import java.io.File;

import copiaturbinada.utils.StringUtils;
import net.codejava.crypto.CryptoException;
import net.codejava.crypto.CryptoUtils;

public class EncryptedOutputDecorator extends OutputDecorator {

	public EncryptedOutputDecorator(Output output) {
		super(output);
	}

	@Override
	public void output(String input) {
		String oldFileName = OutputHandler.getFileName();
		String newFileName = StringUtils.takeExtensionAway(OutputHandler.getFileName());
		OutputHandler.setFileName(newFileName);
		
		super.output(input);
		
		OutputHandler.setFileName(oldFileName);
		File temporaryFile = new File(newFileName);
		File outputFile = new File(OutputHandler.getFileName());
		
		try {
			CryptoUtils.encrypt(OutputHandler.getKey(), temporaryFile, outputFile);
		} catch (CryptoException e) {
			System.out.println("Error to encrypt " + OutputHandler.getFileName());
		}
		
		temporaryFile.delete();
	}
}
