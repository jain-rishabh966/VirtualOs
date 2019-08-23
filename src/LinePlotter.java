import javax.swing.*;

@SuppressWarnings("serial")
public class LinePlotter extends JFrame {
	JLabel l;

	int plot(int x1, int x2, int y1, int y2) {
		int dx = x2 - x1;
		int dy = y2 - y1;
		int steps = dx > dy ? dx : dy;
		double xi = dx / (double) steps;
		double yi = dy / (double) steps;
		double xx = x1;
		double yy = y1;
		int count = 0;
		for (int i = 0; i <= steps; i++) {
			l = new JLabel(".");
			l.setBounds((int) xx, (int) yy, 7, 7);
			super.add(l);
			xx += xi;
			yy += yi;
			count++;
		}
		return count;
	}

	public LinePlotter(int x1, int y1, int x2, int y2) {
		super.setTitle("DDA algo");
		super.setResizable(!false);

		int x = (x1 > x2 ? x1 : x2) + 100;
		int y = (y1 > y2 ? y1 : y2) + 100;

		super.setBounds(200, 200, x, y);
		int count = plot(x1, x2, y1, y2);
		if (count == 0) {
			plot(x2, x1, y2, y1);
		}
		super.setLayout(null);
		super.setVisible(true);
	}
}
