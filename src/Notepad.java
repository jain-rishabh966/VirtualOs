import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Notepad extends JFrame implements ActionListener {
	JButton b1, b2, b3;
	JTextArea area;
	JTextField t1, t2;
	JLabel l1, l2, l3;
	JScrollPane p;

	public Notepad() {
		super.setBounds(30, 15, 900, 1000);
		super.setTitle("My Notepad");
		super.setResizable(false);
		Font f = new Font("", Font.PLAIN, 20);
		b1 = new JButton("Browse");
		b1.setBounds(100, 800, 150, 45);
		super.add(b1);
		b1.addActionListener(this);
		b2 = new JButton("Update");
		b2.setBounds(350, 800, 150, 45);
		super.add(b2);
		b2.addActionListener(this);
		b3 = new JButton("Compile & Execute");
		b3.setBounds(600, 800, 150, 45);
		super.add(b3);
		b3.addActionListener(this);

		area = new JTextArea();
		area.setFont(f);
		area.setBounds(160, 250, 550, 500);
		super.add(area);

		p = new JScrollPane(area);
		p.setBounds(160, 250, 550, 500);
		super.add(p);

		l1 = new JLabel("Directory : ");
		l1.setBounds(50, 50, 100, 30);
		super.add(l1);
		l2 = new JLabel("File name : ");
		l2.setBounds(50, 150, 100, 30);
		super.add(l2);
		l3 = new JLabel("Content : ");
		l3.setBounds(50, 250, 100, 30);
		super.add(l3);

		t1 = new JTextField();
		t1.setBounds(160, 50, 550, 40);
		super.add(t1);
		t2 = new JTextField();
		t2.setBounds(160, 150, 550, 40);
		super.add(t2);

		super.setLayout(null);
		super.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			FileDialog f = new FileDialog(this, "Searching File", FileDialog.LOAD);
			f.setVisible(true);
			String s1 = f.getDirectory();
			String s2 = f.getFile();
			t1.setText(s1);
			t2.setText(s2);
			try {
				FileInputStream fis = new FileInputStream(s1 + s2);
				String str = "";
				while (true) {
					int temp = fis.read();
					if (temp == -1) {
						break;
					}
					str += (char) temp;
				}
				area.setText(str);
				fis.close();
			} catch (Exception e2) {
			}
		} else if (e.getSource() == b2) {
			FileDialog f = new FileDialog(this, "Saving File", FileDialog.SAVE);
			f.setVisible(true);
			String s1 = f.getDirectory();
			String s2 = f.getFile();
			t1.setText(s1);
			t2.setText(s2);
			try {
				FileOutputStream fos = new FileOutputStream(s1 + s2);
				String str = area.getText();
				fos.write(str.getBytes());
				fos.close();
			} catch (Exception e2) {
			}
		} else if (e.getSource() == b3) {
			Runtime r = Runtime.getRuntime();
			try {
				String s1 = t1.getText();
				String s2 = t2.getText();
				File f = new File(s1);
				if (s1.trim().equals("") || s2.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter a Path and a Filename");
					return;
				} else if (!s2.trim().endsWith(".c")) {
					JOptionPane.showMessageDialog(null, "Only valid for C programs! Pleses select another one!");
					t2.setText("");
					return;
				} else if (!f.exists()) {
					JOptionPane.showMessageDialog(null, "Path does not exist!");
					return;
				}
				r.exec("gcc -o "+ s2.substring(0, s2.trim().lastIndexOf(".")) +" "+ s2, null, f);
				JOptionPane.showMessageDialog(null, "Compiled " + s2 + "!");
				r.exec("cmd /c start "+s2.substring(0, s2.trim().lastIndexOf("."))+".exe", null, f);
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

	public static void main(String[] args) {
		new Notepad();
	}
}


//s2.substring(0, s2.trim().length() - 2)