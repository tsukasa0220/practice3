import javax.swing.*;
import java.awt.*;

public class Gradation1 extends JPanel {
  public Gradation1() {
    setPreferredSize(new Dimension(256, 40));
  }
  
  @Override  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int scale = 4;
    int i;

    for (i = 0; i < 64; i++) {
      g.setColor(new Color(i * 4, 0, 255 - i * 4));
      g.fillRect(i * scale, 0, scale, scale * 10);
    } 
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("グラデーション");
      frame.add(new Gradation1());
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}