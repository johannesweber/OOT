package thurntaxis;

import thurntaxis.Amtsmann.*;
import thurntaxis.spiel.Spiel;
import thurntaxis.spieler.*;

import java.util.LinkedList;

/**
 * Created by Johannes on 21.12.13.
 */
public class Main {

    public static <T> void main(String[] args) {

        Spieler eins = new Spieler (Spielerfarbe.GRUEN);
        Spieler zwei = new Spieler (Spielerfarbe.GELB);
        LinkedList<Spieler> spielers = new LinkedList<Spieler>();
        Spiel thurn = new Spiel(spielers);
        eins.amtspersonAusspielen(new Postillion());


    }
}
