package net.codejava.crypto;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import copiaturbinada.enums.FileExtensions;
import copiaturbinada.enums.InputOptions;
import copiaturbinada.enums.OutputOptions;
import copiaturbinada.input.InputHandler;
import copiaturbinada.output.OutputHandler;

class CryptoUtilsTest {
	static String message;
	static String key;
	static String initialFileName = "TestInput/initialdocument.txt";
	
	@BeforeAll
	static void preparation() {
		message = "Fabio kon, você sabia que os alunos te chamam de Fabio.com por aí? xD"
				+ System.lineSeparator();
		key = "lets test it now";
		
		//Create initialdocument.txt
		OutputHandler.setFileExtension(FileExtensions.GENERAL);
		OutputHandler.setFileName("TestInput/initialdocument.txt");
		OutputHandler.setOutputOption(OutputOptions.FILE);
		OutputHandler.getOutput().output(message);
	}

	@Test
	void test() {
		File inputFile = new File(initialFileName);
        File encryptedFile = new File("TestInput/document.encrypted");
        File decryptedFile = new File("TestInput/document.decrypted");
        
        try {
            CryptoUtils.encrypt(key, inputFile, encryptedFile);
            CryptoUtils.decrypt(key, encryptedFile, decryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        InputHandler.setFileExtension(FileExtensions.GENERAL);
		InputHandler.setFileName("TestInput/document.decrypted");
		InputHandler.setInputOption(InputOptions.FILE);
        
		assertEquals(message, InputHandler.getInput().input());
	}

}
