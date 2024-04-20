import java.awt.*;
import javax.swing.*;

public class Parabola extends JPanel {
    public Parabola() {
        setPreferredSize(new Dimension(200, 200));;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        double a = -0.0025, b = 1, c = 0;
        for (int x0 = 0; x0 < 200; x0 += 10) {
            double y0 = a * x0 * x0 + b * x0 + c;
            int x1 = x0 + 10;
            double y1 = a * x1 * x1 + b * x1 + c;
            g.drawLine(x0, (int)y0, x1, (int)y1);
            System.out.printf("(%d,%.1f)--(%d,%.1f)",
                              x0, y0, x1, y1);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("放物線");
            frame.add(new Parabola());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}