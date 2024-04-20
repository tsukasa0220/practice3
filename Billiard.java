import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Billiard extends JPanel implements Runnable {
    double x = 10, y = 100, dx = 1.618034 * 3, dy = 10;
    Thread thread = null;

    public Billiard() {
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
            if (x > 190 || x < 0) dx *= -1;
            if (y > 190 || y < 0) dy *=-1;
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
            JFrame frame = new JFrame("Billiard!");
            frame.add(new Billiard());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}