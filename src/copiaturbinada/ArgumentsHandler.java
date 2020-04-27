/**
 * @file ArgumentsHandler.java
 * 
 * @author Caio Souza <caio326@usp.br>
 * 
 * @date 04/2020
 */

package copiaturbinada;

/**
 * @brief Class responsible for handling entry arguments
 */
abstract class ArgumentsHandler {
	
	private static int argumentIndex = 0;
	
	public static void Handle(String[] args) {
		try {
			if (args[argumentIndex] == "-origem") {
				HandleInput(args);
				HandleOutput(args);
			} else if (args[argumentIndex] == "-destino") {
				HandleOutput(args);
				HandleInput(args);
			} else {
				throw new InvalidArgumentException(args[argumentIndex], true);
			}
		} catch (InvalidArgumentException e) {
			e.showMessage();
		}
	}
	
	private static void HandleInput(String[] args) throws InvalidArgumentException {
		argumentIndex++;
		if (args[argumentIndex] == "-arquivo") {
			fileHandler(args, true);
		} else if (args[argumentIndex] == "-teclado") {
			//PEGA A ENTRADA DO TECLADO
		} else {
			throw new InvalidArgumentException(args[argumentIndex], true);
		}
	}
	
	private static void HandleOutput(String[] args) throws InvalidArgumentException {
		argumentIndex++;
		if (args[argumentIndex] == "-arquivo") {
			fileHandler(args, false);
		} else if (args[argumentIndex] == "-tela") {
			//IMPRIME A ENTRADA NA TELA
		} else {
			throw new InvalidArgumentException(args[argumentIndex], true);
		}
	}
	
	private static void fileHandler(String[] args, boolean input) throws InvalidArgumentException {
		argumentIndex++;
		if (args[argumentIndex] == "-comprimido") {
			//SINALIZA QUE O ARQUIVO É COMPRIMIDO
			argumentIndex++;
			if (args[argumentIndex] == "-criptografado") {
				//SINALIZA QUE É CRIPTOGRAFADO
				encryptedInput(args);
			}
		} else if (args[argumentIndex] == "-criptografado") {
			//SINALIZA QUE É CRIPTOGRAFADO
			encryptedInput(args);
		}
		
		//PEGA O ARQUIVO
	}
	
	private static void encryptedInput(String[] args) throws InvalidArgumentException {
		argumentIndex++;
		if (args[argumentIndex] == "-senha") {
			argumentIndex++;
			//PEGA A SENHA!
			argumentIndex++;
		} else {
			throw new InvalidArgumentException(args[argumentIndex], true);
		}
	}
	
}
