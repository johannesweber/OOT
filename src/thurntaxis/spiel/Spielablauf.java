package thurntaxis.spiel;

import thurntaxis.GUI.*;
import thurntaxis.GUI.Hauptschirm.HauptschirmFrame;
import thurntaxis.spieler.Spieler;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Klasse um ein Spiel Thurn und Taxis zu starten. Jedes Spiel hat einen Namen, eine vorger festgelegte Spieleranzahl
 * und natuerlich ein HauptschirmGUI.
 */
public class Spielablauf {

    public Spieler[] spieler = new Spieler[4];
    public Spielbrett spielbrett;
    public StartmenueFrame startmenue;
    public HauptschirmFrame hauptschirm;
    private Spiel spiel;
    private int istDran = 0;

    public Spielbrett getSpielbrett() {
        return this.spielbrett;
    }

    public int getIstDran() {
        return this.istDran;
    }

    /**
     * Diese Methode ermittelt den Spieler mit der hoechsten Punktzahl. Die Punktzahl der einzelnen Spieler
     * wird in der Klasse Spieler errechnet.
     *
     * @return der gewinner
     */
    public Spieler gewinnerErmitteln() {
        List<Spieler> spielers = Arrays.asList(spieler);
        ListIterator<Spieler> it = spielers.listIterator();
        Spieler gewinner = it.next();
        int max = gewinner.punkteErmitteln();
        while (it.hasNext()) {
            Spieler tmpSpieler = it.next();
            if (tmpSpieler.punkteErmitteln() > max) {
                gewinner = tmpSpieler;
                max = tmpSpieler.punkteErmitteln();
            }
        }
        return gewinner;
    }

    /**
     * In dieser Methode wird jeder Spieler dem aktuellen HauptschirmGUI zugeordnet.
     * Ein Spieler sollte wissen an welchem HauptschirmGUI er spielt.
     */
    private void spielerZuordnen() {
        for (Spieler it : this.spieler) {
            if (it != null) {
                it.setSpielbrett(this.spielbrett);
            }
        }
    }

    /**
     * Methode um die allererste Runde zu starten.
     */
    public void spielStarten() {
        this.spiel = new Spiel(spieler);
        this.spielbrett = spiel.getSpielbrett();
        spieler[istDran].rundeStarten();
    }

    public String naechsteRunde() {
        String meldung;
        if (this.spielbrett.getAuslagestapel().getDeck().isEmpty()) {
            meldung = "Alle Karten sind verbraucht.Das Spiel ist jetzt zu Ende. Der Gewinner ist Spieler "
                    + this.spiel.gewinnerErmitteln().getFarbe().toString();
        } else {
            if (this.spieler[this.istDran].getZaehlerKartenZiehen() == 1) {
                meldung = "Du musst noch eine Karte ziehen";
            } else {
                if (this.spieler[this.istDran].getZaehlerKarteAblegen() == 1) {
                    meldung = "Du musst noch eine Karte ablegen";
                } else {
                    this.naechsterSpieler();
                    meldung = "Jetzt ist Spieler " + this.spieler[this.istDran].getFarbe().toString() + " an der Reihe";
                }
                this.spieler[this.istDran].rundeStarten();
            }

        }
        return meldung;
    }

    private void naechsterSpieler(){
        Spieler tmpSpieler = this.spieler[this.istDran+1];
        if (tmpSpieler == null) {
            this.istDran = 0;
        } else {
            this.istDran++;
        }
    }
}

