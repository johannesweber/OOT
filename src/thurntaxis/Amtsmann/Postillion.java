package thurntaxis.Amtsmann;

import thurntaxis.spieler.Spieler;

/**
 * Created by Johannes on 22.12.13.
 */
public class Postillion implements Amtsperson{

    @Override
    public void ausspielen(Spieler spieler) {
        spieler.setZaehlerKarteAblegen(1);
    }
}
