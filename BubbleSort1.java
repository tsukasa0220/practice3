import java.awt.*;
import javax.swing.*;

public class BubbleSort1 extends JPanel
                         implements Runnable {
  private int[] data = new int[12];
  private final Color[] cs = {
    Color.RED, Color.ORANGE, Color.GREEN, Color.BLUE};
  private volatile Thread thread = null;
  private int i, j;

  public BubbleSort1() {
    setPreferredSize(new Dimension(320, 250));
    startThread();
  }

  private void startThread() {
    if (thread == null) {
      thread = new Thread(this);
      thread.start();
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    int k;
    super.paintComponent(g);
    g.setColor(Color.YELLOW);
    g.fillOval(5, 50 + j * 10, 10, 10);
    g.setColor(Color.CYAN);
    g.fillOval(5, 50 + i * 10, 10, 10);
    for (k = 0; k < data.length; k++) {
      g.setColor(cs[k % cs.length]);
      g.fillRect(20, 50 + k * 10, data[k] * 5, 10);
    }
  }
  
  private void prepareRandomData() {
    int len = data.length;
    for (int k = 0; k < len; k++) {
      // 適当な範囲の乱数  
      data[k] = (int)(Math.random() * len * 4);  
    }
  }

  public void run() {
    while (true) {
      prepareRandomData();
      // バブルソートアルゴリズム
      for (i = 0; i < data.length - 1; i++) {
        for (j = data.length - 1; j > i; j--) {
          if (data[j - 1] > data[j]) { // スワップする。
            int tmp = data[j - 1];
            data[j - 1] = data[j];
            data[j] = tmp;
            repaint();
            try { // repaintの後でしばらく止まる
              Thread.sleep(2000);
            } catch (InterruptedException e) {}
          }
        }
      }
      try { // 並び換え完了後に長めに止まる
        Thread.sleep(5000);
      } catch (InterruptedException e) {}
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("バブルソート");
      frame.add(new BubbleSort1());
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}