/**
 * @file ArgumentsHandler.java
 * 
 * @author Caio Souza <caio326@usp.br>
 * 
 * @date 04/2020
 */

package copiaturbinada.main;

import copiaturbinada.enums.FileExtensions;
import copiaturbinada.enums.InputOptions;
import copiaturbinada.enums.OutputOptions;
import copiaturbinada.exceptions.InvalidArgumentException;
import copiaturbinada.input.InputHandler;
import copiaturbinada.output.OutputHandler;

/**
 * @brief Class responsible for handling entry arguments
 */
abstract class ArgumentsHandler {
	private static boolean exitOnError;
	
	private static int argumentIndex = 0;
	
	public static void Handle(String[] args, boolean exitOnError) {
		ArgumentsHandler.exitOnError = exitOnError;
		
		try {
			if (args[argumentIndex].contentEquals("-origem")) {
				HandleInput(args);
				argumentIndex++;
				HandleOutput(args);
			} else if (args[argumentIndex].contentEquals("-destino")) {
				HandleOutput(args);
				argumentIndex++;
				HandleInput(args);
			} else {
				throw new InvalidArgumentException(args[argumentIndex], exitOnError);
			}
		} catch (InvalidArgumentException e) {
			e.showMessage();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Not enough arguments!");
			
			if (exitOnError) {
				System.exit(0);
			}
		}
	}
	
	private static void HandleInput(String[] args) throws InvalidArgumentException {
		argumentIndex++;
		if (args[argumentIndex].contentEquals("-arquivo")) {
			fileHandler(args, true);
		} else if (args[argumentIndex].contentEquals("-teclado")) {
			InputHandler.setInputOption(InputOptions.KEYBOARD);
		} else {
			throw new InvalidArgumentException(args[argumentIndex], exitOnError);
		}
	}
	
	private static void HandleOutput(String[] args) throws InvalidArgumentException {
		argumentIndex++;
		if (args[argumentIndex].contentEquals("-arquivo")) {
			fileHandler(args, false);
		} else if (args[argumentIndex].contentEquals("-tela")) {
			OutputHandler.setOutputOption(OutputOptions.SCREEN);
		} else {
			throw new InvalidArgumentException(args[argumentIndex], exitOnError);
		}
	}
	
	private static void fileHandler(String[] args, boolean input) throws InvalidArgumentException {
		argumentIndex++;
		
		FileExtensions fileExtension = FileExtensions.GENERAL;
		
		if (args[argumentIndex].contentEquals("-comprimido")) {
			//SINALIZA QUE O ARQUIVO É COMPRIMIDO
			fileExtension = FileExtensions.ZIP;
			argumentIndex++;
			if (args[argumentIndex].contentEquals("-criptografado")) {
				//SINALIZA QUE É CRIPTOGRAFADO
				fileExtension = FileExtensions.ZIP_CRIPT;
				encryptedInput(args, input);
			}
		} else if (args[argumentIndex].contentEquals("-criptografado")) {
			//SINALIZA QUE É CRIPTOGRAFADO
			fileExtension = FileExtensions.CRIPT;
			encryptedInput(args, input);
		}
		
		if (input) {
			InputHandler.setInputOption(InputOptions.FILE);
			InputHandler.setFileName("../" + args[argumentIndex]);
			InputHandler.setFileExtension(fileExtension);
		} else {
			OutputHandler.setOutputOption(OutputOptions.FILE);
			OutputHandler.setFileName("../" + args[argumentIndex]);
			OutputHandler.setFileExtension(fileExtension);
		}
	}
	
	private static void encryptedInput(String[] args, boolean input) throws InvalidArgumentException {
		argumentIndex++;
		if (args[argumentIndex].contentEquals("-senha")) {
			argumentIndex++;
			if (input) {
				InputHandler.setKey(args[argumentIndex]);
			} else {
				OutputHandler.setKey(args[argumentIndex]);
			}
			argumentIndex++;
		} else {
			throw new InvalidArgumentException(args[argumentIndex], exitOnError);
		}
	}
	
}
