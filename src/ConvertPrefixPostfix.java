/**
 * @author Yechan Lim
 * UMGC CMSC 315
 * Project 1: Perform conversion from prefix expressions to postfix and postfix expressions to prefix.
 * Date: August 2023
 * ConvertPrefixPostfix class takes a prefix or postfix expression and then converts it to another expression.
 * Java 17
*/

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ConvertPrefixPostfix {
	// attribute
	private Stack<String> reversalStack;
	private String expression;
	private Stack<String> operandsStack;
	
	// constructor
	public ConvertPrefixPostfix(String expression) {
		this.expression = expression;
		reversalStack = new Stack<>();
		operandsStack = new Stack<>();

	}
	
	// convert prefix expression to postfix
	public String prefixToPostfix() throws SyntaxError {
		
		String current;			// current character in the for loop 
		String temp;			// temporary variable
		String output = null;	// output
		
		String num1; 			// operand 1
		String num2; 			// operand 2
		
		// used for tokenizing input
		String regexPattern = "\\d+|\\s|(\\+|\\-|\\*|\\/)";
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(expression);
		
		// tokenize the string containing the prefix expression
		while(matcher.find()) {
			String s = matcher.group();
			// push the token if it is not a space
			if (s.isBlank() == false) {
				reversalStack.push(s);
			} 
		}

		// while the reversal stack is not empty
		while(reversalStack.isEmpty() == false) {
			// pop the token from the reversal stack
			current = reversalStack.pop();
			// if it is an operand push it onto the operand stack
			if (Character.isDigit(current.charAt(0))) {
				operandsStack.push(current);

			// else it is an operator 
			} else {
				// catch exception occurring from popping an empty stack
				try {
					// pop two operands off of the operand stack
					num1 = operandsStack.pop();
					num2 = operandsStack.pop();
				} catch (Exception e2) {
					throw new SyntaxError();
				}

				// create a string with the two operands followed by the operator
				temp = num1 + " " + num2 + " " + current;
				// push that string onto the operand stack
				operandsStack.push(temp);
			}


		}
		
		// pop the postfix expression off the stack
		while(operandsStack.isEmpty() == false) {
			output = operandsStack.pop();
		} 

		// throw exception if the stack is not empty
		if (operandsStack.isEmpty() == false) {
			throw new SyntaxError();
		}
		
		return output;




	}
	
	// convert postfix expression to prefix
	public String postToPrefix() throws SyntaxError {

		String num1; 			// operand 1
		String num2;  			// operand 2
		String temp;			// temporary variable
		String output = null;	// output
		
		// used for tokenizing input
		String regexPattern = "\\d+|\\s|(\\+|\\-|\\*|\\/)";
		Pattern pattern = Pattern.compile(regexPattern);
		Matcher matcher = pattern.matcher(expression);
		
		// tokenize the string containing the postfix expression
		while(matcher.find()) {
			String s = matcher.group();
			// skip if it is a whitespace
			if (s.isBlank()) {
				
			// if it is an operand push it onto the operand stack
			} else if (Character.isDigit(s.charAt(0))) {
				operandsStack.push(s);

			// else it is an operator
			} else {

				try { 
					// pop two operands off of the operand stack
					num1 = operandsStack.pop();
					num2 = operandsStack.pop();
					// catch exception occurring from popping an empty stack
				} catch (Exception e3) {
					throw new SyntaxError();
				}
				// create a string with the operator followed by two operands and push it to the operand stack
				temp = s + " " + num2 + " " + num1;
				operandsStack.push(temp);
			}
		}
		
		// pop the prefix expression off the stack
		while(operandsStack.isEmpty() == false) {
			output = operandsStack.pop();
		}
		
		// throw exception if the stack is not empty
		if (operandsStack.isEmpty() == false) {
			throw new SyntaxError();
		}
		
		return output;
	}
	


}
