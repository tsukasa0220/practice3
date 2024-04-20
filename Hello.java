import javax.swing.*;
import java.awt.*;


public class Hello extends JPanel {
    public Hello() {
        setPreferredSize(new Dimension(250, 50));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Дякую", 50, 25);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ありがとう");
            frame.add(new Hello());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        });
    }
}