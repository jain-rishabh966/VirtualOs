import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Bill extends JFrame implements ActionListener {
	JLabel l1, l2, l3, l4, l5, l6, l7, l8;
	JButton b1;

	public Bill(String user, int tickets, int snacks, String type, String slot, String movie) {
		super.setBounds(50, 50, 1000, 900);
		super.setTitle("Bill");
		super.setResizable(false);
		b1 = new JButton("OK");
		b1.setBounds(350, 800, 100, 30);
		super.add(b1);
		b1.addActionListener(this);
		Font f = new Font("Gothic", Font.BOLD, 24);
		l1 = new JLabel("Movie: ");
		l1.setFont(f);
		l1.setBounds(250, 10, 200, 30);
		super.add(l1);
		l2 = new JLabel("Show time: ");
		l2.setFont(f);
		l2.setBounds(250, 110, 200, 30);
		super.add(l2);
		l3 = new JLabel("Name: ");
		l3.setFont(f);
		l3.setBounds(250, 210, 200, 30);
		super.add(l3);
		l4 = new JLabel("Email: ");
		l4.setFont(f);
		l4.setBounds(250, 310, 200, 30);
		super.add(l4);
		l5 = new JLabel("Phone Number : ");
		l5.setFont(f);
		l5.setBounds(250, 410, 200, 30);
		super.add(l5);
		l6 = new JLabel("No. of seats: ");
		l6.setFont(f);
		l6.setBounds(250, 510, 200, 30);
		super.add(l6);
		l7 = new JLabel("Cost: ");
		l7.setFont(f);
		l7.setBounds(250, 610, 200, 30);
		super.add(l7);
		l8 = new JLabel("Total Cost: ");
		l8.setFont(f);
		l8.setBounds(250, 710, 200, 30);
		super.add(l8);

		f = new Font("Gothic", Font.ITALIC, 24);
		l1 = new JLabel(movie);
		l1.setFont(f);
		l1.setBounds(500, 10, 200, 30);
		super.add(l1);
		l2 = new JLabel(slot);
		l2.setFont(f);
		l2.setBounds(500, 110, 200, 30);
		super.add(l2);
		String name = "", phno = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms", "root", "root");
			PreparedStatement ps = c.prepareStatement("SELECT name,number FROM login where email = ?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
				phno = rs.getString("number");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

		l3 = new JLabel(name);
		l3.setFont(f);
		l3.setBounds(500, 210, 200, 30);
		super.add(l3);
		l4 = new JLabel(user);
		l4.setFont(f);
		l4.setBounds(500, 310, 200, 30);
		super.add(l4);
		l5 = new JLabel(phno);
		l5.setFont(f);
		l5.setBounds(500, 410, 200, 30);
		super.add(l5);
		l6 = new JLabel(String.valueOf(tickets));
		l6.setFont(f);
		l6.setBounds(500, 510, 200, 30);
		super.add(l6);
		String s = "";
		int n=0;
		if (type.equalsIgnoreCase("normal")) {
			n = 150 * tickets;
			s = String.valueOf(n);
		} else if (type.equalsIgnoreCase("gold")) {
			n = 200 * tickets;
			s = String.valueOf(n);
		} else if (type.equalsIgnoreCase("platinum")) {
			n = 250 * tickets;
			s = String.valueOf(n);
		}
		s=s.concat(" +28% GST and "+(snacks*200)+" +18%GST");
		l7 = new JLabel(s);
		l7.setFont(f);
		l7.setBounds(500, 610, 400, 30);
		super.add(l7);
		
		n += (n*0.28) + ((snacks*200)*0.18) + (snacks*200);
		l8 = new JLabel("Rs. "+n);
		l8.setFont(f);
		l8.setBounds(500, 710, 200, 30);
		super.add(l8);

		super.setLayout(null);
		super.setVisible(true);
	}

	/*public static void main(String[] args) {
		new Bill("jain@gmail.com", 1, 1, "normal", "12-3 pm", "IT");
	}*/
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			super.dispose();
		}

	}
}
