import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SpaceShip extends JPanel implements Runnable {
    double x = 100, y = 100, dx = 1.618034 * 3, dy = 3;   // 初期値は変更しても良いようになっていること
    Thread thread = null;

    public SpaceShip() {
        setPreferredSize(new Dimension(200, 200));
        startThread();
    }

    public void startThread() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stopThread() {
        thread = null;
    }

    @Override
    public void run() {
        Thread me = Thread.currentThread();
        while (thread == me) {
            x += dx;
            y += dy;
            if (x > 200) x -= 200;
            else if (x < 0) x += 200;
            if (y > 200) y -= 200;
            else if (y < 0) y += 200;
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval((int)x, (int)y, 10, 10);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("SpaceShip!");
            frame.add(new SpaceShip());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}