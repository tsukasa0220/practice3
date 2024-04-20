import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;

public class Animal extends JPanel{
    public Animal() {
        setPreferredSize(new Dimension(200, 200));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(184, 134, 11));
        g.fillOval(60, 40, 20, 50);
        g.fillOval(120, 40, 20, 50);
        g.setColor(new Color(222, 184, 135));
        g.fillOval(50, 50, 100, 100); 
        g.setColor(BLACK);
        g.fillOval(70, 70, 20, 20);
        g.fillOval(110, 70, 20, 20);
        g.drawArc(80, 95, 20, 20, 180, 180); 
        g.drawArc(100, 95, 20, 20, 180, 180);
        g.fillOval(93, 95, 15, 10);
        g.drawString("わんわん！！", 20, 20);
        g.setColor(WHITE);
        g.fillOval(73, 73, 5, 5);
        g.fillOval(113, 73, 5, 5);
        g.setColor(RED);
        g.fillOval(60, 100, 15, 10);
        g.fillOval(126, 100, 15, 10);
        g.fillArc(92, 95, 15, 35, 180, 180);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Animal");
            frame.add(new Animal());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}