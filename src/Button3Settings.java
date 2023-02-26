import javax.swing.*;

public class Button3Settings extends JFrame {
    public Button3Settings(JButton button, JPanel panel) {
        button.setVisible(true);
        button.setBounds(20,240,130,100);
        button.setText("Wyjdz");
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEtchedBorder());
        panel.add(button);
    }
}

