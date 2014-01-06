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
     * Diese Methode ermittelt den Spieler mit der hoechsten Punktzahl. Die Punktzahl der einzelnen Spieler
     * wird in der Klasse Spieler errechnet.
     *
     * @return der gewinner
     */
    public Spieler gewinnerErmitteln() {
        List<Spieler> spielers = Arrays.asList(this.spieler);
        ListIterator<Spieler> it = spielers.listIterator();
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

    /**
     * Methode um die allererste Runde zu starten.
     */
    public void spielStarten() {
        this.spieler[0].rundeStarten();
    }
}
