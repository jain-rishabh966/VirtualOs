import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GetManPage extends JFrame implements ActionListener {
	JButton b;
	JTextField tf;

	void getPage() {
		super.setTitle("Manual Page");
		super.setBounds(10, 10, 1000, 600);
		super.setResizable(false);

		Font f = new Font("", Font.ITALIC, 25);

		JLabel l = new JLabel("Search man page of :");
		l.setBounds(100, 100, 400, 50);
		l.setFont(f);
		super.add(l);
		tf = new JTextField();
		tf.setBounds(400, 100, 400, 50);
		tf.setFont(f);
		super.add(tf);
		b = new JButton("Submit");
		b.setBounds(400, 300, 200, 70);
		b.addActionListener(this);
		super.add(b);
		super.setLayout(null);
		super.setVisible(true);
	}

	public static void main(String[] args) {
		new GetManPage().getPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b) {
			new ManPage().showManPage(tf.getText());
		}
	}
}