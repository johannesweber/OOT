package thurntaxis.amtsperson;

import thurntaxis.spieler.Spieler;

/**
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Klasse fuer einen Amtmann, wenn er ausgespielt wird, wird der Auslagestapel einmal komplett ausgetauscht.
 */
public class Amtmann implements Amtsperson {

    @Override
    public void ausspielen(Spieler spieler) {
        spieler.getSpielbrett().getAuslagestapel().kartenAustauschen();

    }
}
