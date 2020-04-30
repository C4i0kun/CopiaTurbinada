/**
 * @file CopiaTurbinada.java
 * 
 * @author Caio Souza <caio326@usp.br>
 * 
 * @date 04/2020
 */

package copiaturbinada.main;

import copiaturbinada.input.InputHandler;
import copiaturbinada.output.OutputHandler;

/**
 * @brief Main class
 */
public class CopiaTurbinada {

	public static void main(String[] args) {
		ArgumentsHandler.Handle(args, true);
		String input = InputHandler.getInput().input();
		OutputHandler.getOutput().output(input);
	}
}
