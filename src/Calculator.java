/**
 * This program can perform basic mathematical calculations.
 * There are 2 text fields that can accept input from the user.
 * The user may type integers from a keyboard or use buttons from the interface to enter input.
 * The user may add, subtract, multiply, or divide two operands.
 * If only integers are inputed, the answer will be an integer.
 * If a decimal is used in either of the operands, the answer will be a floating point.
 * The user may clear input and/or the answer by using the "CLEAR" button
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
* Calculator Model Object.
* 
* @author August Gruneisen @AugustGrun
* @version 1.0
*/
public class Calculator {
	Boolean TextField1 = true; // Used to find which text field is focused. First text field is focused by default.
	Boolean TextField2 = false;

	private JFrame frmCalculator;
	private JTextField textFieldNum1;
	private JTextField textFieldNum2;
	private JTextField answerField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// Initialize frame
		frmCalculator = new JFrame();
		frmCalculator.getContentPane().setBackground(new Color(0, 0, 0));
		frmCalculator.setResizable(false);
		frmCalculator.setTitle("ABT (August Built This) Calculator 1.0");
		frmCalculator.setBounds(500, 100, 457, 629);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		// Initialize first text field
		textFieldNum1 = new JTextField();
		textFieldNum1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_PERIOD) {
					if (textFieldNum1.getText().contains(".")) {
						e.consume();
					}
				}
				else if (!Character.isDigit(e.getKeyChar()) && (e.getKeyChar() != KeyEvent.VK_BACK_SPACE) && (e.getKeyChar() != KeyEvent.VK_DELETE) && (e.getKeyChar() != KeyEvent.VK_PERIOD)) {
					e.consume();
				}
			}
		});
		textFieldNum1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNum1.setForeground(new Color(255, 255, 255));
		textFieldNum1.setCaretColor(new Color(0, 0, 0));
		textFieldNum1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldNum1.setBackground(new Color(0, 0, 255));
		// Focus listener changes the global variables that are used to determine which text field currently has focus
		textFieldNum1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				TextField2= false;
				TextField1 = true;
			}
		});
		textFieldNum1.setBounds(10, 344, 210, 48);
		frmCalculator.getContentPane().add(textFieldNum1);
		textFieldNum1.setColumns(10);
		
		// Initialize second text field
		textFieldNum2 = new JTextField();
		textFieldNum2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_PERIOD) {
					if (textFieldNum2.getText().contains(".")) {
						e.consume();
					}
					
				}
				else if (!Character.isDigit(e.getKeyChar()) && (e.getKeyChar() != KeyEvent.VK_BACK_SPACE) && (e.getKeyChar() != KeyEvent.VK_DELETE) && (e.getKeyChar() != KeyEvent.VK_PERIOD)) {
					e.consume();
				}
			}
		});
		textFieldNum2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNum2.setForeground(new Color(255, 255, 255));
		textFieldNum2.setCaretColor(new Color(0, 0, 0));
		textFieldNum2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldNum2.setBackground(new Color(0, 0, 255));
		// Focus listener changes global variables used to determine which text field currently has focus
		textFieldNum2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				TextField1 = false;
				TextField2 = true;
			}
		});
		textFieldNum2.setColumns(10);
		textFieldNum2.setBounds(230, 344, 210, 48);
		frmCalculator.getContentPane().add(textFieldNum2);
		
		// Initialize answer field
		answerField = new JTextField();
		answerField.setFocusable(false);
		answerField.setHorizontalAlignment(SwingConstants.CENTER);
		answerField.setForeground(new Color(255, 255, 255));
		answerField.setCaretColor(new Color(0, 0, 0));
		answerField.setFont(new Font("Tahoma", Font.BOLD, 15));
		answerField.setBackground(new Color(0, 0, 255));
		answerField.setBounds(230, 521, 210, 48);
		frmCalculator.getContentPane().add(answerField);
		answerField.setColumns(10);
		
		// Initialize answer label
		JLabel lblAnswer = new JLabel("ANSWER:");
		lblAnswer.setForeground(new Color(0, 0, 255));
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAnswer.setBounds(10, 521, 210, 48);
		frmCalculator.getContentPane().add(lblAnswer);
		
		/**
		 * INITIALIZE OPERATION BUTTONS
		 * 
		 * These buttons will be used to perform mathematical operations on the input
		 * When clicked, perform operation using the two operands.
		 * Set text of the answer field to display the operation.
		 * If either operand contains a decimal, perform the operation using doubles
		 * If neither operand contains a decimal, perform the operation using integers
		 * If input is null or does not contain a number, show error message.
		 * Remove focus from both text fields.
		 */
		// Initialize add button
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(UIManager.getColor("Button.background"));
		btnAdd.setFocusable(false);
		// When clicked, perform an addition of the two operands.
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNum1.getText().contains(".") || textFieldNum2.getText().contains(".")) {
					double num1, num2, answer;
					try {
						num1 = Double.parseDouble(textFieldNum1.getText());
						num2 = Double.parseDouble(textFieldNum2.getText());
						
						answer = num1 + num2;
						
						answerField.setText(Double.toString(answer));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Please enter valid number");
					}
				} else {
					int num1, num2, answer;
					try {
						num1 = Integer.parseInt(textFieldNum1.getText());
						num2 = Integer.parseInt(textFieldNum2.getText());
						
						answer = num1 + num2;
						
						answerField.setText(Integer.toString(answer));
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Please enter valid number");
					}
				}
				TextField1 = false;
				TextField2 = false;
				lblAnswer.requestFocusInWindow();
			}
		});
		btnAdd.setBounds(10, 403, 210, 48);
		frmCalculator.getContentPane().add(btnAdd);
		
		// Initialize subtract button
		JButton btnSubtract = new JButton("SUBTRACT");
		btnSubtract.setBackground(UIManager.getColor("Button.background"));
		btnSubtract.setFocusable(false);
		// When clicked, perform a subtraction of the two operands.
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNum1.getText().contains(".") || textFieldNum2.getText().contains(".")) {
					double num1, num2, answer;
					try {
						num1 = Double.parseDouble(textFieldNum1.getText());
						num2 = Double.parseDouble(textFieldNum2.getText());
						
						answer = num1 - num2;
						
						answerField.setText(Double.toString(answer));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Please enter valid number");
					}
				} else {
					int num1, num2, answer;
					try {
						num1 = Integer.parseInt(textFieldNum1.getText());
						num2 = Integer.parseInt(textFieldNum2.getText());
						
						answer = num1 - num2;
						
						answerField.setText(Integer.toString(answer));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Please enter valid number");
					}
				}
				TextField1 = false;
				TextField2 = false;
				lblAnswer.requestFocusInWindow();
			}
		});
		btnSubtract.setBounds(230, 403, 210, 48);
		frmCalculator.getContentPane().add(btnSubtract);
		
		// Initialize multiply button
		JButton btnMultiply = new JButton("MULTIPLY");
		btnMultiply.setBackground(UIManager.getColor("Button.background"));
		btnMultiply.setFocusable(false);
		 // When clicked, perform a multiplication of the two operands.
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNum1.getText().contains(".") || textFieldNum2.getText().contains(".")) {
					double num1, num2, answer;
					try {
						num1 = Double.parseDouble(textFieldNum1.getText());
						num2 = Double.parseDouble(textFieldNum2.getText());
						
						answer = num1 * num2;
						
						answerField.setText(Double.toString(answer));
					} catch (Exception e3) {
						JOptionPane.showMessageDialog(null, "Please enter valid number");
					}
				} else {
					int num1, num2, answer;
					try {
						num1 = Integer.parseInt(textFieldNum1.getText());
						num2 = Integer.parseInt(textFieldNum2.getText());
						
						answer = num1 * num2;
						
						answerField.setText(Integer.toString(answer));
					} catch (Exception e3) {
						JOptionPane.showMessageDialog(null, "Please enter valid number");
					}
				}
				TextField1 = false;
				TextField2 = false;
				lblAnswer.requestFocusInWindow();
			}
		});
		btnMultiply.setBounds(10, 462, 210, 48);
		frmCalculator.getContentPane().add(btnMultiply);
		
		// Initialize divide button
		JButton btnDivide = new JButton("DIVIDE");
		btnDivide.setBackground(UIManager.getColor("Button.background"));
		btnDivide.setFocusable(false);
		// When clicked, perform a division of the two operands.
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNum1.getText().contains(".") || textFieldNum2.getText().contains(".") || Double.parseDouble(textFieldNum1.getText()) % Double.parseDouble(textFieldNum2.getText()) != 0) {
					double num1, num2, answer;
					try {
						num1 = Double.parseDouble(textFieldNum1.getText());
						num2 = Double.parseDouble(textFieldNum2.getText());
						
						if (!(num2 == 0.0)) { // Only performs calculation if second operand is not zero
							answer = num1 / num2;
							answerField.setText(Double.toString(answer));
						} else
							answerField.setText("Can't divide by 0");
					} catch (Exception e4) {
						JOptionPane.showMessageDialog(null, "Please enter valid number");
					}
				} else {
					int num1, num2, answer;
					try {
						num1 = Integer.parseInt(textFieldNum1.getText());
						num2 = Integer.parseInt(textFieldNum2.getText());
						
						if (!(num2 == 0)) {
							answer = num1 / num2;
							answerField.setText(Integer.toString(answer));
						} else
							answerField.setText("Can't divide by 0");
					} catch (Exception e4) {
						JOptionPane.showMessageDialog(null, "Please enter valid number");
					}
				}
				TextField1 = false;
				TextField2 = false;
				lblAnswer.requestFocusInWindow();
			}
		});
		btnDivide.setBounds(230, 462, 210, 48);
		frmCalculator.getContentPane().add(btnDivide);

		/**
		 * INITIALIZE INPUT BUTTONS
		 * 
		 * When clicked, these buttons will input values to a text field
		 * If first text field is focused, input values to the first text field
		 * If second text field is focused, input values to the second text field
		 */
		// Initialize 1 button
		JButton btn1 = new JButton("1");
		btn1.setBackground(UIManager.getColor("Button.background"));
		btn1.setFocusable(false);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (TextField1) {
					String currentText = textFieldNum1.getText();
					textFieldNum1.setText(currentText + Integer.toString(1));
				} else if (TextField2) {
					String currentText = textFieldNum2.getText();
					textFieldNum2.setText(currentText + Integer.toString(1));
				}
			}
		});
		btn1.setBounds(10, 11, 100, 100);
		frmCalculator.getContentPane().add(btn1);
		
		// Initialize 2 button
		JButton btn2 = new JButton("2");
		btn2.setBackground(UIManager.getColor("Button.background"));
		btn2.setFocusable(false);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TextField1) {
					String currentText = textFieldNum1.getText();
					textFieldNum1.setText(currentText + Integer.toString(2));
				} else if (TextField2) {
					String currentText = textFieldNum2.getText();
					textFieldNum2.setText(currentText + Integer.toString(2));
				}
			}
		});
		btn2.setBounds(120, 11, 100, 100);
		frmCalculator.getContentPane().add(btn2);
		
		// Initialize 3 button
		JButton btn3 = new JButton("3");
		btn3.setBackground(UIManager.getColor("Button.background"));
		btn3.setFocusable(false);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TextField1) {
					String currentText = textFieldNum1.getText();
					textFieldNum1.setText(currentText + Integer.toString(3));
				} else if (TextField2) {
					String currentText = textFieldNum2.getText();
					textFieldNum2.setText(currentText + Integer.toString(3));
				}
			}
		});
		btn3.setBounds(230, 11, 100, 100);
		frmCalculator.getContentPane().add(btn3);
		
		// Initialize 4 button
		JButton btn4 = new JButton("4");
		btn4.setBackground(UIManager.getColor("Button.background"));
		btn4.setFocusable(false);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TextField1) {
					String currentText = textFieldNum1.getText();
					textFieldNum1.setText(currentText + Integer.toString(4));
				} else if (TextField2) {
					String currentText = textFieldNum2.getText();
					textFieldNum2.setText(currentText + Integer.toString(4));
				}
			}
		});
		btn4.setBounds(10, 122, 100, 100);
		frmCalculator.getContentPane().add(btn4);
		
		// Initialize 5 button
		JButton btn5 = new JButton("5");
		btn5.setBackground(UIManager.getColor("Button.background"));
		btn5.setFocusable(false);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TextField1) {
					String currentText = textFieldNum1.getText();
					textFieldNum1.setText(currentText + Integer.toString(5));
				} else if (TextField2) {
					String currentText = textFieldNum2.getText();
					textFieldNum2.setText(currentText + Integer.toString(5));
				}
			}
		});
		btn5.setBounds(120, 122, 100, 100);
		frmCalculator.getContentPane().add(btn5);
		
		// Initialize 6 button
		JButton btn6 = new JButton("6");
		btn6.setBackground(UIManager.getColor("Button.background"));
		btn6.setFocusable(false);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TextField1) {
					String currentText = textFieldNum1.getText();
					textFieldNum1.setText(currentText + Integer.toString(6));
				} else if (TextField2) {
					String currentText = textFieldNum2.getText();
					textFieldNum2.setText(currentText + Integer.toString(6));
				}
			}
		});
		btn6.setBounds(230, 122, 100, 100);
		frmCalculator.getContentPane().add(btn6);
		
		// Initialize 7 button
		JButton btn7 = new JButton("7");
		btn7.setBackground(UIManager.getColor("Button.background"));
		btn7.setFocusable(false);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TextField1) {
					String currentText = textFieldNum1.getText();
					textFieldNum1.setText(currentText + Integer.toString(7));
				} else if (TextField2) {
					String currentText = textFieldNum2.getText();
					textFieldNum2.setText(currentText + Integer.toString(7));
				}
			}
		});
		btn7.setBounds(10, 233, 100, 100);
		frmCalculator.getContentPane().add(btn7);
		
		// Initialize 8 button
		JButton btn8 = new JButton("8");
		btn8.setBackground(UIManager.getColor("Button.background"));
		btn8.setFocusable(false);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TextField1) {
					String currentText = textFieldNum1.getText();
					textFieldNum1.setText(currentText + Integer.toString(8));
				} else if (TextField2) {
					String currentText = textFieldNum2.getText();
					textFieldNum2.setText(currentText + Integer.toString(8));
				}
			}
		});
		btn8.setBounds(120, 233, 100, 100);
		frmCalculator.getContentPane().add(btn8);
		
		// Initialize 9 button
		JButton btn9 = new JButton("9");
		btn9.setBackground(UIManager.getColor("Button.background"));
		btn9.setFocusable(false);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TextField1) {
					String currentText = textFieldNum1.getText();
					textFieldNum1.setText(currentText + Integer.toString(9));
				} else if (TextField2) {
					String currentText = textFieldNum2.getText();
					textFieldNum2.setText(currentText + Integer.toString(9));
				}
			}
		});
		btn9.setBounds(230, 233, 100, 100);
		frmCalculator.getContentPane().add(btn9);
		
		// Initialize 0 button
		JButton btn0 = new JButton("0");
		btn0.setBackground(UIManager.getColor("Button.background"));
		btn0.setFocusable(false);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TextField1) {
					String currentText = textFieldNum1.getText();
					textFieldNum1.setText(currentText + Integer.toString(0));
				} else if (TextField2) {
					String currentText = textFieldNum2.getText();
					textFieldNum2.setText(currentText + Integer.toString(0));
				}
			}
		});
		btn0.setBounds(340, 233, 100, 100);
		frmCalculator.getContentPane().add(btn0);
		
		// Initialize decimal button
		JButton btnDecimal = new JButton(".");
		btnDecimal.setBackground(UIManager.getColor("Button.background"));
		btnDecimal.setFocusable(false);
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TextField1) {
					if (!textFieldNum1.getText().contains(".")) { // Only works if there is no decimal already in the text field
						String currentText = textFieldNum1.getText();
						textFieldNum1.setText(currentText + ".");
					}
				} else if (TextField2) {
					if (!textFieldNum2.getText().contains(".")) {
						String currentText = textFieldNum2.getText();
						textFieldNum2.setText(currentText + ".");
					}
				}
			}
		});
		btnDecimal.setBounds(340, 177, 100, 45);
		frmCalculator.getContentPane().add(btnDecimal);
		
		// Initialize sign change button
		JButton btnSignChange = new JButton("+ / -");
		btnSignChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TextField1) {
					if (textFieldNum1.getText().contains(".")) {
						double num = Double.parseDouble(textFieldNum1.getText());
						textFieldNum1.setText(Double.toString(num * -1));
					} else {
						int num = Integer.parseInt(textFieldNum1.getText());
						textFieldNum1.setText(Integer.toString(num * -1));
					}
				} else if (TextField2) {
					if (textFieldNum2.getText().contains(".")) {
						double num = Double.parseDouble(textFieldNum2.getText());
						textFieldNum2.setText(Double.toString(num * -1));
					} else {
						int num = Integer.parseInt(textFieldNum2.getText());
						textFieldNum2.setText(Integer.toString(num * -1));
					}
				}
			}
		});
		btnSignChange.setFocusable(false);
		btnSignChange.setBackground(SystemColor.menu);
		btnSignChange.setBounds(340, 122, 100, 45);
		frmCalculator.getContentPane().add(btnSignChange);

		/** INITIALIZE CLEAR BUTTON
		 * 
		 * This button will clear user input and answer
		 * Action will depend on what stage of the calculation the user is currently in
		 * If focus is currently in a text field:
		 * 		Clears only the focused text field if it contains any input
		 * 		If focused text field is null, or 0, clears both text fields and aswer field
		 * 			Focus returns to first text field
		 * If an operation has been performed and neither text field has focus:
		 * 		Clears both text fields and answer field
		 * 			Focus returns to first text field
		 */
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBackground(UIManager.getColor("Button.background"));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TextField1) {
					if ((textFieldNum1.getText()) == Integer.toString(0) || (textFieldNum1.getText()) == Double.toString(0.0) ||  (textFieldNum1.getText() == null || textFieldNum1.getText().isEmpty())) {
						textFieldNum1.setText(null);
						textFieldNum2.setText(null);
						answerField.setText(null);
						lblAnswer.requestFocusInWindow();
						TextField1 = true;
					} else
						textFieldNum1.setText(null);
				} else if (TextField2) {
					if ((textFieldNum2.getText()) == Integer.toString(0) || (textFieldNum2.getText()) == Double.toString(0.0) ||  (textFieldNum2.getText() == null || textFieldNum2.getText().isEmpty())) {
						textFieldNum1.setText(null);
						textFieldNum2.setText(null);
						answerField.setText(null);
						lblAnswer.requestFocusInWindow();
						TextField1 = true;
					} else
						textFieldNum2.setText(null);
				} else {
					textFieldNum1.setText(null);
					textFieldNum2.setText(null);
					answerField.setText(null);
					TextField1 = true;
				}
			}
		});
		btnClear.setFocusable(false);
		btnClear.setBounds(340, 11, 100, 100);
		frmCalculator.getContentPane().add(btnClear);
		
		JMenuBar menuBar = new JMenuBar();
		frmCalculator.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JRadioButtonMenuItem rdbtnmntmScientific = new JRadioButtonMenuItem("Scientific");
		mnFile.add(rdbtnmntmScientific);
		
		JRadioButtonMenuItem rdbtnmntmSimple = new JRadioButtonMenuItem("Simple");
		mnFile.add(rdbtnmntmSimple);
	}
}