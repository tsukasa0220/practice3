import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter4 extends JPanel {
	private String[] units = {"USD", "EUR", "GBP", "CHF", "CNY"};
	private int currentIdxUnit = 0;

	public CurrencyConverter4() {
		setPreferredSize(new Dimension(350, 40));
    JTextField input1 = new JTextField("0", 9);
		JTextField input2 = new JTextField("0.00", 9);
    JLabel output = new JLabel(units[currentIdxUnit]);
		JButton chgBtn = new JButton("Change!");
		input1.addActionListener(e -> { 
			try {
				double n = Double.parseDouble(input1.getText());
				switch (currentIdxUnit) {
					case 0: n /= 138.57; break;
					case 1: n /= 149.74; break;
					case 2: n /= 172.26; break;
					case 3: n /= 154.17; break;
					case 4: n /= 19.66;  break;
				}
				input2.setText(String.format("%.2f", n));
			} catch (NumberFormatException ex) {
				input2.setText("ERROR!");
			}
		});
		input2.addActionListener(e -> {
			try {
				double n = Double.parseDouble(input2.getText());
				switch (currentIdxUnit) {
					case 0: n *= 138.57; break;
					case 1: n *= 149.74; break;
					case 2: n *= 172.26; break;
					case 3: n *= 154.17; break;
					case 4: n *= 19.66;  break;
				}
				input1.setText(String.format("%d", (int)n));
			} catch (NumberFormatException ex) {
				input1.setText("ERROR!");
			}
		});
		chgBtn.addActionListener(e -> {
			currentIdxUnit = (currentIdxUnit + 1 ) % 5;
			output.setText(units[currentIdxUnit]);
			try {
				double n = Double.parseDouble(input1.getText());
				switch (currentIdxUnit) {
					case 0: n /= 138.57; break;
					case 1: n /= 149.74; break;
					case 2: n /= 172.26; break;
					case 3: n /= 154.17; break;
					case 4: n /= 19.66;  break;
				}
				input2.setText(String.format("%.2f", n));
			} catch (NumberFormatException ex) {
				input2.setText("ERROR!");
			}
		}); 
    setLayout(new FlowLayout());
    add(input1);  
		add(new JLabel("JPN = "));
		add(input2);
    add(output); 
		add(chgBtn);
	}

	
	public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("通貨レート計算");
      frame.add(new CurrencyConverter4());
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}
