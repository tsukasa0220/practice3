import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Factorial extends JPanel
                       implements ActionListener {
  private JTextField input;
  private JLabel output;

  public Factorial() {
    setPreferredSize(new Dimension(300, 50));
    input = new JTextField("0", 8);
    output = new JLabel("   1");
    input.addActionListener(this);
    setLayout(new FlowLayout());
    add(input);  add(new JLabel("の階乗は"));
    add(output); add(new JLabel("です。"));
  }

  // factorial -- 階乗のこと
  private static int factorial(int n) {
    int r = 1;
    for (; n > 0; n--) {
      r *= n;
    }
    return r;
  }

  public void actionPerformed(ActionEvent e) {
    try {
      int n = Integer.parseInt(input.getText());
      /* ラベルの表示文字列の変更 */
      output.setText("  " + factorial(n));
    } catch (NumberFormatException ex) {
      input.setText("数値!");
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("階乗の計算");
      frame.add(new Factorial());
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}