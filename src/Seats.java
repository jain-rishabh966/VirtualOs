import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class Seats extends JFrame implements ActionListener {
	JButton b1, b2, b3, b4;
	JLabel l1, l2, l3;
	String name, slot,user;
	int p, g, n;
	public Seats(String name, String slot,String user) {
		this.name = name;
		this.user=user;
		this.slot = slot;
		super.setBounds(50, 50, 900, 850);
		super.setTitle("Seat Booking");
		super.setResizable(false);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms", "root", "root");
			PreparedStatement ps = c
					.prepareStatement("SELECT normal,gold,platinum FROM booking where name = ? AND slot = ?");
			ps.setString(1, name);
			ps.setString(2, slot);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				p=rs.getInt("platinum");
				g=rs.getInt("gold");
				n=rs.getInt("normal");
			}
			
		} catch (Exception e) {
			System.out.println("Error: "+e);
		}
		Font f = new Font("Greek", Font.BOLD, 30);
		l1 = new JLabel("Select a category for movie ' " + name + " '");
		l1.setBounds(200, 100, 700, 35);
		l1.setFont(f);
		super.add(l1);
		f = new Font("Arial", Font.ITALIC, 27);
		l2 = new JLabel(slot);
		l2.setBounds(350, 200, 100, 35);
		l2.setFont(f);
		super.add(l2);
		b1 = new JButton("Normal");
		b1.setBounds(100, 430, 150, 45);
		super.add(b1);
		b1.addActionListener(this);
		b2 = new JButton("Gold");
		b2.setBounds(350, 430, 150, 45);
		super.add(b2);
		b2.addActionListener(this);
		b3 = new JButton("Platinum");
		b3.setBounds(600, 430, 150, 45);
		super.add(b3);
		b3.addActionListener(this);
		b4 = new JButton("Go Back");
		b4.setBounds(350, 620, 150, 45);
		super.add(b4);
		b4.addActionListener(this);
		l1 = new JLabel("Rs. 150");
		l1.setBounds(150, 500, 100, 35);
		super.add(l1);
		l2 = new JLabel("Rs. 200");
		l2.setBounds(400, 500, 100, 35);
		super.add(l2);
		l3 = new JLabel("Rs. 250");
		l3.setBounds(650, 500, 100, 35);
		super.add(l3);
		
		
		super.setLayout(null);
		super.setVisible(true);
	}

	/*public static void main(String[] args) {
		new Seats("IT", "12-3 pm","rishabh");
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		super.dispose();
		if (e.getSource() == b4) {
			new Details(name,user);
		} else if (e.getSource() == b1) {
			new Book(name,slot,"Normal",n,user);
		} else if (e.getSource() == b2) {
			new Book(name,slot,"Gold",g,user);
		} else if (e.getSource() == b3) {
			new Book(name,slot,"Platinum",p,user);
		}
	}
}
