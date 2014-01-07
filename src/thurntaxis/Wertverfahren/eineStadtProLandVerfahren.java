package thurntaxis.Wertverfahren;

import thurntaxis.spiel.Stadt;
import thurntaxis.spieler.Spieler;


/**
 * Created by Johannes on 05.01.14.
 */
public class eineStadtProLandVerfahren extends Wertverfahren {

    void kartePruefen(Spieler spieler, Stadt karte) {
        if (!this.wertbareRoute.isEmpty()) {
            this.wertbareRoute.add(karte);
            spieler.getRoute().remove(karte);
        } else {
            for (Stadt stadtIt : this.wertbareRoute) {
                if (!(karte.getLand().equals(stadtIt.getLand()))) {
                    this.wertbareRoute.add(karte);
                    spieler.getRoute().remove(karte);
                }
            }
        }
    }
}
