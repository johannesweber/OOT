package thurntaxis.wertverfahren;

import thurntaxis.spiel.Stadt;
import thurntaxis.spieler.Spieler;


/**
 * @author Gruppe 4 Fragezeichen
 */
public class EineStadtProLandVerfahren extends Wertverfahren {

    void kartePruefen(Spieler spieler, Stadt karte) {
        if (this.wertbareRoute.isEmpty()) {
            this.wertbareRoute.add(karte);
        } else {
            for (Stadt stadtIt : this.wertbareRoute) {
                if (!(karte.getLand().equals(stadtIt.getLand()))) {
                    this.zwischenspeicher.add(karte);
                }
            }
        }
    }
}
