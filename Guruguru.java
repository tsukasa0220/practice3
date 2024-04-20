import java.awt.*;
import javax.swing.*;

public class Guruguru extends JPanel
                      implements Runnable {
  private int r = 50;
  private volatile int x = 110, y = 70 ;
  private double theta = 0; // 角度
  private volatile Thread thread = null;

  public Guruguru() {
    setPreferredSize(new Dimension(200, 180));
    JButton startBtn = new JButton("start");
    startBtn.addActionListener(e -> startThread());
    JButton stopBtn = new JButton("stop");
    stopBtn.addActionListener(e -> stopThread());
    setLayout(new FlowLayout());
    add(startBtn); add(stopBtn);
    startThread();
  }
  
  private void startThread() {
    if (thread == null) {
      thread = new Thread(this);
      thread.start();
    }
  }
  
  private void stopThread() {
    thread = null;
  }

  @Override
  public void paintComponent(Graphics g) {
    // スーパークラスの paintComponent を呼び出す
    super.paintComponent(g); 
    // 全体を背景色で塗りつぶす。
    g.drawString("Hello, World!", x, y);
  }

  public void run() {
    Thread thisThread = Thread.currentThread();
    for (; thread == thisThread; theta += 0.02) {
      x =  60 + (int)(r * Math.cos(theta)); 
      y = 100 - (int)(r * Math.sin(theta));
      repaint(); // paintComponent を間接的に呼出す
      try {
        Thread.sleep(30); // 30 ミリ秒お休み
      } catch (InterruptedException e) {}
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("ぐるぐる!");
      frame.add(new Guruguru());
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}