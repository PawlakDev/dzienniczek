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


public class MyFrame2 extends JFrame implements ActionListener {

    JLabel label;
    TextField textField;
    JButton jButton;
    JPanel panel,panel2,panel3;
    JTextArea textArea;

    boolean change = false;

    int D,M,Y;
    private Cell cell;

    public MyFrame2(int d, int m, int y) {
        D = d;
        M = m;
        Y = y;
        //JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setVisible(true);
        this.setLayout(null);

        //label
        label = new JLabel();

        //panel
        panel = new JPanel();

        WpisywanieTekstu wpisywanieTekstu = new WpisywanieTekstu(label,panel);
        this.add(panel);


        //panel2
        panel2 = new JPanel();
        panel2.setBounds(15,70,355,140);
        panel2.setVisible(true);
        //panel.setBackground(Color.black);
        this.add(panel2);

        //panel3
        panel3 = new JPanel();
        panel3.setBounds(15,210,355,220);
        panel3.setVisible(true);
        panel3.setLayout(null);
        //panel.setBackground(Color.black);
        this.add(panel3);

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

        jButton = new JButton();
        jButton.setVisible(true);
        jButton.setLayout(null);
        jButton.setBounds(130,0,100,50);
        jButton.addActionListener(this);
        jButton.setText("Zapisz");
        jButton.setFocusable(false);
        jButton.addActionListener(this);
        jButton.setBorder(BorderFactory.createEtchedBorder());
        panel3.add(jButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== jButton){
            String x = textArea.getText();
            if(change==false) {
                textArea.setEnabled(false);
                jButton.setEnabled(false);
                System.out.println(x);

                try {
                    // Otwórz plik Excel
                    FileInputStream fileIn = new FileInputStream("Dzienniczek.xlsx");
                    Workbook workbook = new XSSFWorkbook(fileIn);
                    fileIn.close();

                    // Pobierz arkusz o nazwie "Arkusz1"
                    Sheet sheet = null;
                    int Miesiac = -1;

                    if (M == 1 && D >= 2 && D <= 29) Miesiac = 1; //Styczen
                    else if ((M == 1 && D >= 30) || (M == 2 && D <= 26)) Miesiac = 2;//Luty
                    else if ((M == 2 && D > 26) || (M == 3) || (M == 4 && D <= 2)) Miesiac = 3; // Marzec

                    switch (Miesiac) {
                        case 12:
                            sheet = workbook.getSheet("Grudzień 2022");
                            break;
                        case 1:
                            sheet = workbook.getSheet("Styczeń 2023");
                            break;
                        case 2:
                            sheet = workbook.getSheet("Luty 2023");
                            break;
                        case 3:
                            sheet = workbook.getSheet("Marzec 2023");
                            break;
                        case 4:
                            System.out.println("B");
                            break;
                        default:
                            System.out.println("Blad wczytania miesiaca");
                            break;
                    }


                    int RI = 0;

                    Row row = null;
                    int rowIndex = -1;


                    /*Pierwszy tydzień*/
                    if ((M == 1 && D >= 2 && D <= 8) || (M == 1 && D >= 30) || (M == 2 && D <= 5)) { //STYCZEN LUTY DONE
                        rowIndex = 6;
                    } /* Drugi tydzień*/ else if ((M == 1 && D > 8 && D <= 15) || (M == 2 && D > 5 && D <= 12)) { //STYCZEN LUTY DONE
                        rowIndex = 21;
                    } /* Trzeci tydzien*/ else if ((M == 1 && D >= 16 && D <= 22) || (M == 2 && D >= 13 && D <= 19)) //STYCZEŃ,LUTY DONE
                    {
                        rowIndex = 37; // Do sprawdzenia
                    } /* Czwarty tydzien*/ else rowIndex = 37;

                    for (; rowIndex <= 30; rowIndex++) {
                        row = sheet.getRow(rowIndex);
                        if (row == null) {
                            // osiągnięto koniec arkusza, zakończ pętlę
                            break;
                        }

                        cell= row.getCell(2);
                        if (cell != null && cell.getCellType() != CellType.BLANK) {
                            // komórka nie jest pusta, przejdź do następnego wiersza
                            System.out.println("Nie pusta");
                            continue;
                        } else {
                            RI = rowIndex;
                            break;
                        }
                    }

                    System.out.print(RI);

                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setAlignment(HorizontalAlignment.CENTER);
                    cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                    cellStyle.setBorderTop(BorderStyle.THIN);
                    cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderBottom(BorderStyle.THIN);
                    cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderLeft(BorderStyle.THIN);
                    cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
                    cellStyle.setBorderRight(BorderStyle.THIN);
                    cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());



                    row = sheet.getRow(RI);
                    cell = row.getCell(1);

                    // Modyfikuj wartość komórki

                    cell.setCellValue(x);
                    cell.setCellStyle(cellStyle);

                    String data = "";

                    data += D;
                    data += ".";
                    data += M;
                    data += ".";
                    data += Y;

                    System.out.println(D);
                    System.out.println(M);
                    System.out.println(Y);

                    cell.setCellValue(data);

                    // Zapisz plik
                    FileOutputStream fileOut = new FileOutputStream("Dzienniczek.xlsx");
                    workbook.write(fileOut);
                    fileOut.close();

                    // Zamknij plik
                    workbook.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("Brak pliku");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                MyFrame3 frame3 = new MyFrame3();
            }

            change = true;
            this.setVisible(false);
        }
    }
}
