/**
 * @file InvalidArgumentException.java
 * 
 * @author Caio Souza <caio326@usp.br>
 * 
 * @date 04/2020
 */

package copiaturbinada;

import java.io.IOException;

/**
 * @brief Exception that happens when an argument passed by the user is invalid
 */
public class InvalidArgumentException extends IOException {
	private static final long serialVersionUID = 1L;
	
	private String invalidArg;
	private boolean exit;
	
	public InvalidArgumentException(String invalidArg, boolean exit) {
		super();
		this.invalidArg = invalidArg;
		this.exit = exit;
	}
	
	public void showMessage() {
		System.out.println("ERROR: Argument " + this.invalidArg + "is invalid!");
		
		if (this.exit == true) {
			System.exit(0);
		}
	}

}
