/**
Dreghici Popa Vlad
Mar 10, 2018

 */

package view;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PolinomGui extends JFrame{

	private JPanel panel;
	private JLabel labelCoef1;
	private JTextField valoriCoef1;
	private JLabel labelCoef2;
	private JTextField valoriCoef2;
	private JButton confirm;
	private JLabel polinom1;
	private JLabel polinom2;
	private JButton addition;
	private JButton subtract;
	private JButton multiply;
	private JButton divide;
	private JButton derivate;
	private JButton integrate;
	private JLabel result;
	private JButton reset;
	private JLabel instr1;
	private JLabel instr2;

	public PolinomGui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100,100,600,550); 
		panel = new JPanel(); 
		panel.setLayout(null); 
		this.setTitle("Polinoame");
		labelCoef1 = new JLabel("Insert first polynomial coefficients, separated with ' , '");
		labelCoef1.setBounds(10, 10, 600, 20);
		labelCoef1.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(labelCoef1);
		valoriCoef1 = new JTextField();
		valoriCoef1.setBounds(10, 30, 200, 30);
		valoriCoef1.setFont(new Font("Arial", Font.BOLD,20));
		panel.add(valoriCoef1);
		labelCoef2 = new JLabel("Insert second polynomial coefficients,"
				+ " separated with ' , '");
		labelCoef2.setBounds(10, 90, 600, 30);
		labelCoef2.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(labelCoef2);
		valoriCoef2 = new JTextField();
		valoriCoef2.setBounds(10, 115, 200, 30);
		valoriCoef2.setFont(new Font("Arial", Font.BOLD,20));
		panel.add(valoriCoef2);
		confirm = new JButton("Confirm");
		confirm.setBounds(10, 180, 100, 20);
		panel.add(confirm);
		polinom1 = new JLabel("First polynomial");
		polinom1.setBounds(10,210,600,20);
		polinom1.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(polinom1);
		polinom2 = new JLabel("Second polynomial");
		polinom2.setBounds(10,240,600,20);
		polinom2.setFont(new Font("Arial", Font.BOLD, 15));	
		panel.add(polinom2);
		addition = new JButton("Add");
		addition.setBounds(10,270,100,20);
		panel.add(addition);
		subtract = new JButton("Subtract");
		subtract.setBounds(10,290,100,20);
		panel.add(subtract);
		multiply = new JButton("Multiplpy");
		multiply.setBounds(10,310,100,20);
		panel.add(multiply);
		divide = new JButton("Divide");
		divide.setBounds(10,330,100,20);
		panel.add(divide);
		derivate = new JButton("Derivate");
		derivate.setBounds(10,350,100,20);
		panel.add(derivate);
		instr1 = new JLabel("Derivation and integration are executed");
		instr1.setBounds(120,350,300,20);
		panel.add(instr1);
		integrate = new JButton("Integrate");
		integrate.setBounds(10,370,100,20);
		panel.add(integrate);
		instr2 = new JLabel("only on the first polynomial");
		instr2.setBounds(120,370,200,20);
		panel.add(instr2);
		result = new JLabel("Result");
		result.setBounds(10, 410,1000,20);
		result.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(result);
		reset = new JButton("Reset polynomials");
		reset.setBounds(10,450,200,20);
		panel.add(reset);
		this.add(panel);
		this.setVisible(true);

	}

	// Methods need to interact with controller
	// Methods are called in the controller
	// Action listener defines what should be done when an user 
	// performs a certain operation
	public String getCoef1() {
		return valoriCoef1.getText();
	}

	public String getCoef2() {
		return valoriCoef2.getText();
	}
	

	public void confirmPress(ActionListener e) {
		confirm.addActionListener(e);
	}

	public void writePolinom1(String arg0) {
		polinom1.setText(arg0);
	}

	public void writePolinom2(String arg0) {
		polinom2.setText(arg0);
	}

	public void additionPressed(ActionListener e) {
		addition.addActionListener(e);
	}

	public void subtractPressed(ActionListener e) {
		subtract.addActionListener(e);
	}

	public void multiplyPressed(ActionListener e) {
		multiply.addActionListener(e);
	}

	public void dividePressed(ActionListener e) {
		divide.addActionListener(e);
	}

	public void integratePressed(ActionListener e) {
		integrate.addActionListener(e);
	}

	public void derivatePressed(ActionListener e) {
		derivate.addActionListener(e);
	}

	public void writeResult(String arg0) {
		result.setText(arg0);
	}

	public void resetPressed(ActionListener e) {
		reset.addActionListener(e);
	}

	public void resetPolinoame() {
		valoriCoef1.setText("");
		valoriCoef2.setText("");
	}

	
	public JFrame returnFrame() {
		return this;
	}
}

