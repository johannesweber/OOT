package thurntaxis.Wertverfahren;

import thurntaxis.spieler.Spieler;

/**
 * Interface fuer die zwei werteverfahren einer route.
 */
public interface Wertverfahren {

    //ich glaub das integriert man besser direkt in Swing
    public abstract void werten(Spieler spieler);
}
