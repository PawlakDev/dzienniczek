import javax.swing.*;

public class Button5Settings extends JFrame {
    public Button5Settings(JButton button, JPanel panel) {
        button.setBounds(20,80,130,80);
        button.setText("Aktualna Data");
        button.setVisible(true);
        button.setFocusable(false);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setEnabled(true);
    }
}

