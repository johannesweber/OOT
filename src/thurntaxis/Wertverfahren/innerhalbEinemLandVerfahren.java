package thurntaxis.wertverfahren;

import thurntaxis.spiel.LandEnum;
import thurntaxis.spiel.Stadt;
import thurntaxis.spieler.Spieler;

import java.util.ListIterator;

/**
 * @author Gruppe 4 Fragezeichen
 */
public class InnerhalbEinemLandVerfahren extends Wertverfahren {

    private LandEnum land;

    /**
     * Diesers verfahren nimmt als Uebergabewert das Land in welchem der Spieler die Route
     * werten lassen will.
     * @param land das Land welches gewertet werden soll.
     */
    public InnerhalbEinemLandVerfahren(LandEnum land) {
        this.land = land;
    }

    void kartePruefen(Spieler spieler, Stadt karte) {
        if (karte.getLand().equals(this.land)) {
            this.wertbareRoute.add(karte);
        }
    }
}