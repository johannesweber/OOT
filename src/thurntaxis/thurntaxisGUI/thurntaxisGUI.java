package thurntaxis.thurntaxisGUI;

import thurntaxis.spieler.Spieler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johannes on 03.01.14.
 */
public class ThurnTaxisGUI extends JFrame{

    static Spieler[] spieler = new Spieler[4];
    final JFrame startbildschirm = new JFrame("ThurnTaxisGUI");
    static JButton start = new JButton("Spiel starten");
    JButton spielerauswahl = new JButton("Spieler auswählen");
    JButton beenden = new JButton("Programm beenden");

    public ThurnTaxisGUI() {

        startbildschirm.setLayout(new GridLayout(3, 1));
        startbildschirm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startbildschirm.setVisible(true);
        startbildschirm.setLocationRelativeTo(null);

        start.setEnabled(false);
        start.addActionListener(new Spielbrett());
        spielerauswahl.addActionListener(new Spielerauswahl(startbildschirm));
        beenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startbildschirm.setVisible(false);
                startbildschirm.dispose();
            }
        });

        startbildschirm.add(start);
        startbildschirm.add(spielerauswahl);
        startbildschirm.add(beenden);

        startbildschirm.pack();

    }
}
