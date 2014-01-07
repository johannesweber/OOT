package thurntaxis.GUI;
import thurntaxis.GUI.Hauptschirm.HauptschirmFrame;
import thurntaxis.spiel.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasse um das Startmenue zu realisieren. Das Startmenue besitzt 3 Buttons und wie jede andere Klasse
 * in der GUI auch einen Spielablauf.
 */
public class StartmenueFrame extends JFrame{

	public static JButton start = new JButton("Spiel starten");
    public static JButton spielerauswahl = new JButton("Spieler auswaehlen");
    private JButton beenden = new JButton("Programm beenden");
	private Spielablauf spielablauf;

	public StartmenueFrame(Spielablauf spielablauf) {
        super("Thurn & Taxis: Das Brettspiel");
		this.spielablauf = spielablauf;

		this.setLayout(new GridLayout(3, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

		StartmenueFrame.start.setEnabled(false);
        StartmenueFrame.start.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent actionEvent) {
        		spielStarten();
            }
        });
        StartmenueFrame.spielerauswahl.addActionListener(new SpielerauswahlListener(this, this.spielablauf));
        beenden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                StartmenueFrame.this.setVisible(false);
                StartmenueFrame.this.dispose();
            }
        });

        this.add(StartmenueFrame.start);
        this.add(StartmenueFrame.spielerauswahl);
        this.add(beenden);

        this.pack();

    }

    /**
     * Methode um ein Spiel zu starten bzw den Hauptschirm zu oeffnen.
     * Wird benutzt wenn man den Button Spiel starten drueckt
     */
	public void spielStarten(){
        this.spielablauf.spielStarten();
        StartmenueFrame.start.setEnabled(false);
        spielablauf.hauptschirm = new HauptschirmFrame(spielablauf);
	}
}
