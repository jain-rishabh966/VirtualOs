import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class AllProcesses extends JFrame implements ActionListener {

	JButton b1, b2, b3, b4, b5, b6;
	JLabel l;

	void newLabel(String s, int x, int y, int width, int height) {
		Font f = new Font("", Font.BOLD, 20);
		l = new JLabel(s);
		l.setFont(f);
		l.setBounds(x, y, width, height);
		super.add(l);
	}

	public AllProcesses() {
		super.setTitle("All Process Menu");
		super.setBounds(10, 10, 1400, 900);
		super.setResizable(false);

		ImageIcon ic = new ImageIcon("ram.jpg");
		b1 = new JButton("Process with Memory Allotment");
		b1.setBounds(100, 100, 300, 230);
		b1.setIcon(ic);
		b1.addActionListener(this);
		newLabel("Process with Memory Allocation", 100, 330, 320, 50);
		super.add(b1);

		ic = new ImageIcon("processId.jpg");
		b2 = new JButton("Process with Process ID");
		b2.setBounds(560, 100, 300, 230);
		b2.setIcon(ic);
		b2.addActionListener(this);
		newLabel("Process with PID", 630, 330, 300, 50);
		super.add(b2);

		ic = new ImageIcon("service.jpg");
		b3 = new JButton("All Services");
		b3.setBounds(100, 500, 300, 230);
		b3.setIcon(ic);
		b3.addActionListener(this);
		newLabel("All Services", 200, 730, 250, 50);
		super.add(b3);

		ic = new ImageIcon("console.jpg");
		b4 = new JButton("All Consoles");
		b4.setBounds(560, 500, 300, 230);
		b4.setIcon(ic);
		b4.addActionListener(this);
		newLabel("All Consoles", 650, 730, 300, 50);
		super.add(b4);

		ic = new ImageIcon("monitorSecurity.png");
		b5 = new JButton("Resource Monitor");
		b5.setBounds(1020, 100, 300, 230);
		b5.setIcon(ic);
		b5.addActionListener(this);
		newLabel("Resource Monitor", 1100, 330, 300, 50);
		super.add(b5);

		ic = new ImageIcon("Folder.png");
		b6 = new JButton("List Content");
		b6.setBounds(1020, 500, 300, 230);
		b6.setIcon(ic);
		b6.addActionListener(this);
		newLabel("List Content", 1100, 730, 300, 50);
		super.add(b6);

		super.setLayout(null);
		super.setVisible(true);
	}

	public static void main(String[] args) {
		new AllProcesses();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			new Processes();
		} else if (e.getSource() == b2) {
			new ProcessPid();
		} else if (e.getSource() == b3) {
			new ListServices();
		} else if (e.getSource() == b4) {
			new ListConsole();
		} else if (e.getSource() == b5) {
			Runtime r = Runtime.getRuntime();
			try {
				r.exec("resmon");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,
						"Resource Monitor currently not available.. Please try again later");
			}
		} else if (e.getSource() == b6) {
			new ListAllFiles();
		}
	}
}
