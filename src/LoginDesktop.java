import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class LoginDesktop extends JFrame implements ActionListener {
	JButton b1, b2;
	JLabel l1, l2;
	JTextField t1, t2;

	public LoginDesktop() {
		super.setBounds(50, 50, 900, 750);
		super.setTitle("Login");
		super.setResizable(false);

		b1 = new JButton("Login");
		b1.setBounds(200, 430, 150, 45);
		super.add(b1);
		b1.addActionListener(this);
		b2 = new JButton("Sign up");
		b2.setBounds(500, 430, 150, 45);
		super.add(b2);
		b2.addActionListener(this);

		t1 = new JTextField();
		t1.setBounds(350, 100, 250, 40);
		super.add(t1);
		t2 = new JPasswordField();
		t2.setBounds(350, 200, 250, 40);
		super.add(t2);

		l1 = new JLabel("Username: ");
		l1.setBounds(220, 100, 100, 40);
		super.add(l1);
		l2 = new JLabel("Password: ");
		l2.setBounds(220, 200, 100, 40);
		super.add(l2);
		
		super.setLayout(null);
		super.setVisible(true);
	}

	public static void main(String[] args) {
		new LoginDesktop();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			if (t1.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Email not entered");
			} else if (t2.getText().length() < 6) {
				JOptionPane.showMessageDialog(null, "Password should be minimum 6 characters long");
			} else {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
					PreparedStatement ps = c.prepareStatement("SELECT email,password FROM login WHERE email = ?");
					String s = t1.getText();
					ps.setString(1, s);
					int x = 0;
					ResultSet r = ps.executeQuery();
					while (r.next()) {
						x++;
					}
					ResultSet rs = ps.executeQuery();
					String pass = "";
					if (x != 0) {
						while (rs.next()) {
							pass = rs.getString("password");
						}
						if (!pass.equals(t2.getText())) {
							JOptionPane.showMessageDialog(null, "Password incorrect");
						} else {
							super.dispose();
							new Desktop();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Username not found");
					}
					c.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error: " + e2);
				}
			}
		} else if (e.getSource() == b2) {
			super.dispose();
			new RegisterUser();
		}
	}
}
