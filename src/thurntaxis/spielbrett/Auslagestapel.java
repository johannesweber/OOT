package thurntaxis.spielbrett;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
 */
public class Auslagestapel {

    private Stadtkarte auslagestapel[];
    private LinkedList<Stadtkarte> deck;

    public Auslagestapel() {
        this.deck = new LinkedList<Stadtkarte>();
        this.auslagestapel = new Stadtkarte[6];
        this.deckFuellen();
        this.kartenAustauschen();
    }

    public void getAuslagestapel() {
        for (int i = 0; i < auslagestapel.length; i++){
            System.out.println(auslagestapel[i]);
        }
    }

    private void deckFuellen() {
        int kartenanzahl = 0;
        while (kartenanzahl < 3){
            for (Stadtkarte it : Stadtkarte.values()){
                this.deck.add(it);
            }
            kartenanzahl++;
        }
        Collections.shuffle(this.deck);
    }

    public Stadtkarte karteZiehen(int nummer) {
        Stadtkarte gezogen = auslagestapel[nummer];
        auslagestapel[nummer] = null;
        return gezogen;
    }

    public void kartenAustauschen() {
        if(this.deck.size() < 6){
            this.deck.clear();
            this.deckFuellen();
            this.kartenAustauschen();
        }else{
            for (int i = 0; i < this.auslagestapel.length; i++) {
                this.auslagestapel[i] = this.deck.pop();
            }
        }
    }
}
