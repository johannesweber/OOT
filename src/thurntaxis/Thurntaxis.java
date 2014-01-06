package thurntaxis;

import thurntaxis.GUI.*;
import thurntaxis.spiel.Spielablauf;

/**
 * Created by Johannes on 21.12.13.
 */
public class Thurntaxis {

    static thurntaxis.spiel.Spielablauf spielablauf = new Spielablauf();
	
	public static void main(String[] args) {
		spielablauf.startmenue = new Startmenue(spielablauf);

	}
}
