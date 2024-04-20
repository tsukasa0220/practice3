import javax.swing.*;
import java.awt.*;

public class Othello extends JPanel {
  private final int scale = 40;
  private final int space = 3;

  public Othello() {
    setPreferredSize(new Dimension(scale * 8 + 1,
                                   scale * 8 + 1));
  }

  @Override  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    int[][] state = {
        {0,1,0,0,1,2,2,2}, {2,2,1,1,1,1,2,0}, 
        {0,0,0,2,2,2,1,1}, {1,1,1,0,2,2,0,2}, 
        {1,2,1,0,0,0,0,0}, {0,0,0,1,1,2,2,2},
        {2,1,0,0,0,2,2,2}, {2,2,2,2,0,0,0,0}};
    int i, j;

    for (i = 0; i < 8; i++) {
      for (j = 0; j < 8; j++) {
        g.setColor(Color.GREEN);
        g.fillRect(i * scale, j * scale,
                   scale, scale);
        g.setColor(Color.BLACK);
        g.drawRect(i * scale, j * scale,
                   scale, scale);
        if (state[i][j] == 1) {
          g.setColor(Color.WHITE);
          g.fillOval(i * scale + space,
                     j * scale + space,
                     scale - space * 2,
                     scale - space * 2);
        } else if (state[i][j] == 2) {
          g.setColor(Color.BLACK);
          g.fillOval(i * scale + space,
                     j * scale + space,
                     scale - space * 2,
                     scale - space * 2);
        }
      } 
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("オセロ");
      frame.add(new Othello());
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}