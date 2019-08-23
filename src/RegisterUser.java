import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RegisterUser extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5;
	JButton b;
	JTextField t1, t2, t3, t4, t5;

	public RegisterUser() {
		super.setBounds(50, 50, 450, 750);
		super.setResizable(false);
		super.setTitle("Sign Up!");

		l1 = new JLabel("Name : ");
		l1.setBounds(30, 30, 100, 40);
		super.add(l1);
		l2 = new JLabel("Email : ");
		l2.setBounds(30, 130, 100, 40);
		super.add(l2);
		l3 = new JLabel("Password : ");
		l3.setBounds(30, 230, 100, 40);
		super.add(l3);
		l4 = new JLabel("City : ");
		l4.setBounds(30, 330, 100, 40);
		super.add(l4);
		l5 = new JLabel("Phone Number : ");
		l5.setBounds(30, 430, 100, 40);
		super.add(l5);

		t1 = new JTextField();
		t1.setBounds(170, 30, 200, 40);
		super.add(t1);
		t2 = new JTextField();
		t2.setBounds(170, 130, 200, 40);
		super.add(t2);
		t3 = new JTextField();
		t3.setBounds(170, 230, 200, 40);
		super.add(t3);
		t4 = new JTextField();
		t4.setBounds(170, 330, 200, 40);
		super.add(t4);
		t5 = new JTextField();
		t5.setBounds(170, 430, 200, 40);
		super.add(t5);

		b = new JButton("Submit");
		b.setBounds(150, 550, 100, 40);
		super.add(b);
		b.addActionListener(this);

		super.setLayout(null);
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == b) {
			if (t2.getText().lastIndexOf(".") - t2.getText().lastIndexOf("@") < 2) {
				JOptionPane.showMessageDialog(null, "Enter a valid email");
			} else if (t3.getText().length() < 6) {
				JOptionPane.showMessageDialog(null, "Password too short(min 6 characters)");
			} else if (t5.getText().length() != 10) {
				JOptionPane.showMessageDialog(null, "Ph no should have exactly 10 numbers");
			} else if (t1.getText() == "" || t2.getText() == "" || t4.getText() == "" || t3.getText() == ""
					|| t5.getText() == "") {
				JOptionPane.showMessageDialog(null, "ERROR: No field can be empty");
			} else {
				int i = 0;
				while (t5.getText().charAt(i) >= '0' && t5.getText().charAt(i) <= '9') {
					i++;
					if (i == 10) {
						break;
					}
				}
				if (i != 10) {
					JOptionPane.showMessageDialog(null, "Ph no should have only numbers");
				} else {
					super.dispose();
					new Login();
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
						PreparedStatement ps = c.prepareStatement("INSERT INTO login VALUES(?,?,?,?,?)");
						ps.setString(1, t1.getText());
						ps.setString(2, t2.getText());
						ps.setString(3, t3.getText());
						ps.setString(4, t4.getText());
						ps.setString(5, t5.getText());
						int nora = ps.executeUpdate();
						JOptionPane.showMessageDialog(null, nora + " record updated");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Error : " + e);
					}
				}
			}
		}
	}
}
