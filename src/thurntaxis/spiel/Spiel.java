package thurntaxis.spiel;

import thurntaxis.spieler.Spieler;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Klasse um ein Spiel Thurn und Taxis zu starten. Jedes Spiel hat einen Namen, eine vorger festgelegte Spieleranzahl
 * und natuerlich ein HauptschirmGUI.
 */
public class Spiel {

    public Spieler[] spieler;
    private Spielbrett spielbrett;

    public Spiel(Spieler[] spieleranzahl) {
        this.spieler = spieleranzahl;
        this.spielbrett = new Spielbrett();
        this.spielerZuordnen();
    }

    public Spielbrett getSpielbrett() {
        return this.spielbrett;
    }

    /**
     * In dieser Methode wird jeder Spieler dem aktuellen HauptschirmGUI zugeordnet.
     * Ein Spieler sollte wissen an welchem HauptschirmGUI er spielt.
     */
    private void spielerZuordnen() {
        for (Spieler it : spieler) {
            if(it != null){
                it.setSpielbrett(this.spielbrett);
            }
        }
    }
}