import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener {
	public JButton[] b;
	public JButton eq, cl, dot, add, sub, mul, div, back, sin, cos, tan;
	public JTextField f;

	public Calculator() {
		super.setTitle("Calculator");
		super.setBounds(10, 10, 1000, 1000);
		b = new JButton[10];
		int c = 0;
		for (int i = 0; i < b.length; i++) {
			if (i != 9) {
				b[i] = new JButton("" + (i + 1));
			} else {
				b[i] = new JButton("0");
			}

			if (i % 3 == 0) {
				c += 200;
			}

			b[i].setBounds(50 + 200 * (i % 3), 10 + c, 100, 100);
			b[i].addActionListener(this);
			super.add(b[i]);
		}
		eq = new JButton("=");
		eq.setBounds(250, 810, 100, 100);
		eq.addActionListener(this);
		super.add(eq);

		cl = new JButton("Clear");
		cl.setBounds(450, 810, 100, 100);
		cl.addActionListener(this);
		super.add(cl);

		dot = new JButton(".");
		dot.setBounds(650, 810, 100, 100);
		dot.addActionListener(this);
		super.add(dot);

		add = new JButton("ADD");
		add.setBounds(650, 50, 100, 100);
		add.addActionListener(this);
		super.add(add);

		sub = new JButton("SUB");
		sub.setBounds(650, 210, 100, 100);
		sub.addActionListener(this);
		super.add(sub);

		mul = new JButton("MUL");
		mul.setBounds(650, 410, 100, 100);
		mul.addActionListener(this);
		super.add(mul);

		sin = new JButton("sin");
		sin.setBounds(850, 50, 100, 100);
		sin.addActionListener(this);
		super.add(sin);

		cos = new JButton("cos");
		cos.setBounds(850, 210, 100, 100);
		cos.addActionListener(this);
		super.add(cos);

		tan = new JButton("tan");
		tan.setBounds(850, 410, 100, 100);
		tan.addActionListener(this);
		super.add(tan);

		div = new JButton("DIV");
		div.setBounds(650, 610, 100, 100);
		div.addActionListener(this);
		super.add(div);

		back = new JButton("DEL");
		back.setBounds(850, 610, 100, 100);
		back.addActionListener(this);
		super.add(back);

		Font ff = new Font("Gorilla", Font.ITALIC, 20);

		f = new JTextField();
		f.setBounds(50, 50, 500, 100);
		f.setFont(ff);
		super.add(f);
		super.setLayout(null);
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ini = f.getText();
		if (e.getSource() == b[0]) {
			ini = ini + "1";
			f.setText(ini);
		} else if (e.getSource() == b[1]) {
			ini = ini + "2";
			f.setText(ini);
		} else if (e.getSource() == b[2]) {
			ini = ini + "3";
			f.setText(ini);
		} else if (e.getSource() == b[3]) {
			ini = ini + "4";
			f.setText(ini);
		} else if (e.getSource() == b[4]) {
			ini = ini + "5";
			f.setText(ini);
		} else if (e.getSource() == b[5]) {
			ini = ini + "6";
			f.setText(ini);
		} else if (e.getSource() == b[6]) {
			ini = ini + "7";
			f.setText(ini);
		} else if (e.getSource() == b[7]) {
			ini = ini + "8";
			f.setText(ini);
		} else if (e.getSource() == b[8]) {
			ini = ini + "9";
			f.setText(ini);
		} else if (e.getSource() == b[9]) {
			ini = ini + "0";
			f.setText(ini);
		} else if (e.getSource() == dot) {
			ini = ini + ".";
			f.setText(ini);
		} else if (e.getSource() == add) {
			ini = ini + " + ";
			f.setText(ini);
		} else if (e.getSource() == sub) {
			ini = ini + " - ";
			f.setText(ini);
		} else if (e.getSource() == back) {
			ini = ini.substring(0, ini.length() - 1);
			f.setText(ini);
		} else if (e.getSource() == mul) {
			ini = ini + " x ";
			f.setText(ini);
		} else if (e.getSource() == div) {
			ini = ini + " / ";
			f.setText(ini);
		} else if (e.getSource() == cl) {
			f.setText("");
		} else if (e.getSource() == sin) {
			f.setText("sin " + f.getText());
		} else if (e.getSource() == cos) {
			f.setText("cos " + f.getText());
		} else if (e.getSource() == tan) {
			f.setText("tan " + f.getText());
		} else if (e.getSource() == eq) {
			String s = f.getText();
			String[] str;
			Double ans1 = 0.0;
			Float ans = 0f;
			Float[] x = new Float[2];
			if (s.contains("+")) {
				str = new String[2];
				str[0] = s.substring(0, s.indexOf("+"));
				str[1] = s.substring(s.indexOf("+") + 1);
				x = getValues(str);
				ans = x[0] + x[1];
			} else if (s.contains("-")) {
				str = s.split("-");
				x = getValues(str);
				ans = x[0] - x[1];
			} else if (s.contains("x")) {
				str = s.split("x");
				x = getValues(str);
				ans = x[0] * x[1];
			} else if (s.contains("*")) {
				str = s.split("*");
				x = getValues(str);
				ans = x[0] * x[1];
			} else if (s.contains("/")) {
				str = s.split("/");
				x = getValues(str);
				ans = x[0] / x[1];
			} else if (s.contains("sin")) {
				str = s.split("sin ");
				double x1 = Double.parseDouble(str[1]);
				ans1 = Math.sin(Math.toRadians(x1));
				String s11 = String.valueOf(ans1);
				ans = Float.parseFloat(s11);
			} else if (s.contains("cos")) {
				str = s.split("cos");
				double x1 = Double.parseDouble(str[1]);
				ans1 = Math.cos(Math.toRadians(x1));
				String s11 = String.valueOf(ans1);
				ans = Float.parseFloat(s11);
			} else if (s.contains("tan")) {
				str = s.split("tan");
				double x1 = Double.parseDouble(str[1]);
				ans1 = Math.tan(Math.toRadians(x1));
				String s11 = String.valueOf(ans1);
				ans = Float.parseFloat(s11);
			} else if (s.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter something!");
			} else {
				try {
					ans = Float.parseFloat(s);
				} catch (Exception ex) {
					f.setText("Error : " + ex);
				}
			}
			f.setText(ans + "");
		}
	}

	Float[] getValues(String[] s) {
		Float[] f1 = new Float[2];
		try {
			f1[0] = Float.parseFloat(s[0]);
			f1[1] = Float.parseFloat(s[1]);
		} catch (Exception e) {
			f.setText("Error : " + e);
		}
		return f1;
	}
}
