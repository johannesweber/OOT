package thurntaxis.gui.hauptschirm;

import javax.swing.*;
import java.awt.*;

import thurntaxis.spiel.*;

/**
 * Klasse um den hauptschirm vom Typ JFrame zu erstellen. der hauptschirm vereint 2 Panels in sich
 * (Spielbrett und Spielersteuerung)
 */
public class HauptschirmFrame extends JFrame {

    public HauptschirmFrame(Spielablauf spielablauf) {
        super("Thurn & Taxis: Das Brettspiel");

        SpielbrettPanel spielbrettPanel = new SpielbrettPanel(spielablauf);
        SpielersteuerungPanel spielersteuerung = new SpielersteuerungPanel(spielablauf, spielbrettPanel);


        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 2));
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.add(spielersteuerung);
        this.add(spielbrettPanel);


        this.pack();
        this.setVisible(true);
    }

}
