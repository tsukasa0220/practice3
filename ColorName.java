import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class ColorName extends JPanel
    implements ActionListener {
    private HashMap<String, Color> hm;
    private JTextField input;

    public ColorName() {
        setPreferredSize(new Dimension(250, 120));
        // http://www.colordic.org/w/ より抜粋
        hm = new HashMap<>();
        hm.put("鴇", new Color(0xf7acbc)); 
        hm.put("赤", new Color(0xed1941));
        hm.put("朱", new Color(0xf26522));
        hm.put("桃", new Color(0xf58f98));
        hm.put("緋", new Color(0xaa2116));
        hm.put("肌", new Color(0xfedcbd));
        hm.put("橙", new Color(0xf47920)); 
        hm.put("褐", new Color(0x843900));
        hm.put("黄", new Color(0xffd400)); 
        hm.put("鶸", new Color(0xcbc547));
        hm.put("鶯", new Color(0x87943b));
        hm.put("緑", new Color(0x45b97c));
        hm.put("鉄", new Color(0x005344));
        hm.put("水", new Color(0xafdfe4));
        hm.put("青", new Color(0x009ad6));
        hm.put("藍", new Color(0x145b7d));
        hm.put("紺", new Color(0x003a6c));
        hm.put("菫", new Color(0x6ff0aa));
        hm.put("藤", new Color(0xafb4db));
        hm.put("紫", new Color(0x8552a1));
        hm.put("白", new Color(0xfffffb));
        hm.put("灰", new Color(0x77787b));
        hm.put("黒", new Color(0x130c0e));
        hm.put("紅", new Color(0xd7003a));
        input = new JTextField("紅 白 紺", 8);
        input.addActionListener(this);
        setLayout(new FlowLayout());
        add(input);
    }

    @Override
    public void paintComponent(Graphics g) {
        String text = input.getText();
        super.paintComponent(g);
        g.setFont(new Font("SansSerif",
                           Font.BOLD, 64));
        String[] colors = text.split("\\s+");
        for (int i = 0; i < colors.length; i++) {
            String c = colors[i];
            Color color = hm.get(c);
            if (color == null) {
                color = Color.BLACK;
            }
            g.setColor(color);
            g.drawString(c, 64 * i, 100);
        }
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("色の名前");
            frame.add(new ColorName());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}