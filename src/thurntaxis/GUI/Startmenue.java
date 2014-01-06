package thurntaxis.GUI;
import thurntaxis.spiel.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Johannes on 03.01.14.
 */
public class Startmenue extends JFrame{

	static JButton start = new JButton("Spiel starten");
    private JButton spielerauswahl = new JButton("Spieler auswaehlen");
    private JButton beenden = new JButton("Programm beenden");
	public Spielablauf spielablauf;

	public Startmenue(Spielablauf spielablauf) {
        super("Thurn & Taxis: Das Brettspiel");
		this.spielablauf = spielablauf;

		this.setLayout(new GridLayout(3, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

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
                Startmenue.this.setVisible(false);
                Startmenue.this.dispose();
            }
        });

        this.add(start);
        this.add(spielerauswahl);
        this.add(beenden);

        this.pack();

    }
	
	public void spielStarten(){
        this.spielablauf.spielStarten();
        this.start.setEnabled(false);
        spielablauf.hauptschirm = new Hauptschirm(spielablauf, true);
	}
}
