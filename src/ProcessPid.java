import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ProcessPid extends JFrame {
	public static List<String> listRunningProcesses() {
		List<String> processes = new ArrayList<String>();
		try {
			String line;
			Process p = Runtime.getRuntime().exec("tasklist.exe /fo csv /nh");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
				if (!line.trim().equals("")) {
					processes.add(line);
				}
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processes;
	}

	public ProcessPid() {
		int c = 0;
		String s = "Process Name -> Process ID\n\n";
		List<String> l = listRunningProcesses();
		super.setTitle("List All Processes");
		super.setResizable(false);
		super.setBounds(20, 20, 450, 900);
		for (String line : l) {
			line = line.substring(1);
			c++;
			s += c + ". " + line.substring(0, line.indexOf("\"")) + " -> ";
			line = line.substring(0, line.length() - 1);
			line = line.substring(line.indexOf("\"") + 1);
			line = line.substring(line.indexOf("\"") + 1);
			line = line.substring(0,line.indexOf("\""));
			s += line + "\n";
		}
		Font f = new Font("", Font.BOLD, 25);
		JLabel l1 = new JLabel("List Of Running Processes:");
		l1.setFont(f);
		l1.setBounds(20, 30, 400, 30);
		super.add(l1);
		f = new Font("", Font.ITALIC, 20);
		JTextArea t = new JTextArea();
		t.setBounds(20, 100, 300, 700);
		t.setEditable(false);
		t.setFont(f);
		t.setText(s);
		super.add(t);
		JScrollPane p = new JScrollPane(t);
		p.setBounds(20, 100, 400, 700);
		super.add(p);
		super.setLayout(null);
		super.setVisible(true);
	}
}

