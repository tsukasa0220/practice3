import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MouseDraw extends JPanel implements MouseListener {
    private ArrayList<int[]> points;

    public MouseDraw() {
        setPreferredSize(new Dimension(640, 640));
        points = new ArrayList<>();
        addMouseListener(this); 
    }

    public void mouseClicked(MouseEvent e) {
        points.add(new int[] { e.getX(), e.getY() });
        repaint();
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int i, n = points.size();
        for (i = 1; i < n; i++) {
            int[] p0 = points.get(i - 1);
            int[] p1 = points.get(i);
            g.drawLine(p0[0], p0[1], p1[0], p1[1]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Mouse Draw");
            frame.add(new MouseDraw());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}