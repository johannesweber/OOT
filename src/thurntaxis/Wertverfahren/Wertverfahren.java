package thurntaxis.Wertverfahren;

import thurntaxis.spiel.Stadt;
import thurntaxis.spieler.Spieler;

import java.util.LinkedList;

/**
 * Interface fuer die zwei werteverfahren einer route.
 */
public interface Wertverfahren {

    public abstract void werten(Spieler spieler, LinkedList<Stadt> route);
    public abstract void kartePruefen(Spieler spieler, Stadt karte);
}
