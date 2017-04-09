import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Calculator {
	// some data
	private JTextField num1, ope, num2, equal, result;
	private JButton add, sub, mul, div, OK;
	// main GUI etc..
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.showGUI();
		calculator.listener();
	}

	// create and show a GUI for the Calculator
	public void showGUI() {
		// the frame of the Calculator
		JFrame frame = new JFrame("Calculator");
		frame.setLayout(new GridLayout(2, 5));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// the numbers:font, position
		num1 = new JTextField("12");
		num1.setFont(new Font("dialog", 0, 16));
		num1.setHorizontalAlignment(JTextField.CENTER);
		
		num2 = new JTextField("2");
		num2.setFont(new Font("dialog", 0, 16));
		num2.setHorizontalAlignment(JTextField.CENTER);
		
		result = new JTextField();
		result.setFont(new Font("dialog", 0, 16));
		result.setBackground(new Color(238, 238, 238));
		result.setHorizontalAlignment(JTextField.CENTER);
		
		// the operation
		ope = new JTextField();
		ope.setFont(new Font("dialog", 0, 20));
		ope.setBackground(new Color(238, 238, 238));
		ope.setHorizontalAlignment(JTextField.CENTER);
		//set the operation not enabled to change by inputting text
		ope.setEnabled(false);
		
		equal = new JTextField("=");
		equal.setFont(new Font("dialog", 0, 20));
		equal.setBackground(new Color(238, 238, 238));
		equal.setHorizontalAlignment(JTextField.CENTER);
		equal.setEnabled(false);
		
		// set the button
		add = new JButton("+");
		add.setFont(new Font("dialog", 0, 20));
		sub = new JButton("-");
		sub.setFont(new Font("dialog", 0, 20));
		mul = new JButton("*");
		mul.setFont(new Font("dialog", 0, 20));
		div = new JButton("/");
		div.setFont(new Font("dialog", 0, 20));
		OK = new JButton("OK");
		OK.setFont(new Font("dialog", 0, 20));	
		
		
		// put the data into the grid
		frame.add(num1);
		frame.add(ope);
		frame.add(num2);
		frame.add(equal);
		frame.add(result);
		frame.add(add);
		frame.add(sub);
		frame.add(mul);
		frame.add(div);
		frame.add(OK);
		frame.setSize(500, 250);
	}
	// add action listener functions
	public void listener() {
		operatorListener opeListener = new operatorListener();
		add.addActionListener(opeListener);
		sub.addActionListener(opeListener);
		mul.addActionListener(opeListener);
		div.addActionListener(opeListener);
		
		OKListener okListener = new OKListener();
		OK.addActionListener(okListener);
	}
	// implement ActionListener.actionPerformed interface for operations
	// and let ope display the operation
	private class operatorListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String selectedOpe = e.getActionCommand();
			ope.setText(selectedOpe);
		}
	}
	// implement ActionListener.actionPerformed interface for OK
	// and calculate the two numbers, display the result
	private class OKListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String selectedOpe = ope.getText();
			double n1 = Double.parseDouble(num1.getText());
			double n2 = Double.parseDouble(num2.getText());
			double n3 = 0;
			DecimalFormat df = new DecimalFormat("#.00");
			
			if (selectedOpe.equals("+")) {
				n3 = n1 + n2;
			}
			else if (selectedOpe.equals("-")) {
				n3 = n1 - n2;
			}
			else if (selectedOpe.equals("*")) {
				n3 = n1 * n2;
			}
			else if (selectedOpe.equals("/")) {
				n3 = n1 / n2;
			}
			result.setText(df.format(n3));
		}
	}
}