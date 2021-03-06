package thurntaxis.wertverfahren;

import thurntaxis.spiel.Bonusmarker;
import thurntaxis.spiel.Land;
import thurntaxis.spiel.LandEnum;
import thurntaxis.spiel.Stadt;
import thurntaxis.spieler.Haus;
import thurntaxis.spieler.Spieler;


import java.util.LinkedList;

/**
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Eine abstrakte Klasse fuer die zwei verschiedenen Werteverfahren einer Route.
 *         Zu dem verfahren der Route werten gehoeren mehrere Schritte: Zuerst wird die Karte ueberpruft ob
 *         sie auch gelegt werden kann, als naechstes werden die Haeuser gesetzt und gleichzeitig geprueft ob
 *         das Spiel zu Ende ist, als letzten werden die Bonusmarker vergeben.
 *         <p/>
 *         Der Zwischenspeicher dient dazu eine ConcurrentModificationException zu vermeiden!
 */

public abstract class Wertverfahren {

    protected LinkedList<Stadt> wertbareRoute = new LinkedList<Stadt>();
    protected LinkedList<Stadt> zwischenspeicher = new LinkedList<Stadt>();

    abstract void kartePruefen(Spieler spieler, Stadt karte);

    public boolean routeWerten(Spieler spieler, LinkedList<Stadt> route) {
        this.wertbareRoute.clear();
        this.zwischenspeicher.clear();
        Boolean ende;
        for (Stadt it : route) {
            this.kartePruefen(spieler, it);
        }
        this.wertbareRoute.addAll(this.zwischenspeicher);
        route.removeAll(this.wertbareRoute);
        ende = this.haeuserSetzen(spieler);
        spieler.getGewerteteKarten().addAll(this.wertbareRoute);
        this.alleLaenderBoniVergeben(spieler);
        this.routenLaengenBoniVergeben(spieler);
        this.landVollstaendigBesetztBoniVergeben(spieler);
        return ende;
    }

    /**
     * Dieser Methode dient dazu die Haeuser des Spielers auf den zuvor gewerteten Karten bzw Staedten zu
     * bauen. Wenn der Spieler auf einer dieser Staedte schon gebaut hat wird diese Stadt uebersprungen.
     * Zusaetzlich wird noch geguckt ob der Spieler all seine Haeuser aufgebraucht hat. Wenn ja ist das Spiel
     * zu Ende.
     *
     * @param spieler der Spieler dessen Hause gesetzt werden
     * @return gibt zurueck ob das spiel zu ende ist oder nicht.
     */
    private boolean haeuserSetzen(Spieler spieler) {
        this.zwischenspeicher.clear();
        Boolean ende = false;
        for (Stadt it : this.wertbareRoute) {
            if (!it.getHaeuser().contains(new Haus(spieler.getFarbe()))) {
                it.hausBauen(spieler.getHaeuser().pop());
            } else {
                this.zwischenspeicher.add(it);
            }
        }
        this.wertbareRoute.removeAll(zwischenspeicher);
        if (spieler.getHaeuser().isEmpty()) {
            ende = true;
        }
        return ende;
    }

    private void routenLaengenBoniVergeben(Spieler spieler) {
        if (!spieler.getSpielbrett().getRoutenlaengeBoni().isEmpty()) {
            if (this.wertbareRoute.size() >= 7) {
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
        if (!spieler.getSpielbrett().getAlleLaenderBesetztBoni().isEmpty()) {
            int zaehler = 0;
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

    private void landVollstaendigBesetztBoniVergeben(Spieler spieler) {
        int anzahlStaedte;
        int kontrollZaehler = 0;
        Land tmpLand;
        Bonusmarker gewonnen = null;
        for (Stadt stadtIt : spieler.getGewerteteKarten()) {
            anzahlStaedte = stadtIt.getLand().getStaedte();
            tmpLand = new Land(stadtIt.getLand());
            if (tmpLand.getStaedte().contains(stadtIt)) {
                kontrollZaehler++;
            }
            if (kontrollZaehler == anzahlStaedte) {
                if (!spieler.getSpielbrett().getVollstaendigBesetzteLaenderBoni().get(tmpLand.getName()).isEmpty()) {
                    switch (tmpLand.getName()) {
                        case SCHWEIZ:
                            gewonnen = (Bonusmarker) spieler.getSpielbrett().getVollstaendigBesetzteLaenderBoni().
                                    get(LandEnum.SCHWEIZ).pop();
                            break;
                        case TYROL:
                            gewonnen = (Bonusmarker) spieler.getSpielbrett().getVollstaendigBesetzteLaenderBoni().
                                    get(LandEnum.SCHWEIZ).pop();
                            break;
                        case BOEHMEN:
                            gewonnen = (Bonusmarker) spieler.getSpielbrett().getVollstaendigBesetzteLaenderBoni().
                                    get(LandEnum.BOEHMEN).pop();
                            break;
                        case SALZBURG:
                            gewonnen = (Bonusmarker) spieler.getSpielbrett().getVollstaendigBesetzteLaenderBoni().
                                    get(LandEnum.BOEHMEN).pop();
                            break;
                        case BADEN:
                            gewonnen = (Bonusmarker) spieler.getSpielbrett().getVollstaendigBesetzteLaenderBoni().
                                    get(LandEnum.BADEN).pop();
                            break;
                        case WUERTTEMBERG:
                            gewonnen = (Bonusmarker) spieler.getSpielbrett().getVollstaendigBesetzteLaenderBoni().
                                    get(LandEnum.WUERTTEMBERG).pop();
                            break;
                        case BAIERN:
                            gewonnen = (Bonusmarker) spieler.getSpielbrett().getVollstaendigBesetzteLaenderBoni().
                                    get(LandEnum.BAIERN).pop();
                            break;
                        case HOHENZOLLERN:
                            gewonnen = (Bonusmarker) spieler.getSpielbrett().getVollstaendigBesetzteLaenderBoni().
                                    get(LandEnum.WUERTTEMBERG).pop();
                            break;
                    }
                }
            }
        }
        if(gewonnen != null)
            spieler.getBoni().add(gewonnen);
    }
}
