package thurntaxis.spiel;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Klasse duer einen Auslagestapel. Der Auslagestapel besteht aus einem Array mit 6 Feldern und zusaetzlich
 * noch aus dem eigentlichen deck welches die ganzen Stadtkarten des Spiels enthaelt.
 */
public class Auslagestapel {

    private Stadt auslagestapel[];
    private LinkedList<Stadt> deck;

    Auslagestapel() {
        this.deck = new LinkedList<Stadt>();
        this.auslagestapel = new Stadt[6];
        this.deckFuellen();
        this.kartenAustauschen();
    }

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

    public Stadt karteZiehen(int nummer) {
        Stadt gezogen = this.auslagestapel[nummer];
        if (this.deck.size() == 0) {
            this.deckFuellen();
        }
        this.auslagestapel[nummer] = this.deck.pop();
        return gezogen;
    }

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
}
