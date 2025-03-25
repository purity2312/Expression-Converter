/**
 * @author Yechan Lim
 * UMGC CMSC 315
 * Project 1: Perform conversion from prefix expressions to postfix and postfix expressions to prefix.
 * Date: August 2023
 * RunConverter class: the main class that opens the GUI for the converter
 * Java 17
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RunConverter {
	
	// variables
	static JFrame frame = new JFrame("Expression Converter");
	static JPanel content = new JPanel();
	static JLabel resultBox;
	static JTextField text;
	static String expression;
	static String converted;
	
	public static void main(String[] args) {

		// set layout
		content.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		// create enter label
		JLabel enter = new JLabel("Enter Expression");
		c.anchor = GridBagConstraints.PAGE_START;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		content.add(enter, c);
		
		// create prefixToPostfix button
		JButton prefixToPostfix = new JButton("Prefix to Postfix");
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		ButtonHandler1 listener1 = new ButtonHandler1();
		prefixToPostfix.addActionListener(listener1);
		content.add(prefixToPostfix, c);
		
		// create postfixToPrefix button 
		JButton postfixToPrefix = new JButton("Postfix to Prefix");
		c.anchor = GridBagConstraints.CENTER;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 1;
		c.gridy = 0;
		ButtonHandler2 listener2 = new ButtonHandler2();
		postfixToPrefix.addActionListener(listener2);
		content.add(postfixToPrefix, c);
		
		// create text field
		text = new JTextField(20);
		c.anchor = GridBagConstraints.FIRST_LINE_END;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 1;
		c.gridy = 0;
		content.add(text, c);
		
		// create result label
		JLabel result = new JLabel("Result");
		c.anchor = GridBagConstraints.PAGE_END;
		c.weightx = 1;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		content.add(result, c);
		
		// frame setting
		frame.setContentPane(content);
		frame.setSize(400, 150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		
	}

/**
 * Action listener for prefixToPostfix Button
 * 
 * Set the text in the resultBox to converted expression
 */	
	public static class ButtonHandler1 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if (resultBox == null) {
				resultBox = new JLabel();
			}
			// get text from the text box
			expression = text.getText();	
			// perform the conversion
			ConvertPrefixPostfix convert = new ConvertPrefixPostfix(expression);	
			try {
				converted = convert.prefixToPostfix();
			} catch (SyntaxError e1) {
				
			}
			// set the text in the resultBox
			resultBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			GridBagConstraints c = new GridBagConstraints();
			c.anchor = GridBagConstraints.PAGE_END;
			c.weightx = 0;
			c.weighty = 0;
			c.gridx = 1;
			c.gridy = 0;
			resultBox.setText(converted);
			content.add(resultBox, c);	
			frame.setVisible(true);


		}
	}
	
/**
 * Action listener for prefixToPostfix Button
 * 
 * Set the text in the resultBox to converted expression
 */
	public static class ButtonHandler2 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if (resultBox == null) {
				resultBox = new JLabel();
			}
			// get text from the text box
			expression = text.getText();
			// perform the conversion
			ConvertPrefixPostfix convert = new ConvertPrefixPostfix(expression);
			try {
				converted = convert.postToPrefix();
			} catch (SyntaxError e1) {

			}
			// set the text in the resultBox
			resultBox.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
			GridBagConstraints c = new GridBagConstraints();
			c.anchor = GridBagConstraints.PAGE_END;
			c.weightx = 0;
			c.weighty = 0;
			c.gridx = 1;
			c.gridy = 0;
			resultBox.setText(converted);
			content.add(resultBox, c);
			frame.setVisible(true);
		}
	}
}
