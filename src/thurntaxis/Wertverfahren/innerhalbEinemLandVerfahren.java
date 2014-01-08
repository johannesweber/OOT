package thurntaxis.wertverfahren;

import thurntaxis.spiel.LandEnum;
import thurntaxis.spiel.Stadt;
import thurntaxis.spieler.Spieler;

import java.util.ListIterator;

/**
 * Created by Johannes on 06.01.14.
 */
public class InnerhalbEinemLandVerfahren extends Wertverfahren {

    private LandEnum land;

    public InnerhalbEinemLandVerfahren(LandEnum land) {
        this.land = land;
    }

    void kartePruefen(Spieler spieler, Stadt karte) {
        if (karte.getLand().equals(this.land)) {
            this.wertbareRoute.add(karte);
        }
    }
}