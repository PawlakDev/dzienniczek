import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MyFrame3 extends JFrame implements ActionListener {

    JLabel label;
    TextField textField;
    JButton jButton,jButton2,jButton3,jButton4,jButton5,jButton6,jButton7,jButton8;
    JPanel panel,panel2,panel3;
    JTextArea textArea;

    boolean change = false;

    public MyFrame3() {
        //JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);

        //panel
        panel = new JPanel();
        panel.setBounds(0,0,400,80);
        panel.setLayout(new GridLayout(3, 2));
        this.add(panel);

        jButton = new JButton();
        jButton.setVisible(true);
        jButton.addActionListener(this);
        jButton.setText("Siłownia");
        jButton.setFocusable(false);
        jButton.addActionListener(this);
        jButton.setBorder(BorderFactory.createEtchedBorder());
        panel.add(jButton);

        jButton2 = new JButton();
        jButton2.setVisible(true);
        jButton2.addActionListener(this);
        jButton2.setText("Woda");
        jButton2.setFocusable(false);
        jButton2.addActionListener(this);
        jButton2.setBorder(BorderFactory.createEtchedBorder());
        panel.add(jButton2);

        jButton3 = new JButton();
        jButton3.setVisible(true);
        jButton3.addActionListener(this);
        jButton3.setText("Ergometr (Basen Wioślarski)");
        jButton3.setFocusable(false);
        jButton3.addActionListener(this);
        jButton3.setBorder(BorderFactory.createEtchedBorder());
        panel.add(jButton3);

        jButton4 = new JButton();
        jButton4.setVisible(true);
        jButton4.addActionListener(this);
        jButton4.setText("Bieg");
        jButton4.setFocusable(false);
        jButton4.addActionListener(this);
        jButton4.setBorder(BorderFactory.createEtchedBorder());
        panel.add(jButton4);

        jButton5 = new JButton();
        jButton5.setVisible(true);
        jButton5.addActionListener(this);
        jButton5.setText("Inne");
        jButton5.setFocusable(false);
        jButton5.addActionListener(this);
        jButton5.setBorder(BorderFactory.createEtchedBorder());
        panel.add(jButton5);

        jButton6 = new JButton();
        jButton6.setVisible(true);
        jButton6.addActionListener(this);
        jButton6.setText("Zatwierdź");
        jButton6.setFocusable(false);
        jButton6.addActionListener(this);
        jButton6.setBorder(BorderFactory.createEtchedBorder());
        panel.add(jButton6);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== jButton) {
            if(change == false) {
                panel.setVisible(false);
                jButton.setVisible(false);
                jButton2.setVisible(false);
                jButton3.setVisible(false);
                jButton4.setVisible(false);
                jButton5.setVisible(false);
                jButton6.setVisible(false);

                //panel 2
                panel2 = new JPanel();
                panel2.setBounds(0, 0, 400, 80);
                panel2.setLayout(new GridLayout(2, 1));
                this.add(panel2);

                JLabel labelx = new JLabel();
                WpisywanieTekstu wpisywanieTekstu = new WpisywanieTekstu(labelx,panel2);
                labelx.setText("Silownia Mocy / Max");
                labelx.setBounds(30,0,400,80);

                //chuj
                // Utwórz obiekt JTextField
                textField = new TextField();

                textArea = new JTextArea();
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                //textArea.setMaximumSize(new Dimension(10, 10));

                GridBagConstraints constraints = new GridBagConstraints();
                // Ustawienie właściwości dla obiektu GridBagConstraints
                constraints.fill = GridBagConstraints.HORIZONTAL;
                constraints.gridx = 1;
                constraints.gridy = 1;
                constraints.weightx = 1;

                // Ustaw rozmiar dla JTextField
                panel2.setLayout(new GridBagLayout());
                textArea.setForeground(new Color(0x000000));
                textArea.setFont(new Font("Consolas", Font.PLAIN,35));
                textArea.setBounds(0, 0, 340, 60);
                panel2.add(textArea, constraints);
                // chuj
                /*
                jButton7.setVisible(true);
                jButton7.addActionListener(this);
                jButton7.setText("Siłownia Mocy / Max");
                jButton7.setFocusable(false);
                jButton7.addActionListener(this);
                jButton7.setBorder(BorderFactory.createEtchedBorder());
                panel2.add(jButton7);
                 */

                jButton8 = new JButton();
                jButton8.setVisible(true);
                jButton8.addActionListener(this);
                jButton8.setText("Siłownia wytrzymałościowa");
                jButton8.setFocusable(false);
                jButton8.addActionListener(this);
                jButton8.setBorder(BorderFactory.createEtchedBorder());
                panel2.add(jButton8);
                change = true;
            }
        }
        if(e.getSource()== jButton7) {
                panel2.setVisible(false);
                jButton7.setVisible(false);
                jButton8.setVisible(false);

            //label
            label = new JLabel();
            label.setText("Ilość powtórzeń");
            label.setBounds(100,0,400,80);
            label.setFont(new Font("MV Boli",Font.PLAIN,32));
            label.setBackground(Color.PINK);

            //panel
            panel3 = new JPanel();
            panel3.setBounds(0,0,400,80);
            panel3.setLayout(null);
            //panel.setBackground(Color.black);
            this.add(panel3);
            panel3.add(label);

            // Utwórz obiekt JTextField
            textField = new TextField();

            textArea = new JTextArea();
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            //textArea.setMaximumSize(new Dimension(10, 10));

            GridBagConstraints constraints = new GridBagConstraints();
            // Ustawienie właściwości dla obiektu GridBagConstraints
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.gridx = 1;
            constraints.gridy = 1;
            constraints.weightx = 1;

            // Ustaw rozmiar dla JTextField
            panel3.setLayout(new GridBagLayout());
            textArea.setForeground(new Color(0x000000));
            textArea.setFont(new Font("Consolas", Font.PLAIN,35));
            textArea.setBounds(0, 0, 340, 60);
            panel3.add(textArea, constraints);
        }
    }

}
