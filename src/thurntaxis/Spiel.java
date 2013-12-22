package thurntaxis;

import thurntaxis.spielbrett.Spielbrett;
import thurntaxis.spieler.Spieler;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Johannes on 21.12.13.
 */
public class Spiel {

    private LinkedList<Spieler> spielerAnzahl;
    private Spielbrett spielbrett;

    public Spiel(LinkedList<Spieler> spielerAnzahl) {
        this.spielerAnzahl = spielerAnzahl;
        this.spielbrett = new Spielbrett();
        this.spielerZuordnen();
    }

    public Spielbrett getSpielbrett() {
        return this.spielbrett;
    }

    public Spieler gewinnerErmitteln() {
        ListIterator<Spieler> it = spielerAnzahl.listIterator();
        Spieler gewinner = it.next();
        int max = gewinner.punkteErmitteln();
        while (it.hasNext()) {
            Spieler tmpSpieler = it.next();
            if (tmpSpieler.punkteErmitteln() > max) {
                gewinner = tmpSpieler;
                max = tmpSpieler.punkteErmitteln();
            }
        }
        return gewinner;
    }

    private void spielerZuordnen() {
        for (Spieler it : spielerAnzahl) {
            it.setSpielbrett(this.spielbrett);
        }
    }

    //hmmm...so oder irgendwie anderst muss es gehen...
    public void spielStarten() {
        ListIterator<Spieler> it = spielerAnzahl.listIterator();
        it.next().rundeStarten(); // Spiel starten aber wie
    }

    //hmmm...so oder irgendwie anderst muss es gehen...
    public void naechsteRunde() {
        ListIterator<Spieler> it = spielerAnzahl.listIterator();
        Spieler naechster = it.next();
        if (naechster.rundeBeenden()) {
            naechster = it.next();
            naechster.rundeStarten();  //naechste Runde starten aber wie
        }
    }
}
