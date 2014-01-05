package thurntaxis.GUI;
import thurntaxis.spiel.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johannes on 03.01.14.
 */
public class Startmenue{

	public JFrame startmenue = new JFrame("Thurn & Taxis: Das Brettspiel");
	static JButton start = new JButton("Spiel starten");
	static JButton spielerauswahl = new JButton("Spieler auswaehlen");
	JButton beenden = new JButton("Programm beenden");
	public Spielablauf spielablauf = new Spielablauf();

	public Startmenue(Spielablauf spielablauf) {
		this.spielablauf = spielablauf;

		startmenue.setLayout(new GridLayout(3, 1));
		startmenue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startmenue.setVisible(true);
		startmenue.setLocationRelativeTo(null);

		start.setEnabled(false);
		start.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent actionEvent) {
        		spielStarten();
            }
        });
        spielerauswahl.addActionListener(new Spielerauswahl(this));
        beenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startmenue.setVisible(false);
                startmenue.dispose();
            }
        });

        startmenue.add(start);
        startmenue.add(spielerauswahl);
        startmenue.add(beenden);

        startmenue.pack();

    }
	
	public void spielStarten(){		

    	this.spielablauf.spielStarten();
	}
}
