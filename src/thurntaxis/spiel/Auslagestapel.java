package thurntaxis.spiel;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Klasse fuer einen Auslagestapel. Der Auslagestapel besteht aus einem Array mit 6 Feldern und zusaetzlich
 *         noch aus dem eigentlichen deck welches die ganzen Stadtkarten des Spiels enthaelt.Zusaetzlich gibt es noch
 *         die Liste ersatzdeck welche zum Sammeln der Karten, welche gezogen wurden, dient.
 */
public class Auslagestapel {

    private Stadt[] auslagestapel;
    private LinkedList<Stadt> deck;
    private LinkedList<Stadt> ersatzdeck;

    public Auslagestapel() {
        this.deck = new LinkedList<Stadt>();
        this.ersatzdeck = new LinkedList<Stadt>();
        this.auslagestapel = new Stadt[6];
        this.deckFuellen();
        this.kartenAustauschen();
    }

    public LinkedList<Stadt> getDeck() {
        return this.deck;
    }

    public Stadt[] getAuslagestapel() {
        return this.auslagestapel;
    }

    /**
     * Methode um eine Karte zu ziehen. Nach dem eine karte gezogen wurde, wird noch der dack wieder gemischt -
     * falls es leer sein sollte.
     *
     * @param nummer die Nummer des Auslagestapels welche gezogen werden soll.
     *
     * @return die gezogene Karte
     */

    public Stadt karteZiehen(int nummer) {
        Stadt gezogen = this.auslagestapel[nummer];
        this.ersatzdeck.add(gezogen);
        if (this.deck.size() == 0) {
            this.deck.addAll(this.ersatzdeck);
            Collections.shuffle(this.deck);
        }
        this.auslagestapel[nummer] = this.deck.pop();
        return gezogen;
    }

    /**
     * Methode um den Auslagestapel zu fuellen bzw. durch den Postmeister auszutauschen.
     */
    public void kartenAustauschen() {
        if (this.deck.size() < 6) {
            this.deck.clear();
            this.deckFuellen();
            this.kartenAustauschen();
        } else {
            for (int i = 0; i < this.auslagestapel.length; i++) {
                this.auslagestapel[i] = this.deck.pop();
            }
        }
    }

    /**
     * Hilfsmethode der Methode kartenAustauschen. Diese Methode wird gebraucht um das Deck wieder
     * zu fuellen.
     */
    private void deckFuellen() {
        int anzahlGleicherKarten = 0;
        while (anzahlGleicherKarten < 3) {
            for (Spielkarte it : Spielkarte.values()) {
                this.deck.add(new Stadt(it));
            }
            anzahlGleicherKarten++;
        }
        Collections.shuffle(this.deck);
    }
}
