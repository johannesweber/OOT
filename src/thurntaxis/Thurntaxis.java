package thurntaxis;

import thurntaxis.gui.*;
import thurntaxis.spiel.Spielablauf;

/**
 * Created by Johannes on 21.12.13.
 */
public class ThurnTaxis {

    static Spielablauf spielablauf = new Spielablauf();

    public static void main(String[] args) {

        spielablauf.startmenue = new StartmenueFrame(spielablauf);
    }
}
