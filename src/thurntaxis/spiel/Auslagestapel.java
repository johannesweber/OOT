package thurntaxis.spiel;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
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
        int kartenanzahl = 0;
        while (kartenanzahl < 3){
            for (StadtEnum it : StadtEnum.values()){
                this.deck.add(new Stadt(it));
            }
            kartenanzahl++;
        }
        Collections.shuffle(this.deck);
    }

    public Stadt karteZiehen(int nummer) {
        Stadt gezogen = auslagestapel[nummer];
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
