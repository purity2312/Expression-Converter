/**
 * @author Yechan Lim
 * UMGC CMSC 315
 * Project 1: Perform conversion from prefix expressions to postfix and postfix expressions to prefix.
 * Date: August 2023
 * SyntaxError class throws makes a Syntax Error window when it is called.
 * Java 17
*/


import javax.swing.*;
public class SyntaxError extends Exception {
	

	public SyntaxError() {
		// error message
		JFrame window = new JFrame();
		JOptionPane.showMessageDialog(window, "Syntax Error");
	}
	
}
