package thurntaxis.Wertverfahren;

import thurntaxis.spiel.Stadt;
import thurntaxis.spieler.Spieler;

import java.util.LinkedList;

/**
 * Interface fuer die zwei werteverfahren einer route.
 */
public interface Wertverfahren {

    //ich glaub das integriert man besser direkt in Swing
    public abstract void werten(Spieler spieler, LinkedList<Stadt> route);
    public abstract void kartePruefen(Spieler spieler, Stadt karte);
}
