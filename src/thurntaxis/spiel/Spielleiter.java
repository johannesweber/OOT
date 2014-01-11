package thurntaxis.spiel;

import thurntaxis.gui.hauptschirm.HauptschirmFrame;
import thurntaxis.wertverfahren.Wertverfahren;
import thurntaxis.spieler.Spieler;

import java.util.LinkedList;

/**
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Klasse um ein Spiel Thurn und Taxis zu starten. Jedes Spiel hat einen Namen, eine vorger festgelegte Spieleranzahl
 *         und natuerlich ein HauptschirmGUI.
 */
public class Spielleiter {

    public Spieler[] spieler;
    private Spielbrett spielbrett;
    public HauptschirmFrame hauptschirm;
    private Spiel spiel;
    private int istDran;
    private boolean ende;

    public Spielleiter() {
        this.spieler = new Spieler[4];
        this.istDran = 0;
        this.ende = false;
    }

    public Spielbrett getSpielbrett() {
        return this.spielbrett;
    }

    public Spieler getIstDran() {
        return this.spieler[istDran];
    }

    /**
     * Diese Methode ermittelt den Spieler mit der hoechsten Punktzahl. Die Punktzahl der einzelnen Spieler
     * wird in der Klasse Spieler errechnet.
     *
     * @return der gewinner
     */
    public Spieler gewinnerErmitteln() {
        int max = this.spieler[0].getPunktstand();
        Spieler gewinner;
        Spieler tmpGewinner;
        LinkedList<Spieler> moeglicheGewinner = new LinkedList<Spieler>();
        moeglicheGewinner.add(this.spieler[0]);

        for (int i = 1; i < this.spieler.length; i++) {
            tmpGewinner = this.spieler[i];
            if (tmpGewinner != null) {
                if (tmpGewinner.getPunktstand() > max) {
                    max = tmpGewinner.getPunktstand();
                    moeglicheGewinner.clear();
                    moeglicheGewinner.add(tmpGewinner);
                }
                if (tmpGewinner.getPunktstand() == max) {
                    moeglicheGewinner.add(tmpGewinner);
                }
            }
        }
        if (moeglicheGewinner.size() > 1) {
            int zufall = (int) (Math.random() * (1 - 0) + 0);
            gewinner = moeglicheGewinner.get(zufall);
        } else {
            gewinner = moeglicheGewinner.getFirst();
        }
        if (!this.spielbrett.getSiegplaettchen().isEmpty()) {
            gewinner.getBoni().add(this.spielbrett.getSiegplaettchen().pop());
        }
        return gewinner;
    }

    /**
     * Methode um die allererste Runde zu starten.
     */
    public void spielStarten() {
        this.spiel = new Spiel(spieler);
        this.spielbrett = spiel.getSpielbrett();
        spieler[istDran].rundeStarten();
    }

    /**
     * Methode welche den naechster Spieler auswaehlt wenn der aktuelle Spieler all seine Zuege getan hat.
     *
     * @return eine Meldung welche dann in der GUI ausgegeben wird
     */
    public String naechsterSpieler() {
        Spieler tmpSpieler;
        String meldung = null;
        if (this.ende) {
            tmpSpieler = spieler[this.istDran + 1];
            if (tmpSpieler == null || istDran == 3)
                meldung = "Das Spiel ist jetzt zu Ende. Der Gewinner ist Spieler "
                        + this.gewinnerErmitteln().getFarbe().toString();
        } else {
            if (this.getIstDran().getZaehlerKartenZiehen() == 1) {
                meldung = "Du musst noch eine Karte ziehen";
            } else {
                if (this.getIstDran().getZaehlerKarteAblegen() == 1) {
                    meldung = "Du musst noch eine Karte ablegen";
                } else {
                    this.naechsterSpielerAuswaehlen();
                    meldung = "Jetzt ist Spieler " + this.getIstDran().getFarbe().toString() + " an der Reihe";

                }
                this.spieler[this.istDran].rundeStarten();
            }
        }
        return meldung;
    }

    /**
     * In dieser Methode wird, mit Hilfe einer externen Klasse, die Route gewertet, aber nur wenn der Spieler
     * schon eine Route mit der Laenge 3 oder groesser besitzt. Gleichzeit wird nur geguckt ob das Spiel
     * zu Ende ist. Wenn ja wird eine entsprechende Meldung ausgegeben.
     */
    public String routeWerten(Wertverfahren verfahren) {
        String meldung;
        this.ende = verfahren.routeWerten(this.getIstDran(), this.getIstDran().getRoute());
        meldung = "Deine Route wurde erfolgreich gewertet.";
        if (this.ende) {
            meldung = "Der erste Spieler hat all seine Streckenposten. Diese Runde wird noch zu Ende gespielt.";
        }
        return meldung;
    }

    /**
     * Dieser Methode dient der Methode welche den naechster Spieler auswaehlt.
     */
    private void naechsterSpielerAuswaehlen() {
        Spieler tmpSpieler = this.spieler[this.istDran + 1];
        if (tmpSpieler == null) {
            this.istDran = 0;
        } else {
            this.istDran++;
        }
    }
}

