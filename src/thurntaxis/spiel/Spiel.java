package thurntaxis.spiel;

import thurntaxis.spieler.Spieler;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Klasse um ein Spiel Thurn und Taxis zu starten. Jedes Spiel hat einen Namen, eine vorger festgelegte Spieleranzahl
 * und natuerlich ein Spielbrett.
 */
public class Spiel {

    private String name;
    private LinkedList<Spieler> spielerAnzahl;
    private Spielbrett spielbrett;

    public Spiel(LinkedList<Spieler> spielerAnzahl) {
        this.name = "Thurn & Taxis: Das Brettspiel";
        this.spielerAnzahl = spielerAnzahl;
        this.spielbrett = new Spielbrett();
        this.spielerZuordnen();
    }

    public Spielbrett getSpielbrett() {
        return this.spielbrett;
    }

    /**
     * Diese Methode ermittelt den Spieler mit der hoechsten Punktzahl. Die Punktzahl der einzelnen Spieler
     * wird in der Klasse Spieler errechnet.
     *
     * @return der gewinner
     */
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

    /**
     * In dieser Methode wird jeder Spieler dem aktuellen Spielbrett zugeordnet.
     * Ein Spieler sollte wissen an welchem Spielbrett er spielt.
     */
    private void spielerZuordnen() {
        for (Spieler it : spielerAnzahl) {
            it.setSpielbrett(this.spielbrett);
        }
    }

    //hmmm...so oder irgendwie anderst muesste es gehen...
    public void spielStarten() {
        ListIterator<Spieler> it = spielerAnzahl.listIterator();
        it.next().rundeStarten(); // Spiel starten aber wie
    }

    //hmmm...so oder irgendwie anderst muesste es gehen...
    public void naechsteRunde() {
        ListIterator<Spieler> it = spielerAnzahl.listIterator();
        Spieler naechster = it.next();
        if (!naechster.isAnDerReihe()) {
            naechster = it.next();
            naechster.rundeStarten();  //naechste Runde starten aber wie
        }
    }
}
