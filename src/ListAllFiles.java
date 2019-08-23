import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ListAllFiles extends JFrame implements ActionListener {
	JLabel l;
	JTextField f;
	JButton b1, b2;

	public ListAllFiles() {
		super.setTitle("List All Files and Directories");
		super.setBounds(100, 100, 700, 500);
		super.setResizable(false);

		Font f1 = new Font("", Font.BOLD, 28);
		l = new JLabel("Enter the path: ");
		l.setFont(f1);
		l.setBounds(30, 80, 230, 30);
		super.add(l);

		f1 = new Font("", Font.ITALIC, 20);

		f = new JTextField();
		f.setFont(f1);
		f.setBounds(260, 80, 400, 40);
		f.setText("C:/");
		super.add(f);

		b1 = new JButton("List All Files");
		b1.setFont(f1);
		b1.setBounds(100, 200, 200, 40);
		b1.addActionListener(this);
		super.add(b1);

		b2 = new JButton("List All Directories");
		b2.setFont(f1);
		b2.setBounds(400, 200, 200, 40);
		b2.addActionListener(this);
		super.add(b2);

		super.setLayout(null);
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		File a = null;
		try {
			a = new File(f.getText());
			File[] b = a.listFiles();
			String s = "";
			List<String> l = new LinkedList<String>();
			for (File file : b) {
				if (e.getSource() == b1) {
					if (file.isFile()) {
						s = file.getName();
					}
				} else {
					if (file.isDirectory()) {
						s = file.getName();
					}
				}
				if (!l.contains(s)) {
					l.add(s);
				}
			}
			new PrintList(l, e.getSource() == b1);
		} catch (Exception e2) {
			if (f.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter a Path");
				return;
			}
			JOptionPane.showMessageDialog(null, "Path is unaccessable! Please try another one");
			return;
		}
	}

	public static void main(String[] args) {
		new ListAllFiles();
	}
}
