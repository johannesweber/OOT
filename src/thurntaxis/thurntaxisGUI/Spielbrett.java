package thurntaxis.thurntaxisGUI;

import thurntaxis.spiel.Land;
import thurntaxis.spiel.Spiel;
import thurntaxis.spiel.Stadt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

/**
 * Created by Johannes on 03.01.14.
 */
public class Spielbrett implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        Spiel thurntaxis = new Spiel(ThurnTaxisGUI.spieler);
        JFrame spielbrett = new JFrame("Thurn & Taxis: Das Brettspiel");

        int zeilen = 22;
        int spalten = 2;

        String[] ueberschrift = {"Städte, Nachbarn"};
        String[][] inhalt = new String[zeilen][spalten];
        ListIterator<Land> landIt = thurntaxis.getSpielbrett().getLaender().listIterator();

        for (int i = 0; i < thurntaxis.getSpielbrett().getLaender().size(); i++) {
            Land tmpLand = landIt.next();
            inhalt[i][0] = tmpLand.toString();
            for (Stadt it : tmpLand.getStaedte()) {
                inhalt[i][1] = it.toString();
            }
        }


        JTable tabelle = new JTable(inhalt, ueberschrift);

        spielbrett.add(tabelle);
        spielbrett.setSize(800, 600);
        spielbrett.setVisible(true);

    }
}
