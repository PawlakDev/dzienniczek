import javax.swing.*;
import java.awt.*;

public class Button1Settings extends JFrame {
    public Button1Settings(JButton button, JPanel panel) {

        button.setBounds(20,20,130,100);
        button.setText("Nowy Trening");
        button.setVisible(true);
        button.setFocusable(false);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setEnabled(true);
        panel.add(button, BorderLayout.NORTH);
    }
}
