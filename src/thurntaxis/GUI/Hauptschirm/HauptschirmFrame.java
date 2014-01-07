package thurntaxis.GUI.Hauptschirm;

import javax.swing.*;
import java.awt.*;

import thurntaxis.GUI.Hauptschirm.SpielbrettPanel;
import thurntaxis.GUI.Hauptschirm.SpielersteuerungPanel;
import thurntaxis.spiel.*;

/**
 * Klasse um den Hauptschirm vom Typ JFrame zu erstellen. der Hauptschirm vereint 2 Panels in sich
 * (Spielbrett und Spielersteuerung)
 */
public class HauptschirmFrame extends JFrame {

    public HauptschirmFrame(Spielablauf spielablauf) {
        super("Thurn & Taxis: Das Brettspiel");

        SpielbrettPanel spielbrettPanel = new SpielbrettPanel(spielablauf);
        SpielersteuerungPanel spielersteuerung = new SpielersteuerungPanel(spielablauf, spielbrettPanel);


        this.setLayout(new GridLayout(1, 2));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.add(spielersteuerung);
        this.add(spielbrettPanel);


        this.pack();
        this.setVisible(true);
    }

}
