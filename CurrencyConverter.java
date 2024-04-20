import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JPanel
                               implements ActionListener {
  private JTextField input1, input2;
  private JLabel output;
	private JButton chgBtn;
	private String[] units = {"USD", "EUR", "GBP", "CHF", "CNY"};
	private int currentIdxUnit = 0;

	public CurrencyConverter() {
		setPreferredSize(new Dimension(350, 40));
    input1 = new JTextField("0", 9);
		input2 = new JTextField("0.00", 9);
    output = new JLabel(units[currentIdxUnit]);
		chgBtn = new JButton("Change!");
    input1.addActionListener(this);
		input2.addActionListener(this);
		chgBtn.addActionListener(this);
    setLayout(new FlowLayout());
    add(input1);  
		add(new JLabel("JPN = "));
		add(input2);
    add(output); 
		add(chgBtn);
	}

  private static double currencyConverter(double n, int currentIdxUnit, int select) {
		if (select == 1) {
			switch (currentIdxUnit) {
				case 0: n /= 138.57; break;
				case 1: n /= 149.74; break;
				case 2: n /= 172.26; break;
				case 3: n /= 154.17; break;
				case 4: n /= 19.66;  break;
			} 
		} else {
			switch (currentIdxUnit) {
				case 0: n *= 138.57; break;
				case 1: n *= 149.74; break;
				case 2: n *= 172.26; break;
				case 3: n *= 154.17; break;
				case 4: n *= 19.66;  break;
			}
		}
		return n;
	}
	
  public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == chgBtn) {
			currentIdxUnit = (currentIdxUnit + 1 ) % 5;
			output.setText(units[currentIdxUnit]);
			try {
				double n = Double.parseDouble(input1.getText());
				input2.setText(String.format("%.2f", currencyConverter(n, currentIdxUnit, 1)));
			} catch (NumberFormatException ex) {
				input2.setText("ERROR!");
			}
		} else if (source == input1) {
			try {
				double n = Double.parseDouble(input1.getText());
				input2.setText(String.format("%.2f", currencyConverter(n, currentIdxUnit, 1)));
			} catch (NumberFormatException ex) {
				input2.setText("ERROR!");
			}
		} else if (source == input2) {
			try {
				double n = Double.parseDouble(input2.getText());
				input1.setText(String.format("%d", (int)currencyConverter(n, currentIdxUnit, 2)));
			} catch (NumberFormatException ex) {
				input1.setText("ERROR!");
			}
		}
  }

	public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("通貨レート計算");
      frame.add(new CurrencyConverter());
      frame.pack();
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}
