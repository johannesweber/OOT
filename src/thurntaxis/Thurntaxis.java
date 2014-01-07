package thurntaxis;

import thurntaxis.GUI.*;
import thurntaxis.spiel.Spielablauf;

/**
 * Created by Johannes on 21.12.13.
 */
public class ThurnTaxis {

    static Spielablauf spielablauf = new Spielablauf();

    public static void main(String[] args) {

        StartmenueFrame startmenue = new StartmenueFrame(spielablauf);
    }
}
