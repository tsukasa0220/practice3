import javax.swing.*;
import java.awt.*;
import static java.lang.Math.*;

public class N_gon extends JPanel {
    public N_gon() {
        setPreferredSize(new Dimension(220, 220));
    }

    @Override  
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int np = 7;
        int sc = 100;

        int i;
        double theta1, theta2;
        for (i = 0; i < np; i++) {
            // 単位 ラジアン
            // 360 * i / np 度
            theta1 = PI * 2 * i / np;
            // 360 * (i + 1) / np 度
            theta2 = PI * 2 * (i + 1) / np; 
            g.drawLine(
                (int)(sc * (1.1 + cos(theta1))), 
                (int)(sc * (1.1 + sin(theta1))),
                (int)(sc * (1.1 + cos(theta2))),
                (int)(sc * (1.1 + sin(theta2))));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("正多角形");
            frame.add(new N_gon());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}