import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Movies extends JFrame implements ActionListener {
	JButton b1, b2, b3,b4;
	JLabel l;
	String name;
	public Movies(String name) {
		this.name = name;
		super.setBounds(50, 50, 900, 850);
		super.setTitle("Movies");
		super.setResizable(false);
		ImageIcon ic = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\Studies\\1.jpg");
		b1 = new JButton("Preview not available for Judwa 2");
		b1.setBounds(160, 100, 380, 230);
		b1.setIcon(ic);
		super.add(b1);
		b1.addActionListener(this);
		ic = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\Studies\\Newton.jpg");
		b2 = new JButton("Preview not available for Newton");
		b2.setBounds(160, 400, 550, 180);
		b2.setIcon(ic);
		super.add(b2);
		b2.addActionListener(this);
		b3 = new JButton("Preview not available for IT");
		b3.setBounds(160, 630, 270, 170);
		ic = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\Studies\\IT.jpeg");
		b3.setIcon(ic);
		super.add(b3);
		b3.addActionListener(this);
		b4 = new JButton("Logout");
		b4.setBounds(700, 20, 100, 50);
		super.add(b4);
		b4.addActionListener(this);
		l = new JLabel("Pick a movie you want to watch!");
		Font f = new Font("Impact", Font.BOLD, 30);
		l.setFont(f);
		l.setBounds(160, 10, 600, 60);
		super.add(l);
		super.setLayout(null);
		super.setVisible(true);
	}

	/*public static void main(String[] args) {
		new Movies("rishabh");
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		if (e.getSource() == b1) {
			new Details("Judwa 2",name);
		} else if (e.getSource() == b2) {
			new Details("Newton",name);
		} else if (e.getSource() == b3) {
			new Details("IT",name);
		} else {
			new Login();
		}
	}
}
