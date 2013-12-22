package thurntaxis.Wertverfahren;

import thurntaxis.spieler.Spieler;

/**
 * Created by Johannes on 22.12.13.
 */
public interface Wertverfahren {

    //ich glaub das integriert man besser direkt in Swing
    public void werten(Spieler spieler, int platznummer);
}
