import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;

public class HSBGradation extends JPanel {
  public HSBGradation() {
    setPreferredSize(new Dimension(256, 256));
  }
  
  @Override  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    int width = getWidth();
    int height = getHeight();
    float h, s;
    Color[][] colors = new Color[width][height];
    for (int i = 0; i < width; i++) {
      h = (float) i / (float) width;
      for (int j = 0; j < height; j++) {
        s = (float) j / (float) height;
        colors[i][j] = Color.getHSBColor(h, s, 1f);
      }
    }
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        g.setColor(colors[i][j]);
        g.fillRect(i, j, 1, 1);
      }
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("HSBグラデーション");
      frame.add(new HSBGradation());
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}