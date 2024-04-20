import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;

public class ShapeTest extends JPanel {
    public ShapeTest() {
        setPreferredSize(new Dimension(200, 150));
    }

    @Override
    public void paintComponent(Graphics g) {
        // ((Graphics2D)g).setRenderingHint(
        //     RenderingHints.KEY_ANTIALIASING,
        //     RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g);
        int[] xs = {100, 137, 175, 175, 137, 100};
        int[] ys = {  0,   0,  25,  50,  50,  25};

        g.setColor(MAGENTA);
        g.drawLine(0, 0, 75, 50);
        g.setColor(BLUE);
        g.drawRect(0, 0, 75, 50);
        g.setColor(ORANGE);
        g.drawOval(0, 75, 75, 50);
        g.setColor(GREEN);
        g.drawPolygon(xs, ys, 6);
        g.setColor(CYAN);
        g.fillRect(110, 85, 75, 50);
        g.setColor(MAGENTA);
        g.fillRect(100, 75, 75, 50);
        g.setColor(YELLOW);
        g.fillRect(90, 65, 75, 50);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Graphics Sample!");
            frame.add(new ShapeTest());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}