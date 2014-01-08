package thurntaxis;

import thurntaxis.GUI.*;
import thurntaxis.spiel.Spielleiter;

/**
 * Created by Johannes on 21.12.13.
 */
public class ThurnTaxis {

    static Spielleiter spielleiter = new Spielleiter();

    public static void main(String[] args) {

        StartmenueFrame startmenue = new StartmenueFrame(spielleiter);
    }
}
