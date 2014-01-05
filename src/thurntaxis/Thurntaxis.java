package thurntaxis;

import thurntaxis.GUI.*;
import thurntaxis.spiel.*;

/**
 * Created by Johannes on 21.12.13.
 */
public class Thurntaxis {
    static thurntaxis.spiel.Spielablauf spielablauf;
	
	public static void main(String[] args) {
		Spielablauf.startmenue = new Startmenue(spielablauf);
		Spielablauf.hauptspiel = new Hauptspiel(spielablauf, false);
	}
}
