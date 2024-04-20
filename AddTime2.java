import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddTime2 extends JPanel
                      implements ActionListener {
    private JTextField input; // e.g. 2:45 1:25 3:34 
    private JLabel output;
    
    public AddTime2() {
        setPreferredSize(new Dimension(180, 150));
        input = new JTextField("1:23 4:56", 16);
        output = new JLabel("00:00");
        input.addActionListener(this);
        setLayout(new FlowLayout());
        add(input);
        add(new JLabel("の和は"));
        add(output);
        add(new JLabel("です。"));
    }
    
    // 時間の足し算を関数として定義する。
    private static int[] addTime(int[] t1, int[] t2) {
        // 時間を大きさ 2の配列で表す。
        int[] t3 = { t1[0] + t2[0], t1[1] + t2[1] };  

        if (t3[1] >= 60) { // 繰り上がりの処理
            t3[0]++;
            t3[1] -= 60;
        }
        return t3;  // 新しい配列を返す。
    }

    public void actionPerformed(ActionEvent e) {
        String[] args = input.getText().split("\\s+");

        int[] t = {0, 0};
        for (String s: args) {
            String[] stime = s.split(":");
            t = addTime(t, new int[] {
                    Integer.parseInt(stime[0]),
                    Integer.parseInt(stime[1])
                });
            // addTimeの呼出し前にその引数に入っていた
            // 配列は不要となる。あとで GC される。
        }
        output.setText(String.format("%02d:%02d",
                                     t[0], t[1]));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("時間の計算");
            frame.add(new AddTime2());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}