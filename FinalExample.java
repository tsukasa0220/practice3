import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinalExample extends JPanel {
   private static final Color[] colors = {
       Color.RED, Color.GREEN, Color.BLUE};
   private int c = 0;
   
   public FinalExample() {
      setPreferredSize(new Dimension(200, 70));
      JButton button  = new JButton("Push");
      button.setForeground(colors[c]);
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            c = (c + 1) % colors.length;
            button.setForeground(colors[c]);
         }
      });
      setLayout(new FlowLayout());
      add(button); 
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
         JFrame frame = new JFrame("Final Example");
         frame.add(new FinalExample());
         frame.pack();
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      });
   }
}