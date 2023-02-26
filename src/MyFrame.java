import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class MyFrame extends JFrame implements ActionListener {
        static boolean change = false;
        JLabel label;
        JButton[] button = new JButton[7];
        //JButton button,button2,button3,button4,button5,button6;
        JPanel panel,panel2;
        TextField textField;

        static String Label="Label";
    public MyFrame(){

        //Tworzenie panelu
        panel = new JPanel();
        //Ustawianie jego wielkosci
        panel.setBounds(0,0,180,400);
        panel.setLayout(null);
        //Ustawienie koloru tla
        panel.setBackground(Color.white);

        //Tworzenie drugiego panelu
        panel2 = new JPanel();
        //Ustawienie wielkości pamietajac o wielkosciach pierwszego panelu
        panel2.setBounds(160,-25,370,400);

        // Utwórz obiekt Image z obrazem
        Image image = new ImageIcon("C:\\Users\\thepo\\Desktop\\Studia\\untitled\\src\\obrazek.png").getImage();

        ImageIcon icon = new ImageIcon("C:\\Users\\thepo\\Desktop\\Studia\\untitled\\src\\obrazek.png");

        // Ustaw właściwość SCALE_SMOOTH dla obrazu
        image = image.getScaledInstance(500, 400, Image.SCALE_SMOOTH);

        // Utwórz obiekt ImageIcon z nowym obrazem
        ImageIcon imageIcon = new ImageIcon(image);

        // Utwórz obiekt JLabel z ikoną obrazu
        JLabel label = new JLabel(imageIcon);


        label.setBounds(0, 0, 400, 300);
        //label.setIcon(icon);
        panel2.add(label);

        //JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(550,400);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Dzienniczek treningowy PZTW");
        this.getContentPane().setBackground(Color.white);
        this.add(panel);
        this.add(panel2);

        //Button1 - "Nowy Trening"
        button[0] = new JButton();
        button[0].addActionListener(this);
        Button1Settings button1Settings = new Button1Settings(button[0],panel);

        //Button2 - "Edytuj trening"
        button[1] = new JButton();
        button[1].addActionListener(this);
        Button2Settings button2Settings = new Button2Settings(button[1],panel);

        //Button3 - "Wyjdz"
        button[2] = new JButton();
        button[2].addActionListener(this);
        Button3Settings button3Settings = new Button3Settings(button[2],panel);

        //Button number 4 settings:
        button[3] = new JButton();
        Button4Settings button4Settings = new Button4Settings(button[3],panel);
        button[3].addActionListener(this);

        //Button number 5 settings:
        button[4] = new JButton();
        button[4].addActionListener(this);
        Button5Settings button5Settings = new Button5Settings(button[4],panel);

        //Button number 6 settings:
        button[5] = new JButton();
        button[5].addActionListener(this);
        Button6Settings button6Settings1 = new Button6Settings(button[5],panel);
    }

    public void setLabel(){
        label.setIcon(null);
        System.out.println("oj");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button[0]) {

            for(int i=0;i<3;i++){
                button[i].setVisible(false);
                panel.remove(button[i]);
            }

            for(int i=3;i<6;i++){
                button[i].setVisible(true);
                panel.add(button[i]);
            }

        }
        if (e.getSource() == button[2]) {
            if (change == false) {
                System.exit(0);
            }
        }
        if (e.getSource() == button[5]) {
            for(int i=3;i<6;i++){
                button[i].setVisible(false);
            }

            for(int i=0;i<3;i++){
                button[i].setVisible(true);
                panel.add(button[i]);
            }
            button[4].setEnabled(true);
        }
        if(e.getSource() == button[4]){

            button[5].setEnabled(false);

            // Utwórz obiekt Calendar z bieżącą datą i godziną
            Calendar calendar = Calendar.getInstance();

            // Pobierz składowe daty z obiektu Calendar
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH) + 1; // Zwróć uwagę na to, że miesiące są liczone od 0
            int year = calendar.get(Calendar.YEAR);

            // Wyświetl wczytaną datę na konsoli
            System.out.println(day + "/" + month + "/" + year);

            button[4].setEnabled(false);

            MyFrame2 frame2 = new MyFrame2(day,month,year);
        }
    }

}
