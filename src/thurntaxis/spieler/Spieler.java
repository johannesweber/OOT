package thurntaxis.spieler;

import thurntaxis.Amtsmann.Amtsperson;
import thurntaxis.Wertverfahren.Wertverfahren;
import thurntaxis.bonus.Bonusmarker;
import thurntaxis.spielbrett.Spielbrett;
import thurntaxis.spielbrett.Stadt;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Johannes on 21.12.13.
 */
public class Spieler {

    private Spielbrett spielbrett;
    private Spielerfarbe farbe;
    private Stack<Haus> haeuser;
    private LinkedList<Stadt> route;
    private LinkedList<Stadt> hand;
    private LinkedList<Bonusmarker> boni;
    private int zaehlerKartenZiehen;
    private int zaehlerKarteAblegen;
    private int zaehlerAmtsperson;

    public Spieler(Spielerfarbe farbe) {
        this.farbe = farbe;
        this.hand = new LinkedList<Stadt>();
        this.route = new LinkedList<Stadt>();
        this.boni = new LinkedList<Bonusmarker>();
        this.haeuser = new Stack<Haus>();
        this.zaehlerKartenZiehen = 1;
        this.zaehlerKarteAblegen = 1;
        this.zaehlerAmtsperson = 1;
        this.haeuserNehmen();
    }

    public void setZaehlerKartenZiehen(int zaehlerKartenZiehen) {
        this.zaehlerKartenZiehen += zaehlerKartenZiehen;
    }

    public void setZaehlerKarteAblegen(int zaehlerKarteAblegen) {
        this.zaehlerKarteAblegen += zaehlerKarteAblegen;
    }

    public Spielbrett getSpielbrett() {
        return this.spielbrett;
    }

    public void setSpielbrett(Spielbrett spielbrett) {
        this.spielbrett = spielbrett;
    }

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

    public void karteZiehen(int platzhalter) {
        if (this.zaehlerKartenZiehen >= 1) {
            this.hand.add(this.spielbrett.getAuslagestapel().karteZiehen((platzhalter - 1)));
        } else {
            System.out.println("Du darfst keine Karte mehr ziehen");
        }
    }

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

    public void amtspersonAusspielen(Amtsperson person) {
        if (this.zaehlerAmtsperson == 1) {
            person.ausspielen(this);
            this.zaehlerAmtsperson = 0;
        }else{
            System.out.println("Du hast in dieser Runde schon eine Amtsperson ausgespielt!");
        }
    }

    public void routeWerten(Wertverfahren verfahren, int platznummer) {
        if (this.route.size() >= 3) {
            verfahren.werten(this, platznummer);
        } else {
            System.out.println("Deine Route muss eine Mindestlange von drei Karten aufweissen");
        }
    }

    private void haeuserNehmen() {
        int anzahl = 0;
        while (anzahl < 20) {
            this.haeuser.add(new Haus(this.farbe));
            anzahl++;
        }
    }

    //hmmm...ob das so geht...
    public void rundeStarten(){
            this.zaehlerAmtsperson = 1;
            this.zaehlerKarteAblegen = 1;
            this.zaehlerKartenZiehen = 1;
    }

    // ich glaub so koennte es gehen
    public boolean rundeBeenden() {
        boolean rundeBeenden = false;
        if (this.zaehlerKartenZiehen == 1){
            System.out.println("Du musst noch eine Karte ziehen");
        }else{
            rundeBeenden = true;
        }
        if(this.zaehlerKarteAblegen == 1){
            System.out.println("Du musst noch eine Karte ablegen");
        }else{
            rundeBeenden = true;
        }
        return rundeBeenden;
    }

}
