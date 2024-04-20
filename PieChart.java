import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import static java.awt.Color.*;

public class PieChart extends JPanel
                    implements ActionListener {
    private double[] is = {};
    private JTextField input;
    private final Color[] cs = {
        Color.RED, Color.BLUE
    };
    private final int scale = 15;
    
    public PieChart() {
        setPreferredSize(new Dimension(200, 240));
        input = new JTextField("", 16);
        input.addActionListener(this);
        setLayout(new FlowLayout());
        add(input);
    } 

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int i;
        int n = is.length;
        double sum = 0, tmp;
        g.setColor(BLACK);
        g.drawOval(10, 50, 180, 180);
        for (i = 0; i < n; i++) {
            sum +=is[i];
        }
        tmp = sum;
        for (i = n-1; i >= 0; i--) {
            if (i == n-1) {
                g.setColor(new Color(0,0,0,0));
            } else if (i%3 == 0) {
                g.setColor(MAGENTA);
            } else if (i%3 == 1) {
                g.setColor(YELLOW);
            } else {
                g.setColor(CYAN);
            }
            g.fillArc(10, 50, 180, 180, 90, (int)(360 * (tmp / -sum)));
            tmp -= is[i];
        }
    }

    public void actionPerformed(ActionEvent e) {
        String[] args = input.getText().split(" ");
        int n = args.length;
        is = new double[n];

        int i;
        for (i = 0; i < n; i++) {
            is[i] = Double.parseDouble(args[i]);
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("PieChart");
            frame.add(new PieChart());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}