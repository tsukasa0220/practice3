import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import static java.awt.Color.*;

public class ColorPickerDraw extends JPanel implements MouseListener {
    private ArrayList<int[]> points;
    private ArrayList<Color[]> colorss;
    private int x = 255, y = 255;
    private Color[][] colors = new Color[256][256];

    public ColorPickerDraw() {
        setPreferredSize(new Dimension(512, 256));
        points = new ArrayList<>();
        colorss = new ArrayList<>();
        addMouseListener(this); 
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getX() >= 256 || e.getY() >= 256) {
            points.add(new int[] { e.getX(), e.getY() }); 
            colorss.add(new Color[] {colors[x][y]});   
        } else {
            x = e.getX();
            y = e.getY();   
        }
        repaint();
    }

    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = 256;
        int height = 256;
        float h, s;
        for (int i = 0; i < width; i++) {
          h = (float) i / (float) width;
          for (int j = 0; j < height; j++) {
            s = (float) j / (float) height;
            colors[i][j] = Color.getHSBColor(h, s, 1f);
          }
        }
        for (int i = 0; i < width; i++) {
          for (int j = 0; j < height; j++) {
            g.setColor(colors[i][j]);
            g.fillRect(i, j, 1, 1);
          }
        }

        int i, n = points.size();
        for (i = 1; i < n; i++) {
            int[] p0 = points.get(i - 1);
            int[] p1 = points.get(i);
            Color[] color = colorss.get(i);
            g.setColor(color[0]);
            g.drawLine(p0[0], p0[1], p1[0], p1[1]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("ColorPickerDraw");
            frame.add(new ColorPickerDraw());
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}