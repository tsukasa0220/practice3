import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.awt.Color.*;

public class OvalChanger extends JPanel
                     implements KeyListener {
    private int w = 50, h = 50;

    public OvalChanger() {
        setPreferredSize(new Dimension(300, 300));
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);validate();
        g.setColor(BLUE);
        g.fillOval(150-w/2, 150-h/2, w, h);
    }

    public void keyTyped(KeyEvent e) {
        int k = e.getKeyChar();
        switch (k) {
            case 't': h += 10; break;
            case 'T': h += 50; break;
            case 's': h -= 10; break;
            case 'S': h -= 50; break;
            case 'w': w += 10; break;
            case 'W': w += 50; break;
            case 'n': w -= 10; break;
            case 'N': w -= 50; break;
            default :          break;
        }
        System.err.printf("key = %d%n", k);
        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Oval Changer");
            frame.add(new OvalChanger());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}