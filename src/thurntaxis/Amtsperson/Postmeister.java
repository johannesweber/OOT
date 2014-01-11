package thurntaxis.amtsperson;

import thurntaxis.spieler.Spieler;

/**
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Klasse fuer den Postillion. Wenn der Postillion ausgespielt wird erhoeht sich der zaehlerKarteZiehen
 *         des Spielers um 1.
 */
public class Postmeister implements Amtsperson {

    @Override
    public void ausspielen(Spieler spieler) {
        spieler.zaehlerKartenZiehenErhoehen();
    }
}
