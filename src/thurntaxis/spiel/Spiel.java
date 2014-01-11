package thurntaxis.spiel;

import thurntaxis.spieler.Spieler;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Gruppe 4 Fragezeichen
 *
 * Klasse um ein Spiel Thurn und Taxis zu starten. Jedes Spiel hat einen Namen und
 * eine vorher festgelegte Spieleranzahl. Das Spiel teilt auch noch jedem Teilnehmer mit
 * an welchem Spielbrett er sitzt. In dem Konstruktor von einem Spiel wird sofort
 * ein neues Spielbrett erstellt und die Spieler festgelegt und dem Spielbrett zugeordnet.
 */
public class Spiel {

    public Spieler[] spieler;
    private Spielbrett spielbrett;

    public Spiel(Spieler[] spieleranzahl) {
        this.spieler = spieleranzahl;
        this.spielbrett = new Spielbrett();
        this.spielerZuordnen();
    }

    protected Spielbrett getSpielbrett() {
        return this.spielbrett;
    }

    /**
     * In dieser Methode wird jedem Spieler das aktuelle Spielbrett zugeordnet.
     * Ein Spieler sollte wissen an welchem Spielbrett er spielt.
     */
    private void spielerZuordnen() {
        for (Spieler it : spieler) {
            if(it != null){
                it.setSpielbrett(this.spielbrett);
            }
        }
    }
}