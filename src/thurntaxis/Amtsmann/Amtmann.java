package thurntaxis.Amtsmann;

import thurntaxis.spieler.Spieler;

/**
 * Klasse fuer einen Amtmann, wenn er ausgespielt wird, wird der Auslagestapel einmal komplett ausgetauscht.
 */
public class Amtmann implements Amtsperson {

    @Override
    public void ausspielen(Spieler spieler) {
        spieler.getSpielbrett().getAuslagestapel().kartenAustauschen();

    }
}
