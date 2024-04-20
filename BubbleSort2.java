import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class BubbleSort2 extends JPanel 
             implements Runnable, ActionListener {
  /* フィールドは、ほとんど BubbleSort1 と同じ */ 
  private int[] args = new int[12];
  private final Color[] cs = {Color.RED, Color.ORANGE, Color.GREEN, Color.BLUE};
  private volatile Thread thread = null;
  private int i, j;

  /* 追加のフィールド */  
  private volatile boolean threadSuspended = true; 
  
  public BubbleSort2() {
    setPreferredSize(new Dimension(320, 250));
    JButton step = new JButton("Step");
    step.addActionListener(this);
    setLayout(new FlowLayout());
    add(step);
    startThread();
  }
  /* startTread は BubbleSort1 と同じ */
  private void startThread() {
    if (thread == null) {
      thread = new Thread(this);
      thread.start();
    }
  }

  public void run() {
    while(true) {
      prepareRandomData();
      // バブルソートアルゴリズム
      for (i = 0; i < args.length - 1; i++) {
        for (j = args.length - 1; j > i; j--) {
          if (args[j - 1] > args[j]) { // スワップする。
            int tmp = args[j - 1];
            args[j - 1] = args[j];
            args[j] = tmp;
          }
          repaint();
          /* repaint の後で止まる */
          try {
            synchronized (this) {
              while (threadSuspended) {
                wait();
              }
              threadSuspended = true;
            }
          } catch (InterruptedException e) {}
        }
      }
    }
  }

  public synchronized void actionPerformed(ActionEvent e) {
    threadSuspended = false;
    notify();
  }
  /* paintComponent, main などは BubbleSort1 と同じ */

  @Override
  public void paintComponent(Graphics g) {
    int k;
    
    super.paintComponent(g);
    g.setColor(Color.YELLOW);
    g.fillOval(5, 50 + j * 10, 10, 10);
    g.setColor(Color.CYAN);
    g.fillOval(5, 50 + i * 10, 10, 10);
    for (k = 0; k < args.length; k++) {
      g.setColor(cs[k % cs.length]);
      g.fillRect(20, 50 + k * 10, args[k] * 5, 10);
    }
  }

  private void prepareRandomData() {
    int len = args.length;
    for (int k = 0; k < len; k++) { 
      args[k] = (int)(Math.random() * len * 4);  // 適当な範囲の乱数
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("バブルソート");
      frame.add(new BubbleSort2());
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}