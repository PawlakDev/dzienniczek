import javax.swing.*;

public class Button6Settings extends JFrame {
    public Button6Settings(JButton button, JPanel panel) {
        button.setBounds(20,290,130,50);
        button.setText("Nowy Trening");
        button.setVisible(true);
        button.setText("Cofnij");
        button.setFocusable(false);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setEnabled(true);
    }
}

