import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Points extends JFrame implements ActionListener {
	JLabel l;
	JTextField f1, f2, f3, f4;
	JButton b;
	int x1, x2, y1, y2;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b) {
			try {
				x1 = Integer.parseInt(f1.getText());
				y1 = Integer.parseInt(f2.getText());
				x2 = Integer.parseInt(f3.getText());
				y2 = Integer.parseInt(f4.getText());
				new LinePlotter(x1, y1, x2, y2);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
		}
	}

	public Points() {
		super.setTitle("Plot Points");
		super.setBounds(100, 100, 400, 700);
		super.setResizable(false);

		Font f = new Font("", Font.ITALIC, 20);

		l = new JLabel("Initial x : ");
		l.setBounds(20, 100, 100, 25);
		l.setFont(f);
		super.add(l);

		l = new JLabel("Initial y : ");
		l.setBounds(20, 200, 100, 25);
		l.setFont(f);
		super.add(l);

		l = new JLabel("Final x : ");
		l.setBounds(20, 300, 100, 25);
		l.setFont(f);
		super.add(l);

		l = new JLabel("Final y : ");
		l.setBounds(20, 400, 100, 25);
		l.setFont(f);
		super.add(l);

		f1 = new JTextField();
		f1.setBounds(200, 100, 100, 30);
		super.add(f1);

		f2 = new JTextField();
		f2.setBounds(200, 200, 100, 30);
		super.add(f2);

		f3 = new JTextField();
		f3.setBounds(200, 300, 100, 30);
		super.add(f3);

		f4 = new JTextField();
		f4.setBounds(200, 400, 100, 30);
		super.add(f4);

		b = new JButton("Submit");
		b.setBounds(150, 500, 100, 50);
		b.addActionListener(this);
		super.add(b);

		super.setLayout(null);
		super.setVisible(true);
	}

	public static void main(String[] args) {
		new Points();
	}
}
