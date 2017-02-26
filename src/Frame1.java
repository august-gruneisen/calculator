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

public class Frame1 {
	
	Boolean TextField1 = true;
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
					Frame1 window = new Frame1();
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
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.getContentPane().setBackground(new Color(0, 0, 0));
		frmCalculator.setResizable(false);
		frmCalculator.setTitle("ABT (August Built This) Calculator 1.0");
		frmCalculator.setBounds(500, 100, 455, 606);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(null);
		
		textFieldNum1 = new JTextField();
		textFieldNum1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNum1.setForeground(new Color(255, 255, 255));
		textFieldNum1.setCaretColor(new Color(0, 0, 0));
		textFieldNum1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldNum1.setBackground(new Color(0, 0, 255));
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
		
		textFieldNum2 = new JTextField();
		textFieldNum2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNum2.setForeground(new Color(255, 255, 255));
		textFieldNum2.setCaretColor(new Color(0, 0, 0));
		textFieldNum2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textFieldNum2.setBackground(new Color(0, 0, 255));
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
		
		JLabel lblAnswer = new JLabel("ANSWER:");
		lblAnswer.setForeground(new Color(0, 0, 255));
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAnswer.setBounds(10, 521, 210, 48);
		frmCalculator.getContentPane().add(lblAnswer);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(UIManager.getColor("Button.background"));
		btnAdd.setFocusable(false);
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
		
		JButton btnSubtract = new JButton("SUBTRACT");
		btnSubtract.setBackground(UIManager.getColor("Button.background"));
		btnSubtract.setFocusable(false);
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
		
		JButton btnMultiply = new JButton("MULTIPLY");
		btnMultiply.setBackground(UIManager.getColor("Button.background"));
		btnMultiply.setFocusable(false);
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
		
		JButton btnDivide = new JButton("DIVIDE");
		btnDivide.setBackground(UIManager.getColor("Button.background"));
		btnDivide.setFocusable(false);
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldNum1.getText().contains(".") || textFieldNum2.getText().contains(".")) {
					double num1, num2, answer;
					try {
						num1 = Double.parseDouble(textFieldNum1.getText());
						num2 = Double.parseDouble(textFieldNum2.getText());
						
						answer = num1 / num2;
						
						answerField.setText(Double.toString(answer));
					} catch (Exception e4) {
						JOptionPane.showMessageDialog(null, "Please enter valid number");
					}
				} else {
					int num1, num2, answer;
					try {
						num1 = Integer.parseInt(textFieldNum1.getText());
						num2 = Integer.parseInt(textFieldNum2.getText());
						
						answer = num1 / num2;
						
						answerField.setText(Integer.toString(answer));
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
		
		answerField = new JTextField();
		answerField.setHorizontalAlignment(SwingConstants.CENTER);
		answerField.setForeground(new Color(255, 255, 255));
		answerField.setCaretColor(new Color(0, 0, 0));
		answerField.setFont(new Font("Tahoma", Font.BOLD, 15));
		answerField.setBackground(new Color(0, 0, 255));
		answerField.setBounds(230, 521, 210, 48);
		frmCalculator.getContentPane().add(answerField);
		answerField.setColumns(10);
		
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
		
		JButton btnDecimal = new JButton(".");
		btnDecimal.setBackground(UIManager.getColor("Button.background"));
		btnDecimal.setFocusable(false);
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TextField1) {
					String currentText = textFieldNum1.getText();
					textFieldNum1.setText(currentText + ".");
				} else if (TextField2) {
					String currentText = textFieldNum2.getText();
					textFieldNum2.setText(currentText + ".");
				}
			}
		});
		btnDecimal.setBounds(340, 122, 100, 100);
		frmCalculator.getContentPane().add(btnDecimal);
		
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
	}
}
