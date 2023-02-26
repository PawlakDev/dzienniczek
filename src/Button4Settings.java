import javax.swing.*;

public class Button4Settings extends JFrame {
    public Button4Settings(JButton button, JPanel panel) {
        button.setBounds(20,20,130,50);
        button.setText("Nowy Trening");
        button.setVisible(true);
        button.setFocusable(false);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setEnabled(false);

    }
}

