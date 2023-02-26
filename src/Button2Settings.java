import javax.swing.*;
import java.awt.*;

public class Button2Settings extends JFrame {
    public Button2Settings(JButton button, JPanel panel) {

        button.setVisible(true);
        button.setBounds(20,130,130,100);
        button.setText("Edytuj trening");
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEtchedBorder());
        panel.add(button);
    }
}
