import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Desktop extends JFrame implements ActionListener {

	JButton b1, b2, b3, b4, b5, b6, b7, b8;
	JLabel l;

	void newLabel(String s, int x, int y, int width, int height) {
		Font f = new Font("", Font.BOLD, 25);
		l = new JLabel(s);
		l.setFont(f);
		l.setBounds(x, y, width, height);
		super.add(l);
	}

	public Desktop() {
		super.setTitle("Desktop");
		super.setBounds(10, 10, 1800, 1000);
		super.setResizable(false);
		Date d1 = new Date();
		@SuppressWarnings("deprecation")
		String d = d1.toLocaleString();
		int n = d.lastIndexOf(":");
		d = d.substring(0, n) + d.substring(n + 4) + " IST";
		newLabel(d, 1450, 900, 400, 50);

		ImageIcon ic = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\ProjectPics\\Calculator.png");
		b1 = new JButton("Calculator");
		b1.setBounds(160, 100, 200, 230);
		b1.setIcon(ic);
		b1.addActionListener(this);
		newLabel("Calculator", 200, 330, 150, 50);
		super.add(b1);

		ic = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\ProjectPics\\Notepad.jpg");
		b2 = new JButton("Notepad");
		b2.setBounds(550, 100, 236, 230);
		b2.setIcon(ic);
		b2.addActionListener(this);
		newLabel("Notepad", 630, 330, 150, 50);
		super.add(b2);

		ic = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\ProjectPics\\scale.jpeg");
		b3 = new JButton("Line Plotter");
		b3.setBounds(960, 100, 300, 230);
		b3.setIcon(ic);
		b3.addActionListener(this);
		newLabel("Line Plotter", 1060, 330, 150, 50);
		super.add(b3);

		ic = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\ProjectPics\\terminal.png");
		b4 = new JButton("Terminal");
		b4.setBounds(160, 500, 215, 230);
		b4.setIcon(ic);
		b4.addActionListener(this);
		newLabel("Command Prompt", 160, 730, 215, 50);
		super.add(b4);

		ic = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\ProjectPics\\bms.jpg");
		b5 = new JButton("Notepad");
		b5.setBounds(550, 500, 236, 230);
		b5.setIcon(ic);
		b5.addActionListener(this);
		newLabel("Book My Show", 580, 730, 236, 50);
		super.add(b5);

		ic = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\ProjectPics\\Process.png");
		b6 = new JButton("Process Info");
		b6.setBounds(960, 500, 300, 230);
		b6.setIcon(ic);
		b6.addActionListener(this);
		newLabel("System Info", 1040, 730, 150, 50);
		super.add(b6);

		ic = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\ProjectPics\\wPr24iH2_400x400.png");
		b7 = new JButton("Man Page");
		b7.setBounds(1360, 100, 300, 230);
		b7.setIcon(ic);
		b7.addActionListener(this);
		newLabel("Man Page", 1460, 330, 150, 50);
		super.add(b7);
		
		ic = new ImageIcon("C:\\Users\\jainr\\Desktop\\Rishabh\\ProjectPics\\fnf.png");
		b8 = new JButton("Creation and Deletion");
		b8.setBounds(1360, 500, 300, 230);
		b8.setIcon(ic);
		b8.addActionListener(this);
		newLabel("Creation And Deletion", 1380, 730, 350, 50);
		super.add(b8);
		
		super.setLayout(null);
		super.setVisible(true);
	}

	public static void main(String[] args) {
		Desktop d = new Desktop();
		int c = 0;
		while (c != 1) {
			try {
				c++;
				Thread.sleep(1000 * 60);
				d.dispose();
				d = new Desktop();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// d.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			new NewCalc();
		} else if (e.getSource() == b2) {
			new Notepad();
		} else if (e.getSource() == b3) {
			new Points();
		} else if (e.getSource() == b4) {
			Runtime r = Runtime.getRuntime();
			try {
				r.exec("cmd /c start cmd.exe");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == b5) {
			new Login();
		} else if (e.getSource() == b6) {
			new AllProcesses();
		} else if (e.getSource() == b7) {
			new GetManPage().getPage();
		} else if (e.getSource() == b8) {
			new ChangeDirectory().getPage();
		}
	}
}
