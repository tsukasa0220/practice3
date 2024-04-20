import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyTest extends JPanel
                     implements KeyListener {
    private int x = 50, y = 20;

    public KeyTest() {
        setPreferredSize(new Dimension(150, 150));
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("HELLO WORLD!", x, y);
    }

    public void keyTyped(KeyEvent e) {
        int k = e.getKeyChar();
        if (k == 'u') {
            y -= 10;
        } else if (k == 'd') {
            y += 10;
        } 
        System.err.printf("key = %d%n", k);
        repaint();
    }
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Key Test");
            frame.add(new KeyTest());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}