package thurntaxis.thurntaxisGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johannes on 23.12.13.
 */
public class thurntaxisGUI {

    private JButton spielStarten;
    private JPanel startbildschirm;
    private JList list1;
    private JButton button1;

    public thurntaxisGUI() {
        spielStarten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Object[] spielerAnzahl = {2, 3, 4};
                JFrame fenster = new JFrame("Spieleranzahl auswählen");
                JOptionPane.showInputDialog(fenster, "Bitte wählen Sie aus", "Spieleranzahl",
                JOptionPane.INFORMATION_MESSAGE, null, spielerAnzahl, spielerAnzahl[3]);
                //Spiel eins = new Spiel();

            }
        });
    }
}
