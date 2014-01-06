package thurntaxis.GUI;

import javax.swing.*;
import java.awt.*;

import thurntaxis.spiel.*;

/**
 * Created by Johannes on 03.01.14.
 */
public class Hauptschirm extends JFrame {
	
	public Hauptschirm(Spielablauf spielablauf, Boolean visible) {
        super("Thurn & Taxis: Das Brettspiel");
		
		Spielersteuerung spielersteuerung = new Spielersteuerung(spielablauf);
        spielersteuerung.setSpielablauf(spielablauf);
		Landkarte spielbrett = new Landkarte(spielablauf);

		this.add(spielersteuerung, BorderLayout.EAST);
        this.add(spielbrett, BorderLayout.CENTER);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(visible);
	}

}
