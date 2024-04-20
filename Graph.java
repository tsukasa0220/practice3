import java.awt.*;
import javax.swing.*;

public class Graph extends JPanel {
  public Graph() {
    setPreferredSize(new Dimension(200, 105));
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int[] is = {10, 4, 6, 2, 9, 1};
    Color[] cs = {Color.RED, Color.BLUE};
    int scale = 15;
    int i, n = is.length;

    for (i = 0; i < n; i++) {
      g.setColor(cs[i % cs.length]);
      g.fillRect(0, i * scale, is[i] * scale, scale);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("");
      frame.add(new Graph());
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}