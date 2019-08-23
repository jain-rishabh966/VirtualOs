import java.awt.Font;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ManPage extends JFrame {
	private static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/man", "root", "root");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "An Error Occured.. Cant connect to MySql");
		}
		return c;
	}

	void showManPage(String s) {
		Connection c = ManPage.getConnection();
		int count = 0;
		List<String> l1 = null, l2 = null, l3 = null;
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM function WHERE name = ?");
			ps.setString(1, s);
			ResultSet rs = ps.executeQuery();
			l1 = new LinkedList<String>();
			l2 = new LinkedList<String>();
			l3 = new LinkedList<String>();
			while (rs.next()) {
				l1.add(rs.getString(2));
				l2.add(rs.getString(4));
				l3.add(rs.getString(3));
				count++;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "An Error Occured.. Cant traverse in ResultSet");
		}
		if (count == 0) {
			JOptionPane.showMessageDialog(null, "No such manual page found");
			return;
		}
		for (int i = 0; i < l1.size(); i++) {
			super.setTitle("Manual Page");
			super.setBounds(10, 10, 1400, 900);
			super.setResizable(false);
			Font f = new Font("", Font.BOLD, 25);
			JLabel l = new JLabel("Function name ->");
			l.setBounds(10, 10, 220, 40);
			l.setFont(f);
			super.add(l);
			l = new JLabel("Description ->");
			l.setBounds(10, 160, 200, 40);
			l.setFont(f);
			super.add(l);
			l = new JLabel("Arguments ->");
			l.setBounds(10, 400, 200, 40);
			l.setFont(f);
			super.add(l);
			l = new JLabel("Return Type ->");
			l.setBounds(10, 610, 200, 40);
			l.setFont(f);
			super.add(l);

			f = new Font("", Font.ITALIC, 25);
			JTextArea ar = new JTextArea();
			ar.setEditable(false);
			ar.setBounds(50, 240, 1300, 100);
			ar.setText(l1.get(i) + "  ");
			ar.setFont(f);
			super.add(ar);
			JScrollPane p = new JScrollPane(ar);
			p.setBounds(50, 240, 1300, 100);
			super.add(p);

			ar = new JTextArea();
			ar.setEditable(false);
			ar.setBounds(50, 450, 1300, 80);
			ar.setText(l3.get(i) + "  ");
			ar.setFont(f);
			super.add(ar);
			p = new JScrollPane(ar);
			p.setBounds(50, 450, 1300, 80);
			super.add(p);

			ar = new JTextArea();
			ar.setEditable(false);
			ar.setBounds(50, 660, 1300, 80);
			ar.setText(l2.get(i) + "  ");
			ar.setFont(f);
			super.add(ar);
			p = new JScrollPane(ar);
			p.setBounds(50, 660, 1300, 80);
			super.add(p);
			
			ar = new JTextArea();
			ar.setEditable(false);
			ar.setBounds(50, 60, 1300, 80);
			ar.setText(s+"  ");
			ar.setFont(f);
			super.add(ar);
			p = new JScrollPane(ar);
			p.setBounds(50, 60, 1300, 80);
			super.add(p);
			
			super.setLayout(null);
			super.setVisible(true);
		}
	}

	public static void main(String[] args) {
		new ManPage().showManPage("fork");
	}
}
