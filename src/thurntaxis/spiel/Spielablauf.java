package thurntaxis.spiel;

import thurntaxis.GUI.*;
import thurntaxis.spieler.Spieler;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Klasse um ein Spiel Thurn und Taxis zu starten. Jedes Spiel hat einen Namen, eine vorger festgelegte Spieleranzahl
 * und natuerlich ein HauptschirmGUI.
 */
public class Spielablauf {

    public Spieler[] spieler = new Spieler[4];
    public Spielbrett spielbrett;
	public Startmenue startmenue;
	public Hauptschirm hauptschirm;
    private Spiel spiel;

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
        List<Spieler> spielers = Arrays.asList(spieler);
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
        for (Spieler it : this.spieler) {
            if(it != null){
                it.setSpielbrett(this.spielbrett);
            }
        }
    }

    /**
     * Methode um die allererste Runde zu starten.
     */
    public void spielStarten() {
        this.spiel = new Spiel(spieler);
        this.spielbrett = spiel.getSpielbrett();
    	spieler[0].rundeStarten();
        System.out.println(spieler[0]);
    }
}
