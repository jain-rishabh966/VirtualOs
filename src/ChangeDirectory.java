import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ChangeDirectory extends JFrame implements ActionListener {
	JButton b1, b2, b3;
	JTextField tf1, tf2;

	void getPage() {
		super.setTitle("Create and Delete Files/Directories");
		super.setBounds(10, 10, 1000, 800);
		super.setResizable(false);

		Font f = new Font("", Font.ITALIC, 25);

		JLabel l = new JLabel("Enter Directory:");
		l.setBounds(100, 100, 400, 50);
		l.setFont(f);
		super.add(l);
		tf1 = new JTextField();
		tf1.setBounds(400, 100, 400, 50);
		tf1.setFont(f);
		tf1.setText("C:/");
		super.add(tf1);
		l = new JLabel("Enter File/directory Name : ");
		l.setBounds(100, 300, 400, 50);
		l.setFont(f);
		super.add(l);
		tf2 = new JTextField();
		tf2.setBounds(400, 300, 400, 50);
		tf2.setFont(f);
		super.add(tf2);

		b1 = new JButton("Make File");
		b1.setBounds(150, 500, 150, 50);
		b1.addActionListener(this);
		super.add(b1);

		b2 = new JButton("Make Folder(s)");
		b2.setBounds(400, 500, 150, 50);
		b2.addActionListener(this);
		super.add(b2);

		b3 = new JButton("Delete");
		b3.setBounds(650, 500, 150, 50);
		b3.addActionListener(this);
		super.add(b3);

		super.setLayout(null);
		super.setVisible(true);
	}

	public static void main(String[] args) {
		new ChangeDirectory().getPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String path = tf1.getText() + (tf1.getText().endsWith("/") ? "" : "/") + tf2.getText();
		File f = new File(tf1.getText());
		if (!f.exists()) {
			JOptionPane.showMessageDialog(null, "Invalid path!");
			return;
		} else if ((f = new File(path)).exists()) {
			if(e.getSource() == b3){
				f.delete();
				JOptionPane.showMessageDialog(null, "File Deleted");
				return;
			}
			JOptionPane.showMessageDialog(null, "File Could not be Deleted!");
			return;
		}
		try {
			if (e.getSource() == b1) {
				f.createNewFile();
				JOptionPane.showMessageDialog(null, "File Created");
				return;
			} else if (e.getSource() == b2) {
				f.mkdirs();
				JOptionPane.showMessageDialog(null, "Dirctory created");
				return;
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			return;
		}
	}
}