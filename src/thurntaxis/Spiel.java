package thurntaxis;

import thurntaxis.spielbrett.Spielbrett;
import thurntaxis.spieler.Spieler;

import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
 */
public class Spiel {

    private LinkedList<Spieler> spielerAnzahl;
    private Spielbrett spielbrett;

    public Spiel(LinkedList<Spieler> spielerAnzahl) {
        this.spielerAnzahl = spielerAnzahl;
        this.spielbrett = new Spielbrett();
    }

    public Spielbrett getSpielbrett(){
        return this.spielbrett;
    }

    public void naechsteRunde(){

    }

    public Spieler gewinnerErmitteln(){
        return null;
    }

    public void kartenAusteilen(){

    }
}
