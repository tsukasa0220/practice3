import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangeColor extends JPanel
                         implements ActionListener {
    private final Color[] cs = {
      Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE
    };
    private int i = 0;
    private JLabel label;
    
    public ChangeColor() {
        JButton b = new JButton("Next");
        b.addActionListener(this);          /* 1 */
        label = new JLabel("HELLO WORLD!"); 
        label.setForeground(cs[i]);/* 前景色の変更 */
        setLayout(new FlowLayout());        /* 2 */
        add(b); add(label);                 /* 3 */
    }
    
    public void actionPerformed(ActionEvent e) {
        i = (i + 1) % cs.length;
        label.setForeground(cs[i]);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Change Color");
            frame.add(new ChangeColor());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}