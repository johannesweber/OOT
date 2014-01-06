package thurntaxis.GUI;

import javax.swing.*;
import java.awt.*;

import thurntaxis.spiel.*;

/**
 * Created by Johannes on 03.01.14.
 */
public class HauptschirmFrame extends JFrame {

    public HauptschirmFrame(Spielablauf spielablauf) {
        super("Thurn & Taxis: Das Brettspiel");

        SpielersteuerungPanel spielersteuerung = new SpielersteuerungPanel
                (spielablauf.spieler[spielablauf.getIstDran()], spielablauf);

        SpielbrettPanel spielbrettGUI = new SpielbrettPanel(spielablauf);


        this.setLayout(new GridLayout(1, 2));
        this.add(spielersteuerung);
        this.add(spielbrettGUI);


        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
