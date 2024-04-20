import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LeftRightButton2 extends JPanel {
    private int x = 20;
    
    public LeftRightButton2() {
        setPreferredSize(new Dimension(200, 70));
        JButton lBtn = new JButton("Left");
        JButton rBtn = new JButton("Right");
        lBtn.addActionListener(new LeftListener());
        rBtn.addActionListener(new RightListener());
        setLayout(new FlowLayout());
        add(lBtn); add(rBtn);
    }

    private class LeftListener
            implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            x -= 10;
            repaint();
        }
    }

    private class RightListener
            implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            x += 10;
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("HELLO WORLD!", x, 55);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ボタン");
            frame.add(new LeftRightButton2());
            frame.pack();
            frame.setVisible(true);;
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}