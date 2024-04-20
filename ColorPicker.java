import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.*;

public class ColorPicker extends JPanel 
                        implements MouseListener {
  private int x = 0, y = 0;
	
	public ColorPicker() {
    setPreferredSize(new Dimension(256, 275));
    addMouseListener(this);
  }

	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
		return;
	}

	public void mousePressed(MouseEvent e) {}  /* 5 */
	public void mouseReleased(MouseEvent e) {} /* 5 */ 
	public void mouseEntered(MouseEvent e) {}  /* 5 */ 
	public void mouseExited(MouseEvent e) {}   /* 5 */ 
  
  @Override  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    int width = 256;
    int height = 256;
    float h, s;
    Color[][] colors = new Color[width][height];
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

		g.setColor(colors[x][y]);
		g.setFont(new Font("Arial", Font.PLAIN, 24));
		g.drawString("HELLO WORLD!", 30, 275);

  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Color Picker");
      frame.add(new ColorPicker());
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}