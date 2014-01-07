package thurntaxis.Wertverfahren;

import thurntaxis.spiel.Stadt;
import thurntaxis.spieler.Spieler;

/**
 * Created by Johannes on 06.01.14.
 */
public class innerhalbEinemLandVerfahren extends Wertverfahren {

    void kartePruefen(Spieler spieler, Stadt karte) {
        if (spieler.getGewerteteKarten() == null) {
            this.wertbareRoute.add(karte);
            spieler.getRoute().remove(karte);
        } else {
            for (Stadt stadtIt : spieler.getGewerteteKarten()) {
                if (karte.getLand().equals(stadtIt.getLand())) {
                    this.wertbareRoute.add(karte);
                    spieler.getRoute().remove(karte);
                }
            }
        }
    }
}