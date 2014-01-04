package thurntaxis.thurntaxisGUI;

import thurntaxis.spieler.Spieler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johannes on 03.01.14.
 */
public class HauptmenueGUI extends JFrame{

    static Spieler[] spieler = new Spieler[4];
    final JFrame hauptmenue = new JFrame("Thurn & Taxis: Das Brettspiel");
    static JButton start = new JButton("Spiel starten");
    static JButton spielerauswahl = new JButton("Spieler auswählen");
    JButton beenden = new JButton("Programm beenden");

    public HauptmenueGUI() {

        hauptmenue.setLayout(new GridLayout(3, 1));
        hauptmenue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hauptmenue.setVisible(true);
        hauptmenue.setLocationRelativeTo(null);

        start.setEnabled(false);
        start.addActionListener(new HauptschirmGUI());
        spielerauswahl.addActionListener(new SpielerauswahlGUI(hauptmenue));
        beenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                hauptmenue.setVisible(false);
                hauptmenue.dispose();
            }
        });

        hauptmenue.add(start);
        hauptmenue.add(spielerauswahl);
        hauptmenue.add(beenden);

        hauptmenue.pack();

    }
}
