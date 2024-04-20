import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.Color.*;

public class SimplePieChart extends JPanel
                       implements ActionListener {
  private JTextField input;
	private double r = 0;

  public SimplePieChart() {
    setPreferredSize(new Dimension(200, 240));
    input = new JTextField("0", 20);
    input.addActionListener(this);
    setLayout(new FlowLayout());
    add(input);
  }

  @Override
  public void paintComponent(Graphics g) {
      super.paintComponent(g);validate();
      g.setColor(BLUE);
			g.drawOval(10, 50, 180, 180);
      g.fillArc(10, 50, 180, 180, 90, (int)(360 * r / -100));
  }

  public void actionPerformed(ActionEvent e) {
    try {
      r = Double.parseDouble(input.getText());
			if (r < 0 || r > 100) {
				r = 0;
				input.setText("0~100で入力");
			}
      repaint();
    } catch (NumberFormatException ex) {
      input.setText("0~100で入力");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Simple Pie Chart");
      frame.add(new SimplePieChart());
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}