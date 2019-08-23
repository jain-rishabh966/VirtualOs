import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Book extends JFrame implements ActionListener {
	String user,name, slot, type;
	int seats;
	JLabel l1, l2, l3;
	JTextField t1, t2;
	JButton b1, b2;
	
	public Book(String name, String slot, String type, int seats,String user) {
		this.name = name;
		this.slot = slot;
		this.seats = seats;
		this.type = type;
		this.user=user;
		super.setBounds(50, 50, 900, 750);
		super.setTitle("Book");
		super.setResizable(false);
		l1 = new JLabel(type.toUpperCase() + " :");
		l1.setBounds(10, 20, 200, 40);
		Font f = new Font("Gothic", Font.BOLD, 40);
		l1.setFont(f);
		super.add(l1);
		l2 = new JLabel("Seats - ");
		f = new Font("Roman", Font.ITALIC, 30);
		l2.setBounds(80, 150, 200, 30);
		l2.setFont(f);
		super.add(l2);
		l3 = new JLabel("Snacks - ");
		l3.setBounds(80, 300, 200, 30);
		l3.setFont(f);
		super.add(l3);
		l3 = new JLabel("Rs. 200 each");
		l3.setBounds(250, 300, 100, 30);
		super.add(l3);
		t1 = new JTextField();
		t1.setBounds(350, 150, 200, 30);
		super.add(t1);
		t2 = new JTextField();
		t2.setBounds(350, 300, 200, 30);
		super.add(t2);
		t2.addActionListener(this);

		b1 = new JButton("Pay");
		b1.setBounds(300, 450, 150, 30);
		super.add(b1);
		b1.addActionListener(this);
		b2 = new JButton("Go Back");
		b2.setBounds(300, 550, 150, 30);
		super.add(b2);
		b2.addActionListener(this);

		super.setLayout(null);
		super.setVisible(true);
		t1.setText("0");
		t2.setText("0");
	}

	/*public static void main(String[] args) {
		new Book("IT", "12-3 pm", "Normal", 50,"rishabh");
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		String s1 = t1.getText(), s2 = t2.getText();
		if (s1.equals("") || s2.equals("")) {
			JOptionPane.showMessageDialog(null, "No field can be left Empty");
		} else {
			if (e.getSource() == b1) {
				int tickets = Integer.parseInt(s1);
				@SuppressWarnings("unused")
				int snacks = Integer.parseInt(s2);
				if (type.equalsIgnoreCase("gold") && tickets > 20) {
					JOptionPane.showMessageDialog(null, "In Gold not more than 20 tickets can be booked at once");
				} else if (type.equalsIgnoreCase("platinum") && tickets > 5) {
					JOptionPane.showMessageDialog(null, "In Platinum not more than 5 tickets can be booked at once");
				} else if (seats < tickets){
					JOptionPane.showMessageDialog(null, "Not enough seats available");
				}
				else {
					super.dispose();
					new Bill(user,Integer.parseInt(s1),Integer.parseInt(s2),type,slot,name);
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms","root","root");
						Statement ps = c.createStatement();
						ps.executeUpdate("UPDATE booking SET "+type.toLowerCase()+" = "+(seats-tickets)+" WHERE name = '"+name+"' AND slot = '"+slot+"'");
					} catch (Exception e2) {
						System.out.println("Error"+e2);
					}
				}
			} else if (e.getSource() == b2) {
				super.dispose();
				new Seats(name, slot,user);
			}
		}

	}

}
