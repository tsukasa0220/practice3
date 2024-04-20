import javax.swing.*;
import java.awt.*;
import java.awt.event.*;   /* 1 */

public class MouseTest extends JPanel
             implements MouseListener /* 2 */ {
    private int x = 50, y = 20;
    
    public MouseTest() {
        setPreferredSize(new Dimension(150, 150));
        addMouseListener(this);   /* 3 */
    }

    /* 4 */
    public void mouseClicked(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
        return;
    }

    public void mousePressed(MouseEvent e) {}  /* 5 */
    public void mouseReleased(MouseEvent e) {} /* 5 */ 
    public void mouseEntered(MouseEvent e) {}  /* 5 */ 
    public void mouseExited(MouseEvent e) {}   /* 5 */ 

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("HELLO WORLD!", x, y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mouse Test");
            frame.add(new MouseTest());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}