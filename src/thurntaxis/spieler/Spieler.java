package thurntaxis.spieler;

import thurntaxis.spielbrett.Stadtkarte;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Johannes on 21.12.13.
 */
public class Spieler {

    private Spielerfarbe farbe;
    private int punkte;
    private Stack<Haus> haeuser;
    private LinkedList<Stadtkarte> route;
    private int zaehlerKartenNehmen;
    private int zaehlerKarteLegen;
    private int zaehlerRoute;

    public Spieler(Spielerfarbe farbe) {
        this.farbe = farbe;
        this.zaehlerKarteLegen = 1;
        this.route = new LinkedList<Stadtkarte>();
        this.haeuser = new Stack<Haus>();
        this.zaehlerKartenNehmen = 1;
        this.haeuserNehmen();
    }

    public void setZaehlerKartenNehmen(int zaehlerKartenNehmen) {
        this.zaehlerKartenNehmen = zaehlerKartenNehmen;
    }

    public void setZaehlerKarteLegen(int zaehlerKarteLegen) {
        this.zaehlerKarteLegen = zaehlerKarteLegen;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public Spielerfarbe getFarbe() {
        return this.farbe;
    }

    public int getPunkte() {
        return this.punkte;
    }


    public LinkedList<Stadtkarte> getRoute() {
        return this.route;
    }

    public int punkteErmitteln() {
        return 0;
    }

    public void karteAufnehmen() {

    }

    public void karteAblegen(Stadtkarte karte) {

    }

    public void amtspersonAusspielen(){

    }

    public int routeWerten() {
        return 0;
    }

    public void rundeBeenden() {

    }

    private void haeuserNehmen(){
        int anzahl = 0;
        while(anzahl < 20){
            this.haeuser.add(new Haus(this.farbe));
            anzahl++;
        }
    }

}
