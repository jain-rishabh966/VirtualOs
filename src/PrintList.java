import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PrintList extends JFrame {
	JLabel l1;
	JTextArea t;

	public PrintList(List<String> l, boolean b) {
		// true file, false directory
		super.setTitle("List All Files and Directories");
		super.setBounds(20, 20, 450, 900);
		super.setResizable(false);

		Font f = new Font("", Font.BOLD, 25);

		t = new JTextArea();
		t.setBounds(20, 100, 300, 700);
		t.setEditable(false);
		t.setFont(f);
		String s = "";
		for (String string : l) {
			s += string + "\n";
		}
		t.setText(s);
		super.add(t);
		JScrollPane p = new JScrollPane(t);
		p.setBounds(20, 100, 400, 700);
		super.add(p);

		l1 = new JLabel("List of " + (!b ? "Directories" : "Files") + " ->");
		l1.setFont(f);
		l1.setBounds(20, 30, 400, 30);
		super.add(l1);

		super.setLayout(null);
		super.setVisible(true);
	}
}
