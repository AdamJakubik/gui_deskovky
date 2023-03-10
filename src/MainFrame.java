import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Scanner;

public class MainFrame extends JFrame {
    private JFileChooser chooser = new JFileChooser(".");

    private JButton btnDataFromFile;
    private JPanel mainPanel;
    private JTextField textField1;
    private JCheckBox checkBox1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;

    public MainFrame() {
        initComponents();
    }

    private void readFromFile() {
         int result = chooser.showOpenDialog(this);
         // Klikl uživatel na "Open"? Pokud ano, zpracuj událost:
         if (result == JFileChooser.APPROVE_OPTION){
             File selectedFile = chooser.getSelectedFile();
             //JOptionPane.showMessageDialog(this, "Uživatel zvolil soubor:" + selectedFile.getAbsoluteFile());
             try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(selectedFile)))
             ){

             } catch (FileNotFoundException e){
                 throw new RuntimeException(e);
             }
         }
    }

    private void initComponents() {
        setTitle("Deskové hry");
        setContentPane(mainPanel);
        btnDataFromFile.addActionListener(e->readFromFile());
    }

    public static void main(String[] args) {
        MainFrame f = new MainFrame();
        f.setVisible(true);
        f.setSize(300, 200);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
