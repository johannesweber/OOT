package thurntaxis.GUI;

import javax.swing.*;
import java.awt.*;

import thurntaxis.spiel.*;

/**
 * Created by Johannes on 03.01.14.
 */
public class Hauptspiel extends JFrame {
	
	public JFrame hauptschirm = new JFrame("Thurn & Taxis: Das Brettspiel");
	
	public Hauptspiel(Spielablauf spielablauf, Boolean visible) {
		
		Spielersteuerung spielersteuerung = new Spielersteuerung(spielablauf);
		Landkarte spielbrett = new Landkarte(spielablauf);

		hauptschirm.add(spielersteuerung, BorderLayout.EAST);
		hauptschirm.add(spielbrett, BorderLayout.CENTER);

		hauptschirm.pack();
		hauptschirm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hauptschirm.setVisible(visible);
	}

}
