package thurntaxis;


import thurntaxis.spieler.Spieler;
import thurntaxis.spieler.Spielerfarbe;

import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
 */
public class Main {

    public static <T> void main(String[] args) {

        LinkedList<Spieler> spieler = new LinkedList<Spieler>();
        Spieler joo = new Spieler(Spielerfarbe.ROT);
        Spieler jessy = new Spieler(Spielerfarbe.GRUEN);
        spieler.add(joo);
        spieler.add(jessy);
        Spiel neu = new Spiel(spieler);
        System.out.println(neu.getSpielbrett());


    }
}
