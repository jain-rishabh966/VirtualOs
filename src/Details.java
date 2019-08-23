import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Details extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6;
	JButton b1, b2, b3, b4;
	String name,user;

	Details(String name,String user) {
		this.name = name;
		this.user = user;
		super.setBounds(50, 50, 1400, 850);
		super.setTitle("Movie : " + name);
		super.setResizable(false);
		Font f = new Font("Arial", Font.BOLD, 25);
		l1 = new JLabel("Movie name : ");
		l1.setFont(f);
		l1.setBounds(10, 10, 250, 30);
		super.add(l1);
		l2 = new JLabel("Starcast : ");
		l2.setFont(f);
		l2.setBounds(10, 110, 250, 30);
		super.add(l2);
		l3 = new JLabel("Duration : ");
		l3.setFont(f);
		l3.setBounds(10, 210, 250, 30);
		super.add(l3);
		l4 = new JLabel("Plot : ");
		l4.setFont(f);
		l4.setBounds(10, 310, 250, 30);
		super.add(l4);
		l5 = new JLabel("Director name : ");
		l5.setFont(f);
		l5.setBounds(10, 410, 250, 30);
		super.add(l5);
		l6 = new JLabel("Rating : ");
		l6.setFont(f);
		l6.setBounds(10, 510, 250, 30);
		super.add(l6);
		f = f.deriveFont(Font.ITALIC, 24);
		String starcast = "", duration = "", plot = "", director = "", rating = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms", "root", "root");
			PreparedStatement ps = c.prepareStatement("SELECT * FROM movies where name = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				starcast = rs.getString("starcast");
				duration = rs.getString("duration");
				plot = rs.getString("plot");
				director = rs.getString("director");
				rating = rs.getString("rating");
			}
		} catch (Exception e) {
			System.out.println("Error " + e);
		}
		l1 = new JLabel(name);
		l1.setFont(f);
		l1.setBounds(300, 10, 250, 30);
		super.add(l1);
		l2 = new JLabel(starcast);
		l2.setFont(f);
		l2.setBounds(300, 110, 750, 30);
		super.add(l2);
		l3 = new JLabel(duration);
		l3.setFont(f);
		l3.setBounds(300, 210, 750, 30);
		super.add(l3);
		l4 = new JLabel(plot);
		l4.setFont(f);
		l4.setBounds(200, 310, 1300, 30);
		super.add(l4);
		l5 = new JLabel(director);
		l5.setFont(f);
		l5.setBounds(300, 410, 250, 30);
		super.add(l5);
		l6 = new JLabel(rating);
		l6.setFont(f);
		l6.setBounds(300, 510, 250, 30);
		super.add(l6);

		b1 = new JButton("12 - 3 pm");
		b1.setBounds(200, 650, 150, 45);
		super.add(b1);
		b1.addActionListener(this);
		b2 = new JButton("3 - 6 pm");
		b2.setBounds(500, 650, 150, 45);
		super.add(b2);
		b2.addActionListener(this);
		b3 = new JButton("6 - 9 pm");
		b3.setBounds(800, 650, 150, 45);
		super.add(b3);
		b3.addActionListener(this);
		b4 = new JButton("Go Back");
		b4.setBounds(1100, 650, 150, 45);
		super.add(b4);
		b4.addActionListener(this);
		ImageIcon i;
		if (name.equalsIgnoreCase("Judwa 2")) {
			i = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\Studies\\j2.jpg");
			l1 = new JLabel("Judwa 2");
			l1.setBounds(1100, 30, 250, 260);
			l1.setIcon(i);
			super.add(l1);
		} else if (name.equalsIgnoreCase("IT")) {
			i = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\Studies\\ti.jpg");
			l1 = new JLabel("IT");
			l1.setBounds(1000, 30, 300, 260);
			l1.setIcon(i);
			super.add(l1);
		} else if (name.equalsIgnoreCase("Newton")) {
			i = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\Studies\\n.jpg");
			l1 = new JLabel("Newton");
			l1.setBounds(1050, 30, 330, 400);
			l1.setIcon(i);
			super.add(l1);

		}
		super.setLayout(null);
		super.setVisible(true);
	}

	/*public static void main(String[] args) {
		new Details("newton","rishabh");
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		super.dispose();
		if (e.getSource() == b1) {
			new Seats(name,"12-3 pm",user);
		} else if (e.getSource() == b2) {
			new Seats(name,"3-6 pm",user);
		} else if (e.getSource() == b3) {
			new Seats(name,"6-9 pm",user);
		} else {
			new Movies(user);
		}
	}
}
