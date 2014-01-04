package thurntaxis.spieler;

import thurntaxis.Amtsperson.Amtsperson;
import thurntaxis.Wertverfahren.Wertverfahren;
import thurntaxis.spiel.Bonusmarker;
import thurntaxis.spiel.Spielbrett;
import thurntaxis.spiel.Stadt;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Klasse fuer einen Spieler. Ein Spieler weiss an welchem Spielbrette er sitzt, er hat eine Farbe,
 * er besitzt zwanzig Hauser. Er kann eine Route auslegen und hat eine Hand in welcher er seine Karten haelt.
 * zusaetzlich kann er noch eine beliebige Anzahl an Boni besitzen. Um zu kontrollieren ob der Spieler seine
 * Runde auch wirklich abschliessen darf gibt es noch zaehler fuer das Ablegen und Ziehen von Karten und fuer
 * das Ablegen von Amtspersonen. Mit dem Boolean anDerReihe signalisiert der Spieler wann er seine Runde beendet
 * bzw er bekommt signalisiert wann er an der Reihe ist.
 */
public class Spieler {

    private Spielbrett spielbrett;
    private Spielerfarbe farbe;
    private Stack<Haus> haeuser;
    private LinkedList<Stadt> route;
    private LinkedList<Stadt> hand;
    private LinkedList<Stadt> gelegteRoute;
    private LinkedList<Bonusmarker> boni;
    private int zaehlerKartenZiehen;
    private int zaehlerKarteAblegen;
    private int zaehlerAmtsperson;

    public LinkedList<Stadt> getRoute() {
        return this.route;
    }

    public Spieler(Spielerfarbe farbe) {
        this.farbe = farbe;
        this.hand = new LinkedList<Stadt>();
        this.route = new LinkedList<Stadt>();
        this.boni = new LinkedList<Bonusmarker>();
        this.gelegteRoute = new LinkedList<Stadt>();
        this.haeuser = new Stack<Haus>();
        this.zaehlerKartenZiehen = 0;
        this.zaehlerKarteAblegen = 0;
        this.zaehlerAmtsperson = 0;
        this.haeuserNehmen();
    }

    public void setZaehlerKartenZiehen() {
        this.zaehlerKartenZiehen++;
    }

    public void setZaehlerKarteAblegen() {
        this.zaehlerKarteAblegen++;
    }

    public void setSpielbrett(Spielbrett spielbrett) {
        this.spielbrett = spielbrett;
    }

    public Stack<Haus> getHaeuser() {
        return this.haeuser;
    }

    public Spielerfarbe getFarbe() {
        return this.farbe;
    }

    public LinkedList<Stadt> getGelegteRoute() {
        return this.gelegteRoute;
    }

    public Spielbrett getSpielbrett() {
        return this.spielbrett;
    }

    /**
     * Mit dieser metode ermittelt der Spieler seine Punktzahl.
     *
     * @return sie punktzahl des spielers.
     */
    public int punkteErmitteln() {
        int punkteBoni = 0;
        int punkteHaeuser = 0;
        for (Bonusmarker it : this.boni) {
            punkteBoni *= it.getPunkte();
        }
        for (Haus it : this.haeuser) {
            punkteHaeuser += it.getPunkte();
        }
        return (punkteBoni - punkteHaeuser);
    }

    /**
     * Mit dieser Methode zieht der Spieler eine Karte vom Auslagestapel. Damit der Spieler auch eine "richtige" zahl
     * angeben kann und sich nicht an indizes halten muss wird von der uebergebenen nummer eins abgezogen wenn
     * der spieler ene karte zieht.
     * Gleichzeitig wird noch kontrolliert ob der Spieler schon eine Karte gezogen hat. Ist dies der Fall darf
     * er keine mehr ziehen.
     *
     * @param platzhalter der Platz in dem Auslagestapel von welchem der Spieler eine Karte
     *                    ziehen will.
     */
    public void karteZiehen(int platzhalter) {
        if (this.zaehlerKartenZiehen >= 1) {
            this.hand.add(this.spielbrett.getAuslagestapel().karteZiehen((platzhalter - 1)));
        } else {
            System.out.println("Du darfst keine Karte mehr ziehen");
        }
    }

    /**
     * In dieser methode kann der spieler eine karte ablegen. beim ablegen der karte wird ueberprueft ob es
     * ueberhaupt legitim ist diese karte zu legen. Zusaetzlich wird auch noch ueberprueft ob der spieler
     * schon eine karte gelegt hat oder nicht. wenn der spieler schon eine karte gelegt hat darf er keine
     * weitere mehr legen.
     *
     * @param karte die karte welcher der spieler ablegen will.
     */
    public void karteAblegen(Stadt karte) {
        if (this.zaehlerKarteAblegen >= 1) {
            if (this.route.isEmpty()) {
                this.route.add(karte);
            } else {
                if (!this.route.contains(karte)) {
                    if (this.route.getFirst().getNachbarn().contains(karte)) {
                        this.route.addFirst(karte);
                    } else {
                        if (this.route.getLast().getNachbarn().contains(karte)) {
                            this.route.addLast(karte);
                        } else {
                            System.out.println("Karte kann nicht gelegt werden. keine direkte Verbindung.");
                        }
                    }
                } else {
                    System.out.println("Diese Karte ist schon in deiner Route enthalten!");
                }
            }
        } else {
            System.out.println("Du darfst keine Karte mehr ablegen.");
        }
    }

    /**
     * Mit dieser methode kann ein spieler eine amtsperson auslegen, aber nur wenn er in diesem zug noch
     * keine ausgelegt hat.
     *
     * @param person die amtsperson die der spieler ausspielen will.
     */
    public void amtspersonAusspielen(Amtsperson person) {
        if (this.zaehlerAmtsperson == 1) {
            person.ausspielen(this);
            this.zaehlerAmtsperson = 0;
        } else {
            System.out.println("Du hast in dieser Runde schon eine Amtsperson ausgespielt!");
        }
    }

    /**
     * In dieser Methode wird, mit Hilfe einer externen Klasse, die Route gewertet, aber nur wenn der Spieler
     * schon eine Route mit der Laenge 3 oder groesser besitzt.
     */
    public void routeWerten(Wertverfahren verfahren) {
        if (this.route.size() < 3) {
            System.out.println("Deine Route muss eine Mindestlange von drei Karten aufweissen");
        } else {
            verfahren.werten(this, this.route);
        }
    }

    /**
     * Private methode um dem Spieler zu Spielbeginn seine Hauser zuzuordnen
     */
    private void haeuserNehmen() {
        int anzahl = 0;
        while (anzahl < 20) {
            this.haeuser.add(new Haus(this.farbe));
            anzahl++;
        }
    }

    public void rundeStarten() {
        this.zaehlerAmtsperson = 1;
        this.zaehlerKarteAblegen = 1;
        this.zaehlerKartenZiehen = 1;
    }

    public void rundeBeenden() {
        if (this.zaehlerKartenZiehen == 1) {
            System.out.println("Du musst noch eine Karte ziehen");
        }
        if (this.zaehlerKarteAblegen == 1) {
            System.out.println("Du musst noch eine Karte ablegen");
        }
    }

    @Override
    public String toString() {
        return "Spieler{" +
                ", farbe=" + farbe +
                ", route=" + route +
                ", hand=" + hand +
                ", gelegteRoute=" + gelegteRoute +
                ", boni=" + boni +
                ", zaehlerKartenZiehen=" + zaehlerKartenZiehen +
                ", zaehlerKarteAblegen=" + zaehlerKarteAblegen +
                ", zaehlerAmtsperson=" + zaehlerAmtsperson +
                '}';
    }
}
