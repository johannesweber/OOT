package thurntaxis.spieler;

import thurntaxis.amtsperson.Amtsperson;
import thurntaxis.spiel.*;

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
    private LinkedList<Stadt> gewerteteKarten;
    private LinkedList<Bonusmarker> boni;
    private int zaehlerKartenZiehen;
    private int zaehlerKarteAblegen;
    private int zaehlerAmtsperson;
    private int punktstand;
    private int bonuspunkte;
    private int haeuserpunkte;

    public Spieler(Spielerfarbe farbe) {
        this.farbe = farbe;
        this.hand = new LinkedList<Stadt>();
        this.route = new LinkedList<Stadt>();
        this.boni = new LinkedList<Bonusmarker>();
        this.gewerteteKarten = new LinkedList<Stadt>();
        this.haeuser = new Stack<Haus>();
        this.zaehlerKartenZiehen = 0;
        this.zaehlerKarteAblegen = 0;
        this.zaehlerAmtsperson = 0;
        this.haeuserNehmen();
    }

    public int getBonuspunkte() {
        return this.bonuspunkte;
    }

    public int getHaeuserpunkte() {
        return this.haeuserpunkte;
    }

    public int getPunktstand() {
        return this.punktstand;
    }

    public LinkedList<Bonusmarker> getBoni() {
        return this.boni;
    }

    public LinkedList<Stadt> getRoute() {
        return this.route;
    }

    public int getZaehlerKartenZiehen() {
        return this.zaehlerKartenZiehen;
    }

    public int getZaehlerKarteAblegen() {
        return this.zaehlerKarteAblegen;
    }

    public void zaehlerKartenAblegenVerringern() {
        this.zaehlerKarteAblegen--;
    }

    public void zaehlerKartenZiehenErhoehen() {
        this.zaehlerKartenZiehen++;
    }

    public void zaehlerKarteAblegenErhoehen() {
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

    public LinkedList<Stadt> getGewerteteKarten() {
        return this.gewerteteKarten;
    }

    public Spielbrett getSpielbrett() {
        return this.spielbrett;
    }

    public LinkedList<Stadt> getHand() {
        return hand;
    }

    /**
     * Mit dieser metode ermittelt der Spieler seine Punktzahl.
     *
     * @return sie punktzahl des spielers.
     */
    public void punkteErmitteln() {

        for (Bonusmarker it : this.boni) {
            this.bonuspunkte += it.getPunkte();
        }
        for (Haus it : this.haeuser) {
            this.haeuserpunkte += it.getPunkte();
        }
        this.haeuserpunkte = 20 - this.haeuserpunkte;
        this.punktstand = (this.bonuspunkte + this.haeuserpunkte);
    }

    /**
     * Mit dieser Methode zieht der Spieler eine Karte vom Auslagestapel. Damit der Spieler auch eine "richtige" zahl
     * angeben kann und sich nicht an indizes halten muss wird von der uebergebenen nummer eins abgezogen wenn
     * der spieler ene karte zieht.
     * Gleichzeitig wird noch kontrolliert ob der Spieler schon eine Karte gezogen hat. Ist dies der Fall darf
     * er keine mehr ziehen.
     *
     * @param ausgewaehlt der Platz in dem Auslagestapel von welchem der Spieler eine Karte
     *                    ziehen will.
     */
    public String karteZiehen(int ausgewaehlt) {
        Stadt gezogen;
        String meldung = null;
        if (!(this.zaehlerKartenZiehen < 1)) {
            gezogen = this.spielbrett.getAuslagestapel().karteZiehen((ausgewaehlt));
            this.hand.add(gezogen);
            this.zaehlerKartenZiehen--;
        } else {
            meldung = "Du darfst keine Karte mehr ziehen";
        }
        return meldung;
    }

    /**
     * In dieser methode kann der spieler eine karte ablegen. beim ablegen der karte wird ueberprueft ob es
     * ueberhaupt legitim ist diese karte zu legen. Zusaetzlich wird auch noch ueberprueft ob der spieler
     * schon eine karte gelegt hat oder nicht. wenn der spieler schon eine karte gelegt hat darf er keine
     * weitere mehr legen.
     *
     * @param karte die karte welcher der spieler ablegen will.
     */
    public int karteAblegen(Stadt karte) {
        int meldung = 0;
        if (!(this.zaehlerKarteAblegen < 1)) {
            if (this.route.isEmpty()) {
                this.route.add(karte);
                this.hand.remove(karte);
                this.zaehlerKarteAblegen--;
            } else {
                if (!this.route.contains(karte)) {
                    if (this.isErsterNachbar(karte)) {
                        this.route.addFirst(karte);
                        this.hand.remove(karte);
                        this.zaehlerKarteAblegen--;
                    } else {
                        if (this.isLetzterNachbar(karte)) {
                            this.route.addLast(karte);
                            this.hand.remove(karte);
                            this.zaehlerKarteAblegen--;
                        } else {
                            meldung = 1;//"Karte kann nicht gelegt werden. Keine direkte Verbindung.";
                        }
                    }
                } else {
                    meldung = 2;//"Diese Karte ist schon in deiner Route enthalten!";
                }
            }
        } else {
            meldung = 3;//"Du darfst keine Karte mehr ablegen.";
        }
        return meldung;
    }

    /**
     * Mit dieser methode kann ein spieler eine amtsperson auslegen, aber nur wenn er in diesem zug noch
     * keine ausgelegt hat.
     *
     * @param person die amtsperson die der spieler ausspielen will.
     */
    public String amtspersonAusspielen(Amtsperson person) {
        String meldung = null;
        if (this.zaehlerAmtsperson == 1) {
            person.ausspielen(this);
            this.zaehlerAmtsperson--;
        } else {
            meldung = "Du hast in dieser Runde schon eine Amtsperson ausgespielt!";
        }
        return meldung;
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

    /**
     * Methode um den Spieler auf eine neue Runde vorzubereiten.
     */
    public void rundeStarten() {
            this.zaehlerAmtsperson = 1;
            this.zaehlerKarteAblegen = 1;
            this.zaehlerKartenZiehen = 1;
    }

    private boolean isErsterNachbar(Stadt karte){
        boolean nachbar = false;
        for (Spielkarte it : this.route.getFirst().getNachbarn()){
            if(karte.getName().equals(it)){
                nachbar = true;
            }
        }
        return nachbar;
    }

    private boolean isLetzterNachbar(Stadt karte){
        boolean nachbar = false;
        for (Spielkarte it : this.route.getLast().getNachbarn()){
            if(karte.getName().equals(it)){
                nachbar = true;
            }
        }
        return nachbar;
    }

    @Override
    public String toString() {
        return "Spieler{" +
                "farbe=" + farbe +
                ", punktstand=" + punktstand +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spieler)) return false;

        Spieler spieler = (Spieler) o;

        if (zaehlerAmtsperson != spieler.zaehlerAmtsperson) return false;
        if (zaehlerKarteAblegen != spieler.zaehlerKarteAblegen) return false;
        if (zaehlerKartenZiehen != spieler.zaehlerKartenZiehen) return false;
        if (boni != null ? !boni.equals(spieler.boni) : spieler.boni != null) return false;
        if (farbe != spieler.farbe) return false;
        if (gewerteteKarten != null ? !gewerteteKarten.equals(spieler.gewerteteKarten) : spieler.gewerteteKarten != null)
            return false;
        if (haeuser != null ? !haeuser.equals(spieler.haeuser) : spieler.haeuser != null) return false;
        if (hand != null ? !hand.equals(spieler.hand) : spieler.hand != null) return false;
        if (route != null ? !route.equals(spieler.route) : spieler.route != null) return false;
        if (spielbrett != null ? !spielbrett.equals(spieler.spielbrett) : spieler.spielbrett != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = spielbrett != null ? spielbrett.hashCode() : 0;
        result = 31 * result + (farbe != null ? farbe.hashCode() : 0);
        result = 31 * result + (haeuser != null ? haeuser.hashCode() : 0);
        result = 31 * result + (route != null ? route.hashCode() : 0);
        result = 31 * result + (hand != null ? hand.hashCode() : 0);
        result = 31 * result + (gewerteteKarten != null ? gewerteteKarten.hashCode() : 0);
        result = 31 * result + (boni != null ? boni.hashCode() : 0);
        result = 31 * result + zaehlerKartenZiehen;
        result = 31 * result + zaehlerKarteAblegen;
        result = 31 * result + zaehlerAmtsperson;
        return result;
    }
}
