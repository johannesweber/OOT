package thurntaxis.amtsperson;

import thurntaxis.spieler.Spieler;

/**
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Interface fuer die Amtspersonen. Die Amtspersonen haben alle die Methode ausspielen,
 *         nur dass die Implementierung jeweils anderst ist.
 */
public interface Amtsperson {

    public abstract void ausspielen(Spieler spieler);
}
