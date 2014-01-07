package thurntaxis.Wertverfahren;

import thurntaxis.spiel.Bonusmarker;
import thurntaxis.spiel.Land;
import thurntaxis.spiel.LandEnum;
import thurntaxis.spiel.Stadt;
import thurntaxis.spieler.Haus;
import thurntaxis.spieler.Spieler;


import java.util.LinkedList;

/**
 * Eine abstrakte Klasse fuer die zwei verschiedenen Werteverfahren einer Route.
 */

public abstract class Wertverfahren {

    LinkedList<Stadt> wertbareRoute = new LinkedList<Stadt>();

    abstract void kartePruefen(Spieler spieler, Stadt karte);

    public boolean routeWerten(Spieler spieler, LinkedList<Stadt> route) {
        for (Stadt it : route) {
            this.kartePruefen(spieler, it);
        }
        Boolean ende = this.HaeuserSetzen(spieler);
        spieler.getGewerteteKarten().addAll(wertbareRoute);
        this.alleLaenderBoniVergeben(spieler);
        this.routenLaengenBoniVergeben(spieler);
        return ende;
    }

    private boolean HaeuserSetzen(Spieler spieler) {
        Boolean ende = false;
        if (spieler.getHaeuser().isEmpty()) {
            ende = true;
        } else {
            for (Stadt it : this.wertbareRoute) {
                Stadt tmpStadt = it;
                if (it.getHaeuser().contains(new Haus(spieler.getFarbe()))) {
                    this.wertbareRoute.remove(tmpStadt);
                } else {
                    it.hausBauen(spieler.getHaeuser().pop());
                }
            }
        }
        return ende;
    }

    private void routenLaengenBoniVergeben(Spieler spieler) {
        if (!spieler.getSpielbrett().getRoutenlaengeBoni().isEmpty()) {
            if (this.wertbareRoute.size() == 7) {
                spieler.getBoni().add((Bonusmarker) spieler.getSpielbrett().getRoutenlaengeBoni().get(7).pop());
            }
            if (this.wertbareRoute.size() == 6) {
                spieler.getBoni().add((Bonusmarker) spieler.getSpielbrett().getRoutenlaengeBoni().get(6).pop());
            }
            if (this.wertbareRoute.size() == 5) {
                spieler.getBoni().add((Bonusmarker) spieler.getSpielbrett().getRoutenlaengeBoni().get(5).pop());
            }
        }
    }

    private void alleLaenderBoniVergeben(Spieler spieler) {
        int zaehler = 0;
        if (!spieler.getSpielbrett().getAlleLaenderBesetztBoni().isEmpty()) {
            for (Stadt it : spieler.getGewerteteKarten()) {
                for (LandEnum landIt : LandEnum.values()) {
                    if (it.getLand().equals(landIt)) {
                        zaehler++;
                    }
                }
            }
            if (zaehler == 9) {
                spieler.getBoni().add(spieler.getSpielbrett().getAlleLaenderBesetztBoni().pop());
            }
        }
    }

    //hmmm...
    private void jedesLandBesetztBoniVergeben(Spieler spieler) {
        for (Stadt it : spieler.getGewerteteKarten()) {
            for (LandEnum landIt : LandEnum.values()) {
                for (Stadt stadtIt : new Land(landIt).getStaedte()) {
                    //wie geht es jetzt weiter
                }
            }
        }
    }


}
