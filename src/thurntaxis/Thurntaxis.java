package thurntaxis;

import thurntaxis.spiel.Spiel;
import thurntaxis.spieler.Spieler;
import thurntaxis.spieler.Spielerfarbe;

/**
 * Created by Johannes on 21.12.13.
 */
public class Thurntaxis {

    public static <T> void main(String[] args) {

        Spieler eins = new Spieler(Spielerfarbe.ROT);
        Spieler zwei = new Spieler(Spielerfarbe.GELB);
        Spieler[] spieler = new Spieler[2];
        spieler[0] = eins;
        spieler[1] = zwei;

        Spiel spiel = new Spiel(spieler);

        System.out.println(spiel.getSpielbrett());

        spiel.spielStarten();


    }
}
