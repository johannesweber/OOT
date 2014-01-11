package thurntaxis;

import thurntaxis.gui.*;
import thurntaxis.spiel.Spielleiter;

/**
 * @author Gruppe 4 Fragezeichen
 *         <p/>
 *         Die Main-Klasse ThurnTaxis. In ihr wird ein Spielleiter erstellt und das Startmenue der grafischen
 *         Oberflaeche erstellt bzw. aufgerufen. Jedem Frame / Dialog in der grafischen Oberflaeche wird der
 *         Spielleiter als Uebergabeparameter mitgegeben um ueber diesen alles zu steuern.
 */
public class ThurnTaxis {

    static Spielleiter spielleiter = new Spielleiter();

    public static void main(String[] args) {

        StartmenueFrame startmenue = new StartmenueFrame(spielleiter);
    }
}
